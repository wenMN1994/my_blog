package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.page.TableDataInfo;
import com.dragon.portal.domain.Article;
import com.dragon.portal.domain.ArticleTag;
import com.dragon.portal.service.IArticleTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: DragonWen
 * @date: 2024/6/30
 * @Version: 1.0
 * @description: 标签信息
 */
@Anonymous
@RestController
@RequestMapping("/web/tag")
@Api(tags = "标签信息")
public class TagApiController extends BaseController {

    @Autowired
    private IArticleTagService articleTagService;

    @PostMapping("/list")
    @ApiOperation(value = "前台获取标签列表")
    public AjaxResult findCategoryList() {
        return AjaxResult.success(articleTagService.selectArticleTagList(new ArticleTag()));
    }

    @ApiOperation(value = "前台获取标签下文章列表")
    @PostMapping("/article/list")
    public TableDataInfo getTagArticlePageList(@RequestBody ArticleTag articleTag) {
        startPage();
        List<Article> list = articleTagService.getTagArticlePageList(articleTag);
        return getDataTable(list);
    }
}
