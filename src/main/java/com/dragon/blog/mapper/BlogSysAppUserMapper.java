package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysAppUser;
import com.dragon.blog.model.BlogSysAppUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysAppUserMapper {
    long countByExample(BlogSysAppUserExample example);

    int deleteByExample(BlogSysAppUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(BlogSysAppUser record);

    int insertSelective(BlogSysAppUser record);

    List<BlogSysAppUser> selectByExample(BlogSysAppUserExample example);

    BlogSysAppUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") BlogSysAppUser record, @Param("example") BlogSysAppUserExample example);

    int updateByExample(@Param("record") BlogSysAppUser record, @Param("example") BlogSysAppUserExample example);

    int updateByPrimaryKeySelective(BlogSysAppUser record);

    int updateByPrimaryKey(BlogSysAppUser record);
}