package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysUserMapper;
import com.dragon.blog.model.BlogSysUser;
import com.dragon.blog.model.BlogSysUserExample;
import com.dragon.blog.service.BlogSysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysUserService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysUserServiceImpl extends BaseServiceImpl<BlogSysUserMapper, BlogSysUser, BlogSysUserExample> implements BlogSysUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysUserServiceImpl.class);

    @Autowired
    BlogSysUserMapper blogSysUserMapper;

}