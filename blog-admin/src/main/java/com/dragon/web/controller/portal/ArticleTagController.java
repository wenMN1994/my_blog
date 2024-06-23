package com.dragon.web.controller.portal;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dragon.common.core.domain.model.LoginUser;
import io.swagger.annotations.ApiOperation;
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
import com.dragon.portal.domain.ArticleTag;
import com.dragon.portal.service.IArticleTagService;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 文章标签管理Controller
 * 
 * @author dragon
 * @date 2024-06-10
 */
@RestController
@RequestMapping("/portal/tag")
public class ArticleTagController extends BaseController {
    @Autowired
    private IArticleTagService articleTagService;

    /**
     * 查询文章标签管理列表
     */
    @ApiOperation(value = "查询文章标签列表")
    @PreAuthorize("@ss.hasPermi('portal:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArticleTag articleTag) {
        startPage();
        List<ArticleTag> list = articleTagService.selectArticleTagList(articleTag);
        return getDataTable(list);
    }

    /**
     * 导出文章标签管理列表
     */
    @ApiOperation(value = "导出文章标签列表")
    @PreAuthorize("@ss.hasPermi('portal:tag:export')")
    @Log(title = "文章标签管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ArticleTag articleTag) {
        List<ArticleTag> list = articleTagService.selectArticleTagList(articleTag);
        ExcelUtil<ArticleTag> util = new ExcelUtil<ArticleTag>(ArticleTag.class);
        util.exportExcel(response, list, "文章标签管理数据");
    }

    /**
     * 获取文章标签管理详细信息
     */
    @ApiOperation(value = "获取文章标签详细信息")
    @PreAuthorize("@ss.hasPermi('portal:tag:query')")
    @GetMapping(value = "/{tagId}")
    public AjaxResult getInfo(@PathVariable("tagId") Long tagId) {
        return success(articleTagService.selectArticleTagById(tagId));
    }

    /**
     * 新增文章标签管理
     */
    @ApiOperation(value = "新增文章标签")
    @PreAuthorize("@ss.hasPermi('portal:tag:add')")
    @Log(title = "文章标签管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArticleTag articleTag) {
        LoginUser loginUser = getLoginUser();
        return toAjax(articleTagService.insertArticleTag(articleTag, loginUser));
    }

    /**
     * 修改文章标签管理
     */
    @ApiOperation(value = "修改文章标签")
    @PreAuthorize("@ss.hasPermi('portal:tag:edit')")
    @Log(title = "文章标签管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArticleTag articleTag) {
        LoginUser loginUser = getLoginUser();
        return toAjax(articleTagService.updateArticleTag(articleTag, loginUser));
    }

    /**
     * 删除文章标签管理
     */
    @ApiOperation(value = "删除文章标签")
    @PreAuthorize("@ss.hasPermi('portal:tag:remove')")
    @Log(title = "文章标签管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(articleTagService.deleteArticleTagByIds(ids));
    }

    /**
     * 标签下拉列表数据获取
     * @return
     */
    @ApiOperation(value = "文章标签下拉列表")
    @PostMapping("/select/list")
    public AjaxResult findTagSelectList() {
        return success(articleTagService.findTagSelectList());
    }
}
