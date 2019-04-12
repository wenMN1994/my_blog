package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysDictionariesMapper;
import com.dragon.blog.model.BlogSysDictionaries;
import com.dragon.blog.model.BlogSysDictionariesExample;
import com.dragon.blog.service.BlogSysDictionariesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysDictionariesService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysDictionariesServiceImpl extends BaseServiceImpl<BlogSysDictionariesMapper, BlogSysDictionaries, BlogSysDictionariesExample> implements BlogSysDictionariesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysDictionariesServiceImpl.class);

    @Autowired
    BlogSysDictionariesMapper blogSysDictionariesMapper;

}