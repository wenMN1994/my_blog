package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysRoleMapper;
import com.dragon.blog.model.BlogSysRole;
import com.dragon.blog.model.BlogSysRoleExample;
import com.dragon.blog.service.BlogSysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysRoleService实现
* Created by Dragon.Wen on 2019/5/19.
*/
@Service
@Transactional
@BaseService
public class BlogSysRoleServiceImpl extends BaseServiceImpl<BlogSysRoleMapper, BlogSysRole, BlogSysRoleExample> implements BlogSysRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysRoleServiceImpl.class);

    @Autowired
    BlogSysRoleMapper blogSysRoleMapper;

}