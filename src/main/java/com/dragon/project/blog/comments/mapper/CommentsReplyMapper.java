package com.dragon.project.blog.comments.mapper;

import com.dragon.project.blog.comments.domain.CommentsReply;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/8/17 11:25
 * @description：回复评论处理数据层
 * @modified By：
 * @version: 1.0.0
 */
public interface CommentsReplyMapper {
    /**
     * 插入回复信息数据
     * @param commentsReply
     * @return
     */
    int insertCommentReply(CommentsReply commentsReply);
}
