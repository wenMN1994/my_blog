package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogAdPositions;
import com.dragon.blog.model.BlogAdPositionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogAdPositionsMapper {
    long countByExample(BlogAdPositionsExample example);

    int deleteByExample(BlogAdPositionsExample example);

    int deleteByPrimaryKey(Integer positionId);

    int insert(BlogAdPositions record);

    int insertSelective(BlogAdPositions record);

    List<BlogAdPositions> selectByExample(BlogAdPositionsExample example);

    BlogAdPositions selectByPrimaryKey(Integer positionId);

    int updateByExampleSelective(@Param("record") BlogAdPositions record, @Param("example") BlogAdPositionsExample example);

    int updateByExample(@Param("record") BlogAdPositions record, @Param("example") BlogAdPositionsExample example);

    int updateByPrimaryKeySelective(BlogAdPositions record);

    int updateByPrimaryKey(BlogAdPositions record);
}