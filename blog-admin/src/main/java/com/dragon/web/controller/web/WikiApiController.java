package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.domain.Article;
import com.dragon.portal.domain.PortalWiki;
import com.dragon.portal.service.IPortalWikiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DragonWen
 * @date: 2024/7/21
 * @Version: 1.0
 * @description:
 */
@Anonymous
@RestController
@RequestMapping("/web/wiki")
@Api(tags = "知识库")
public class WikiApiController extends BaseController {

    @Autowired
    private IPortalWikiService portalWikiService;

    /**
     * 获取知识库列表
     */
    @ApiOperation(value = "获取知识库列表")
    @GetMapping( "/getWikiList")
    public AjaxResult getWikiList(PortalWiki portalWiki) {
        portalWiki.setIsPublish(1);
        return AjaxResult.success(portalWikiService.selectPortalWikiList(portalWiki));
    }
}
