package com.dragon.web.controller.web;

import com.dragon.common.annotation.Anonymous;
import com.dragon.common.annotation.RateLimiter;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.redis.RedisCache;
import com.dragon.portal.domain.Slideshow;
import com.dragon.portal.service.ISlideshowService;
import com.dragon.system.domain.SysNotice;
import com.dragon.system.service.ISysNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-08-20
 * @description：网站首页ApiController
 * @modifiedBy：
 * @version:
 */
@Anonymous
@RestController
@RequestMapping("/web/index")
@Api(tags = "网站首页基础信息")
public class IndexApiController extends BaseController {
    @Autowired
    private ISlideshowService slideshowService;

    @Autowired
    private ISysNoticeService sysNoticeService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 前端获取轮播图信息
     * @param slideshow 轮播图
     * @return
     */
    @GetMapping("/getSlideshowList")
    public AjaxResult getSlideshowList(Slideshow slideshow) {
        List<Slideshow> slideshowList = new ArrayList<>();
        if(redisCache.hasKey(CacheConstants.INDEX_FRONT_SLIDESHOW_KEY)){
            slideshowList = redisCache.getCacheList(CacheConstants.INDEX_FRONT_SLIDESHOW_KEY);
        } else {
            slideshowList = slideshowService.selectSlideshowList(slideshow);
            redisCache.setCacheList(CacheConstants.INDEX_FRONT_SLIDESHOW_KEY, slideshowList);
        }
        return AjaxResult.success(slideshowList);
    }

    /**
     * 查询热门课程和新上好课
     * @return
     */
    @GetMapping("/getIndexData")
    public AjaxResult getIndexData() {
        // @TODO 查询热门课程和新上好课
        return AjaxResult.success();
    }

    /**
     * 校验账号、手机号码、邮箱是否已注册
     * @param account
     * @return
     */
    @GetMapping("/verifyAccount")
    @RateLimiter
    public AjaxResult verifyAccount(@RequestParam(name = "account") String account) {
        // @TODO 查询数据库校验账号、手机号码、邮箱是否已注册
        return AjaxResult.success(true);
    }

    @ApiOperation(value = "获取通知公告列表")
    @PostMapping("/getNoticeList")
    public AjaxResult getNoticeList() {
        return AjaxResult.success(sysNoticeService.selectNoticeList(new SysNotice()));
    }
}
