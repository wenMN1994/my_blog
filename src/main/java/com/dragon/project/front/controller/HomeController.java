package com.dragon.project.front.controller;

import com.dragon.framework.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/17 16:27
 * @description： 前台首页Controller
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping({"/","/my_blog"})
public class HomeController extends BaseController {
    @RequestMapping("")
    public String index(ModelMap modelMap){

        return "front/index/index";
    }
}
