package com.dragon.blog.controller.web;

import com.dragon.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/2 14:36
 * @description： 前端Controller
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping({"/","/my_blog"})
public class WebIndexController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebIndexController.class);

    @RequestMapping("")
    public String index(ModelMap modelMap){
        
        return "index/index";
    }
}
