package com.dragon.blog.service;

import com.dragon.blog.model.BlogSysUser;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/19 22:41
 * @description： Blog系统接口
 * @modified By：
 * @version: $version$
 */
public interface BlogSysApiService {

    /**
     * 根据username获取BlogSysUser 接口
     * @param username
     * @return
     */
    BlogSysUser selectBlogSysUserByUsername(String username);
}
