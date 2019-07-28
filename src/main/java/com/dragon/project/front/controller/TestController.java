package com.dragon.project.front.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/3/18 17:09
 * @description： 测试Controller
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/my_blog")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 这里的@GetMapping相当于@RequestMapping(value = "/hello", method = RequestMethod.GET)
     * @return
     * @throws InterruptedException
     */
    @GetMapping("hello")
    @ResponseBody
    public String test() {
        logger.info("欢迎关注DragonWen博客");
        return "i love java";
    }

}
