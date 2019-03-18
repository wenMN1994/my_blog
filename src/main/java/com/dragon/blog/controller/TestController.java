package com.dragon.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/3/18 17:09
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 这里的@GetMapping相当于@RequestMapping(value = "/hello", method = RequestMethod.GET)
     * @return
     * @throws InterruptedException
     */
    @GetMapping("hello")
    public String test() throws InterruptedException {
        logger.info("欢迎关注DragonWen博客");
        return "i love java";
    }
}
