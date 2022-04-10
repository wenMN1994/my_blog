package com.dragon.web.controller.cms;

import com.dragon.cms.service.ICmsFileService;
import com.dragon.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dragon.common.core.controller.BaseController;

/**
 * 文件管理Controller
 * 
 * @author DragonWen
 * @date 2021-09-25
 */
@RestController
@RequestMapping("/cms/file")
public class CmsFileController extends BaseController {
    @Autowired
    private ICmsFileService cmsFileService;

    @Autowired
    private ISysDictTypeService sysDictTypeService;
}
