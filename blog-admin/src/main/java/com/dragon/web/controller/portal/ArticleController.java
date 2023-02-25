package com.dragon.web.controller.portal;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dragon.common.core.domain.model.LoginUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
import com.dragon.portal.domain.Article;
import com.dragon.portal.service.IArticleService;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 文章信息Controller
 *
 * @author dragon
 * @date 2022-05-08
 */
@Api(tags = "文章管理")
@RestController
@RequestMapping("/portal/article")
public class ArticleController extends BaseController {
    @Autowired
    private IArticleService articleService;

    /**
     * 查询文章信息列表
     */
    @ApiOperation(value = "获取文章列表")
    @PreAuthorize("@ss.hasPermi('portal:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(Article article) {
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        return getDataTable(list);
    }

    /**
     * 导出文章信息列表
     */
    @ApiOperation(value = "导出文章列表")
    @PreAuthorize("@ss.hasPermi('portal:article:export')")
    @Log(title = "文章信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Article article) {
        List<Article> list = articleService.selectArticleList(article);
        ExcelUtil<Article> util = new ExcelUtil<>(Article.class);
        util.exportExcel(response, list, "文章信息数据");
    }

    /**
     * 获取文章详细信息
     */
    @ApiOperation(value = "获取文章详细信息")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermi('portal:article:query')")
    @GetMapping(value = "/{articleId}")
    public AjaxResult getInfo(@PathVariable("articleId") Long articleId) {
        return AjaxResult.success(articleService.selectArticleByArticleId(articleId));
    }

    /**
     * 新增文章信息
     */
    @ApiOperation(value = "新增文章")
    @PreAuthorize("@ss.hasPermi('portal:article:add')")
    @Log(title = "文章信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Article article) {
        LoginUser loginUser = getLoginUser();
        return toAjax(articleService.insertArticle(article, loginUser));
    }

    /**
     * 修改文章信息
     */
    @ApiOperation(value = "修改文章")
    @PreAuthorize("@ss.hasPermi('portal:article:edit')")
    @Log(title = "文章信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Article article) {
        LoginUser loginUser = getLoginUser();
        return toAjax(articleService.updateArticle(article, loginUser));
    }

    /**
     * 删除文章信息
     */
    @ApiOperation(value = "删除文章")
    @ApiImplicitParam(name = "articleIds", value = "文章ID数组", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermi('portal:article:remove')")
    @Log(title = "文章信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{articleIds}")
    public AjaxResult remove(@PathVariable Long[] articleIds) {
        LoginUser loginUser = getLoginUser();
        return toAjax(articleService.deleteArticleByArticleIds(articleIds, loginUser));
    }
}
