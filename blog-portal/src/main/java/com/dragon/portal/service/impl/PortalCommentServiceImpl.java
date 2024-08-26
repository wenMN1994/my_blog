package com.dragon.portal.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollectionUtil;
import com.dragon.common.enums.CommentStatusEnum;
import com.dragon.common.exception.ServiceException;
import com.dragon.common.utils.DateUtils;
import com.dragon.common.utils.StringUtils;
import com.dragon.portal.domain.FindCommentItemRspVO;
import com.dragon.portal.domain.FindCommentListRspVO;
import com.dragon.portal.domain.PortalSettings;
import com.dragon.portal.event.PublishCommentEvent;
import com.dragon.portal.service.IPortalSettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.PortalCommentMapper;
import com.dragon.portal.domain.PortalComment;
import com.dragon.portal.service.IPortalCommentService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import toolgood.words.IllegalWordsSearch;
import toolgood.words.IllegalWordsSearchResult;

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

    @Autowired
    private IPortalSettingsService portalSettingsService;

    @Autowired
    private IllegalWordsSearch wordsSearch;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

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
     * 发布评论
     * @param portalComment
     * @return
     */
    @Override
    public int publishComment(PortalComment portalComment) {
        // 评论内容
        String content = portalComment.getContent();
        // 查询博客设置相关信息
        PortalSettings portalSettings = portalSettingsService.packageSettingsInfo();
        // 是否开启了敏感词过滤
        Boolean isCommentSensitiveWordsOpen = portalSettings.getIsCommentSensitiveWordsOpen();
        // 是否开启了审核
        Boolean isCommentExamineOpen = portalSettings.getIsCommentExamineOpen();
        // 设置默认状态（正常）
        Integer status = CommentStatusEnum.NORMAL.getCode();
        // 审核不通过原因
        String reason = "";

        // 如果开启了审核, 设置状态为待审核，等待博主后台审核通过
        if (isCommentExamineOpen) {
            status = CommentStatusEnum.WAIT_EXAMINE.getCode();
        }

        // 评论内容是否包含敏感词
        boolean isContainSensitiveWord = false;
        // 是否开启了敏感词过滤
        if (isCommentSensitiveWordsOpen) {
            // 校验评论中是否包含敏感词
            isContainSensitiveWord = wordsSearch.ContainsAny(content);

            if (isContainSensitiveWord) {
                // 若包含敏感词，设置状态为审核不通过
                status = CommentStatusEnum.EXAMINE_FAILED.getCode();
                // 匹配到的所有敏感词组
                List<IllegalWordsSearchResult> results = wordsSearch.FindAll(content);
                List<String> keywords = results.stream().map(result -> result.Keyword).collect(Collectors.toList());
                // 不同过的原因
                reason = String.format("系统自动拦截，包含敏感词：%s", keywords);
                log.warn("此评论内容中包含敏感词: {}, content: {}", keywords, content);
            }
        }
        portalComment.setStatus(status);
        portalComment.setReason(reason);
        portalComment.setCreateBy(portalComment.getNickname());
        portalComment.setCreateTime(DateUtils.getNowDate());
        int count = portalCommentMapper.insertPortalComment(portalComment);
        Long commentId = portalComment.getCommentId();
        // 发送评论发布事件
        eventPublisher.publishEvent(new PublishCommentEvent(this, commentId));
        // 给予前端对应的提示信息
        if (isContainSensitiveWord) {
            throw new ServiceException("评论内容中包含敏感词，请修改后再次发布");
        }
        if (Objects.equals(status, CommentStatusEnum.WAIT_EXAMINE.getCode())) {
            throw new ServiceException("评论已提交, 等待博主审核通过");
        }
        return count;
    }

    /**
     * 获取页面所有评论
     * @param portalComment
     * @return
     */
    @Override
    public FindCommentListRspVO findPageComments(PortalComment portalComment) {
        // 路由地址
        String routerUrl = portalComment.getRouterUrl();
        // 根据该路由地址下所有评论（仅查询状态正常的）
        List<PortalComment> commentDOS = portalCommentMapper.selectByRouterUrlAndStatus(routerUrl, CommentStatusEnum.NORMAL.getCode());
        // 总评论数
        Integer total = commentDOS.size();
        List<FindCommentItemRspVO> vos = null;
        // DO 转 VO
        if (!CollectionUtils.isEmpty(commentDOS)) {
            // 一级评论：parentCommentId 父级 ID 为空，则表示为一级评论
            vos = commentDOS.stream()
                    .filter(commentDO -> Objects.isNull(commentDO.getParentCommentId()))
                    .map(commentDO -> commentConvert(commentDO))
                    .collect(Collectors.toList());
            // 循环设置评论回复数据
            vos.forEach(vo -> {
                Long commentId = vo.getCommentId();
                List<FindCommentItemRspVO> childComments = commentDOS.stream()
                        .filter(commentDO -> Objects.equals(commentDO.getParentCommentId(), commentId)) // 过滤出一级评论下所有子评论
                        .sorted(Comparator.comparing(PortalComment::getCreateTime)) // 按发布时间升序排列
                        .map(commentDO -> {
                            FindCommentItemRspVO findPageCommentRspVO = commentConvert(commentDO);
                            Long replyCommentId = commentDO.getReplyCommentId();
                            // 若二级评论的 replayCommentId 不等于一级评论 ID, 前端则需要展示【回复 @ xxx】，需要设置回复昵称
                            if (!Objects.equals(replyCommentId, commentId)) {
                                // 设置回复用户的昵称
                                Optional<PortalComment> optionalCommentDO = commentDOS.stream()
                                        .filter(commentDO1 -> Objects.equals(commentDO1.getCommentId(), replyCommentId)).findFirst();
                                if (optionalCommentDO.isPresent()) {
                                    findPageCommentRspVO.setReplyNickname(optionalCommentDO.get().getNickname());
                                }
                            }
                            return findPageCommentRspVO;
                        }).collect(Collectors.toList());

                vo.setChildComments(childComments);
            });
        }
        return FindCommentListRspVO.builder()
                .total(total)
                .comments(vos)
                .build();
    }

    /**
     * 评论实体类转换
     * @param commentDO
     * @return
     */
    private FindCommentItemRspVO commentConvert(PortalComment commentDO) {
        return FindCommentItemRspVO.builder()
                .commentId(commentDO.getCommentId())
                .avatar(commentDO.getAvatar())
                .nickname(commentDO.getNickname())
                .website(commentDO.getWebsite())
                .content(commentDO.getContent())
                .createTime(commentDO.getCreateTime())
                .build();
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