package com.dragon.framework.web.service;

import com.dragon.common.constant.CacheConstants;
import com.dragon.common.constant.Constants;
import com.dragon.common.constant.RegExpConstants;
import com.dragon.common.constant.UserConstants;
import com.dragon.common.core.domain.entity.SysUser;
import com.dragon.common.core.domain.model.MembersRegisterBody;
import com.dragon.common.core.domain.model.RegisterBody;
import com.dragon.common.core.redis.RedisCache;
import com.dragon.common.exception.user.CaptchaException;
import com.dragon.common.exception.user.CaptchaExpireException;
import com.dragon.common.utils.MessageUtils;
import com.dragon.common.utils.SecurityUtils;
import com.dragon.common.utils.StringUtils;
import com.dragon.framework.manager.AsyncManager;
import com.dragon.framework.manager.factory.AsyncFactory;
import com.dragon.system.service.ISysConfigService;
import com.dragon.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * 注册校验方法
 * 
 * @author dragon
 */
@Component
public class SysRegisterService {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 注册
     */
    public String register(RegisterBody registerBody) {
        String msg = "";
        String username = registerBody.getUsername();
        String password = registerBody.getPassword();
        // 验证码开关
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        if (captchaEnabled) {
            validateCaptcha(username, registerBody.getCode(), registerBody.getUuid());
        }

        return registerCheck(msg, username, password, UserConstants.USER_TYPE_SYS);
    }

    /**
     * 校验验证码
     * 
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid) {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException();
        }
    }

    /**
     * 会员注册
     * @param membersRegisterBody
     * @return
     */
    public String membersRegister(MembersRegisterBody membersRegisterBody) {
        String msg = "";
        String username = membersRegisterBody.getUsername();
        String password = membersRegisterBody.getPassword();
        String verificationCode = membersRegisterBody.getVerificationCode();
        validateSmsCode(username, verificationCode);
        return registerCheck(msg, username, password, UserConstants.USER_TYPE_MEMBER);
    }

    /**
     * 校验短信验证码
     * @param username
     * @param verificationCode
     */
    private void validateSmsCode(String username, String verificationCode) {
        String verifyKey = CacheConstants.SMS_CAPTCHA_CODE_KEY + username;
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }
        if (!verificationCode.equalsIgnoreCase(captcha)) {
            throw new CaptchaException();
        }
    }

    /**
     * 注册校验
     * @param msg 返回消息
     * @param username 用户名
     * @param password 密码
     * @param userType 用户类型 00：系统用户 11：会员
     * @return
     */
    private String registerCheck(String msg, String username, String password, String userType) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        if (StringUtils.isEmpty(username)) {
            msg = "手机号/邮箱/用户名不能为空";
        } else if (StringUtils.isEmpty(password)) {
            msg = "用户密码不能为空";
        } else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            msg = "账户长度必须在2到30个字符之间";
        } else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            msg = "密码长度必须在5到20个字符之间";
        } else if (!userService.checkUserNameUnique(sysUser)) {
            msg = "用户'" + username + "'注册失败，注册账号已存在";
        } else {
            String accountType = "";
            Pattern phone = Pattern.compile(RegExpConstants.PHONE);
            Pattern email = Pattern.compile(RegExpConstants.EMAIL);
            if (phone.matcher(username).matches()) {
                accountType = Constants.PHONE;
            } else if (email.matcher(username).matches()) {
                accountType = Constants.EMAIL;
            }
            if (Constants.PHONE.equals(accountType)) {
                sysUser.setPhonenumber(username);
            } else if (Constants.EMAIL.equals(accountType)) {
                sysUser.setEmail(username);
            }
            sysUser.setNickName(username);
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            sysUser.setUserType(userType);
            boolean regFlag = userService.registerUser(sysUser);
            if (!regFlag) {
                msg = "注册失败,请联系系统管理人员";
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }

    /**
     * 会员重置密码
     *
     * @param membersRegisterBody
     * @return
     */
    public String membersResetPwd(MembersRegisterBody membersRegisterBody) {
        String msg = "";
        String username = membersRegisterBody.getUsername();
        String password = membersRegisterBody.getPassword();
        String verificationCode = membersRegisterBody.getVerificationCode();
        validateSmsCode(username, verificationCode);
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        if (StringUtils.isEmpty(password)) {
            msg = "用户密码不能为空";
        } else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            msg = "密码长度必须在5到20个字符之间";
        } else if (userService.checkUserNameUnique(sysUser)) {
            msg = "重置用户'" + username + "'密码失败，账号不已存在";
        } else {
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            sysUser.setUpdateBy(username);
            int resetPwd = userService.resetPwd(sysUser);
            if (resetPwd == 0) {
                msg = "重置失败,请联系系统管理人员";
            } else {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }
}
