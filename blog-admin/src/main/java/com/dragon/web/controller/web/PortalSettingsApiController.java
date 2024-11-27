package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.domain.PortalSettings;
import com.dragon.portal.service.IPortalSettingsService;
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
 * @description: 网站设置
 */
@Anonymous
@RestController
@RequestMapping("/web/portal/settings")
@Api(tags = "网站设置")
public class PortalSettingsApiController extends BaseController {

    @Autowired
    private IPortalSettingsService portalSettingsService;

    @ApiOperation(value = "获取网站详细信息")
    @PostMapping("/detail")
    public AjaxResult findDetail() {
        PortalSettings portalSettings = portalSettingsService.packageSettingsInfo();
        return AjaxResult.success(portalSettings);
    }
}
