package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysUserRole;
import com.dragon.blog.model.BlogSysUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysUserRoleMapper {
    long countByExample(BlogSysUserRoleExample example);

    int deleteByExample(BlogSysUserRoleExample example);

    int deleteByPrimaryKey(Integer userRoleId);

    int insert(BlogSysUserRole record);

    int insertSelective(BlogSysUserRole record);

    List<BlogSysUserRole> selectByExample(BlogSysUserRoleExample example);

    BlogSysUserRole selectByPrimaryKey(Integer userRoleId);

    int updateByExampleSelective(@Param("record") BlogSysUserRole record, @Param("example") BlogSysUserRoleExample example);

    int updateByExample(@Param("record") BlogSysUserRole record, @Param("example") BlogSysUserRoleExample example);

    int updateByPrimaryKeySelective(BlogSysUserRole record);

    int updateByPrimaryKey(BlogSysUserRole record);
}