package com.dragon.blog.controller;

import com.dragon.base.BaseController;
import com.dragon.common.CustomResultConstant;
import com.dragon.common.constant.CustomResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * @param response
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        //获取用户输入的用户名
        String username = request.getParameter("username");
        //获取用户输入的密码
        String password = request.getParameter("password");
        //判断用户名是否为空
        if (StringUtils.isBlank(username)) {
            return new CustomResult(CustomResultConstant.EMPTY_USERNAME, "帐号不能为空！");
        }
        //判断密码是否为空
        if (StringUtils.isBlank(password)) {
            return new CustomResult(CustomResultConstant.EMPTY_PASSWORD, "密码不能为空！");
        }
        try {
            // 使用shiro认证
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            LOGGER.info("登录失败：帐号不存在！");
            return new CustomResult(CustomResultConstant.INVALID_USERNAME, "帐号不存在！");
        } catch (IncorrectCredentialsException e) {
            LOGGER.info("登录失败：密码错误！");
            return new CustomResult(CustomResultConstant.INVALID_PASSWORD, "密码错误！");
        } catch (LockedAccountException e) {
            LOGGER.info("登录失败：帐号已锁定！");
            return new CustomResult(CustomResultConstant.INVALID_ACCOUNT, "帐号已锁定！");
        }

        return new CustomResult(CustomResultConstant.SUCCESS, loginSuccessUrl);

    }

    @RequestMapping(value = "unauth", method = RequestMethod.GET)
    public String unauth() {
        return "error/403";
    }

}
