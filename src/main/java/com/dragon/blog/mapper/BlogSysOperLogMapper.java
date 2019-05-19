package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysOperLog;
import com.dragon.blog.model.BlogSysOperLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysOperLogMapper {
    long countByExample(BlogSysOperLogExample example);

    int deleteByExample(BlogSysOperLogExample example);

    int deleteByPrimaryKey(Integer operId);

    int insert(BlogSysOperLog record);

    int insertSelective(BlogSysOperLog record);

    List<BlogSysOperLog> selectByExample(BlogSysOperLogExample example);

    BlogSysOperLog selectByPrimaryKey(Integer operId);

    int updateByExampleSelective(@Param("record") BlogSysOperLog record, @Param("example") BlogSysOperLogExample example);

    int updateByExample(@Param("record") BlogSysOperLog record, @Param("example") BlogSysOperLogExample example);

    int updateByPrimaryKeySelective(BlogSysOperLog record);

    int updateByPrimaryKey(BlogSysOperLog record);
}