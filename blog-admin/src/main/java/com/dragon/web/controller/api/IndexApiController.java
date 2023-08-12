package com.dragon.web.controller.api;

import com.dragon.common.annotation.RateLimiter;
import com.dragon.common.constant.CacheConstants;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.redis.RedisCache;
import com.dragon.portal.domain.Slideshow;
import com.dragon.portal.service.ISlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/publicApi/indexFront")
public class IndexApiController extends BaseController {
    @Autowired
    private ISlideshowService slideshowService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 前端获取轮播图信息
     * @param slideshow 轮播图
     * @return
     */
    @GetMapping("/getSlideshowList")
    @RateLimiter
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
    @RateLimiter
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
}
