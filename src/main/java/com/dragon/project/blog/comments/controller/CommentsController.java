package com.dragon.project.blog.comments.controller;

import com.dragon.framework.web.controller.BaseController;
import com.dragon.framework.web.page.TableDataInfo;
import com.dragon.project.blog.comments.domain.CommentsInfo;
import com.dragon.project.blog.comments.service.CommentsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/8/15 15:09
 * @description：评论管理控制器
 * @modified By：
 * @version: 1.0.0
 */
@Api("评论管理")
@Controller
@RequestMapping("/blog/comments")
public class CommentsController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(CommentsController.class);

    private String prefix = "blog/comments";

    @Autowired
    private CommentsInfoService commentsInfoService;

    @GetMapping()
    @ApiOperation("访问评论管理页面")
    public String comments() {
        return prefix + "/comments";
    }

    @GetMapping("/list")
    @ApiOperation("查询评论信息")
    @ResponseBody
    public TableDataInfo list(CommentsInfo commentsInfo) {
        startPage();
        List<CommentsInfo> commentsInfoList = commentsInfoService.selectCommentsInfoList(commentsInfo);
        return getDataTable(commentsInfoList);
    }

}
