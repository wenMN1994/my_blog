package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysLog;
import com.dragon.blog.model.BlogSysLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysLogMapper {
    long countByExample(BlogSysLogExample example);

    int deleteByExample(BlogSysLogExample example);

    int deleteByPrimaryKey(String logId);

    int insert(BlogSysLog record);

    int insertSelective(BlogSysLog record);

    List<BlogSysLog> selectByExample(BlogSysLogExample example);

    BlogSysLog selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") BlogSysLog record, @Param("example") BlogSysLogExample example);

    int updateByExample(@Param("record") BlogSysLog record, @Param("example") BlogSysLogExample example);

    int updateByPrimaryKeySelective(BlogSysLog record);

    int updateByPrimaryKey(BlogSysLog record);
}