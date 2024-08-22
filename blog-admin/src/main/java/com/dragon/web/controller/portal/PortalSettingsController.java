package com.dragon.web.controller.portal;

import com.alibaba.fastjson2.JSON;
import com.dragon.common.annotation.Log;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.enums.BusinessType;
import com.dragon.common.utils.StringUtils;
import com.dragon.portal.domain.PortalSettings;
import com.dragon.portal.service.IPortalSettingsService;
import com.dragon.system.domain.SysConfig;
import com.dragon.system.domain.SysFile;
import com.dragon.system.service.ISysConfigService;
import com.dragon.system.service.ISysFileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author: DragonWen
 * @date: 2024/6/29
 * @Version: 1.0
 * @description: 网站设置Controller
 */
@RestController
@RequestMapping("/portal/settings")
public class PortalSettingsController extends BaseController {

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IPortalSettingsService portalSettingsService;

    @Autowired
    private ISysFileService sysFileService;

    @ApiOperation(value = "获取网站详细信息")
    @PostMapping("/detail")
    @PreAuthorize("@ss.hasPermi('portal:settings:query')")
    public AjaxResult findDetail() {
        PortalSettings portalSettings = portalSettingsService.packageSettingsInfo();
        return AjaxResult.success(portalSettings);
    }

    @ApiOperation(value = "修改网站详细信息")
    @Log(title = "网站设置", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @PreAuthorize("@ss.hasPermi('portal:settings:edit')")
    public AjaxResult update(@RequestBody @Validated PortalSettings portalSettings) {
        String configValue = JSON.toJSON(portalSettings).toString();
        SysConfig sysConfig = new SysConfig();
        sysConfig.setConfigKey(CacheConstants.CONFIG_KEY_PORTAL_SETTINGS_INFO);
        sysConfig.setConfigValue(configValue);
        String dbConfigValue = configService.selectConfigByKey(CacheConstants.CONFIG_KEY_PORTAL_SETTINGS_INFO);
        SysFile sysFile = sysFileService.selectSysFileByFileUrl(portalSettings.getMemberAvatar());
        if (Objects.isNull(sysFile)) {
            // 保存到系统文件表
            SysFile saveSysFile = new SysFile();
            saveSysFile.setFileUrl(portalSettings.getMemberAvatar());
            saveSysFile.setCreateBy(getUsername());
            sysFileService.insertSysFile(saveSysFile);
        }
        int count = 0;
        if (StringUtils.isEmpty(dbConfigValue)) {
            sysConfig.setConfigName("网站设置");
            sysConfig.setConfigType("Y");
            sysConfig.setRemark("网站管理菜单下的网站设置数据源");
            sysConfig.setCreateBy(getUsername());
            count = configService.insertConfig(sysConfig);
        } else {
            sysConfig.setUpdateBy(getUsername());
            count = configService.updateConfigByKey(sysConfig);
        }
        return toAjax(count);
    }
}
