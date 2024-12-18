package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.PortalComment;
import org.apache.ibatis.annotations.Param;

/**
 * 评论管理Mapper接口
 *
 * @author dragon
 * @date 2024-06-29
 */
public interface PortalCommentMapper {
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
     * 修改评论管理
     *
     * @param portalComment 评论管理
     * @return 结果
     */
    public int updatePortalComment(PortalComment portalComment);

    /**
     * 删除评论管理
     * @param commentId
     * @return
     */
    public int deletePortalCommentByCommentId(@Param("commentId") Long commentId);

    /**
     * 获取回复评论
     * @param commentId
     * @return
     */
    public List<PortalComment> selectPortalCommentByReplyCommentId(Long commentId);

    /**
     * 根据该路由地址下所有评论（仅查询状态正常的）
     * @param routerUrl
     * @param status
     * @return
     */
    public List<PortalComment> selectByRouterUrlAndStatus(@Param("routerUrl") String routerUrl, @Param("status") Integer status);
}