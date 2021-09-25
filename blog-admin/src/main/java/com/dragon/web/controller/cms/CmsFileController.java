package com.dragon.web.controller.cms;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dragon.common.annotation.Log;
import com.dragon.common.enums.BusinessType;
import com.dragon.cms.domain.CmsFile;
import com.dragon.cms.service.ICmsFileService;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 文件管理Controller
 * 
 * @author DragonWen
 * @date 2021-09-25
 */
@Controller
@RequestMapping("/cms/file")
public class CmsFileController extends BaseController
{
    private String prefix = "cms/file";

    @Autowired
    private ICmsFileService cmsFileService;

    @RequiresPermissions("cms:file:view")
    @GetMapping()
    public String file()
    {
        return prefix + "/file";
    }

    /**
     * 查询文件管理列表
     */
    @RequiresPermissions("cms:file:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CmsFile cmsFile)
    {
        startPage();
        List<CmsFile> list = cmsFileService.selectCmsFileList(cmsFile);
        return getDataTable(list);
    }

    /**
     * 导出文件管理列表
     */
    @RequiresPermissions("cms:file:export")
    @Log(title = "文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CmsFile cmsFile)
    {
        List<CmsFile> list = cmsFileService.selectCmsFileList(cmsFile);
        ExcelUtil<CmsFile> util = new ExcelUtil<CmsFile>(CmsFile.class);
        return util.exportExcel(list, "文件管理数据");
    }

    /**
     * 新增文件管理
     */
    @GetMapping("/upload")
    public String upload()
    {
        return prefix + "/upload";
    }

    /**
     * 新增保存文件管理
     */
    @RequiresPermissions("cms:file:upload")
    @Log(title = "文件管理", businessType = BusinessType.INSERT)
    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadSave(CmsFile cmsFile)
    {
        return toAjax(cmsFileService.insertCmsFile(cmsFile));
    }

    /**
     * 删除文件管理
     */
    @RequiresPermissions("cms:file:remove")
    @Log(title = "文件管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cmsFileService.deleteCmsFileByFileIds(ids));
    }
}
