package com.dragon.config;

import com.dragon.interceptor.BlogInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/16 17:36
 * @description： 拦截器配置
 * @modified By：
 * @version: $version$
 */
@Component
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);

    @Resource
    BlogInterceptor blogInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //排除静态资源拦截
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        registry.addResourceHandler("/my_blog/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        registry.addResourceHandler("/admin/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
    }

    /**
     * 授权拦截的路径 addPathPatterns：拦截的路径 excludePathPatterns：不拦截的路径
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("add interceptors");
        registry.addInterceptor(blogInterceptor).addPathPatterns("/**").excludePathPatterns(Arrays.asList("/admin/login","/my_blog/**","/Front-End/**","/common/**","/admin/h_ui_4.9/**"));
    }

}
