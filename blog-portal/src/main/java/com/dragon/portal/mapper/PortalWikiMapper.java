package com.dragon.portal.mapper;

import java.util.List;
import com.dragon.portal.domain.PortalWiki;
import org.apache.ibatis.annotations.Param;

/**
 * 知识库Mapper接口
 * 
 * @author dragon
 * @date 2024-07-20
 */
public interface PortalWikiMapper {
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
     * @return 结果
     */
    public int insertPortalWiki(PortalWiki portalWiki);

    /**
     * 修改知识库
     * 
     * @param portalWiki 知识库
     * @return 结果
     */
    public int updatePortalWiki(PortalWiki portalWiki);

    /**
     * 删除知识库
     *
     * @param wikiId   知识库主键
     * @param username
     * @return 结果
     */
    public int deletePortalWikiByWikiId(@Param("wikiId") Long wikiId, @Param("username") String username);

    /**
     * 批量删除知识库
     *
     * @param wikiIds  需要删除的数据主键集合
     * @param username
     * @return 结果
     */
    public int deletePortalWikiByWikiIds(@Param("wikiIds") Long[] wikiIds, @Param("username") String username);

    /**
     * 获取知识库最大权重值
     * @return
     */
    public Integer selectMaxWeight();
}
