package com.dragon.blog.service.impl;

import com.dragon.blog.mapper.BlogSysUserMapper;
import com.dragon.blog.model.BlogSysUser;
import com.dragon.blog.model.BlogSysUserExample;
import com.dragon.blog.service.BlogSysApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/19 22:47
 * @description： BlogSysApiService实现
 * @modified By：
 * @version: $version$
 */
@Service
@Transactional
public class BlogSysApiServiceImpl implements BlogSysApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysApiServiceImpl.class);

    @Autowired
    BlogSysUserMapper blogSysUserMapper;

    /**
     * 根据username获取BlogSysUser 实现
     * @param username
     * @return
     */
    @Override
    public BlogSysUser selectBlogSysUserByUsername(String username) {
        BlogSysUserExample blogSysUserExample = new BlogSysUserExample();
        blogSysUserExample.createCriteria().andLoginNameEqualTo(username);
        List<BlogSysUser> blogSysUsers = blogSysUserMapper.selectByExample(blogSysUserExample);
        if(null != blogSysUsers && blogSysUsers.size() > 0){
            return blogSysUsers.get(0);
        }
        return null;
    }
}
