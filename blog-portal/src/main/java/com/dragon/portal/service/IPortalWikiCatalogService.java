package com.dragon.portal.service;

import java.util.List;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.portal.domain.FindWikiArticlePreNextVo;
import com.dragon.portal.domain.PortalWikiCatalog;

/**
 * 知识库目录Service接口
 *
 * @author dragon
 * @date 2024-07-21
 */
public interface IPortalWikiCatalogService {
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
     * @param loginUser
     * @return 结果
     */
    public int insertPortalWikiCatalog(PortalWikiCatalog portalWikiCatalog, LoginUser loginUser);

    /**
     * 修改知识库目录
     *
     * @param portalWikiCatalog 知识库目录
     * @param loginUser
     * @return 结果
     */
    public int updatePortalWikiCatalog(PortalWikiCatalog portalWikiCatalog, LoginUser loginUser);

    /**
     * 批量删除知识库目录
     *
     * @param wikiCatalogIds 需要删除的知识库目录主键集合
     * @param loginUser
     * @return 结果
     */
    public int deletePortalWikiCatalogByWikiCatalogIds(Long[] wikiCatalogIds, LoginUser loginUser);

    /**
     * 删除知识库目录信息
     *
     * @param wikiCatalogId 知识库目录主键
     * @return 结果
     */
    public int deletePortalWikiCatalogByWikiCatalogId(Long wikiCatalogId);

    /**
     * 获取知识库文章上下页
     * @param portalWikiCatalog
     * @return
     */
    public FindWikiArticlePreNextVo findArticlePreNext(PortalWikiCatalog portalWikiCatalog);
}
