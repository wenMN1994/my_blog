package com.dragon.portal.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.ArticleCategoryRelMapper;
import com.dragon.portal.domain.ArticleCategoryRel;
import com.dragon.portal.service.IArticleCategoryRelService;

/**
 * 文章所属分类关联Service业务层处理
 * 
 * @author dragon
 * @date 2024-06-22
 */
@Service
public class ArticleCategoryRelServiceImpl implements IArticleCategoryRelService {
    @Autowired
    private ArticleCategoryRelMapper articleCategoryRelMapper;

    /**
     * 查询文章所属分类关联
     * 
     * @param id 文章所属分类关联主键
     * @return 文章所属分类关联
     */
    @Override
    public ArticleCategoryRel selectArticleCategoryRelById(Long id) {
        return articleCategoryRelMapper.selectArticleCategoryRelById(id);
    }

    /**
     * 查询文章所属分类关联列表
     * 
     * @param articleCategoryRel 文章所属分类关联
     * @return 文章所属分类关联
     */
    @Override
    public List<ArticleCategoryRel> selectArticleCategoryRelList(ArticleCategoryRel articleCategoryRel) {
        return articleCategoryRelMapper.selectArticleCategoryRelList(articleCategoryRel);
    }

    /**
     * 新增文章所属分类关联
     * 
     * @param articleCategoryRel 文章所属分类关联
     * @return 结果
     */
    @Override
    public int insertArticleCategoryRel(ArticleCategoryRel articleCategoryRel) {
        return articleCategoryRelMapper.insertArticleCategoryRel(articleCategoryRel);
    }

    /**
     * 修改文章所属分类关联
     * 
     * @param articleCategoryRel 文章所属分类关联
     * @return 结果
     */
    @Override
    public int updateArticleCategoryRel(ArticleCategoryRel articleCategoryRel) {
        return articleCategoryRelMapper.updateArticleCategoryRel(articleCategoryRel);
    }

    /**
     * 批量删除文章所属分类关联
     * 
     * @param ids 需要删除的文章所属分类关联主键
     * @return 结果
     */
    @Override
    public int deleteArticleCategoryRelByIds(Long[] ids) {
        return articleCategoryRelMapper.deleteArticleCategoryRelByIds(ids);
    }

    /**
     * 删除文章所属分类关联信息
     * 
     * @param id 文章所属分类关联主键
     * @return 结果
     */
    @Override
    public int deleteArticleCategoryRelById(Long id) {
        return articleCategoryRelMapper.deleteArticleCategoryRelById(id);
    }
}
