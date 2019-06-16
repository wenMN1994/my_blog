package com.dragon.blog.service;

import com.dragon.base.BaseServiceMock;
import com.dragon.blog.mapper.BlogSysMenuMapper;
import com.dragon.blog.model.BlogSysMenu;
import com.dragon.blog.model.BlogSysMenuExample;
import com.dragon.blog.model.BlogSysRole;
import com.dragon.web.domain.Ztree;

import java.util.List;

/**
* 降级实现BlogSysMenuService接口
* Created by Dragon.Wen on 2019/6/10.
*/
public class BlogSysMenuServiceMock extends BaseServiceMock<BlogSysMenuMapper, BlogSysMenu, BlogSysMenuExample> implements BlogSysMenuService {

    @Override
    public List<Ztree> roleMenuTreeData(BlogSysRole blogSysRole) {
        return null;
    }
}
