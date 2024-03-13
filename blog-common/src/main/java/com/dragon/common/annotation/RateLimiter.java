package com.dragon.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.enums.LimitType;

/**
 * 限流注解
 *
 * @author dragon
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    /**
     * 限流key
     */
    public String key() default CacheConstants.RATE_LIMIT_KEY;

    /**
     * 限流时间,单位秒
     */
    public int time() default 60;

    /**
     * 限流次数
     */
    public int count() default 5;

    /**
     * 限流类型
     */
    public LimitType limitType() default LimitType.DEFAULT;
}
