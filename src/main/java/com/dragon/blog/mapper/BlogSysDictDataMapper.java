package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysDictData;
import com.dragon.blog.model.BlogSysDictDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysDictDataMapper {
    long countByExample(BlogSysDictDataExample example);

    int deleteByExample(BlogSysDictDataExample example);

    int deleteByPrimaryKey(Integer dictCode);

    int insert(BlogSysDictData record);

    int insertSelective(BlogSysDictData record);

    List<BlogSysDictData> selectByExample(BlogSysDictDataExample example);

    BlogSysDictData selectByPrimaryKey(Integer dictCode);

    int updateByExampleSelective(@Param("record") BlogSysDictData record, @Param("example") BlogSysDictDataExample example);

    int updateByExample(@Param("record") BlogSysDictData record, @Param("example") BlogSysDictDataExample example);

    int updateByPrimaryKeySelective(BlogSysDictData record);

    int updateByPrimaryKey(BlogSysDictData record);
}