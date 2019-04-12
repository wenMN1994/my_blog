package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysRole;
import com.dragon.blog.model.BlogSysRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysRoleMapper {
    long countByExample(BlogSysRoleExample example);

    int deleteByExample(BlogSysRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(BlogSysRole record);

    int insertSelective(BlogSysRole record);

    List<BlogSysRole> selectByExample(BlogSysRoleExample example);

    BlogSysRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") BlogSysRole record, @Param("example") BlogSysRoleExample example);

    int updateByExample(@Param("record") BlogSysRole record, @Param("example") BlogSysRoleExample example);

    int updateByPrimaryKeySelective(BlogSysRole record);

    int updateByPrimaryKey(BlogSysRole record);
}