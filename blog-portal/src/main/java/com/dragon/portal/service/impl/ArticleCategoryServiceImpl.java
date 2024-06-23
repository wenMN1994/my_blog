package com.dragon.portal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollectionUtil;
import com.dragon.common.utils.DateUtils;
import com.dragon.system.domain.vo.SelectRspVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.ArticleCategoryMapper;
import com.dragon.portal.domain.ArticleCategory;
import com.dragon.portal.service.IArticleCategoryService;

/**
 * 文章分类管理Service业务层处理
 * 
 * @author dragon
 * @date 2024-06-10
 */
@Service
public class ArticleCategoryServiceImpl implements IArticleCategoryService {
    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    /**
     * 查询文章分类管理
     * 
     * @param categoryId 文章分类管理主键
     * @return 文章分类管理
     */
    @Override
    public ArticleCategory selectArticleCategoryById(Long categoryId) {
        return articleCategoryMapper.selectArticleCategoryById(categoryId);
    }

    /**
     * 查询文章分类管理列表
     * 
     * @param ArticleCategory 文章分类管理
     * @return 文章分类管理
     */
    @Override
    public List<ArticleCategory> selectArticleCategoryList(ArticleCategory ArticleCategory) {
        return articleCategoryMapper.selectArticleCategoryList(ArticleCategory);
    }

    /**
     * 新增文章分类管理
     * 
     * @param ArticleCategory 文章分类管理
     * @return 结果
     */
    @Override
    public int insertArticleCategory(ArticleCategory ArticleCategory) {
        ArticleCategory.setCreateTime(DateUtils.getNowDate());
        return articleCategoryMapper.insertArticleCategory(ArticleCategory);
    }

    /**
     * 修改文章分类管理
     * 
     * @param ArticleCategory 文章分类管理
     * @return 结果
     */
    @Override
    public int updateArticleCategory(ArticleCategory ArticleCategory) {
        ArticleCategory.setUpdateTime(DateUtils.getNowDate());
        return articleCategoryMapper.updateArticleCategory(ArticleCategory);
    }

    /**
     * 批量删除文章分类管理
     * 
     * @param ids 需要删除的文章分类管理主键
     * @return 结果
     */
    @Override
    public int deleteArticleCategoryByIds(Long[] ids) {
        return articleCategoryMapper.deleteArticleCategoryByIds(ids);
    }

    /**
     * 删除文章分类管理信息
     * 
     * @param categoryId 文章分类管理主键
     * @return 结果
     */
    @Override
    public int deleteArticleCategoryById(Long categoryId) {
        return articleCategoryMapper.deleteArticleCategoryById(categoryId);
    }

    /**
     * 文章分类下拉列表
     * @return
     */
    @Override
    public List<SelectRspVo> findCategorySelectList() {
        List<ArticleCategory> articleCategories = articleCategoryMapper.selectArticleCategoryList(new ArticleCategory());
        // DO 转 VO
        List<SelectRspVo> selectRspVos = new ArrayList<>();
        // 如果分类数据不为空
        if (CollectionUtil.isNotEmpty(articleCategories)) {
            // 将分类 ID 作为 Value 值，将分类名称作为 label 展示
            selectRspVos = articleCategories.stream()
                    .map(categoryDo -> SelectRspVo.builder()
                            .label(categoryDo.getName())
                            .value(categoryDo.getCategoryId())
                            .build())
                    .collect(Collectors.toList());
        }
        return selectRspVos;
    }
}
