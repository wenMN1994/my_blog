package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysBlickListMapper;
import com.dragon.blog.model.BlogSysBlickList;
import com.dragon.blog.model.BlogSysBlickListExample;
import com.dragon.blog.service.BlogSysBlickListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysBlickListService实现
* Created by Dragon.Wen on 2019/5/19.
*/
@Service
@Transactional
@BaseService
public class BlogSysBlickListServiceImpl extends BaseServiceImpl<BlogSysBlickListMapper, BlogSysBlickList, BlogSysBlickListExample> implements BlogSysBlickListService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysBlickListServiceImpl.class);

    @Autowired
    BlogSysBlickListMapper blogSysBlickListMapper;

}