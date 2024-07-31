package com.dragon.portal.service;

import com.dragon.portal.domain.SearchArticleVo;

import java.util.Map;

/**
 * @author: DragonWen
 * @date: 2024/7/30
 * @Version: 1.0
 * @description:查询服务接口
 */
public interface ISearchService {
    /**
     * 文章搜索
     * @param searchArticleVo
     * @return
     */
    Map<String, Object> searchArticlePageList(SearchArticleVo searchArticleVo);
}
