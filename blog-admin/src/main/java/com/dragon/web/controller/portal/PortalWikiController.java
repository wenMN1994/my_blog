package com.dragon.web.controller.portal;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dragon.common.core.domain.model.LoginUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dragon.common.annotation.Log;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.enums.BusinessType;
import com.dragon.portal.domain.PortalWiki;
import com.dragon.portal.service.IPortalWikiService;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 知识库Controller
 * 
 * @author dragon
 * @date 2024-07-20
 */
@RestController
@RequestMapping("/portal/wiki")
public class PortalWikiController extends BaseController {
    @Autowired
    private IPortalWikiService portalWikiService;

    /**
     * 查询知识库列表
     */
    @PreAuthorize("@ss.hasPermi('portal:wiki:list')")
    @GetMapping("/list")
    public TableDataInfo list(PortalWiki portalWiki) {
        startPage();
        List<PortalWiki> list = portalWikiService.selectPortalWikiList(portalWiki);
        return getDataTable(list);
    }

    /**
     * 导出知识库列表
     */
    @PreAuthorize("@ss.hasPermi('portal:wiki:export')")
    @Log(title = "知识库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PortalWiki portalWiki) {
        List<PortalWiki> list = portalWikiService.selectPortalWikiList(portalWiki);
        ExcelUtil<PortalWiki> util = new ExcelUtil<PortalWiki>(PortalWiki.class);
        util.exportExcel(response, list, "知识库数据");
    }

    /**
     * 获取知识库详细信息
     */
    @PreAuthorize("@ss.hasPermi('portal:wiki:query')")
    @GetMapping(value = "/{wikiId}")
    public AjaxResult getInfo(@PathVariable("wikiId") Long wikiId) {
        return success(portalWikiService.selectPortalWikiByWikiId(wikiId));
    }

    /**
     * 新增知识库
     */
    @PreAuthorize("@ss.hasPermi('portal:wiki:add')")
    @Log(title = "知识库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PortalWiki portalWiki) {
        LoginUser loginUser = getLoginUser();
        return toAjax(portalWikiService.insertPortalWiki(portalWiki, loginUser));
    }

    /**
     * 修改知识库
     */
    @PreAuthorize("@ss.hasPermi('portal:wiki:edit')")
    @Log(title = "知识库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PortalWiki portalWiki) {
        LoginUser loginUser = getLoginUser();
        return toAjax(portalWikiService.updatePortalWiki(portalWiki, loginUser));
    }

    /**
     * 删除知识库
     */
    @PreAuthorize("@ss.hasPermi('portal:wiki:remove')")
    @Log(title = "知识库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{wikiIds}")
    public AjaxResult remove(@PathVariable Long[] wikiIds) {
        LoginUser loginUser = getLoginUser();
        return toAjax(portalWikiService.deletePortalWikiByWikiIds(wikiIds, loginUser));
    }

    /**
     * 修改知识库置顶
     */
    @PreAuthorize("@ss.hasPermi('portal:wiki:edit')")
    @Log(title = "知识库", businessType = BusinessType.UPDATE)
    @GetMapping(value = "/isTop/update")
    public AjaxResult updateWikiIsTop(@RequestParam(name = "wikiId") Long wikiId, @RequestParam(name = "isTop") Boolean isTop) {
        LoginUser loginUser = getLoginUser();
        return toAjax(portalWikiService.updateWikiIsTop(wikiId, isTop, loginUser));
    }

    /**
     * 修改知识库发布状态
     */
    @PreAuthorize("@ss.hasPermi('portal:wiki:edit')")
    @Log(title = "知识库", businessType = BusinessType.UPDATE)
    @GetMapping(value = "/isPublish/update")
    public AjaxResult updateWikiIsPublish(@RequestParam(name = "wikiId") Long wikiId, @RequestParam(name = "isPublish") Boolean isPublish) {
        LoginUser loginUser = getLoginUser();
        return toAjax(portalWikiService.updateWikiIsPublish(wikiId, isPublish, loginUser));
    }
}
