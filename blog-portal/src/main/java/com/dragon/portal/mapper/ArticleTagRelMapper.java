package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.ArticleTagRel;
import org.apache.ibatis.annotations.Param;

/**
 * 文章对应标签关联Mapper接口
 * 
 * @author dragon
 * @date 2024-06-23
 */
public interface ArticleTagRelMapper {
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
     * 删除文章对应标签关联
     * 
     * @param id 文章对应标签关联主键
     * @return 结果
     */
    public int deleteArticleTagRelById(Long id);

    /**
     * 批量删除文章对应标签关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticleTagRelByIds(Long[] ids);

    /**
     * 根据文章ID删除文章标签
     *
     * @param articleId 文章ID
     * @return 结果
     */
    public void deleteByArticleId(@Param("articleId") Long articleId);

    /**
     * 批量插入文章-标签关联关系
     *
     * @param list
     * @return 结果
     */
    public void insertBatchArticleTagRel(@Param("list") List<ArticleTagRel> list);

    /**
     * 根据文章ID批量删除文章标签关联表
     *
     * @param articleIds 文章ID集合
     * @return 结果
     */
    void deleteArticleTagRelByArticleIds(@Param("articleIds") Long[] articleIds);
}
