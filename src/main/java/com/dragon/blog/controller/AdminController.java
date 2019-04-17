package com.dragon.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/3/22 11:50
 * @description 后台管理Controller测试
 * @modified By：
 * @version: $version$
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    /**
     * 测试后台管理跳转
     * @return
     */
    @RequestMapping("index")
    public String admin(){
        return "admin/index";
    }

    /**
     * 测试后台管理登录页面
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "admin/sso/login";
    }

    /**
     * 测试后台管理跳转
     * @return
     */
    @RequestMapping("home")
    public String home(){
        return "admin/home/home";
    }
}
