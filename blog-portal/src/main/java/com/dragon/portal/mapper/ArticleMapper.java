package com.dragon.portal.mapper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.dragon.portal.domain.Article;
import com.dragon.portal.domain.ArticlePublishCountDO;
import com.dragon.portal.domain.FindPreNextArticle;
import org.apache.ibatis.annotations.Param;

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
    public Article selectArticleByArticleId(@Param("articleId") Long articleId);

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
     * @param loginUser 登录用户信息
     * @param nowDate 当前系统时间
     * @return 结果
     */
    public int deleteArticleByArticleId(@Param("articleId") Long articleId, @Param("loginUser") String loginUser, @Param("nowDate") Date nowDate);

    /**
     * 批量删除文章信息
     *
     * @param articleIds 需要删除的数据主键集合
     * @param loginUser 登录用户信息
     * @param nowDate 当前系统时间
     * @return 结果
     */
    public int deleteArticleByArticleIds(@Param("articleIds") Long[] articleIds, @Param("loginUser") String loginUser, @Param("nowDate") Date nowDate);

    /**
     * 获取文章最大权重
     * @return
     */
    public Integer selectMaxWeight();

    /**
     * 执行文章阅读量 +1
     * @param articleId
     */
    public void increaseReadNum(@Param("articleId") Long articleId);

    /**
     * 获取上一篇文章
     * @param articleId
     * @return
     */
    public FindPreNextArticle selectPreArticle(@Param("articleId") Long articleId);

    /**
     * 获取下一篇文章
     * @param articleId
     * @return
     */
    public FindPreNextArticle selectNextArticle(@Param("articleId") Long articleId);

    /**
     * 根据文章id获取文章列表
     * @param articleIds
     * @return
     */
    public List<Article> selectArticleByArticleIds(@Param("articleIds") List<Long> articleIds);

    /**
     * 根据文章ID集合更新文章类型
     *
     * @param articleIds
     * @param type
     * @param username
     * @param nowDate
     */
    public void updateArticleTypeByArticleIds(@Param("articleIds") List<Long> articleIds, @Param("type") Integer type, @Param("username") String username, @Param("nowDate") Date nowDate);

    /**
     * 按日分组，并统计每日发布的文章数量
     * @param startDate
     * @param endDate
     * @return
     */
    public List<ArticlePublishCountDO> selectDateArticlePublishCount(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
