package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysDictionaries;
import com.dragon.blog.model.BlogSysDictionariesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysDictionariesMapper {
    long countByExample(BlogSysDictionariesExample example);

    int deleteByExample(BlogSysDictionariesExample example);

    int insert(BlogSysDictionaries record);

    int insertSelective(BlogSysDictionaries record);

    List<BlogSysDictionaries> selectByExample(BlogSysDictionariesExample example);

    int updateByExampleSelective(@Param("record") BlogSysDictionaries record, @Param("example") BlogSysDictionariesExample example);

    int updateByExample(@Param("record") BlogSysDictionaries record, @Param("example") BlogSysDictionariesExample example);
}