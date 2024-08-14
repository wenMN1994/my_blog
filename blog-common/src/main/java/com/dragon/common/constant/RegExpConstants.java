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
    public static final String PHONE = "^1[3-9]\\d{9}$";

    /**
     * 邮箱地址
     */
    public static final String EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    /**
     * 密码
     */
    public static final String PASSWORD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
}
