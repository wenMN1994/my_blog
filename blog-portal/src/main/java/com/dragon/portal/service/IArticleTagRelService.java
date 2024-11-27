package com.dragon.portal.service;

import java.util.List;
import com.dragon.portal.domain.ArticleTagRel;

/**
 * 文章对应标签关联Service接口
 * 
 * @author dragon
 * @date 2024-06-23
 */
public interface IArticleTagRelService {
    /**
     * 查询文章对应标签关联
     * 
     * @param id 文章对应标签关联主键
     * @return 文章对应标签关联
     */
    public ArticleTagRel selectArticleTagRelById(Long id);

    /**
     * 查询文章对应标签关联列表
     * 
     * @param articleTagRel 文章对应标签关联
     * @return 文章对应标签关联集合
     */
    public List<ArticleTagRel> selectArticleTagRelList(ArticleTagRel articleTagRel);

    /**
     * 新增文章对应标签关联
     * 
     * @param articleTagRel 文章对应标签关联
     * @return 结果
     */
    public int insertArticleTagRel(ArticleTagRel articleTagRel);

    /**
     * 修改文章对应标签关联
     * 
     * @param articleTagRel 文章对应标签关联
     * @return 结果
     */
    public int updateArticleTagRel(ArticleTagRel articleTagRel);

    /**
     * 批量删除文章对应标签关联
     * 
     * @param ids 需要删除的文章对应标签关联主键集合
     * @return 结果
     */
    public int deleteArticleTagRelByIds(Long[] ids);

    /**
     * 删除文章对应标签关联信息
     * 
     * @param id 文章对应标签关联主键
     * @return 结果
     */
    public int deleteArticleTagRelById(Long id);
}
