package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.domain.PortalComment;
import com.dragon.portal.service.IPortalCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DragonWen
 * @date: 2024/8/21
 * @Version: 1.0
 * @description: 评论
 */
@Anonymous
@RestController
@RequestMapping("/web/comment")
@Api(tags = "评论")
public class CommentController  extends BaseController {

    @Autowired
    private IPortalCommentService portalCommentService;

    @ApiOperation(value = "发布评论")
    @PostMapping("/publish")
    public AjaxResult publishComment(@RequestBody @Validated PortalComment portalComment) {
        return AjaxResult.success(portalCommentService.publishComment(portalComment));
    }

    @ApiOperation(value = "获取页面所有评论")
    @PostMapping("/list")
    public AjaxResult findPageComments(@RequestBody PortalComment portalComment) {
        return AjaxResult.success(portalCommentService.findPageComments(portalComment));
    }
}
