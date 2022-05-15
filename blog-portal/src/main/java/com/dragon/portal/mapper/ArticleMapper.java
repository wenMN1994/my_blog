package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.Article;

/**
 * 文章信息Mapper接口
 *
 * @author dragon
 * @date 2022-05-08
 */
public interface ArticleMapper
{
    /**
     * 查询文章信息
     *
     * @param articleId 文章信息主键
     * @return 文章信息
     */
    public Article selectArticleByArticleId(Long articleId);

    /**
     * 查询文章信息列表
     *
     * @param article 文章信息
     * @return 文章信息集合
     */
    public List<Article> selectArticleList(Article article);

    /**
     * 新增文章信息
     *
     * @param article 文章信息
     * @return 结果
     */
    public int insertArticle(Article article);

    /**
     * 修改文章信息
     *
     * @param article 文章信息
     * @return 结果
     */
    public int updateArticle(Article article);

    /**
     * 删除文章信息
     *
     * @param articleId 文章信息主键
     * @return 结果
     */
    public int deleteArticleByArticleId(Long articleId);

    /**
     * 批量删除文章信息
     *
     * @param articleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticleByArticleIds(Long[] articleIds);
}