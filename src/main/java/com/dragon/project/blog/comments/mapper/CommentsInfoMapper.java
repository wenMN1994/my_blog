package com.dragon.project.blog.comments.mapper;

import com.dragon.project.blog.comments.domain.CommentsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/8/17 11:19
 * @description：新建评论处理数据层
 * @modified By：
 * @version: 1.0.0
 */
public interface CommentsInfoMapper {
    /**
     * 插入评论信息
     * @param commentsInfo
     * @return
     */
    int insertCommentInfo(CommentsInfo commentsInfo);

    /**
     * 根据被评论对象ID查询评论信息
     * @param ownerId
     * @return
     */
    List<CommentsInfo> selectCommentsInfoByOwnerId(@Param("ownerId") Integer ownerId);
}