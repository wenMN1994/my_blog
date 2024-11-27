package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 文章所属分类关联对象 portal_article_category_rel
 *
 * @author dragon
 * @date 2024-06-22
 */
@Data
@ApiModel(value = "ArticleCategoryRel", description = "文章所属分类关联对象")
public class ArticleCategoryRel extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** id */
    @ApiModelProperty("ID")
    private Long id;

    /** 文章id */
    @ApiModelProperty("文章ID")
    @Excel(name = "文章id")
    private Long articleId;

    /** 分类id */
    @ApiModelProperty("分类ID")
    @Excel(name = "分类id")
    private Long categoryId;
}
