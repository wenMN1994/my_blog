package com.dragon.portal.service;

import com.dragon.portal.domain.ArticleCategoryStatistics;
import com.dragon.portal.domain.ArticlePvStatistics;
import com.dragon.portal.domain.ArticleTagStatistics;
import com.dragon.portal.domain.StatisticsInfo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    /**
     * 前台获取统计信息
     * @return
     */
    public StatisticsInfo findInfo();

    /**
     * 获取后台仪表盘文章发布热点统计信息
     * @return
     */
    public Map<LocalDate, Long> publishArticleStatisticsInfo();

    /**
     * 获取后台仪表盘最近一周 PV 访问量信息
     * @return
     */
    public ArticlePvStatistics articleViewStatisticsInfo();

    /**
     * 获取后台仪表盘文章分类统计
     * @return
     */
    public List<ArticleCategoryStatistics> articleCategoryStatisticsInfo();

    /**
     * 获取后台仪表盘文章标签统计
     * @return
     */
    public ArticleTagStatistics articleTagStatisticsInfo();
}
