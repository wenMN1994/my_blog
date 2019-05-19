package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysUserOnline;
import com.dragon.blog.model.BlogSysUserOnlineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysUserOnlineMapper {
    long countByExample(BlogSysUserOnlineExample example);

    int deleteByExample(BlogSysUserOnlineExample example);

    int deleteByPrimaryKey(String sessionid);

    int insert(BlogSysUserOnline record);

    int insertSelective(BlogSysUserOnline record);

    List<BlogSysUserOnline> selectByExample(BlogSysUserOnlineExample example);

    BlogSysUserOnline selectByPrimaryKey(String sessionid);

    int updateByExampleSelective(@Param("record") BlogSysUserOnline record, @Param("example") BlogSysUserOnlineExample example);

    int updateByExample(@Param("record") BlogSysUserOnline record, @Param("example") BlogSysUserOnlineExample example);

    int updateByPrimaryKeySelective(BlogSysUserOnline record);

    int updateByPrimaryKey(BlogSysUserOnline record);
}