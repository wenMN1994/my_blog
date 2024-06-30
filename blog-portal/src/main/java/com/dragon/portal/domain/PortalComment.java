package com.dragon.portal.domain;

import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 评论管理对象 portal_comment
 *
 * @author dragon
 * @date 2024-06-29
 */
@Data
@ApiModel(value = "PortalComment", description = "评论管理对象")
public class PortalComment extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long commentId;

    /** 路由地址 */
    @Excel(name = "路由地址")
    private String routerUrl;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 昵称 */
    @Excel(name = "昵称")
    private String nickname;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String mail;

    /** 网站地址 */
    @Excel(name = "网站地址")
    private String website;

    /** 1: 待审核；2：审核通过；3：审核未通过; */
    private Integer status;

    /** 1: 待审核；2：审核通过；3：审核未通过; */
    @Excel(name = "审核状态")
    private String statusStr;

    /** 原因描述 */
    @Excel(name = "原因描述")
    private String reason;

    /** 删除标志位：0：未删除 1：已删除 */
    private Integer isDeleted;

    /** 回复的评论 ID */
    private Long replyCommentId;

    /** 父评论 ID */
    private Long parentCommentId;
}
