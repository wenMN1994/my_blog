package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysNoticeMapper;
import com.dragon.blog.model.BlogSysNotice;
import com.dragon.blog.model.BlogSysNoticeExample;
import com.dragon.blog.service.BlogSysNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysNoticeService实现
* Created by Dragon.Wen on 2019/6/14.
*/
@Service
@Transactional
@BaseService
public class BlogSysNoticeServiceImpl extends BaseServiceImpl<BlogSysNoticeMapper, BlogSysNotice, BlogSysNoticeExample> implements BlogSysNoticeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysNoticeServiceImpl.class);

    @Autowired
    BlogSysNoticeMapper blogSysNoticeMapper;

}