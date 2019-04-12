package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysUser;
import com.dragon.blog.model.BlogSysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysUserMapper {
    long countByExample(BlogSysUserExample example);

    int deleteByExample(BlogSysUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(BlogSysUser record);

    int insertSelective(BlogSysUser record);

    List<BlogSysUser> selectByExample(BlogSysUserExample example);

    BlogSysUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") BlogSysUser record, @Param("example") BlogSysUserExample example);

    int updateByExample(@Param("record") BlogSysUser record, @Param("example") BlogSysUserExample example);

    int updateByPrimaryKeySelective(BlogSysUser record);

    int updateByPrimaryKey(BlogSysUser record);
}