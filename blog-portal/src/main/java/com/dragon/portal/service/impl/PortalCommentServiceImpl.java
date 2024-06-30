package com.dragon.portal.service.impl;

import java.util.List;
import java.util.Objects;

import cn.hutool.core.collection.CollectionUtil;
import com.dragon.common.exception.ServiceException;
import com.dragon.common.utils.DateUtils;
import com.dragon.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.PortalCommentMapper;
import com.dragon.portal.domain.PortalComment;
import com.dragon.portal.service.IPortalCommentService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 评论管理Service业务层处理
 *
 * @author dragon
 * @date 2024-06-29
 */
@Service
@Slf4j
public class PortalCommentServiceImpl implements IPortalCommentService {
    @Autowired
    private PortalCommentMapper portalCommentMapper;

    /**
     * 查询评论管理
     *
     * @param commentId 评论管理主键
     * @return 评论管理
     */
    @Override
    public PortalComment selectPortalCommentBycommentId(Long commentId) {
        return portalCommentMapper.selectPortalCommentBycommentId(commentId);
    }

    /**
     * 查询评论管理列表
     *
     * @param portalComment 评论管理
     * @return 评论管理
     */
    @Override
    public List<PortalComment> selectPortalCommentList(PortalComment portalComment) {
        return portalCommentMapper.selectPortalCommentList(portalComment);
    }

    /**
     * 新增评论管理
     *
     * @param portalComment 评论管理
     * @return 结果
     */
    @Override
    public int insertPortalComment(PortalComment portalComment) {
        portalComment.setCreateTime(DateUtils.getNowDate());
        return portalCommentMapper.insertPortalComment(portalComment);
    }

    /**
     * 审核评论管理
     *
     * @param portalComment 评论管理
     * @return 结果
     */
    @Override
    public int updatePortalComment(PortalComment portalComment) {
        Long commentId = portalComment.getCommentId();
        // id不能为空
        if (Objects.isNull(commentId)) {
            log.warn("评论id不能为空");
            throw new ServiceException("评论id不能为空");
        }
        PortalComment commentDO = portalCommentMapper.selectPortalCommentBycommentId(commentId);
        if (Objects.isNull(commentDO)) {
            log.warn("该评论不存在, commentId: {}", commentId);
            throw new ServiceException("该评论不存在");
        }
        Integer status = portalComment.getStatus();
        Integer currStatus = commentDO.getStatus();
        // 若未处于待审核状态
        if (!Objects.equals(1, currStatus)) {
            log.warn("该评论未处于待审核状态, commentId: {}", commentId);
            throw new ServiceException("该评论未处于待审核状态");
        }
        String reason = portalComment.getReason();
        if (Objects.isNull(status)) {
            log.warn("审核状态不能为空");
            throw new ServiceException("审核状态不能为空");
        } else if (status == 3) {
            if (StringUtils.isEmpty(reason)) {
                log.warn("审核状态为审核未通过时，审核原因不能为空");
                throw new ServiceException("审核状态为【审核未通过】时，审核原因不能为空");
            }
        }
        portalComment.setUpdateTime(DateUtils.getNowDate());
        return portalCommentMapper.updatePortalComment(portalComment);
    }

    /**
     * 删除评论管理信息
     *
     * @param commentId 评论管理主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deletePortalCommentByCommentId(Long commentId) {
        // 查询该评论是一级评论，还是二级评论
        PortalComment portalComment = portalCommentMapper.selectPortalCommentBycommentId(commentId);
        // 判断评论是否存在
        if (Objects.isNull(portalComment)) {
            log.warn("该评论不存在, commentId: {}", commentId);
            throw new RuntimeException("该评论不存在");
        }
        // 删除评论
        int count = portalCommentMapper.deletePortalCommentByCommentId(commentId);
        Long replyCommentId = portalComment.getReplyCommentId();
        // 一级评论
        if (Objects.isNull(replyCommentId)) {
            // 删除子评论
            portalCommentMapper.deletePortalCommentByCommentId(commentId);
        } else {
            // 二级评论
            // 删除此评论, 以及此评论下的所有回复
            deleteAllChildComment(commentId);
        }
        return count;
    }

    /**
     * 递归删除所有子评论
     * @param commentId
     */
    private void deleteAllChildComment(Long commentId) {
        List<PortalComment> childCommentDOS = portalCommentMapper.selectPortalCommentByReplyCommentId(commentId);
        if (CollectionUtil.isNotEmpty(childCommentDOS)) {
            childCommentDOS.forEach(childCommentDO -> {
                // 删除子评论
                portalCommentMapper.deletePortalCommentByCommentId(childCommentDO.getCommentId());
                // 递归删除子评论
                deleteAllChildComment(childCommentDO.getCommentId());
            });
        }
    }
}