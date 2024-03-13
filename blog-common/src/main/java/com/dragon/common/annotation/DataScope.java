package com.dragon.common.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 * 
 * @author dragon
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    /**
     * 用户表的别名
     */
    public String userAlias() default "";

    /**
     * 权限字符（如不填默认会自动根据注解获取）
     */
    public String permission() default "";
}
