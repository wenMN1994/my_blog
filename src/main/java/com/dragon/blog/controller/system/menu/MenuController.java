package com.dragon.blog.controller.system.menu;

import com.dragon.blog.model.*;
import com.dragon.blog.service.BlogSysDictDataService;
import com.dragon.blog.service.BlogSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/13 14:45
 * @description：菜单管理控制器
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("system/menu")
public class MenuController {
    private String prefix = "system/menu";

    @Autowired
    private BlogSysMenuService blogSysMenuService;

    @Autowired
    private BlogSysDictDataService blogSysDictDataService;

    /**
     * 菜单管理页面跳转
     * @return
     */
    @GetMapping()
    public String menu() {
        return prefix + "/menu";
    }

    /**
     * 获取菜单列表
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public List<BlogSysMenu> list(ModelMap modelMap) {
        BlogSysMenuExample blogSysMenuExample = new BlogSysMenuExample();
        List<BlogSysMenu> menuList = blogSysMenuService.selectByExample(blogSysMenuExample);
        return menuList;
    }
}
