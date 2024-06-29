package com.dragon.portal.service;

/**
 * @author: DragonWen
 * @date: 2024/6/29
 * @Version: 1.0
 * @description: 文章统计分析 Service
 */
public interface IArticleStatisticsService {

    /**
     * 统计各分类下文章总数
     */
    public void statisticsCategoryArticleTotal();

    /**
     * 统计各标签下文章总数
     */
    public void statisticsTagArticleTotal();
}
