package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 文章对应标签关联对象 portal_article_tag_rel
 * 
 * @author dragon
 * @date 2024-06-23
 */
@Data
@ApiModel(value = "ArticleTagRel", description = "文章对应标签关联对象")
public class ArticleTagRel extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty("ID")
    private Long id;

    /** 文章id */
    @ApiModelProperty("文章ID")
    @Excel(name = "文章id")
    private Long articleId;

    /** 标签id */
    @ApiModelProperty("标签ID")
    @Excel(name = "标签id")
    private Long tagId;
}
