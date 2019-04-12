package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysAppUserMapper;
import com.dragon.blog.model.BlogSysAppUser;
import com.dragon.blog.model.BlogSysAppUserExample;
import com.dragon.blog.service.BlogSysAppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysAppUserService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysAppUserServiceImpl extends BaseServiceImpl<BlogSysAppUserMapper, BlogSysAppUser, BlogSysAppUserExample> implements BlogSysAppUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysAppUserServiceImpl.class);

    @Autowired
    BlogSysAppUserMapper blogSysAppUserMapper;

}