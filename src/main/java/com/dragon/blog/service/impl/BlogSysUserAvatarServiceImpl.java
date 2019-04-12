package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysUserAvatarMapper;
import com.dragon.blog.model.BlogSysUserAvatar;
import com.dragon.blog.model.BlogSysUserAvatarExample;
import com.dragon.blog.service.BlogSysUserAvatarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysUserAvatarService实现
* Created by Dragon.Wen on 2019/4/12.
*/
@Service
@Transactional
@BaseService
public class BlogSysUserAvatarServiceImpl extends BaseServiceImpl<BlogSysUserAvatarMapper, BlogSysUserAvatar, BlogSysUserAvatarExample> implements BlogSysUserAvatarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysUserAvatarServiceImpl.class);

    @Autowired
    BlogSysUserAvatarMapper blogSysUserAvatarMapper;

}