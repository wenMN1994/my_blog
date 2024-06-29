package com.dragon.portal.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.dragon.portal.domain.ArticleCategory;
import com.dragon.portal.domain.ArticleCategoryRel;
import com.dragon.portal.domain.ArticleTag;
import com.dragon.portal.domain.ArticleTagRel;
import com.dragon.portal.mapper.ArticleCategoryMapper;
import com.dragon.portal.mapper.ArticleCategoryRelMapper;
import com.dragon.portal.mapper.ArticleTagMapper;
import com.dragon.portal.mapper.ArticleTagRelMapper;
import com.dragon.portal.service.IArticleStatisticsService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
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
    private ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    private ArticleCategoryRelMapper articleCategoryRelMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;

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
}
