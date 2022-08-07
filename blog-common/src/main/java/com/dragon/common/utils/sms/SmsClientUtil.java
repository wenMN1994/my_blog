package com.dragon.common.utils.sms;

import com.aliyun.dysmsapi20170525.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.models.*;
import com.aliyun.teautil.*;
import org.springframework.stereotype.Component;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-08-07
 * @description：阿里云短信发送工具
 */
@Slf4j
@Component
public class SmsClientUtil {

    @Value("${oss.aliyun.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.aliyun.accessKeySecret}")
    private String accessKeySecret;

    /**
     * 使用AK&SK初始化账号Client 并发送短信
     * @param phone 手机号码
     * @param code 验证码
     * @throws Exception
     * @return
     */
    public String sendSms(String phone, String code) throws Exception {
        String errorMsg = "";
        Config config = new Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        Client client = new Client(config);
        // 1.发送短信
        SendSmsRequest sendReq = new SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setTemplateParam("{\"code\":\"" + code + "\"}");
        SendSmsResponse sendResp = client.sendSms(sendReq);
        String codeResp = sendResp.body.code;
        if (!Common.equalString(codeResp, "OK")) {
            errorMsg = sendResp.body.message;
        }
        return errorMsg;
    }
}
