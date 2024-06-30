package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 文章标签管理对象 portal_article_tag
 * 
 * @author dragon
 * @date 2024-06-10
 */
@Data
@ApiModel(value = "ArticleTag", description = "文章标签实体")
public class ArticleTag extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签ID")
    private Long tagId;

    @ApiModelProperty("标签名称")
    @Excel(name = "标签名称")
    private String name;

    @ApiModelProperty("逻辑删除标志位：0：未删除 1：已删除")
    private Long isDeleted;

    @ApiModelProperty("文章数量")
    @Excel(name = "文章数量")
    private Long articlesTotal;
}
