package com.dragon.web.controller.portal;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dragon.common.core.domain.model.LoginUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dragon.common.annotation.Log;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.enums.BusinessType;
import com.dragon.portal.domain.Slideshow;
import com.dragon.portal.service.ISlideshowService;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 轮播图管理Controller
 *
 * @author dragon
 * @date 2022-08-20
 */
@RestController
@RequestMapping("/portal/slideshow")
public class SlideshowController extends BaseController {
    @Autowired
    private ISlideshowService slideshowService;

    /**
     * 查询轮播图管理列表
     */
    @PreAuthorize("@ss.hasPermi('portal:slideshow:list')")
    @GetMapping("/list")
    public TableDataInfo list(Slideshow slideshow) {
        startPage();
        List<Slideshow> list = slideshowService.selectSlideshowList(slideshow);
        return getDataTable(list);
    }

    /**
     * 导出轮播图管理列表
     */
    @PreAuthorize("@ss.hasPermi('portal:slideshow:export')")
    @Log(title = "轮播图管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Slideshow slideshow) {
        List<Slideshow> list = slideshowService.selectSlideshowList(slideshow);
        ExcelUtil<Slideshow> util = new ExcelUtil<Slideshow>(Slideshow.class);
        util.exportExcel(response, list, "轮播图管理数据");
    }

    /**
     * 获取轮播图管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('portal:slideshow:query')")
    @GetMapping(value = "/{slideshowId}")
    public AjaxResult getInfo(@PathVariable("slideshowId") Long slideshowId) {
        return AjaxResult.success(slideshowService.selectSlideshowBySlideshowId(slideshowId));
    }

    /**
     * 新增轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('portal:slideshow:add')")
    @Log(title = "轮播图管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Slideshow slideshow) {
        LoginUser loginUser = getLoginUser();
        return toAjax(slideshowService.insertSlideshow(slideshow, loginUser));
    }

    /**
     * 修改轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('portal:slideshow:edit')")
    @Log(title = "轮播图管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Slideshow slideshow) {
        LoginUser loginUser = getLoginUser();
        return toAjax(slideshowService.updateSlideshow(slideshow, loginUser));
    }

    /**
     * 删除轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('portal:slideshow:remove')")
    @Log(title = "轮播图管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{slideshowIds}")
    public AjaxResult remove(@PathVariable Long[] slideshowIds) {
        LoginUser loginUser = getLoginUser();
        return toAjax(slideshowService.deleteSlideshowBySlideshowIds(slideshowIds, loginUser));
    }
}
