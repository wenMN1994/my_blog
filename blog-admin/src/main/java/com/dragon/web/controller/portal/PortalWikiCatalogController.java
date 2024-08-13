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
import com.dragon.portal.domain.PortalWikiCatalog;
import com.dragon.portal.service.IPortalWikiCatalogService;
import com.dragon.common.utils.poi.ExcelUtil;

/**
 * 知识库目录Controller
 *
 * @author dragon
 * @date 2024-07-21
 */
@RestController
@RequestMapping("/portal/wikiCatalog")
public class PortalWikiCatalogController extends BaseController {
    @Autowired
    private IPortalWikiCatalogService portalWikiCatalogService;

    /**
     * 查询知识库目录列表
     */
    @PreAuthorize("@ss.hasPermi('portal:wikiCatalog:list')")
    @GetMapping("/list")
    public AjaxResult list(PortalWikiCatalog portalWikiCatalog) {
        List<PortalWikiCatalog> list = portalWikiCatalogService.selectPortalWikiCatalogList(portalWikiCatalog);
        return success(list);
    }

    /**
     * 导出知识库目录列表
     */
    @PreAuthorize("@ss.hasPermi('portal:wikiCatalog:export')")
    @Log(title = "知识库目录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PortalWikiCatalog portalWikiCatalog) {
        List<PortalWikiCatalog> list = portalWikiCatalogService.selectPortalWikiCatalogList(portalWikiCatalog);
        ExcelUtil<PortalWikiCatalog> util = new ExcelUtil<PortalWikiCatalog>(PortalWikiCatalog.class);
        util.exportExcel(response, list, "知识库目录数据");
    }

    /**
     * 获取知识库目录详细信息
     */
    @PreAuthorize("@ss.hasPermi('portal:wikiCatalog:query')")
    @GetMapping(value = "/{wikiCatalogId}")
    public AjaxResult getInfo(@PathVariable("wikiCatalogId") Long wikiCatalogId) {
        return success(portalWikiCatalogService.selectPortalWikiCatalogByWikiCatalogId(wikiCatalogId));
    }

    /**
     * 新增知识库目录
     */
    @PreAuthorize("@ss.hasPermi('portal:wikiCatalog:add')")
    @Log(title = "知识库目录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PortalWikiCatalog portalWikiCatalog) {
        LoginUser loginUser = getLoginUser();
        return toAjax(portalWikiCatalogService.insertPortalWikiCatalog(portalWikiCatalog, loginUser));
    }

    /**
     * 修改知识库目录
     */
    @PreAuthorize("@ss.hasPermi('portal:wikiCatalog:edit')")
    @Log(title = "知识库目录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PortalWikiCatalog portalWikiCatalog) {
        LoginUser loginUser = getLoginUser();
        return toAjax(portalWikiCatalogService.updatePortalWikiCatalog(portalWikiCatalog, loginUser));
    }

    /**
     * 删除知识库目录
     */
    @PreAuthorize("@ss.hasPermi('portal:wikiCatalog:remove')")
    @Log(title = "知识库目录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{wikiCatalogIds}")
    public AjaxResult remove(@PathVariable Long[] wikiCatalogIds) {
        LoginUser loginUser = getLoginUser();
        return toAjax(portalWikiCatalogService.deletePortalWikiCatalogByWikiCatalogIds(wikiCatalogIds, loginUser));
    }
}
