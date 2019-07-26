package com.dragon.project.front.controller;

import com.dragon.framework.aspectj.lang.annotation.VLog;
import com.dragon.framework.web.controller.BaseController;
import com.dragon.project.blog.blog.domain.Blog;
import com.dragon.project.front.service.HomeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private HomeService homeService;

    @VLog(title = "首页")
    @RequestMapping("")
    public String index(Integer pageNum, Model model){
        setCommonMessage(model);
        PageHelper.startPage(pageNum == null ? 1 : pageNum, 12, "create_time desc");
        model.addAttribute("blogs", new PageInfo<>(homeService.selectFrontBlogList(new Blog())));
        return "front/index/index";
    }

    private void setCommonMessage(Model model) {
    }
}
