package com.dragon.portal.service;

import com.dragon.portal.domain.PortalSettings;

/**
 * @author: DragonWen
 * @date: 2024/6/29
 * @Version: 1.0
 * @description: 网站设置服务层接口
 */
public interface IPortalSettingsService {
    /**
     * 组装网站设置信息实体
     * @param configValue
     * @return
     */
    public PortalSettings packageSettingsInfo(String configValue);
}
