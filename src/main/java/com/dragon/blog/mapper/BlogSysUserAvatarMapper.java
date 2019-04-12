package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysUserAvatar;
import com.dragon.blog.model.BlogSysUserAvatarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysUserAvatarMapper {
    long countByExample(BlogSysUserAvatarExample example);

    int deleteByExample(BlogSysUserAvatarExample example);

    int deleteByPrimaryKey(String userPhotoId);

    int insert(BlogSysUserAvatar record);

    int insertSelective(BlogSysUserAvatar record);

    List<BlogSysUserAvatar> selectByExample(BlogSysUserAvatarExample example);

    BlogSysUserAvatar selectByPrimaryKey(String userPhotoId);

    int updateByExampleSelective(@Param("record") BlogSysUserAvatar record, @Param("example") BlogSysUserAvatarExample example);

    int updateByExample(@Param("record") BlogSysUserAvatar record, @Param("example") BlogSysUserAvatarExample example);

    int updateByPrimaryKeySelective(BlogSysUserAvatar record);

    int updateByPrimaryKey(BlogSysUserAvatar record);
}