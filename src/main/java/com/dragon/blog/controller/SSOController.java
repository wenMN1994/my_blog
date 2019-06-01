package com.dragon.blog.controller;

import com.dragon.base.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/13 15:02
 * @description 单点登录Controller
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/sso")
@Configuration
public class SSOController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SSOController.class);

    /**
     * 登录成功后跳转链接
     */
    @Value("${blog.sso.successUrl}")
    private String loginSuccessUrl;

    /**
     * 登录页面跳转方法
     * @return 登录页面地址
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "system/sso/login";
    }

    /**
     * 登录请求方法
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request) {
        //获取用户输入的用户名
        String username = request.getParameter("username");
        //获取用户输入的密码
        String password = request.getParameter("password");
        //获取用户是否选择“记住我”
        String rememberMe = request.getParameter("rememberMe");

        try {
            // 使用shiro认证
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password,rememberMe);
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            return success();
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @RequestMapping(value = "unauth", method = RequestMethod.GET)
    public String unauth() {
        return "error/403";
    }

}
