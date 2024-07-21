package com.dragon.portal.service.impl;

import java.util.List;
import java.util.Objects;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.common.utils.DateUtils;
import com.dragon.portal.mapper.PortalWikiCatalogMapper;
import com.dragon.system.domain.SysFile;
import com.dragon.system.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.PortalWikiMapper;
import com.dragon.portal.domain.PortalWiki;
import com.dragon.portal.service.IPortalWikiService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 知识库Service业务层处理
 * 
 * @author dragon
 * @date 2024-07-20
 */
@Service
public class PortalWikiServiceImpl implements IPortalWikiService {
    @Autowired
    private ISysFileService iSysFileService;

    @Autowired
    private PortalWikiMapper portalWikiMapper;

    @Autowired
    private PortalWikiCatalogMapper portalWikiCatalogMapper;

    /**
     * 查询知识库
     * 
     * @param wikiId 知识库主键
     * @return 知识库
     */
    @Override
    public PortalWiki selectPortalWikiByWikiId(Long wikiId) {
        PortalWiki portalWiki = portalWikiMapper.selectPortalWikiByWikiId(wikiId);
        // 获取封面url
        if(Objects.nonNull(portalWiki) && Objects.nonNull(portalWiki.getCover())){
            SysFile sysFile = iSysFileService.selectSysFileByFileId(portalWiki.getCover());
            portalWiki.setCoverUrl(sysFile.getFileUrl());
        }
        return portalWiki;
    }

    /**
     * 查询知识库列表
     * 
     * @param portalWiki 知识库
     * @return 知识库
     */
    @Override
    public List<PortalWiki> selectPortalWikiList(PortalWiki portalWiki) {
        List<PortalWiki> portalWikiList = portalWikiMapper.selectPortalWikiList(portalWiki);
        portalWikiList.forEach(item -> {
            // 获取封面url
            if(Objects.nonNull(item) && Objects.nonNull(item.getCover())){
                SysFile sysFile = iSysFileService.selectSysFileByFileId(item.getCover());
                item.setCoverUrl(sysFile.getFileUrl());
            }
            item.setIsTop(item.getWeight() > 0);
            item.setIsPublishBoolean(item.getIsPublish() == 1);
            // 设置每个知识库的第一篇文章 ID，方便前端跳转
            Long articleId = portalWikiCatalogMapper.selectFirstArticleId(item.getWikiId());
            item.setFirstArticleId(articleId);
        });
        return portalWikiList;
    }

    /**
     * 新增知识库
     *
     * @param portalWiki 知识库
     * @param loginUser
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPortalWiki(PortalWiki portalWiki, LoginUser loginUser) {
        try {
            SysFile sysFile = new SysFile();
            sysFile.setFileUrl(portalWiki.getCoverUrl());
            sysFile.setIsEnable("0");
            sysFile.setCreateBy(loginUser.getUsername());
            iSysFileService.insertSysFile(sysFile);
            portalWiki.setCover(sysFile.getFileId());
            portalWiki.setCreateBy(loginUser.getUsername());
            portalWiki.setCreateTime(DateUtils.getNowDate());
            return portalWikiMapper.insertPortalWiki(portalWiki);
        } catch (Exception e) {
            throw new RuntimeException("新增失败！");
        }

    }

    /**
     * 修改知识库
     *
     * @param portalWiki 知识库
     * @param loginUser
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updatePortalWiki(PortalWiki portalWiki, LoginUser loginUser) {
        // 1、保存封面并返回封面ID
        if(portalWiki.getCover() == null || Objects.equals(0, portalWiki.getCover())){
            SysFile sysFile = new SysFile();
            sysFile.setFileUrl(portalWiki.getCoverUrl());
            sysFile.setIsEnable("0");
            sysFile.setCreateBy(loginUser.getUsername());
            iSysFileService.insertSysFile(sysFile);
            portalWiki.setCover(sysFile.getFileId());
        }
        portalWiki.setUpdateBy(loginUser.getUsername());
        portalWiki.setUpdateTime(DateUtils.getNowDate());
        return portalWikiMapper.updatePortalWiki(portalWiki);
    }

    /**
     * 批量删除知识库
     *
     * @param wikiIds   需要删除的知识库主键
     * @param loginUser
     * @return 结果
     */
    @Override
    public int deletePortalWikiByWikiIds(Long[] wikiIds, LoginUser loginUser) {
        return portalWikiMapper.deletePortalWikiByWikiIds(wikiIds, loginUser.getUsername());
    }

    /**
     * 删除知识库信息
     * 
     * @param wikiId 知识库主键
     * @return 结果
     */
    @Override
    public int deletePortalWikiByWikiId(Long wikiId, LoginUser loginUser) {
        return portalWikiMapper.deletePortalWikiByWikiId(wikiId, loginUser.getUsername());
    }

    /**
     * 修改知识库置顶
     * @param wikiId
     * @param isTop
     * @param loginUser
     * @return
     */
    @Override
    public int updateWikiIsTop(Long wikiId, Boolean isTop, LoginUser loginUser) {
        // 默认权重为 0
        Integer weight = 0;
        // 若设置为置顶
        if (isTop) {
            // 查询出表中最大的权重值
            Integer maxWeight = portalWikiMapper.selectMaxWeight();
            // 最大权重值加一
            weight = maxWeight + 1;
        }
        // 更新知识库权重值
        PortalWiki portalWiki = new PortalWiki();
        portalWiki.setWikiId(wikiId);
        portalWiki.setWeight(weight);
        portalWiki.setUpdateBy(loginUser.getUsername());
        portalWiki.setUpdateTime(DateUtils.getNowDate());
        return portalWikiMapper.updatePortalWiki(portalWiki);
    }

    /**
     * 修改知识库发布状态
     * @param wikiId
     * @param isPublish
     * @param loginUser
     * @return
     */
    @Override
    public int updateWikiIsPublish(Long wikiId, Boolean isPublish, LoginUser loginUser) {
        // 更新知识库权重值
        PortalWiki portalWiki = new PortalWiki();
        portalWiki.setWikiId(wikiId);
        if (isPublish) {
            portalWiki.setIsPublish(1);
        } else {
            portalWiki.setIsPublish(0);
        }
        portalWiki.setUpdateBy(loginUser.getUsername());
        portalWiki.setUpdateTime(DateUtils.getNowDate());
        return portalWikiMapper.updatePortalWiki(portalWiki);
    }
}
