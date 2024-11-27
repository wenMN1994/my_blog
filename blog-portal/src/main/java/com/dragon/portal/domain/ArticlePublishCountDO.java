package com.dragon.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author: DragonWen
 * @date: 2024/11/24
 * @Version: 1.0
 * @description:以日为维度统计文章发布数量
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticlePublishCountDO {
    /**
     * 日期
     */
    private LocalDate createDate;

    /**
     * 文章发布数量
     */
    private Long count;
}
