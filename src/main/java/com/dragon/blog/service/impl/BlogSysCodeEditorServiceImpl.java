package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysCodeEditorMapper;
import com.dragon.blog.model.BlogSysCodeEditor;
import com.dragon.blog.model.BlogSysCodeEditorExample;
import com.dragon.blog.service.BlogSysCodeEditorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogSysCodeEditorService实现
* Created by Dragon.Wen on 2019/6/10.
*/
@Service
@Transactional
@BaseService
public class BlogSysCodeEditorServiceImpl extends BaseServiceImpl<BlogSysCodeEditorMapper, BlogSysCodeEditor, BlogSysCodeEditorExample> implements BlogSysCodeEditorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysCodeEditorServiceImpl.class);

    @Autowired
    BlogSysCodeEditorMapper blogSysCodeEditorMapper;

}