package com.dragon.project.blog.comments.service;

import com.dragon.project.blog.comments.domain.CommentsInfo;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/8/17 11:22
 * @description：新建评论服务层接口
 * @modified By：
 * @version: 1.0.0
 */
public interface CommentsInfoService {
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
    List<CommentsInfo> selectCommentsInfoByOwnerId(Integer ownerId);
}
