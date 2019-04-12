package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysButton;
import com.dragon.blog.model.BlogSysButtonExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysButtonMapper {
    long countByExample(BlogSysButtonExample example);

    int deleteByExample(BlogSysButtonExample example);

    int deleteByPrimaryKey(String buttonId);

    int insert(BlogSysButton record);

    int insertSelective(BlogSysButton record);

    List<BlogSysButton> selectByExample(BlogSysButtonExample example);

    BlogSysButton selectByPrimaryKey(String buttonId);

    int updateByExampleSelective(@Param("record") BlogSysButton record, @Param("example") BlogSysButtonExample example);

    int updateByExample(@Param("record") BlogSysButton record, @Param("example") BlogSysButtonExample example);

    int updateByPrimaryKeySelective(BlogSysButton record);

    int updateByPrimaryKey(BlogSysButton record);
}