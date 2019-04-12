package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysStatisticsMapper;
import com.dragon.blog.model.BlogSysStatistics;
import com.dragon.blog.model.BlogSysStatisticsExample;
import com.dragon.blog.service.BlogSysStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysStatisticsService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysStatisticsServiceImpl extends BaseServiceImpl<BlogSysStatisticsMapper, BlogSysStatistics, BlogSysStatisticsExample> implements BlogSysStatisticsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysStatisticsServiceImpl.class);

    @Autowired
    BlogSysStatisticsMapper blogSysStatisticsMapper;

}