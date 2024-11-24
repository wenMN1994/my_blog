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
 * @description:文章标签统计
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleTagStatistics {
    /**
     * 标签名
     */
    private List<String> tagNames;

    /**
     * 标签关联文章数量
     */
    private List<Long> articleCounts;
}
