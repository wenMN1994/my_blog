package com.dragon.blog.service;

import com.dragon.base.BaseServiceMock;
import com.dragon.blog.mapper.BlogSysUserOnlineMapper;
import com.dragon.blog.model.BlogSysUserOnline;
import com.dragon.blog.model.BlogSysUserOnlineExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
* 降级实现BlogSysUserOnlineService接口
* Created by Dragon.Wen on 2019/6/10.
*/
public class BlogSysUserOnlineServiceMock extends BaseServiceMock<BlogSysUserOnlineMapper, BlogSysUserOnline, BlogSysUserOnlineExample> implements BlogSysUserOnlineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysUserOnlineServiceMock.class);

    @Override
    public void saveOnline(BlogSysUserOnline online) {
        LOGGER.info("BlogSysUserOnlineServiceMock => saveOnline");
        return;
    }

    @Override
    public void batchDeleteOnline(List<String> needOfflineIdList) {
        LOGGER.info("BlogSysUserOnlineServiceMock => batchDeleteOnline");
    }

}
