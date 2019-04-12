package com.dragon.blog.service;

import com.dragon.base.BaseServiceMock;
import com.dragon.blog.mapper.BlogSysAppUserMapper;
import com.dragon.blog.model.BlogSysAppUser;
import com.dragon.blog.model.BlogSysAppUserExample;

/**
* 降级实现BlogSysAppUserService接口
* Created by Dragon.Wen on 2019/4/12.
*/
public class BlogSysAppUserServiceMock extends BaseServiceMock<BlogSysAppUserMapper, BlogSysAppUser, BlogSysAppUserExample> implements BlogSysAppUserService {

}
