package com.dragon.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: DragonWen
 * @date: 2024/7/24
 * @Version: 1.0
 * @description:知识库上一篇/下一篇文章
 */
@Data
public class FindWikiArticlePreNextVo {

    /**上一篇文章*/
    @ApiModelProperty("上一篇文章")
    private FindPreNextArticle preArticle;

    /**下一篇文章*/
    @ApiModelProperty("下一篇文章")
    private FindPreNextArticle nextArticle;
}
