package com.dragon.portal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.common.utils.DateUtils;
import com.dragon.portal.domain.Article;
import com.dragon.portal.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.PortalWikiCatalogMapper;
import com.dragon.portal.domain.PortalWikiCatalog;
import com.dragon.portal.service.IPortalWikiCatalogService;

/**
 * 知识库目录Service业务层处理
 *
 * @author dragon
 * @date 2024-07-21
 */
@Service
public class PortalWikiCatalogServiceImpl implements IPortalWikiCatalogService {
    @Autowired
    private PortalWikiCatalogMapper portalWikiCatalogMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询知识库目录
     *
     * @param wikiCatalogId 知识库目录主键
     * @return 知识库目录
     */
    @Override
    public PortalWikiCatalog selectPortalWikiCatalogByWikiCatalogId(Long wikiCatalogId) {
        return portalWikiCatalogMapper.selectPortalWikiCatalogByWikiCatalogId(wikiCatalogId);
    }

    /**
     * 查询知识库目录列表
     *
     * @param portalWikiCatalog 知识库目录
     * @return 知识库目录
     */
    @Override
    public List<PortalWikiCatalog> selectPortalWikiCatalogList(PortalWikiCatalog portalWikiCatalog) {
        return portalWikiCatalogMapper.selectPortalWikiCatalogList(portalWikiCatalog);
    }

    /**
     * 新增知识库目录
     *
     * @param portalWikiCatalog 知识库目录
     * @param loginUser
     * @return 结果
     */
    @Override
    public int insertPortalWikiCatalog(PortalWikiCatalog portalWikiCatalog, LoginUser loginUser) {
        if (Objects.equals("C", portalWikiCatalog.getCatalogType())) {
            // 添加内容
            if (CollectionUtil.isEmpty(portalWikiCatalog.getArticleIds())) {
                throw new RuntimeException("请选择要添加的内容！");
            }
            List<Article> articleList = articleMapper.selectArticleByArticleIds(portalWikiCatalog.getArticleIds());
            List<PortalWikiCatalog> portalWikiCatalogList = new ArrayList<>();
            articleList.forEach(article -> {
                PortalWikiCatalog portalWikiCatalogItem = new PortalWikiCatalog();
                BeanUtil.copyProperties(portalWikiCatalog, portalWikiCatalogItem);
                portalWikiCatalogItem.setArticleId(article.getArticleId());
                portalWikiCatalogItem.setCatalogName(article.getArticleTitle());
                portalWikiCatalogItem.setCreateBy(loginUser.getUsername());
                portalWikiCatalogItem.setCreateTime(DateUtils.getNowDate());
                portalWikiCatalogList.add(portalWikiCatalogItem);
            });
            return portalWikiCatalogMapper.batchInsertPortalWikiCatalog(portalWikiCatalogList);
        } else if (Objects.equals("M", portalWikiCatalog.getCatalogType())) {
            // 添加目录
            portalWikiCatalog.setCreateBy(loginUser.getUsername());
            portalWikiCatalog.setCreateTime(DateUtils.getNowDate());
            return portalWikiCatalogMapper.insertPortalWikiCatalog(portalWikiCatalog);
        }
        return 0;
    }

    /**
     * 修改知识库目录
     *
     * @param portalWikiCatalog 知识库目录
     * @param loginUser
     * @return 结果
     */
    @Override
    public int updatePortalWikiCatalog(PortalWikiCatalog portalWikiCatalog, LoginUser loginUser) {
        portalWikiCatalog.setUpdateBy(loginUser.getUsername());
        portalWikiCatalog.setUpdateTime(DateUtils.getNowDate());
        return portalWikiCatalogMapper.updatePortalWikiCatalog(portalWikiCatalog);
    }

    /**
     * 批量删除知识库目录
     *
     * @param wikiCatalogIds 需要删除的知识库目录主键
     * @return 结果
     */
    @Override
    public int deletePortalWikiCatalogByWikiCatalogIds(Long[] wikiCatalogIds) {
        return portalWikiCatalogMapper.deletePortalWikiCatalogByWikiCatalogIds(wikiCatalogIds);
    }

    /**
     * 删除知识库目录信息
     *
     * @param wikiCatalogId 知识库目录主键
     * @return 结果
     */
    @Override
    public int deletePortalWikiCatalogByWikiCatalogId(Long wikiCatalogId) {
        return portalWikiCatalogMapper.deletePortalWikiCatalogByWikiCatalogId(wikiCatalogId);
    }
}
