package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.domain.PortalSettings;
import com.dragon.portal.service.IPortalSettingsService;
import com.dragon.system.service.ISysConfigService;
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
    private ISysConfigService configService;

    @Autowired
    private IPortalSettingsService portalSettingsService;

    @ApiOperation(value = "获取网站详细信息")
    @PostMapping("/detail")
    public AjaxResult findDetail() {
        String configValue = configService.selectConfigByKey(CacheConstants.CONFIG_KEY_PORTAL_SETTINGS_INFO);
        PortalSettings portalSettings = portalSettingsService.packageSettingsInfo(configValue);
        return AjaxResult.success(portalSettings);
    }
}
