package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysUserRoleMapper;
import com.dragon.blog.model.BlogSysUserRole;
import com.dragon.blog.model.BlogSysUserRoleExample;
import com.dragon.blog.service.BlogSysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysUserRoleService实现
* Created by Dragon.Wen on 2019/5/19.
*/
@Service
@Transactional
@BaseService
public class BlogSysUserRoleServiceImpl extends BaseServiceImpl<BlogSysUserRoleMapper, BlogSysUserRole, BlogSysUserRoleExample> implements BlogSysUserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysUserRoleServiceImpl.class);

    @Autowired
    BlogSysUserRoleMapper blogSysUserRoleMapper;

}