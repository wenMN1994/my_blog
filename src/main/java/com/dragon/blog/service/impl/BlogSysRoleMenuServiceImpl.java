package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysRoleMenuMapper;
import com.dragon.blog.model.BlogSysRoleMenu;
import com.dragon.blog.model.BlogSysRoleMenuExample;
import com.dragon.blog.service.BlogSysRoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysRoleMenuService实现
* Created by Dragon.Wen on 2019/5/19.
*/
@Service
@Transactional
@BaseService
public class BlogSysRoleMenuServiceImpl extends BaseServiceImpl<BlogSysRoleMenuMapper, BlogSysRoleMenu, BlogSysRoleMenuExample> implements BlogSysRoleMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysRoleMenuServiceImpl.class);

    @Autowired
    BlogSysRoleMenuMapper blogSysRoleMenuMapper;

}