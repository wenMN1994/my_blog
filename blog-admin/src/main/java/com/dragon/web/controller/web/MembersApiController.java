package com.dragon.web.controller.web;

import com.alibaba.fastjson2.JSONObject;
import com.dragon.common.annotation.Anonymous;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.constant.Constants;
import com.dragon.common.constant.RegExpConstants;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.domain.entity.SysUser;
import com.dragon.common.core.domain.entity.Verification;
import com.dragon.common.core.domain.model.MembersLoginBody;
import com.dragon.common.core.domain.model.MembersRegisterBody;
import com.dragon.common.core.redis.RedisCache;
import com.dragon.common.exception.user.UserPasswordNotMatchException;
import com.dragon.common.utils.SecurityUtils;
import com.dragon.common.utils.StringUtils;
import com.dragon.common.utils.email.MailUtil;
import com.dragon.common.utils.sms.SmsClientUtil;
import com.dragon.framework.web.service.SysLoginService;
import com.dragon.framework.web.service.SysRegisterService;
import com.dragon.system.service.ISysConfigService;
import com.dragon.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @author: DragonWen
 * @date: 2024/8/9
 * @Version: 1.0
 * @description: 会员中心
 */
@Slf4j
@Anonymous
@RestController
@RequestMapping("/web/members")
@Api(tags = "会员中心")
public class MembersApiController extends BaseController {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private SmsClientUtil smsClientUtil;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysUserService userService;

    @ApiOperation(value = "获取验证码")
    @PostMapping("/getVerificationCode")
    public AjaxResult getVerificationCode(@RequestBody Verification verification) {
        String phoneEmailVerifyKey = CacheConstants.SMS_CAPTCHA_CODE_KEY + verification.getUsername();
        if (redisCache.hasKey(phoneEmailVerifyKey)) {
            throw new RuntimeException("请勿重复获取验证码");
        }
        SysUser sysUser = userService.selectUserByUserName(verification.getUsername());
        // 注册获取验证码校验账号是否存在
        if (Constants.REGISTER.equals(verification.getType()) && Objects.nonNull(sysUser)) {
            throw new RuntimeException("用户'" + sysUser.getUserName() + "'发送短信失败，注册账号已存在");
        } else if ((Constants.LOGIN.equals(verification.getType()) || Constants.RESET_PWD.equals(verification.getType())) && Objects.isNull(sysUser)){
            throw new UserPasswordNotMatchException();
        }
        AjaxResult ajax = AjaxResult.success();
        Pattern phone = Pattern.compile(RegExpConstants.PHONE);
        Pattern email = Pattern.compile(RegExpConstants.EMAIL);
        String accountType = "";
        if (StringUtils.isEmpty(verification.getUsername())) {
            throw new RuntimeException("手机号码或邮箱不能为空");
        }
        if (phone.matcher(verification.getUsername()).matches()) {
            accountType = Constants.PHONE;
        } else if (email.matcher(verification.getUsername()).matches()) {
            accountType = Constants.EMAIL;
        } else {
            throw new RuntimeException("请输入正确的手机号码或邮箱");
        }
        // 保存验证码信息
        String phoneEmailVerifyValue = StringUtils.generateCaptcha();
        // 发送短信或邮箱验证码
        if (Constants.PHONE.equals(accountType)) {
            // 短信发送
            try {
                JSONObject jsonObject = configService.selectAliyunSms();
                String signature = jsonObject.get("signature").toString();
                String templateCode = jsonObject.get("templateCode").toString();
                String sendSms = smsClientUtil.sendSms(verification.getUsername(), signature, templateCode, phoneEmailVerifyValue);
                log.info("sendSms：", sendSms);
            } catch (Exception e) {
                throw new RuntimeException("服务异常，请稍后再试！");
            }
        } else if (Constants.EMAIL.equals(accountType)) {
            // 邮件发送
            try {
                String emailTemplate = configService.selectEmailTemplateVerificationCode();
                Map<String, Object> params = new HashMap<>(2);
                params.put("code", phoneEmailVerifyValue);
                params.put("expires", Constants.CAPTCHA_EXPIRATION);
                ExpressionParser parser = new SpelExpressionParser();
                TemplateParserContext parserContext = new TemplateParserContext();
                String content = parser.parseExpression(emailTemplate, parserContext).getValue(params, String.class);
                mailUtil.sendText(verification.getUsername(), "", "", "码农油管", content);
            } catch (Exception e) {
                throw new RuntimeException("服务异常，请稍后再试！");
            }
        }
        // 缓存当前手机号码或邮箱地址+验证码到Redis 5分钟内不允许重复发送验证码
        redisCache.setCacheObject(phoneEmailVerifyKey, phoneEmailVerifyValue, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        return ajax;
    }

    @ApiOperation(value = "会员登录")
    @PostMapping("/membersLogin")
    public AjaxResult membersLogin(@RequestBody MembersLoginBody membersLoginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.membersLogin(membersLoginBody.getUsername(), membersLoginBody.getPassword(), membersLoginBody.getVerificationCode());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    @ApiOperation(value = "会员信息")
    @PostMapping("/getUserInfo")
    public AjaxResult getUserInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        user.setPassword(null);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        return ajax;
    }

    @ApiOperation(value = "会员注册")
    @PostMapping("/membersRegister")
    public AjaxResult membersRegister(@RequestBody MembersRegisterBody membersRegisterBody) {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.membersRegister(membersRegisterBody);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }

    @ApiOperation(value = "会员重置密码")
    @PostMapping("/membersResetPwd")
    public AjaxResult membersResetPwd(@RequestBody MembersRegisterBody membersRegisterBody) {
        String msg = registerService.membersResetPwd(membersRegisterBody);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
