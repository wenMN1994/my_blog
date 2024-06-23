package com.dragon.web.controller.portal;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.dragon.portal.domain.ArticleCategory;
import com.dragon.portal.service.IArticleCategoryService;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 文章分类管理Controller
 * 
 * @author dragon
 * @date 2024-06-10
 */
@RestController
@RequestMapping("/portal/category")
public class ArticleCategoryController extends BaseController {
    @Autowired
    private IArticleCategoryService articleCategoryService;

    /**
     * 查询文章分类管理列表
     */
    @ApiOperation(value = "查询文章分类列表")
    @PreAuthorize("@ss.hasPermi('portal:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArticleCategory ArticleCategory) {
        startPage();
        List<ArticleCategory> list = articleCategoryService.selectArticleCategoryList(ArticleCategory);
        return getDataTable(list);
    }

    /**
     * 导出文章分类管理列表
     */
    @ApiOperation(value = "导出文章分类列表")
    @PreAuthorize("@ss.hasPermi('portal:category:export')")
    @Log(title = "文章分类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ArticleCategory ArticleCategory) {
        List<ArticleCategory> list = articleCategoryService.selectArticleCategoryList(ArticleCategory);
        ExcelUtil<ArticleCategory> util = new ExcelUtil<ArticleCategory>(ArticleCategory.class);
        util.exportExcel(response, list, "文章分类管理数据");
    }

    /**
     * 获取文章分类管理详细信息
     */
    @ApiOperation(value = "获取文章分类详细信息")
    @PreAuthorize("@ss.hasPermi('portal:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId) {
        return success(articleCategoryService.selectArticleCategoryById(categoryId));
    }

    /**
     * 新增文章分类管理
     */
    @ApiOperation(value = "新增文章分类")
    @PreAuthorize("@ss.hasPermi('portal:category:add')")
    @Log(title = "文章分类管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArticleCategory ArticleCategory) {
        return toAjax(articleCategoryService.insertArticleCategory(ArticleCategory));
    }

    /**
     * 修改文章分类管理
     */
    @ApiOperation(value = "修改文章分类")
    @PreAuthorize("@ss.hasPermi('portal:category:edit')")
    @Log(title = "文章分类管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArticleCategory ArticleCategory) {
        return toAjax(articleCategoryService.updateArticleCategory(ArticleCategory));
    }

    /**
     * 删除文章分类管理
     */
    @ApiOperation(value = "删除文章分类")
    @PreAuthorize("@ss.hasPermi('portal:category:remove')")
    @Log(title = "文章分类管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(articleCategoryService.deleteArticleCategoryByIds(ids));
    }

    /**
     * 分类下拉列表数据获取
     * @return
     */
    @ApiOperation(value = "文章分类下拉列表")
    @PostMapping("/select/list")
    public AjaxResult findCategorySelectList() {
        return success(articleCategoryService.findCategorySelectList());
    }
}
