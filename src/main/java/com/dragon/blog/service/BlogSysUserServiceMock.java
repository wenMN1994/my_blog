package com.dragon.blog.service;

import com.dragon.base.BaseServiceMock;
import com.dragon.blog.mapper.BlogSysUserMapper;
import com.dragon.blog.model.BlogSysUser;
import com.dragon.blog.model.BlogSysUserExample;

/**
* 降级实现BlogSysUserService接口
* Created by Dragon.Wen on 2019/4/12.
*/
public class BlogSysUserServiceMock extends BaseServiceMock<BlogSysUserMapper, BlogSysUser, BlogSysUserExample> implements BlogSysUserService {

}
