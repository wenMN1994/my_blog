package com.dragon.web.service;

import com.dragon.blog.service.BlogSysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/15 15:07
 * @description：html调用 thymeleaf 实现参数管理
 * @modified By：
 * @version: 1.0.0
 */
@Service("config")
public class ConfigService {
    @Autowired
    private BlogSysConfigService blogSysConfigService;

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数名称
     * @return 参数键值
     */
    public String getKey(String configKey) {
        return String.valueOf(blogSysConfigService.selectByPrimaryKey(configKey));
    }

}
