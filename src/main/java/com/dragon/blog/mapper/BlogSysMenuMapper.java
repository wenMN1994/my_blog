package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysMenu;
import com.dragon.blog.model.BlogSysMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysMenuMapper {
    long countByExample(BlogSysMenuExample example);

    int deleteByExample(BlogSysMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(BlogSysMenu record);

    int insertSelective(BlogSysMenu record);

    List<BlogSysMenu> selectByExample(BlogSysMenuExample example);

    BlogSysMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") BlogSysMenu record, @Param("example") BlogSysMenuExample example);

    int updateByExample(@Param("record") BlogSysMenu record, @Param("example") BlogSysMenuExample example);

    int updateByPrimaryKeySelective(BlogSysMenu record);

    int updateByPrimaryKey(BlogSysMenu record);
}