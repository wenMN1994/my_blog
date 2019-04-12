package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysLoginImageMapper;
import com.dragon.blog.model.BlogSysLoginImage;
import com.dragon.blog.model.BlogSysLoginImageExample;
import com.dragon.blog.service.BlogSysLoginImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysLoginImageService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysLoginImageServiceImpl extends BaseServiceImpl<BlogSysLoginImageMapper, BlogSysLoginImage, BlogSysLoginImageExample> implements BlogSysLoginImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysLoginImageServiceImpl.class);

    @Autowired
    BlogSysLoginImageMapper blogSysLoginImageMapper;

}