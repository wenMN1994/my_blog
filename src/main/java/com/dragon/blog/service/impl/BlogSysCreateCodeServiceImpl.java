package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysCreateCodeMapper;
import com.dragon.blog.model.BlogSysCreateCode;
import com.dragon.blog.model.BlogSysCreateCodeExample;
import com.dragon.blog.service.BlogSysCreateCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysCreateCodeService实现
* Created by Dragon.Wen on 2019/5/19.
*/
@Service
@Transactional
@BaseService
public class BlogSysCreateCodeServiceImpl extends BaseServiceImpl<BlogSysCreateCodeMapper, BlogSysCreateCode, BlogSysCreateCodeExample> implements BlogSysCreateCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysCreateCodeServiceImpl.class);

    @Autowired
    BlogSysCreateCodeMapper blogSysCreateCodeMapper;

}