package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogAdPositionsMapper;
import com.dragon.blog.model.BlogAdPositions;
import com.dragon.blog.model.BlogAdPositionsExample;
import com.dragon.blog.service.BlogAdPositionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogAdPositionsService实现
* Created by Dragon.Wen on 2019/4/4.
*/
@Service
@Transactional
@BaseService
public class BlogAdPositionsServiceImpl extends BaseServiceImpl<BlogAdPositionsMapper, BlogAdPositions, BlogAdPositionsExample> implements BlogAdPositionsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogAdPositionsServiceImpl.class);

    @Autowired
    BlogAdPositionsMapper blogAdPositionsMapper;

}