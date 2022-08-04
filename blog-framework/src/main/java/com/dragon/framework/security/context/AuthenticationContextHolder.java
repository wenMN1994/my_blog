package com.dragon.framework.security.context;

import org.springframework.security.core.Authentication;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-08-04
 * @description：身份验证信息
 */
public class AuthenticationContextHolder {
    private static final ThreadLocal<Authentication> contextHolder = new ThreadLocal<>();

    public static Authentication getContext() {
        return contextHolder.get();
    }

    public static void setContext(Authentication context) {
        contextHolder.set(context);
    }

    public static void clearContext() {
        contextHolder.remove();
    }
}
