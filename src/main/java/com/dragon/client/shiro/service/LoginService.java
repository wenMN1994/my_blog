package com.dragon.client.shiro.service;

import com.dragon.blog.model.BlogSysUser;
import com.dragon.blog.service.BlogSysApiService;
import com.dragon.blog.service.BlogSysUserService;
import com.dragon.common.constant.Constants;
import com.dragon.common.constant.ShiroConstants;
import com.dragon.common.constant.UserConstants;
import com.dragon.common.exception.user.CaptchaException;
import com.dragon.common.exception.user.UserNotExistsException;
import com.dragon.common.exception.user.UserPasswordNotMatchException;
import com.dragon.manager.AsyncManager;
import com.dragon.manager.factory.AsyncFactory;
import com.dragon.utils.DateUtils;
import com.dragon.utils.MessageUtils;
import com.dragon.utils.ServletUtils;
import com.dragon.utils.security.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/5/29 14:53
 * @description： 登录校验方法
 * @modified By：
 * @version: 1.0.0
 */
@Component
public class LoginService {

    @Autowired
    private BlogSysApiService blogSysApiService;

    @Autowired
    private BlogSysUserService blogSysUserService;

    @Autowired
    private PasswordService passwordService;

    /**
     * 登录
     */
    public BlogSysUser login(String username, String password) {

        // 验证码校验
        if (!StringUtils.isEmpty(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA))) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }

        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 查询用户信息
        BlogSysUser blogSysUser = blogSysApiService.selectBlogSysUserByUsername(username);

        if (blogSysUser == null) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.not.exists")));
            throw new UserNotExistsException();
        }

        passwordService.validate(blogSysUser, password);

        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));

        recordLoginInfo(blogSysUser);
        return blogSysUser;
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(BlogSysUser blogSysUser) {
        blogSysUser.setLoginIp(ShiroUtils.getIp());
        blogSysUser.setLoginDate(DateUtils.getNowDate());
        blogSysUserService.updateByPrimaryKey(blogSysUser);
    }
}
