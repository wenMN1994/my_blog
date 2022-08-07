package com.dragon.system.domain;

import lombok.Data;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-08-07
 * @description：滑块拼图验证码校验参数
 */
@Data
public class CheckSliderCaptcha {
    /**
     * 验证码
     */
    private Integer code;

    /**
     * 账号：手机号码或邮箱
     */
    private String name;

    /**
     * 缓存key
     */
    private String verifyKey;
}
