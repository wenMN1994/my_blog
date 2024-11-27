package com.dragon.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: DragonWen
 * @date: 2024/6/30
 * @Version: 1.0
 * @description: 统计信息实体
 */
@Data
public class StatisticsInfo {

    @ApiModelProperty("文章总数")
    private Long articleTotalCount;

    @ApiModelProperty("分类总数")
    private Long categoryTotalCount;

    @ApiModelProperty("标签总数")
    private Long tagTotalCount;

    @ApiModelProperty("总浏览量")
    private Long pvTotalCount;
}
