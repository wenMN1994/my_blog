package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.page.TableDataInfo;
import com.dragon.portal.domain.ArchiveArticle;
import com.dragon.portal.domain.Article;
import com.dragon.portal.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: DragonWen
 * @date: 2024/6/30
 * @Version: 1.0
 * @description: 文章归档
 */
@Anonymous
@RestController
@RequestMapping("/web/archive")
@Api(tags = "文章归档")
public class ArchiveApiController extends BaseController {

    @Autowired
    private IArticleService articleService;

    @ApiOperation(value = "获取文章归档分页数据")
    @PostMapping("/list")
    public TableDataInfo getArchivePageList() {
        startPage();
        List<ArchiveArticle> list = articleService.getArchivePageList();
        return getDataTable(list);
    }
}
