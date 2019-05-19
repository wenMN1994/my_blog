package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysDictDataMapper;
import com.dragon.blog.model.BlogSysDictData;
import com.dragon.blog.model.BlogSysDictDataExample;
import com.dragon.blog.service.BlogSysDictDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysDictDataService实现
* Created by Dragon.Wen on 2019/5/19.
*/
@Service
@Transactional
@BaseService
public class BlogSysDictDataServiceImpl extends BaseServiceImpl<BlogSysDictDataMapper, BlogSysDictData, BlogSysDictDataExample> implements BlogSysDictDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysDictDataServiceImpl.class);

    @Autowired
    BlogSysDictDataMapper blogSysDictDataMapper;

}