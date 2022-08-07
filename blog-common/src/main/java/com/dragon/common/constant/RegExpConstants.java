package com.dragon.common.constant;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-08-07
 * @description：正则表达式常量
 */
public class RegExpConstants {

    /**
     * 手机号码
     */
    public static final String PHONE = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";

    /**
     * 邮箱地址
     */
    public static final String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    /**
     * 密码
     */
    public static final String PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
}
