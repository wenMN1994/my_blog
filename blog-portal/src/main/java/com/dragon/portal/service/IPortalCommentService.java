package com.dragon.portal.service;

import java.util.List;
import com.dragon.portal.domain.PortalComment;

/**
 * 评论管理Service接口
 *
 * @author dragon
 * @date 2024-06-29
 */
public interface IPortalCommentService {
    /**
     * 查询评论管理
     *
     * @param commentId 评论管理主键
     * @return 评论管理
     */
    public PortalComment selectPortalCommentBycommentId(Long commentId);

    /**
     * 查询评论管理列表
     *
     * @param portalComment 评论管理
     * @return 评论管理集合
     */
    public List<PortalComment> selectPortalCommentList(PortalComment portalComment);

    /**
     * 新增评论管理
     *
     * @param portalComment 评论管理
     * @return 结果
     */
    public int insertPortalComment(PortalComment portalComment);

    /**
     * 审核评论管理
     *
     * @param portalComment 评论管理
     * @return 结果
     */
    public int updatePortalComment(PortalComment portalComment);

    /**
     * 删除评论管理信息
     *
     * @param commentId 评论管理主键
     * @return 结果
     */
    public int deletePortalCommentByCommentId(Long commentId);
}