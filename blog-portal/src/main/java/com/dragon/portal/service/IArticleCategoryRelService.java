package com.dragon.portal.service;

import java.util.List;
import com.dragon.portal.domain.ArticleCategoryRel;

/**
 * 文章所属分类关联Service接口
 * 
 * @author dragon
 * @date 2024-06-22
 */
public interface IArticleCategoryRelService {
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
     * 批量删除文章所属分类关联
     * 
     * @param ids 需要删除的文章所属分类关联主键集合
     * @return 结果
     */
    public int deleteArticleCategoryRelByIds(Long[] ids);

    /**
     * 删除文章所属分类关联信息
     * 
     * @param id 文章所属分类关联主键
     * @return 结果
     */
    public int deleteArticleCategoryRelById(Long id);
}
