package com.dragon.blog.controller.system.index;

import com.dragon.base.BaseController;
import com.dragon.blog.model.BlogSysMenu;
import com.dragon.blog.model.BlogSysMenuExample;
import com.dragon.blog.service.BlogSysMenuService;
import com.dragon.utils.TreeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/5 16:27
 * @description： 后台管理首页控制器
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/system")
public class SystemIndexController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemIndexController.class);

    @Autowired
    private BlogSysMenuService blogSysMenuService;
    /**
     * 台管理首页跳转
     * @return
     */
    @RequestMapping("index")
    public String admin(HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        if(StringUtils.isEmpty(session.getAttribute("sessionUser"))){
            return "system/sso/login";
        }
        BlogSysMenuExample blogSysMenuExample = new BlogSysMenuExample();
        List<BlogSysMenu> menusAll = blogSysMenuService.selectByExample(blogSysMenuExample);
        List<BlogSysMenu> menus = TreeUtils.getChildPerms(menusAll, 0);
        model.addAttribute("menus",menus);
        return "system/index";
    }

    /**
     * 加载首页
     * @return
     */
    @RequestMapping("home")
    public String home(){
        return "system/home/home";
    }
}
