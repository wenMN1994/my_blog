package com.dragon.portal.service;

import java.util.List;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.portal.domain.PortalWiki;

/**
 * 知识库Service接口
 * 
 * @author dragon
 * @date 2024-07-20
 */
public interface IPortalWikiService {
    /**
     * 查询知识库
     * 
     * @param wikiId 知识库主键
     * @return 知识库
     */
    public PortalWiki selectPortalWikiByWikiId(Long wikiId);

    /**
     * 查询知识库列表
     * 
     * @param portalWiki 知识库
     * @return 知识库集合
     */
    public List<PortalWiki> selectPortalWikiList(PortalWiki portalWiki);

    /**
     * 新增知识库
     *
     * @param portalWiki 知识库
     * @param loginUser
     * @return 结果
     */
    public int insertPortalWiki(PortalWiki portalWiki, LoginUser loginUser);

    /**
     * 修改知识库
     *
     * @param portalWiki 知识库
     * @param loginUser
     * @return 结果
     */
    public int updatePortalWiki(PortalWiki portalWiki, LoginUser loginUser);

    /**
     * 批量删除知识库
     *
     * @param wikiIds   需要删除的知识库主键集合
     * @param loginUser
     * @return 结果
     */
    public int deletePortalWikiByWikiIds(Long[] wikiIds, LoginUser loginUser);

    /**
     * 删除知识库信息
     * 
     * @param wikiId 知识库主键
     * @param loginUser
     * @return 结果
     */
    public int deletePortalWikiByWikiId(Long wikiId, LoginUser loginUser);

    /**
     * 修改知识库置顶
     * @param wikiId
     * @param isTop
     * @param loginUser
     * @return
     */
    public int updateWikiIsTop(Long wikiId, Boolean isTop, LoginUser loginUser);

    /**
     * 修改知识库发布状态
     * @param wikiId
     * @param isPublish
     * @param loginUser
     * @return
     */
    public int updateWikiIsPublish(Long wikiId, Boolean isPublish, LoginUser loginUser);
}
