package com.dragon.web.controller.portal;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dragon.common.annotation.Log;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.enums.BusinessType;
import com.dragon.portal.domain.ArticleTagRel;
import com.dragon.portal.service.IArticleTagRelService;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 文章对应标签关联Controller
 *
 * @author dragon
 * @date 2024-06-23
 */
@RestController
@RequestMapping("/portal/articleTagRel")
public class ArticleTagRelController extends BaseController {
    @Autowired
    private IArticleTagRelService articleTagRelService;

    /**
     * 查询文章对应标签关联列表
     */
    @PreAuthorize("@ss.hasPermi('portal:articleTagRel:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArticleTagRel articleTagRel) {
        startPage();
        List<ArticleTagRel> list = articleTagRelService.selectArticleTagRelList(articleTagRel);
        return getDataTable(list);
    }

    /**
     * 导出文章对应标签关联列表
     */
    @PreAuthorize("@ss.hasPermi('portal:articleTagRel:export')")
    @Log(title = "文章对应标签关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ArticleTagRel articleTagRel) {
        List<ArticleTagRel> list = articleTagRelService.selectArticleTagRelList(articleTagRel);
        ExcelUtil<ArticleTagRel> util = new ExcelUtil<ArticleTagRel>(ArticleTagRel.class);
        util.exportExcel(response, list, "文章对应标签关联数据");
    }

    /**
     * 获取文章对应标签关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('portal:articleTagRel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(articleTagRelService.selectArticleTagRelById(id));
    }

    /**
     * 新增文章对应标签关联
     */
    @PreAuthorize("@ss.hasPermi('portal:articleTagRel:add')")
    @Log(title = "文章对应标签关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArticleTagRel articleTagRel) {
        return toAjax(articleTagRelService.insertArticleTagRel(articleTagRel));
    }

    /**
     * 修改文章对应标签关联
     */
    @PreAuthorize("@ss.hasPermi('portal:articleTagRel:edit')")
    @Log(title = "文章对应标签关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArticleTagRel articleTagRel) {
        return toAjax(articleTagRelService.updateArticleTagRel(articleTagRel));
    }

    /**
     * 删除文章对应标签关联
     */
    @PreAuthorize("@ss.hasPermi('portal:articleTagRel:remove')")
    @Log(title = "文章对应标签关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(articleTagRelService.deleteArticleTagRelByIds(ids));
    }
}