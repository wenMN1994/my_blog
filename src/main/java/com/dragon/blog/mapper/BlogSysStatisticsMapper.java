package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysStatistics;
import com.dragon.blog.model.BlogSysStatisticsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysStatisticsMapper {
    long countByExample(BlogSysStatisticsExample example);

    int deleteByExample(BlogSysStatisticsExample example);

    int deleteByPrimaryKey(String statisticsId);

    int insert(BlogSysStatistics record);

    int insertSelective(BlogSysStatistics record);

    List<BlogSysStatistics> selectByExample(BlogSysStatisticsExample example);

    BlogSysStatistics selectByPrimaryKey(String statisticsId);

    int updateByExampleSelective(@Param("record") BlogSysStatistics record, @Param("example") BlogSysStatisticsExample example);

    int updateByExample(@Param("record") BlogSysStatistics record, @Param("example") BlogSysStatisticsExample example);

    int updateByPrimaryKeySelective(BlogSysStatistics record);

    int updateByPrimaryKey(BlogSysStatistics record);
}