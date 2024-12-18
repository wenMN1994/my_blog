package com.dragon.common.constant;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-07-09
 * @description：缓存的key常量
 */
public class CacheConstants {
    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 限流 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * 登录账户密码错误次数 redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

    /**
     * 网站首页轮播图缓存 redis key
     */
    public static final String INDEX_FRONT_SLIDESHOW_KEY = "index_front:slideshow";

    /**
     * 短信验证码 redis key
     */
    public static final String SMS_CAPTCHA_CODE_KEY = "sms:captcha";

    /**
     * 网站设置 redis key
     */
    public static final String CONFIG_KEY_PORTAL_SETTINGS_INFO = "portal.settings.info";
}
