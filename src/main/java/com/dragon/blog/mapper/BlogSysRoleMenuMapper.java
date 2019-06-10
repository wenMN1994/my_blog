package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysRoleMenu;
import com.dragon.blog.model.BlogSysRoleMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysRoleMenuMapper {
    long countByExample(BlogSysRoleMenuExample example);

    int deleteByExample(BlogSysRoleMenuExample example);

    int deleteByPrimaryKey(Integer roleMenuId);

    int insert(BlogSysRoleMenu record);

    int insertSelective(BlogSysRoleMenu record);

    List<BlogSysRoleMenu> selectByExample(BlogSysRoleMenuExample example);

    BlogSysRoleMenu selectByPrimaryKey(Integer roleMenuId);

    int updateByExampleSelective(@Param("record") BlogSysRoleMenu record, @Param("example") BlogSysRoleMenuExample example);

    int updateByExample(@Param("record") BlogSysRoleMenu record, @Param("example") BlogSysRoleMenuExample example);

    int updateByPrimaryKeySelective(BlogSysRoleMenu record);

    int updateByPrimaryKey(BlogSysRoleMenu record);
}