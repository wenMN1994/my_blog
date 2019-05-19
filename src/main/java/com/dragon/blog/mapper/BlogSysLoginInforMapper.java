package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysLoginInfor;
import com.dragon.blog.model.BlogSysLoginInforExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysLoginInforMapper {
    long countByExample(BlogSysLoginInforExample example);

    int deleteByExample(BlogSysLoginInforExample example);

    int deleteByPrimaryKey(Integer infoId);

    int insert(BlogSysLoginInfor record);

    int insertSelective(BlogSysLoginInfor record);

    List<BlogSysLoginInfor> selectByExample(BlogSysLoginInforExample example);

    BlogSysLoginInfor selectByPrimaryKey(Integer infoId);

    int updateByExampleSelective(@Param("record") BlogSysLoginInfor record, @Param("example") BlogSysLoginInforExample example);

    int updateByExample(@Param("record") BlogSysLoginInfor record, @Param("example") BlogSysLoginInforExample example);

    int updateByPrimaryKeySelective(BlogSysLoginInfor record);

    int updateByPrimaryKey(BlogSysLoginInfor record);
}