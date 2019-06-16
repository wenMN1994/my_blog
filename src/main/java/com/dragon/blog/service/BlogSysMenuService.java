package com.dragon.blog.service;

import com.dragon.base.BaseService;
import com.dragon.blog.model.BlogSysMenu;
import com.dragon.blog.model.BlogSysMenuExample;
import com.dragon.blog.model.BlogSysRole;
import com.dragon.web.domain.Ztree;

import java.util.List;

/**
* BlogSysMenuService接口
* Created by Dragon.Wen on 2019/6/10.
*/
public interface BlogSysMenuService extends BaseService<BlogSysMenu, BlogSysMenuExample> {

    /**
     *
     * @param blogSysRole
     * @return
     */
    List<Ztree> roleMenuTreeData(BlogSysRole blogSysRole);
}