package com.dragon.web.controller.api;

import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.page.TableDataInfo;
import com.dragon.portal.domain.Article;
import com.dragon.portal.service.IArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
@RequestMapping("/publicApi/articleFront")
public class ArticleApiController extends BaseController {
    @Autowired
    private IArticleService articleService;

    /**
     * 分页查询文章列表
     */
    @ApiOperation(value = "分页查询文章列表")
    @GetMapping("/getArticlePageList")
    public TableDataInfo getArticlePageList(Article article) {
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        return getDataTable(list);
    }
}
