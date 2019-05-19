package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysRoleMenu;
import com.dragon.blog.model.BlogSysRoleMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysRoleMenuMapper {
    long countByExample(BlogSysRoleMenuExample example);

    int deleteByExample(BlogSysRoleMenuExample example);

    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);

    int insert(BlogSysRoleMenu record);

    int insertSelective(BlogSysRoleMenu record);

    List<BlogSysRoleMenu> selectByExample(BlogSysRoleMenuExample example);

    int updateByExampleSelective(@Param("record") BlogSysRoleMenu record, @Param("example") BlogSysRoleMenuExample example);

    int updateByExample(@Param("record") BlogSysRoleMenu record, @Param("example") BlogSysRoleMenuExample example);
}