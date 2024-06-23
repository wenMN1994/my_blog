package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.ArticleCategoryRel;
import org.apache.ibatis.annotations.Param;

/**
 * 文章所属分类关联Mapper接口
 * 
 * @author dragon
 * @date 2024-06-22
 */
public interface ArticleCategoryRelMapper {
    /**
     * 查询文章所属分类关联
     * 
     * @param id 文章所属分类关联主键
     * @return 文章所属分类关联
     */
    public ArticleCategoryRel selectArticleCategoryRelById(Long id);

    /**
     * 查询文章所属分类关联列表
     * 
     * @param articleCategoryRel 文章所属分类关联
     * @return 文章所属分类关联集合
     */
    public List<ArticleCategoryRel> selectArticleCategoryRelList(ArticleCategoryRel articleCategoryRel);

    /**
     * 新增文章所属分类关联
     * 
     * @param articleCategoryRel 文章所属分类关联
     * @return 结果
     */
    public int insertArticleCategoryRel(ArticleCategoryRel articleCategoryRel);

    /**
     * 修改文章所属分类关联
     * 
     * @param articleCategoryRel 文章所属分类关联
     * @return 结果
     */
    public int updateArticleCategoryRel(ArticleCategoryRel articleCategoryRel);

    /**
     * 删除文章所属分类关联
     * 
     * @param id 文章所属分类关联主键
     * @return 结果
     */
    public int deleteArticleCategoryRelById(Long id);

    /**
     * 批量删除文章所属分类关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticleCategoryRelByIds(Long[] ids);

    /**
     * 根据文章 ID 删除关联记录
     *
     * @param articleId 文章ID
     * @return 结果
     */
    public int deleteByArticleId(@Param("articleId") Long articleId);

    /**
     * 根据文章ID获取文章与分类关联关系
     * @param articleId 文章ID
     * @return
     */
    public ArticleCategoryRel selectByArticleId(@Param("articleId") Long articleId);

    /**
     * 根据文章ID批量删除文章分类关联表
     *
     * @param articleIds 文章ID集合
     */
    public void deleteArticleCategoryRelByArticleIds(@Param("articleIds") Long[] articleIds);
}
