package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.service.IArticleStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DragonWen
 * @date: 2024/6/30
 * @Version: 1.0
 * @description:
 */
@Anonymous
@RestController
@RequestMapping("/web/statistics")
@Api(tags = "统计信息信息")
public class StatisticsApiController extends BaseController {

    @Autowired
    private IArticleStatisticsService articleStatisticsService;

    @PostMapping("/info")
    @ApiOperation(value = "前台获取统计信息")
    public AjaxResult findInfo() {
        return AjaxResult.success(articleStatisticsService.findInfo());
    }
}
