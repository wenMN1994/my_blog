package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 文章分类管理对象 portal_article_category
 * 
 * @author dragon
 * @date 2024-06-10
 */
@Data
@ApiModel(value = "ArticleCategory", description = "文章分类实体")
public class ArticleCategory extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类ID")
    private Long categoryId;

    @ApiModelProperty("分类名称")
    @Excel(name = "分类名称")
    private String name;

    /** 逻辑删除标志位：0：未删除 1：已删除 */
    @ApiModelProperty("逻辑删除标志位：0：未删除 1：已删除")
    private Long isDeleted;

    @ApiModelProperty("文章数量")
    @Excel(name = "文章数量")
    private Long articlesTotal;
}
