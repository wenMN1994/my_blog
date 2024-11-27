package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: DragonWen
 * @date: 2024/7/30
 * @Version: 1.0
 * @description:
 */
@Data
@ApiModel(value = "文章搜索 VO")
public class SearchArticleVo {

    /**
     * 查询关键词
     */
    @ApiModelProperty("查询关键词")
    @NotBlank(message = "搜索关键词不能为空")
    private String word;

    /**
     * 当前页码, 默认第一页
     */
    @ApiModelProperty("当前页码")
    private Long current = 1L;

    /**
     * 每页展示的数据数量，默认每页展示 10 条数据
     */
    @ApiModelProperty("每页展示的数据数量")
    private Long size = 10L;
}
