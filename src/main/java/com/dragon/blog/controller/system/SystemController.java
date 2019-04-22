package com.dragon.blog.controller.system;

import com.dragon.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/system")
public class SystemController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);
    /**
     * 测试后台管理跳转
     * @return
     */
    @RequestMapping("index")
    public String admin(){
        // 获得当前Subject
        Subject currentUser = SecurityUtils.getSubject();
        // 验证用户是否验证，即是否登录
        if (!currentUser.isAuthenticated()) {
            return "redirect:sso/login";
        }
        return "system/index";
    }

    /**
     * 测试后台管理跳转
     * @return
     */
    @RequestMapping("home")
    public String home(){
        return "system/home/home";
    }
}
