package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysDictTypeMapper;
import com.dragon.blog.model.BlogSysDictType;
import com.dragon.blog.model.BlogSysDictTypeExample;
import com.dragon.blog.service.BlogSysDictTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysDictTypeService实现
* Created by Dragon.Wen on 2019/6/10.
*/
@Service
@Transactional
@BaseService
public class BlogSysDictTypeServiceImpl extends BaseServiceImpl<BlogSysDictTypeMapper, BlogSysDictType, BlogSysDictTypeExample> implements BlogSysDictTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysDictTypeServiceImpl.class);

    @Autowired
    BlogSysDictTypeMapper blogSysDictTypeMapper;

}