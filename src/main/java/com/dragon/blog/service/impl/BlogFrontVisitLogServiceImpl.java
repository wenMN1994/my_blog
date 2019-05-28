package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogFrontVisitLogMapper;
import com.dragon.blog.model.BlogFrontVisitLog;
import com.dragon.blog.model.BlogFrontVisitLogExample;
import com.dragon.blog.service.BlogFrontVisitLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogFrontVisitLogService实现
* Created by Dragon.Wen on 2019/5/27.
*/
@Service
@Transactional
@BaseService
public class BlogFrontVisitLogServiceImpl extends BaseServiceImpl<BlogFrontVisitLogMapper, BlogFrontVisitLog, BlogFrontVisitLogExample> implements BlogFrontVisitLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogFrontVisitLogServiceImpl.class);

    @Autowired
    BlogFrontVisitLogMapper blogFrontVisitLogMapper;

}