package com.dragon.portal.service;

import java.util.List;

import com.dragon.portal.domain.Article;
import com.dragon.portal.domain.ArticleCategory;
import com.dragon.system.domain.vo.SelectRspVo;

/**
 * 文章分类管理Service接口
 * 
 * @author dragon
 * @date 2024-06-10
 */
public interface IArticleCategoryService {
    /**
     * 查询文章分类管理
     * 
     * @param categoryId 文章分类管理主键
     * @return 文章分类管理
     */
    public ArticleCategory selectArticleCategoryById(Long categoryId);

    /**
     * 查询文章分类管理列表
     * 
     * @param articleCategory 文章分类管理
     * @return 文章分类管理集合
     */
    public List<ArticleCategory> selectArticleCategoryList(ArticleCategory articleCategory);

    /**
     * 新增文章分类管理
     * 
     * @param articleCategory 文章分类管理
     * @return 结果
     */
    public int insertArticleCategory(ArticleCategory articleCategory);

    /**
     * 修改文章分类管理
     * 
     * @param articleCategory 文章分类管理
     * @return 结果
     */
    public int updateArticleCategory(ArticleCategory articleCategory);

    /**
     * 批量删除文章分类管理
     * 
     * @param ids 需要删除的文章分类管理主键集合
     * @return 结果
     */
    public int deleteArticleCategoryByIds(Long[] ids);

    /**
     * 删除文章分类管理信息
     * 
     * @param categoryId 文章分类管理主键
     * @return 结果
     */
    public int deleteArticleCategoryById(Long categoryId);

    /**
     * 文章分类下拉列表
     * @return
     */
    public List<SelectRspVo> findCategorySelectList();

    /**
     * 前台获取分类下文章分页数据
     * @param articleCategory
     * @return
     */
    public List<Article> getCategoryArticlePageList(ArticleCategory articleCategory);
}
