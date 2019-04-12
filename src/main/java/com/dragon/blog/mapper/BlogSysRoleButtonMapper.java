package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysRoleButton;
import com.dragon.blog.model.BlogSysRoleButtonExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysRoleButtonMapper {
    long countByExample(BlogSysRoleButtonExample example);

    int deleteByExample(BlogSysRoleButtonExample example);

    int deleteByPrimaryKey(String roleButtonId);

    int insert(BlogSysRoleButton record);

    int insertSelective(BlogSysRoleButton record);

    List<BlogSysRoleButton> selectByExample(BlogSysRoleButtonExample example);

    BlogSysRoleButton selectByPrimaryKey(String roleButtonId);

    int updateByExampleSelective(@Param("record") BlogSysRoleButton record, @Param("example") BlogSysRoleButtonExample example);

    int updateByExample(@Param("record") BlogSysRoleButton record, @Param("example") BlogSysRoleButtonExample example);

    int updateByPrimaryKeySelective(BlogSysRoleButton record);

    int updateByPrimaryKey(BlogSysRoleButton record);
}