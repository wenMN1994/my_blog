package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysUserOnlineMapper;
import com.dragon.blog.model.BlogSysUserOnline;
import com.dragon.blog.model.BlogSysUserOnlineExample;
import com.dragon.blog.service.BlogSysUserOnlineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysUserOnlineService实现
* Created by Dragon.Wen on 2019/5/19.
*/
@Service
@Transactional
@BaseService
public class BlogSysUserOnlineServiceImpl extends BaseServiceImpl<BlogSysUserOnlineMapper, BlogSysUserOnline, BlogSysUserOnlineExample> implements BlogSysUserOnlineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysUserOnlineServiceImpl.class);

    @Autowired
    BlogSysUserOnlineMapper blogSysUserOnlineMapper;

}