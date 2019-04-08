package com.dragon;

import com.dragon.blog.utils.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/3/18 17:09
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@SpringBootApplication
@MapperScan(value = "com.dragon.blog.mapper")
public class MyBlogApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyBlogApplication.class, args);
	}

}
