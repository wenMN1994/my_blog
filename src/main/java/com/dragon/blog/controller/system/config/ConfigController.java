package com.dragon.blog.controller.system.config;

import com.dragon.base.BaseController;
import com.dragon.blog.model.BlogSysConfig;
import com.dragon.blog.model.BlogSysConfigExample;
import com.dragon.blog.service.BlogSysConfigService;
import com.dragon.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/14 14:40
 * @description： 参数配置 信息操作处理
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/system/config")
public class ConfigController extends BaseController {
    private String prefix = "system/config";

    @Autowired
    private BlogSysConfigService blogSysConfigService;

    @GetMapping()
    public String config() {
        return prefix + "/config";
    }

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(BlogSysConfig blogSysConfig) {
        startPage();
        BlogSysConfigExample blogSysConfigExample = new BlogSysConfigExample();
        List<BlogSysConfig> list = blogSysConfigService.selectByExample(blogSysConfigExample);
        return getDataTable(list);
    }
}
