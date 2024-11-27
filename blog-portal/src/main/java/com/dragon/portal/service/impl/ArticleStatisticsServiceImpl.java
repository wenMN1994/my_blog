package com.dragon.portal.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.dragon.common.utils.DateUtils;
import com.dragon.portal.domain.*;
import com.dragon.portal.mapper.*;
import com.dragon.portal.service.IArticleCategoryService;
import com.dragon.portal.service.IArticleStatisticsService;
import com.dragon.portal.service.IArticleTagService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: DragonWen
 * @date: 2024/6/29
 * @Version: 1.0
 * @description: 文章统计分析接口实现类
 */
@Service
public class ArticleStatisticsServiceImpl implements IArticleStatisticsService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    private ArticleCategoryRelMapper articleCategoryRelMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;

    @Autowired
    private StatisticsArticlePvMapper statisticsArticlePvMapper;

    @Autowired
    private IArticleCategoryService articleCategoryService;

    @Autowired
    private IArticleTagService articleTagService;

    /**
     * 统计各分类下文章总数
     */
    @Override
    public void statisticsCategoryArticleTotal() {
        // 查询所有分类
        List<ArticleCategory> categoryDOS = articleCategoryMapper.selectArticleCategoryList(new ArticleCategory());
        // 查询所有文章-分类映射记录
        List<ArticleCategoryRel> articleCategoryRelDOS = articleCategoryRelMapper.selectArticleCategoryRelList(new ArticleCategoryRel());
        // 按所属分类 ID 进行分组
        Map<Long, List<ArticleCategoryRel>> categoryIdAndArticleCategoryRelDOMap = Maps.newHashMap();
        // 如果不为空
        if (CollectionUtil.isNotEmpty(articleCategoryRelDOS)) {
            categoryIdAndArticleCategoryRelDOMap = articleCategoryRelDOS.stream()
                    .collect(Collectors.groupingBy(ArticleCategoryRel::getCategoryId));
        }
        if (CollectionUtil.isNotEmpty(categoryDOS)) {
            for (ArticleCategory categoryDO : categoryDOS) {
                Long categoryId = categoryDO.getCategoryId();
                // 获取此分类下所有映射记录
                List<ArticleCategoryRel> articleCategoryRelDOList = categoryIdAndArticleCategoryRelDOMap.get(categoryId);

                // 获取文章总数
                Integer articlesTotal = CollectionUtils.isEmpty(articleCategoryRelDOList) ? 0 : articleCategoryRelDOList.size();

                // 更新该分类的文章总数
                ArticleCategory updateDO = new ArticleCategory();
                updateDO.setCategoryId(categoryId);
                updateDO.setArticlesTotal(Long.parseLong(articlesTotal.toString()));
                articleCategoryMapper.updateArticleCategory(updateDO);
            }
        }
    }

    /**
     * 统计各标签下文章总数
     */
    @Override
    public void statisticsTagArticleTotal() {
        // 查询所有标签
        List<ArticleTag> tagDOS = articleTagMapper.selectArticleTagList(new ArticleTag());
        // 查询所有文章-标签映射记录
        List<ArticleTagRel> articleTagRelDOS = articleTagRelMapper.selectArticleTagRelList(new ArticleTagRel());
        // 按所属标签 ID 进行分组
        Map<Long, List<ArticleTagRel>> tagIdAndArticleTagRelDOMap = Maps.newHashMap();
        // 如果不为空
        if (CollectionUtil.isNotEmpty(articleTagRelDOS)) {
            tagIdAndArticleTagRelDOMap = articleTagRelDOS.stream()
                    .collect(Collectors.groupingBy(ArticleTagRel::getTagId));
        }
        if (CollectionUtil.isNotEmpty(tagDOS)) {
            // 循环统计各标签下的文章总数
            for (ArticleTag tagDO : tagDOS) {
                Long tagId = tagDO.getTagId();

                // 获取此标签下所有映射记录
                List<ArticleTagRel> articleTagRelDOList = tagIdAndArticleTagRelDOMap.get(tagId);

                // 获取文章总数
                Integer articlesTotal = CollectionUtils.isEmpty(articleTagRelDOList) ? 0 : articleTagRelDOList.size();

                // 更新该标签的文章总数
                ArticleTag updateDo = new ArticleTag();
                updateDo.setTagId(tagId);
                updateDo.setArticlesTotal(Long.parseLong(articlesTotal.toString()));
                articleTagMapper.updateArticleTag(updateDo);
            }
        }
    }

    /**
     * 前台获取统计信息
     * @return
     */
    @Override
    public StatisticsInfo findInfo() {
        // 查询文章总数
        List<Article> articles = articleMapper.selectArticleList(new Article());
        Long articleTotalCount = CollectionUtil.isEmpty(articles) ? 0L : articles.size();
        // 查询分类总数
        List<ArticleCategory> articleCategories = articleCategoryMapper.selectArticleCategoryList(new ArticleCategory());
        Long categoryTotalCount = CollectionUtil.isEmpty(articleCategories) ? 0L : articleCategories.size();
        // 查询标签总数
        List<ArticleTag> articleTags = articleTagMapper.selectArticleTagList(new ArticleTag());
        Long tagTotalCount = CollectionUtil.isEmpty(articleTags) ? 0L : articleTags.size();
        // 总浏览量
        Long pvTotalCount = CollectionUtil.isEmpty(articles) ? 0L : articles.stream().mapToLong(Article::getReadNum).sum();
        // 组装 VO 类
        StatisticsInfo statisticsInfo = new StatisticsInfo();
        statisticsInfo.setArticleTotalCount(articleTotalCount);
        statisticsInfo.setCategoryTotalCount(categoryTotalCount);
        statisticsInfo.setTagTotalCount(tagTotalCount);
        statisticsInfo.setPvTotalCount(pvTotalCount);
        return statisticsInfo;
    }

    /**
     * 获取后台仪表盘文章发布热点统计信息
     * @return
     */
    @Override
    public Map<LocalDate, Long> publishArticleStatisticsInfo() {
        // 当前日期
        LocalDate currDate = LocalDate.now();

        // 当前日期倒退一年的日期
        LocalDate startDate = currDate.minusYears(1);

        // 查找这一年内，每日发布的文章数量
        List<ArticlePublishCountDO> articleList = articleMapper.selectDateArticlePublishCount(startDate, currDate.plusDays(1));

        Map<LocalDate, Long> map = null;
        if (CollectionUtil.isNotEmpty(articleList)) {
            // list转map
            Map<LocalDate, Long> dateArticleCountMap = articleList.stream().collect(Collectors.toMap(ArticlePublishCountDO::getCreateDate, ArticlePublishCountDO::getCount));
            // 有序 Map, 返回的日期文章数需要以升序排列
            map = Maps.newLinkedHashMap();
            // 从上一年的今天循环到今天
            for (; startDate.isBefore(currDate) || startDate.isEqual(currDate); startDate = startDate.plusDays(1)) {
                // 以日期作为 key 从 dateArticleCountMap 中取文章发布总量
                Long count = dateArticleCountMap.get(startDate);
                // 设置到返参 Map
                map.put(startDate, Objects.isNull(count) ? 0 : count);
            }
        }
        return map;
    }

    /**
     * 获取后台仪表盘最近一周 PV 访问量信息
     * @return
     */
    @Override
    public ArticlePvStatistics articleViewStatisticsInfo() {
        List<StatisticsArticlePv> pvList = statisticsArticlePvMapper.selectLatestWeekRecords();
        ArticlePvStatistics rsp = new ArticlePvStatistics();
        if (CollectionUtil.isNotEmpty(pvList)) {
            // 转 Map, 方便后续通过日期获取 PV 访问量
            Map<LocalDate, Long> pvMap = pvList.stream().collect(Collectors.toMap(StatisticsArticlePv::getPvDate, StatisticsArticlePv::getPvCount));
            // 日期集合
            List<String> pvDates = Lists.newArrayList();
            // PV 集合
            List<Long> pvCounts = Lists.newArrayList();

            // 当前日期
            LocalDate currDate = LocalDate.now();
            // 一周前
            LocalDate tmpDate = currDate.minusWeeks(1);
            // 从一周前开始循环
            for (; tmpDate.isBefore(currDate) || tmpDate.isEqual(currDate); tmpDate = tmpDate.plusDays(1)) {
                // 设置对应日期的 PV 访问量
                pvDates.add(tmpDate.format(DateUtils.MONTH_DAY_FORMATTER));
                Long pvCount = pvMap.get(tmpDate);
                pvCounts.add(Objects.isNull(pvCount) ? 0 : pvCount);
            }
            rsp = ArticlePvStatistics.builder().pvDates(pvDates).pvCounts(pvCounts).build();
        }
        return rsp;
    }

    /**
     * 获取后台仪表盘文章分类统计
     * @return
     */
    @Override
    public List<ArticleCategoryStatistics> articleCategoryStatisticsInfo() {
        List<ArticleCategory> categoryList = articleCategoryService.selectArticleCategoryList(new ArticleCategory());
        List<ArticleCategoryStatistics> rspList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(categoryList)) {
            categoryList.forEach(item -> {
                ArticleCategoryStatistics rsp = new ArticleCategoryStatistics(item.getName(), item.getArticlesTotal());
                rspList.add(rsp);
            });
        }
        return rspList;
    }

    /**
     * 获取后台仪表盘文章分类统计
     * @return
     */
    @Override
    public ArticleTagStatistics articleTagStatisticsInfo() {
        List<ArticleTag> tagList = articleTagService.selectArticleTagList(new ArticleTag());
        ArticleTagStatistics result = new ArticleTagStatistics();
        if (CollectionUtil.isNotEmpty(tagList)) {
            List<String> tagNames = tagList.stream().map(ArticleTag::getName).collect(Collectors.toList());
            List<Long> articleCounts = tagList.stream().map(ArticleTag::getArticlesTotal).collect(Collectors.toList());
            result.setTagNames(tagNames);
            result.setArticleCounts(articleCounts);
        }
        return result;
    }
}
