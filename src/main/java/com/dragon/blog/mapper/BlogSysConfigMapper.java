package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysConfig;
import com.dragon.blog.model.BlogSysConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysConfigMapper {
    long countByExample(BlogSysConfigExample example);

    int deleteByExample(BlogSysConfigExample example);

    int deleteByPrimaryKey(Integer configId);

    int insert(BlogSysConfig record);

    int insertSelective(BlogSysConfig record);

    List<BlogSysConfig> selectByExample(BlogSysConfigExample example);

    BlogSysConfig selectByPrimaryKey(Integer configId);

    int updateByExampleSelective(@Param("record") BlogSysConfig record, @Param("example") BlogSysConfigExample example);

    int updateByExample(@Param("record") BlogSysConfig record, @Param("example") BlogSysConfigExample example);

    int updateByPrimaryKeySelective(BlogSysConfig record);

    int updateByPrimaryKey(BlogSysConfig record);
}