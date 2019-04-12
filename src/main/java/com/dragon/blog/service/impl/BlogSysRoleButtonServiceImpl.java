package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysRoleButtonMapper;
import com.dragon.blog.model.BlogSysRoleButton;
import com.dragon.blog.model.BlogSysRoleButtonExample;
import com.dragon.blog.service.BlogSysRoleButtonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysRoleButtonService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysRoleButtonServiceImpl extends BaseServiceImpl<BlogSysRoleButtonMapper, BlogSysRoleButton, BlogSysRoleButtonExample> implements BlogSysRoleButtonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysRoleButtonServiceImpl.class);

    @Autowired
    BlogSysRoleButtonMapper blogSysRoleButtonMapper;

}