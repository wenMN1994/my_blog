package com.dragon.portal.mapper;

import java.util.List;
import java.util.Map;

import com.dragon.portal.domain.PortalWikiCatalog;
import org.apache.ibatis.annotations.Param;

/**
 * 知识库目录Mapper接口
 *
 * @author dragon
 * @date 2024-07-21
 */
public interface PortalWikiCatalogMapper {
    /**
     * 查询知识库目录
     *
     * @param wikiCatalogId 知识库目录主键
     * @return 知识库目录
     */
    public PortalWikiCatalog selectPortalWikiCatalogByWikiCatalogId(Long wikiCatalogId);

    /**
     * 查询知识库目录列表
     *
     * @param portalWikiCatalog 知识库目录
     * @return 知识库目录集合
     */
    public List<PortalWikiCatalog> selectPortalWikiCatalogList(PortalWikiCatalog portalWikiCatalog);

    /**
     * 新增知识库目录
     *
     * @param portalWikiCatalog 知识库目录
     * @return 结果
     */
    public int insertPortalWikiCatalog(PortalWikiCatalog portalWikiCatalog);

    /**
     * 修改知识库目录
     *
     * @param portalWikiCatalog 知识库目录
     * @return 结果
     */
    public int updatePortalWikiCatalog(PortalWikiCatalog portalWikiCatalog);

    /**
     * 删除知识库目录
     *
     * @param wikiCatalogId 知识库目录主键
     * @return 结果
     */
    public int deletePortalWikiCatalogByWikiCatalogId(Long wikiCatalogId);

    /**
     * 批量删除知识库目录
     *
     * @param wikiCatalogIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePortalWikiCatalogByWikiCatalogIds(Long[] wikiCatalogIds);

    /**
     * 批量插入知识库内容
     * @param portalWikiCatalogList
     * @return
     */
    public int batchInsertPortalWikiCatalog(List<PortalWikiCatalog> portalWikiCatalogList);

    /**
     * 获取知识库第一篇文章ID
     * @param wikiId
     * @return
     */
    public Long selectFirstArticleId(Long wikiId);

    /**
     * 获取当前文章所属知识库的目录的上一篇文章和下一篇文章
     * @param wikiId 知识库ID
     * @param articleId 文章ID
     */
    public Map<String, Object> selectByWikiIdAndArticleId(@Param("wikiId") Long wikiId, @Param("articleId") Long articleId);
}
