package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysOperLogMapper;
import com.dragon.blog.model.BlogSysOperLog;
import com.dragon.blog.model.BlogSysOperLogExample;
import com.dragon.blog.service.BlogSysOperLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysOperLogService实现
* Created by Dragon.Wen on 2019/6/10.
*/
@Service
@Transactional
@BaseService
public class BlogSysOperLogServiceImpl extends BaseServiceImpl<BlogSysOperLogMapper, BlogSysOperLog, BlogSysOperLogExample> implements BlogSysOperLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysOperLogServiceImpl.class);

    @Autowired
    BlogSysOperLogMapper blogSysOperLogMapper;

}