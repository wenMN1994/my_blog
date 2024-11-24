package com.dragon.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: DragonWen
 * @date: 2024/11/24
 * @Version: 1.0
 * @description:查询仪表盘文章分类统计
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleCategoryStatistics {
    /**
     * 分类名称
     */
    private String name;

    /**
     * 文章数量
     */
    private Long value;
}
