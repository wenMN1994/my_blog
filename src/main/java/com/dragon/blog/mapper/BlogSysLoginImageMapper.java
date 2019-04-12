package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysLoginImage;
import com.dragon.blog.model.BlogSysLoginImageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysLoginImageMapper {
    long countByExample(BlogSysLoginImageExample example);

    int deleteByExample(BlogSysLoginImageExample example);

    int deleteByPrimaryKey(String loginImageId);

    int insert(BlogSysLoginImage record);

    int insertSelective(BlogSysLoginImage record);

    List<BlogSysLoginImage> selectByExample(BlogSysLoginImageExample example);

    BlogSysLoginImage selectByPrimaryKey(String loginImageId);

    int updateByExampleSelective(@Param("record") BlogSysLoginImage record, @Param("example") BlogSysLoginImageExample example);

    int updateByExample(@Param("record") BlogSysLoginImage record, @Param("example") BlogSysLoginImageExample example);

    int updateByPrimaryKeySelective(BlogSysLoginImage record);

    int updateByPrimaryKey(BlogSysLoginImage record);
}