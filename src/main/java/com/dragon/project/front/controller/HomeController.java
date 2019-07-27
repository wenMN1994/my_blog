package com.dragon.project.front.controller;

import com.dragon.common.constant.CommonConstant;
import com.dragon.framework.aspectj.lang.annotation.VLog;
import com.dragon.framework.web.controller.BaseController;
import com.dragon.project.blog.blog.domain.Blog;
import com.dragon.project.blog.blog.service.BlogService;
import com.dragon.project.front.service.HomeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private BlogService blogService;

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

    @VLog(title = "博客")
    @GetMapping("/f/article/{blogId}.html")
    public String article(@PathVariable Integer blogId, Model model) {
        setCommonMessage(model);
        Blog blog = blogService.selectBlogWithTextAndTagsAndCategoryByBlogId(blogId);
        //只能访问是已经发表的文章
        if (!CommonConstant.one.equals(blog.getStatus())) {
            return "error/404";
        }
        model.addAttribute("blog", blog);
        model.addAttribute("nextBlog", blogService.selectNextBlogById(blogId));
        model.addAttribute("previousBlog", blogService.selectPreviousBlogById(blogId));
        model.addAttribute("randBlogList", blogService.selectRandBlogList());
        return "front/article/article";
    }
}
