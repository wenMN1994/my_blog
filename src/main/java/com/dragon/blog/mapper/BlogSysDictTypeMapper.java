package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysDictType;
import com.dragon.blog.model.BlogSysDictTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysDictTypeMapper {
    long countByExample(BlogSysDictTypeExample example);

    int deleteByExample(BlogSysDictTypeExample example);

    int deleteByPrimaryKey(Integer dictId);

    int insert(BlogSysDictType record);

    int insertSelective(BlogSysDictType record);

    List<BlogSysDictType> selectByExample(BlogSysDictTypeExample example);

    BlogSysDictType selectByPrimaryKey(Integer dictId);

    int updateByExampleSelective(@Param("record") BlogSysDictType record, @Param("example") BlogSysDictTypeExample example);

    int updateByExample(@Param("record") BlogSysDictType record, @Param("example") BlogSysDictTypeExample example);

    int updateByPrimaryKeySelective(BlogSysDictType record);

    int updateByPrimaryKey(BlogSysDictType record);
}