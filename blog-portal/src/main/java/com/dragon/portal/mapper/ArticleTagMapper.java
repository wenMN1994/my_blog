package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.ArticleTag;
import org.apache.ibatis.annotations.Param;

/**
 * 文章标签管理Mapper接口
 * 
 * @author dragon
 * @date 2024-06-10
 */
public interface ArticleTagMapper {
    /**
     * 查询文章标签管理
     * 
     * @param tagId 文章标签管理主键
     * @return 文章标签管理
     */
    public ArticleTag selectArticleTagById(@Param("tagId") Long tagId);

    /**
     * 查询文章标签管理列表
     * 
     * @param articleTag 文章标签管理
     * @return 文章标签管理集合
     */
    public List<ArticleTag> selectArticleTagList(ArticleTag articleTag);

    /**
     * 新增文章标签管理
     * 
     * @param articleTag 文章标签管理
     * @return 结果
     */
    public int insertArticleTag(ArticleTag articleTag);

    /**
     * 修改文章标签管理
     * 
     * @param articleTag 文章标签管理
     * @return 结果
     */
    public int updateArticleTag(ArticleTag articleTag);

    /**
     * 删除文章标签管理
     * 
     * @param tagId 文章标签管理主键
     * @return 结果
     */
    public int deleteArticleTagById(@Param("tagId") Long tagId);

    /**
     * 批量删除文章标签管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticleTagByIds(Long[] ids);
}
