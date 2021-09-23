package com.dragon.web.controller.cms;

import com.dragon.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2021/9/18 15:20
 * @description：文件管理
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("/cms/file")
public class CmsFileController extends BaseController {

    private String prefix = "cms/file";

    @RequiresPermissions("crm:file:view")
    @GetMapping()
    public String file()
    {
        return prefix + "/file";
    }
}
