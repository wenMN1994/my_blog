package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.domain.SearchArticleVo;
import com.dragon.portal.service.ISearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: DragonWen
 * @date: 2024/7/30
 * @Version: 1.0
 * @description:查询服务
 */
@Anonymous
@RestController
@RequestMapping("/web/search")
@Api(tags = "查询服务")
public class SearchController extends BaseController {

    @Autowired
    private ISearchService searchService;

    @ApiOperation(value = "文章搜索")
    @PostMapping("/article")
    public AjaxResult searchArticlePageList(@RequestBody @Validated SearchArticleVo searchArticleVo) {
        Map<String, Object> result = searchService.searchArticlePageList(searchArticleVo);
        return success(result);
    }
}
