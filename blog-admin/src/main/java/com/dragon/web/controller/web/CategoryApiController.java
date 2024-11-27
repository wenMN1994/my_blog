package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.annotation.RateLimiter;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.page.TableDataInfo;
import com.dragon.portal.domain.Article;
import com.dragon.portal.domain.ArticleCategory;
import com.dragon.portal.service.IArticleCategoryService;
import com.dragon.portal.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: DragonWen
 * @date: 2024/6/30
 * @Version: 1.0
 * @description: 分类信息
 */
@Anonymous
@RestController
@RequestMapping("/web/category")
@Api(tags = "分类信息")
public class CategoryApiController extends BaseController {

    @Autowired
    private IArticleCategoryService articleCategoryService;

    @ApiOperation(value = "前台获取分类列表")
    @PostMapping("/list")
    public AjaxResult findCategoryList() {
        return AjaxResult.success(articleCategoryService.selectArticleCategoryList(new ArticleCategory()));
    }

    @ApiOperation(value = "前台获取分类下文章分页数据")
    @GetMapping("/article/list")
    public TableDataInfo getCategoryArticlePageList(ArticleCategory articleCategory) {
        startPage();
        List<Article> list = articleCategoryService.getCategoryArticlePageList(articleCategory);
        return getDataTable(list);
    }
}
