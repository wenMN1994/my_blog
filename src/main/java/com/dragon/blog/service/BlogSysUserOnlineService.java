package com.dragon.blog.service;

import com.dragon.base.BaseService;
import com.dragon.blog.model.BlogSysUserOnline;
import com.dragon.blog.model.BlogSysUserOnlineExample;

import java.util.List;

/**
* BlogSysUserOnlineService接口
* Created by Dragon.Wen on 2019/5/19.
*/
public interface BlogSysUserOnlineService extends BaseService<BlogSysUserOnline, BlogSysUserOnlineExample> {

    /**
     * 保存会话信息
     *
     * @param online 会话信息
     */
    void saveOnline(BlogSysUserOnline online);

    /**
     * 通过会话序号删除信息
     *
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    void batchDeleteOnline(List<String> needOfflineIdList);
}