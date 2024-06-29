package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.ArticleCategory;
import com.dragon.portal.domain.ArticleCategoryRel;
import org.apache.ibatis.annotations.Param;

/**
 * 文章分类管理Mapper接口
 * 
 * @author dragon
 * @date 2024-06-10
 */
public interface ArticleCategoryMapper {
    /**
     * 查询文章分类管理
     * 
     * @param categoryId 文章分类管理主键
     * @return 文章分类管理
     */
    public ArticleCategory selectArticleCategoryById(@Param("categoryId") Long categoryId);

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
     * 删除文章分类管理
     * 
     * @param categoryId 文章分类管理主键
     * @return 结果
     */
    public int deleteArticleCategoryById(@Param("categoryId") Long categoryId);

    /**
     * 批量删除文章分类管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticleCategoryByIds(Long[] ids);
}
