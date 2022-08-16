package com.dragon.web.controller.common;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.constant.RegExpConstants;
import com.dragon.common.utils.SliderCaptchaUtils;
import com.dragon.common.utils.StringUtils;
import com.dragon.common.utils.sms.SmsClientUtil;
import com.dragon.system.domain.CheckSliderCaptcha;
import com.google.code.kaptcha.Producer;
import com.dragon.common.config.BlogConfig;
import com.dragon.common.constant.Constants;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.redis.RedisCache;
import com.dragon.common.utils.sign.Base64;
import com.dragon.common.utils.uuid.IdUtils;
import com.dragon.system.service.ISysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * 验证码操作处理
 * 
 * @author dragon
 */
@Slf4j
@RestController
public class CaptchaController {
    /**
     * 验证码类型 math 数组计算
     */
    private static String MATH = "math";

    /**
     * 验证码类型 char 字符验证
     */
    private static String CHAR = "char";

    /**
     * 账户类型 phone 手机号码
     */
    private static String PHONE = "phone";

    /**
     * 账户类型 email 邮箱地址
     */
    private static String EMAIL = "email";

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;
    
    @Autowired
    private ISysConfigService configService;

    @Autowired
    private SmsClientUtil smsClientUtil;

    /**
     * 生成验证码
     * @param response
     * @return
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCode(HttpServletResponse response) {
        AjaxResult ajax = AjaxResult.success();
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        ajax.put("captchaEnabled", captchaEnabled);
        if (!captchaEnabled) {
            return ajax;
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null;
        String code = null;
        BufferedImage image = null;

        // 生成验证码
        String captchaType = BlogConfig.getCaptchaType();
        if (MATH.equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        } else if (CHAR.equals(captchaType)) {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return AjaxResult.error(e.getMessage());
        }

        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));
        return ajax;
    }

    /**
     * 生产滑块拼图验证码
     * @param response
     * @return
     */
    @GetMapping("/sliderCaptcha")
    public AjaxResult sliderCaptcha(HttpServletResponse response, String emailOrPhone){
        AjaxResult ajax = AjaxResult.success();
        Map<String,Object> result = new HashMap<>(16);
        JSONArray jsonArray = configService.selectSliderCaptcha();
        Random random = new Random();
        int nextInt = random.nextInt(jsonArray.size());
        Map<String, Object> imageUrlMap = (Map<String, Object>) jsonArray.get(nextInt);
        String imageUrl = imageUrlMap.get("imgUrl").toString();
        SliderCaptchaUtils.createImage(null, imageUrl, result);
        if(!CollectionUtils.isEmpty(result)){
            // 保存验证码信息
            String uuid = IdUtils.simpleUUID();
            String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;
            result.put("verifyKey", verifyKey);
            result.put("emailOrPhone", emailOrPhone);
            Object code = result.get("xWidth");
            redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
            ajax.putAll(result);
        }
        return ajax;
    }

    /**
     * 验证滑块拼图验证码
     * @return
     */
    @PostMapping("/checkSliderCaptcha")
    public AjaxResult checkSliderCaptcha(@RequestBody CheckSliderCaptcha sliderCaptcha){
        String phoneEmailVerifyKey = CacheConstants.CAPTCHA_CODE_KEY + sliderCaptcha.getName();
        if(redisCache.hasKey(phoneEmailVerifyKey)){
            throw new RuntimeException("请勿重复获取验证码");
        }
        AjaxResult ajax = AjaxResult.success();
        Pattern phone = Pattern.compile(RegExpConstants.PHONE);
        Pattern email = Pattern.compile(RegExpConstants.EMAIL);
        String accountType = "";
        if (sliderCaptcha.getCode() == null) {
            throw new RuntimeException("验证码不能为空");
        } else if(StringUtils.isEmpty(sliderCaptcha.getName())){
            throw new RuntimeException("手机号码或邮箱不能为空");
        } else if(StringUtils.isEmpty(sliderCaptcha.getVerifyKey())){
            throw new RuntimeException("verifyKey不能为空");
        }
        if(phone.matcher(sliderCaptcha.getName()).matches()){
            accountType = PHONE;
        }else if(email.matcher(sliderCaptcha.getName()).matches()){
            accountType = EMAIL;
        } else {
            throw new RuntimeException("请输入正确的手机号码或邮箱");
        }

        if (!redisCache.hasKey(sliderCaptcha.getVerifyKey())) {
            throw new RuntimeException("验证码不合法");
        }
        Object codeObj = redisCache.getCacheObject(sliderCaptcha.getVerifyKey());
        if (codeObj == null) {
            throw new RuntimeException("验证码不合法");
        }

        String saveCode = codeObj.toString();
        if (StringUtils.isEmpty(saveCode)) {
            redisCache.deleteObject(sliderCaptcha.getVerifyKey());
            throw new RuntimeException("验证码不合法");
        }

        // 判断验证值 加减15 是否在范围内
        Integer saveCodeInt1 = Integer.parseInt(saveCode) - 15;
        Integer saveCodeInt2 = Integer.parseInt(saveCode) + 15;
        redisCache.deleteObject(sliderCaptcha.getVerifyKey());
        if (saveCodeInt1 > sliderCaptcha.getCode() || saveCodeInt2 < sliderCaptcha.getCode()) {
            throw new RuntimeException("验证码不合法");
        }

        // 保存验证码信息
        String phoneEmailVerifyValue = StringUtils.generateCaptcha();
        // 发送短信或邮箱验证码
        if(PHONE.equals(accountType)){
            try {
                JSONObject jsonObject = configService.selectAliyunSms();
                String signature = jsonObject.get("signature").toString();
                String templateCode = jsonObject.get("templateCode").toString();
                String sendSms = smsClientUtil.sendSms(sliderCaptcha.getName(), signature, templateCode, phoneEmailVerifyValue);
                log.info("sendSms：", sendSms);
            } catch (Exception e) {
                throw new RuntimeException("服务异常，请稍后再试！");
            }
        }else if(EMAIL.equals(accountType)){
            // @TODO 邮件发送
        }

        // 缓存当前手机号码或邮箱地址+验证码到Redis 2分钟内不允许重复发送验证码
        redisCache.setCacheObject(phoneEmailVerifyKey, phoneEmailVerifyValue, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        ajax.put("phoneEmailVerifyKey", phoneEmailVerifyKey);
        return ajax;
    }
}
