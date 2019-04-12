package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogMenuMapper;
import com.dragon.blog.model.BlogMenu;
import com.dragon.blog.model.BlogMenuExample;
import com.dragon.blog.service.BlogMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogMenuService实现
* Created by Dragon.Wen on 2019/4/4.
*/
@Service
@Transactional
@BaseService
public class BlogMenuServiceImpl extends BaseServiceImpl<BlogMenuMapper, BlogMenu, BlogMenuExample> implements BlogMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogMenuServiceImpl.class);

    @Autowired
    BlogMenuMapper blogMenuMapper;

}