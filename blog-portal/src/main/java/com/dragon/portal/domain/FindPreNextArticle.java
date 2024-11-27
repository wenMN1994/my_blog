package com.dragon.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: DragonWen
 * @date: 2024/7/14
 * @Version: 1.0
 * @description: 文章上下页
 */
@Data
public class FindPreNextArticle {

    /** 文章ID */
    @ApiModelProperty("文章ID")
    private Long articleId;

    /** 文章标题 */
    @ApiModelProperty("文章标题")
    private String articleTitle;
}
