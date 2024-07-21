package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.PortalWikiCatalog;

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
}
