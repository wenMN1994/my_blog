package com.dragon.web.controller.api;

import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.portal.domain.Slideshow;
import com.dragon.portal.service.ISlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 前端获取轮播图信息
     * @param slideshow 轮播图
     * @return
     */
    @GetMapping("/getSlideshowList")
    public AjaxResult getSlideshowList(Slideshow slideshow) {
        return AjaxResult.success(slideshowService.selectSlideshowList(slideshow));
    }
}
