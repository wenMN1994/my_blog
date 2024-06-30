package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.page.TableDataInfo;
import com.dragon.portal.domain.Article;
import com.dragon.portal.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-09-05
 * @description：网站文章ApiController
 * @modifiedBy：
 * @version:
 */
@Anonymous
@RestController
@RequestMapping("/web/article")
@Api(tags = "网站文章信息")
public class ArticleApiController extends BaseController {
    @Autowired
    private IArticleService articleService;

    /**
     * 获取首页文章分页数据
     * @param article
     * @return
     */
    @ApiOperation(value = "获取首页文章分页数据")
    @PostMapping("/getArticlePageList")
    public TableDataInfo getArticlePageList(Article article) {
        startPage();
        List<Article> list = articleService.getArticlePageList(article);
        return getDataTable(list);
    }

    /**
     * 根据文章ID获取文章详细信息
     */
    @ApiOperation(value = "根据文章ID获取文章详细信息")
    @GetMapping( "/getArticleInfo")
    public AjaxResult getArticleInfo(Article article) {
        return AjaxResult.success(articleService.selectArticleByArticleId(article.getArticleId()));
    }
}
