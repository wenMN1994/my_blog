package com.dragon.blog.controller;

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
 * @version: $version$
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
    public String test() throws InterruptedException {
        logger.info("欢迎关注DragonWen博客");
        return "i love java";
    }

    /**
     * 测试首页跳转
     * @return
     */
//    @RequestMapping("")
//    public String index(){
//        return "index/index";
//    }

    /**
     * 测试个人博客日记跳转
     * @return
     */
    @RequestMapping("blog")
    public String blog(){
        return "blog/blog";
    }

    /**
     * 测试随笔分类跳转
     * @return
     */
    @RequestMapping("classify")
    public String classify(){
        return "classify/classify";
    }

    /**
     * 测试源码库跳转
     * @return
     */
    @RequestMapping("sourcecode")
    public String resume(){
        return "sourcecode/sourcecode";
    }

    /**
     * 测试知识库跳转
     * @return
     */
    @RequestMapping("repository")
    public String repository(){
        return "repository/repository";
    }

    /**
     * 测试关于我跳转
     * @return
     */
    @RequestMapping("about")
    public String about(){
        return "about/about";
    }

    /**
     * 测试文章内容页跳转
     * @return
     */
    @RequestMapping("article")
    public String info(){
        return "article/article";
    }

    /**
     * 测试时间轴跳转
     * @return
     */
    @RequestMapping("time")
    public String time(){
        return "time/time";
    }

}
