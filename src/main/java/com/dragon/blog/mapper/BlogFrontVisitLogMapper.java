package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogFrontVisitLog;
import com.dragon.blog.model.BlogFrontVisitLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogFrontVisitLogMapper {
    long countByExample(BlogFrontVisitLogExample example);

    int deleteByExample(BlogFrontVisitLogExample example);

    int deleteByPrimaryKey(Integer visitId);

    int insert(BlogFrontVisitLog record);

    int insertSelective(BlogFrontVisitLog record);

    List<BlogFrontVisitLog> selectByExample(BlogFrontVisitLogExample example);

    BlogFrontVisitLog selectByPrimaryKey(Integer visitId);

    int updateByExampleSelective(@Param("record") BlogFrontVisitLog record, @Param("example") BlogFrontVisitLogExample example);

    int updateByExample(@Param("record") BlogFrontVisitLog record, @Param("example") BlogFrontVisitLogExample example);

    int updateByPrimaryKeySelective(BlogFrontVisitLog record);

    int updateByPrimaryKey(BlogFrontVisitLog record);
}