package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysButtonMapper;
import com.dragon.blog.model.BlogSysButton;
import com.dragon.blog.model.BlogSysButtonExample;
import com.dragon.blog.service.BlogSysButtonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysButtonService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysButtonServiceImpl extends BaseServiceImpl<BlogSysButtonMapper, BlogSysButton, BlogSysButtonExample> implements BlogSysButtonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysButtonServiceImpl.class);

    @Autowired
    BlogSysButtonMapper blogSysButtonMapper;

}