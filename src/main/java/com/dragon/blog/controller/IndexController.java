package com.dragon.blog.controller;

import com.dragon.blog.base.BaseController;
import com.dragon.blog.model.BlogMenu;
import com.dragon.blog.model.BlogMenuExample;
import com.dragon.blog.service.BlogMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/2 14:36
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Controller
public class IndexController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private BlogMenuService blogMenuService;

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        BlogMenuExample blogMenuExample = new BlogMenuExample();
        blogMenuExample.createCriteria().andMenuIdEqualTo(1);
        List<BlogMenu> blogMenus = blogMenuService.selectByExample(blogMenuExample);
        modelMap.put("menu",blogMenus);
        return "index/index";
    }
}
