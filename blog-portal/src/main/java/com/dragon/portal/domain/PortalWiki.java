package com.dragon.portal.domain;

import lombok.Data;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 知识库对象 portal_wiki
 * 
 * @author dragon
 * @date 2024-07-20
 */
@Data
public class PortalWiki extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 知识库id */
    private Long wikiId;

    /** 知识库标题 */
    @Excel(name = "标题")
    private String title;

    /** 封面ID */
    @Excel(name = "封面ID")
    private Long cover;

    /** 封面URL */
    @Excel(name = "封面URL")
    private String coverUrl;

    /** 摘要 */
    @Excel(name = "摘要")
    private String summary;

    /** 删除标志位：0：未删除 1：已删除 */
    private Integer isDeleted;

    /** 删除标志位：0：未删除 1：已删除 */
    @Excel(name = "删除标志位")
    private String isDeletedStr;

    /** 权重，用于是否置顶（0: 未置顶；>0: 参与置顶，权重值越高越靠前） */
    @Excel(name = "权重")
    private Integer weight;

    /** 是否发布：0：未发布 1：已发布 */
    @Excel(name = "是否发布：0：未发布 1：已发布")
    private Integer isPublish;

    /** 是否发布：0：未发布 1：已发布 */
    @Excel(name = "是否发布")
    private String isPublishStr;

    /** 置顶状态 */
    private Boolean isTop;

    /** 是否发布 */
    private Boolean isPublishBoolean;

    /** 第一篇文章ID */
    private Long firstArticleId;
}
