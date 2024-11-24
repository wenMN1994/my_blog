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
 * @description:查询仪表盘文章 PV 访问量信息入参 VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticlePvStatistics {
    /**
     * 日期集合
     */
    private List<String> pvDates;

    /**
     * PV 浏览量集合
     */
    private List<Long> pvCounts;
}
