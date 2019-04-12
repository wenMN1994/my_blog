package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysCreateCode;
import com.dragon.blog.model.BlogSysCreateCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysCreateCodeMapper {
    long countByExample(BlogSysCreateCodeExample example);

    int deleteByExample(BlogSysCreateCodeExample example);

    int deleteByPrimaryKey(String createCodeId);

    int insert(BlogSysCreateCode record);

    int insertSelective(BlogSysCreateCode record);

    List<BlogSysCreateCode> selectByExample(BlogSysCreateCodeExample example);

    BlogSysCreateCode selectByPrimaryKey(String createCodeId);

    int updateByExampleSelective(@Param("record") BlogSysCreateCode record, @Param("example") BlogSysCreateCodeExample example);

    int updateByExample(@Param("record") BlogSysCreateCode record, @Param("example") BlogSysCreateCodeExample example);

    int updateByPrimaryKeySelective(BlogSysCreateCode record);

    int updateByPrimaryKey(BlogSysCreateCode record);
}