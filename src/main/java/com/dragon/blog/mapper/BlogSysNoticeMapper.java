package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysNotice;
import com.dragon.blog.model.BlogSysNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysNoticeMapper {
    long countByExample(BlogSysNoticeExample example);

    int deleteByExample(BlogSysNoticeExample example);

    int deleteByPrimaryKey(Integer noticeId);

    int insert(BlogSysNotice record);

    int insertSelective(BlogSysNotice record);

    List<BlogSysNotice> selectByExample(BlogSysNoticeExample example);

    BlogSysNotice selectByPrimaryKey(Integer noticeId);

    int updateByExampleSelective(@Param("record") BlogSysNotice record, @Param("example") BlogSysNoticeExample example);

    int updateByExample(@Param("record") BlogSysNotice record, @Param("example") BlogSysNoticeExample example);

    int updateByPrimaryKeySelective(BlogSysNotice record);

    int updateByPrimaryKey(BlogSysNotice record);
}