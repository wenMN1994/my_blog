package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysBlickList;
import com.dragon.blog.model.BlogSysBlickListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysBlickListMapper {
    long countByExample(BlogSysBlickListExample example);

    int deleteByExample(BlogSysBlickListExample example);

    int deleteByPrimaryKey(Integer blacklistId);

    int insert(BlogSysBlickList record);

    int insertSelective(BlogSysBlickList record);

    List<BlogSysBlickList> selectByExample(BlogSysBlickListExample example);

    BlogSysBlickList selectByPrimaryKey(Integer blacklistId);

    int updateByExampleSelective(@Param("record") BlogSysBlickList record, @Param("example") BlogSysBlickListExample example);

    int updateByExample(@Param("record") BlogSysBlickList record, @Param("example") BlogSysBlickListExample example);

    int updateByPrimaryKeySelective(BlogSysBlickList record);

    int updateByPrimaryKey(BlogSysBlickList record);
}