package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysMenuMapper;
import com.dragon.blog.model.BlogSysMenu;
import com.dragon.blog.model.BlogSysMenuExample;
import com.dragon.blog.service.BlogSysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysMenuService实现
* Created by Dragon.Wen on 2019/6/10.
*/
@Service
@Transactional
@BaseService
public class BlogSysMenuServiceImpl extends BaseServiceImpl<BlogSysMenuMapper, BlogSysMenu, BlogSysMenuExample> implements BlogSysMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysMenuServiceImpl.class);

    @Autowired
    BlogSysMenuMapper blogSysMenuMapper;

}