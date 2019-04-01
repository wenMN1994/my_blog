package com.dragon.blog.annotation;

import java.lang.annotation.*;

/**
 * 
 * <p>Title: BaseService</p>  
 * <p>Description: 初始化继承BaseService的service</p>  
 * @author Dragon.Wen
 * @date Oct 17, 2018
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
