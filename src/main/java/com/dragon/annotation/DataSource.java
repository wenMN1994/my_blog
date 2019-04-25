package com.dragon.annotation;

import com.dragon.db.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/25 21:41
 * @description： 自定义多数据源切换注解
 * @modified By：
 * @version: $version$
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    /**
     * 切换数据源名称
     */
    DataSourceEnum value() default DataSourceEnum.MASTER;
}
