package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysLogMapper;
import com.dragon.blog.model.BlogSysLog;
import com.dragon.blog.model.BlogSysLogExample;
import com.dragon.blog.service.BlogSysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysLogService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysLogServiceImpl extends BaseServiceImpl<BlogSysLogMapper, BlogSysLog, BlogSysLogExample> implements BlogSysLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysLogServiceImpl.class);

    @Autowired
    BlogSysLogMapper blogSysLogMapper;

}