package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.domain.FindWikiArticlePreNextVo;
import com.dragon.portal.domain.PortalWiki;
import com.dragon.portal.domain.PortalWikiCatalog;
import com.dragon.portal.service.IPortalWikiCatalogService;
import com.dragon.portal.service.IPortalWikiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: DragonWen
 * @date: 2024/7/21
 * @Version: 1.0
 * @description:知识库
 */
@Anonymous
@RestController
@RequestMapping("/web/wiki")
@Api(tags = "知识库")
public class WikiApiController extends BaseController {

    @Autowired
    private IPortalWikiService portalWikiService;

    @Autowired
    private IPortalWikiCatalogService portalWikiCatalogService;

    /**
     * 获取知识库列表
     */
    @ApiOperation(value = "获取知识库列表")
    @GetMapping( "/getWikiList")
    public AjaxResult getWikiList(PortalWiki portalWiki) {
        portalWiki.setIsPublish(1);
        return AjaxResult.success(portalWikiService.selectPortalWikiList(portalWiki));
    }

    /**
     * 获取知识库目录列表
     */
    @ApiOperation(value = "获取知识库目录列表")
    @GetMapping( "/getWikiCatalogs")
    public AjaxResult getWikiCatalogs(PortalWikiCatalog portalWikiCatalog) {
        List<PortalWikiCatalog> list = portalWikiCatalogService.selectPortalWikiCatalogList(portalWikiCatalog);
        return success(list);
    }

    /**
     * 获取知识库文章上下页
     * @param portalWikiCatalog
     * @return
     */
    @ApiOperation(value = "获取知识库文章上下页")
    @PostMapping("/article/preNext")
    public AjaxResult findArticlePreNext(@RequestBody PortalWikiCatalog portalWikiCatalog) {
        FindWikiArticlePreNextVo findWikiArticlePreNextVo = portalWikiCatalogService.findArticlePreNext(portalWikiCatalog);
        return success(findWikiArticlePreNextVo);
    }
}
