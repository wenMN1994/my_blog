package com.dragon.portal.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.constant.Constants;
import com.dragon.common.utils.StringUtils;
import com.dragon.portal.domain.PortalSettings;
import com.dragon.portal.service.IPortalSettingsService;
import com.dragon.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: DragonWen
 * @date: 2024/6/29
 * @Version: 1.0
 * @description: 网站设置服务层接口实现
 */
@Service
public class PortalSettingsServiceImpl implements IPortalSettingsService {

    @Autowired
    private ISysConfigService configService;

    /**
     * 组装网站设置信息实体
     * @return
     */
    @Override
    public PortalSettings packageSettingsInfo() {
        String configValue = configService.selectConfigByKey(CacheConstants.CONFIG_KEY_PORTAL_SETTINGS_INFO);
        JSONObject obj = new JSONObject();
        if (StringUtils.isEmpty(configValue)) {
            obj = JSON.parseObject(Constants.PORTAL_SETTINGS);
        }
        obj = JSON.parseObject(configValue);
        PortalSettings portalSettings = new PortalSettings();
        portalSettings.setLogo(obj.getString("logo"));
        portalSettings.setName(obj.getString("name"));
        portalSettings.setAuthor(obj.getString("author"));
        portalSettings.setIntroduction(obj.getString("introduction"));
        portalSettings.setAvatar(obj.getString("avatar"));
        portalSettings.setGithubHomepage(obj.getString("githubHomepage"));
        portalSettings.setCsdnHomepage(obj.getString("csdnHomepage"));
        portalSettings.setGiteeHomepage(obj.getString("giteeHomepage"));
        portalSettings.setZhihuHomepage(obj.getString("zhihuHomepage"));
        portalSettings.setMail(obj.getString("mail"));
        portalSettings.setIsCommentSensitiveWordsOpen(obj.getBoolean("isCommentSensitiveWordsOpen"));
        portalSettings.setIsCommentExamineOpen(obj.getBoolean("isCommentExamineOpen"));
        portalSettings.setMemberAvatar(obj.getString("memberAvatar"));
        portalSettings.setIcp(obj.getString("icp"));
        portalSettings.setDomainName(obj.getString("domainName"));
        portalSettings.setMiit(obj.getString("miit"));
        portalSettings.setCopyrightNotice(obj.getString("copyrightNotice"));
        return portalSettings;
    }
}
