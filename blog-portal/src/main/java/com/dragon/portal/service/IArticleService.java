package com.dragon.portal.service;

import java.util.List;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.portal.domain.ArchiveArticle;
import com.dragon.portal.domain.Article;

/**
 * 文章信息Service接口
 *
 * @author dragon
 * @date 2022-05-08
 */
public interface IArticleService {
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
     * @param loginUser 登录用户信息
     * @return 结果
     */
    public int insertArticle(Article article, LoginUser loginUser);

    /**
     * 修改文章信息
     *
     * @param article 文章信息
     * @param loginUser 登录用户信息
     * @return 结果
     */
    public int updateArticle(Article article, LoginUser loginUser);

    /**
     * 批量删除文章信息
     *
     * @param articleIds 需要删除的文章信息主键集合
     * @param loginUser 登录用户信息
     * @return 结果
     */
    public int deleteArticleByArticleIds(Long[] articleIds, LoginUser loginUser);

    /**
     * 删除文章信息信息
     *
     * @param articleId 文章信息主键
     * @param loginUser 登录用户信息
     * @return 结果
     */
    public int deleteArticleByArticleId(Long articleId, LoginUser loginUser);

    /**
     * 更新文章置顶状态
     * @param articleId
     * @param isTop
     * @param loginUser
     * @return
     */
    public int updateArticleIsTop(Long articleId, Boolean isTop, LoginUser loginUser);

    /**
     * 获取首页文章分页数据
     * @param article
     * @return
     */
    public List<Article> getArticlePageList(Article article);

    /**
     * 获取文章归档分页数据
     * @return
     */
    public List<ArchiveArticle> getArchivePageList();
}
