package com.dragon.web.controller.portal;

import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.domain.ArticleCategoryStatistics;
import com.dragon.portal.domain.ArticlePvStatistics;
import com.dragon.portal.domain.ArticleTagStatistics;
import com.dragon.portal.service.IArticleStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author: DragonWen
 * @date: 2024/11/23
 * @Version: 1.0
 * @description: 后台仪表盘
 */
@RestController
@RequestMapping("/portal/dashboard")
public class PortalDashboardController extends BaseController {

    @Autowired
    private IArticleStatisticsService articleStatisticsService;

    /**
     * 获取后台仪表盘基础统计信息
     * @return
     */
    @PostMapping("/baseInfo")
    public AjaxResult baseInfo() {
        return AjaxResult.success(articleStatisticsService.findInfo());
    }

    /**
     * 获取后台仪表盘文章发布热点统计信息
     * @return
     */
    @PostMapping("/publishArticleStatisticsInfo")
    public AjaxResult publishArticleStatisticsInfo() {
        Map<LocalDate, Long> map = articleStatisticsService.publishArticleStatisticsInfo();
        return success(map);
    }

    /**
     * 获取后台仪表盘最近一周 PV 访问量信息
     * @return
     */
    @PostMapping("/articleViewStatisticsInfo")
    public AjaxResult articleViewStatisticsInfo() {
        ArticlePvStatistics result = articleStatisticsService. articleViewStatisticsInfo();
        return success(result);
    }

    /**
     * 获取后台仪表盘文章分类统计
     * @return
     */
    @PostMapping("/articleCategoryStatisticsInfo")
    public AjaxResult articleCategoryStatisticsInfo() {
        List<ArticleCategoryStatistics> result = articleStatisticsService. articleCategoryStatisticsInfo();
        return success(result);
    }

    /**
     * 获取后台仪表盘文章标签统计
     * @return
     */
    @PostMapping("/articleTagStatisticsInfo")
    public AjaxResult articleTagStatisticsInfo() {
        ArticleTagStatistics result = articleStatisticsService.articleTagStatisticsInfo();
        return success(result);
    }
}
