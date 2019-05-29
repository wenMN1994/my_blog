package com.dragon.client.shiro.service;

import com.dragon.blog.model.BlogSysUser;
import com.dragon.blog.service.BlogSysApiService;
import com.dragon.blog.service.BlogSysUserService;
import com.dragon.utils.DateUtils;
import com.dragon.utils.security.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        // 查询用户信息
        BlogSysUser blogSysUser = blogSysApiService.selectBlogSysUserByUsername(username);
        passwordService.validate(blogSysUser, password);

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
