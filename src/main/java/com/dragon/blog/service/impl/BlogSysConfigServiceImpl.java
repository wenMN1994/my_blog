package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysConfigMapper;
import com.dragon.blog.model.BlogSysConfig;
import com.dragon.blog.model.BlogSysConfigExample;
import com.dragon.blog.service.BlogSysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysConfigService实现
* Created by Dragon.Wen on 2019/6/14.
*/
@Service
@Transactional
@BaseService
public class BlogSysConfigServiceImpl extends BaseServiceImpl<BlogSysConfigMapper, BlogSysConfig, BlogSysConfigExample> implements BlogSysConfigService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysConfigServiceImpl.class);

    @Autowired
    BlogSysConfigMapper blogSysConfigMapper;

}