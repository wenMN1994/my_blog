package com.dragon.web.controller.portal;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.dragon.portal.domain.PortalComment;
import com.dragon.portal.service.IPortalCommentService;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 评论管理Controller
 *
 * @author dragon
 * @date 2024-06-29
 */
@RestController
@RequestMapping("/portal/comment")
public class PortalCommentController extends BaseController {
    @Autowired
    private IPortalCommentService portalCommentService;

    /**
     * 查询评论管理列表
     */
    @PreAuthorize("@ss.hasPermi('portal:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(PortalComment portalComment) {
        startPage();
        List<PortalComment> list = portalCommentService.selectPortalCommentList(portalComment);
        return getDataTable(list);
    }

    /**
     * 导出评论管理列表
     */
    @PreAuthorize("@ss.hasPermi('portal:comment:export')")
    @Log(title = "评论管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PortalComment portalComment) {
        List<PortalComment> list = portalCommentService.selectPortalCommentList(portalComment);
        ExcelUtil<PortalComment> util = new ExcelUtil<PortalComment>(PortalComment.class);
        util.exportExcel(response, list, "评论管理数据");
    }

    /**
     * 获取评论管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('portal:comment:query')")
    @GetMapping(value = "/{commentId}")
    public AjaxResult getInfo(@PathVariable("commentId") Long commentId) {
        return success(portalCommentService.selectPortalCommentBycommentId(commentId));
    }

    /**
     * 新增评论管理
     */
    @PreAuthorize("@ss.hasPermi('portal:comment:add')")
    @Log(title = "评论管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PortalComment portalComment) {
        return toAjax(portalCommentService.insertPortalComment(portalComment));
    }

    /**
     * 审核评论管理
     */
    @PreAuthorize("@ss.hasPermi('portal:comment:audit')")
    @Log(title = "评论管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult audit(@RequestBody PortalComment portalComment) {
        return toAjax(portalCommentService.updatePortalComment(portalComment));
    }

    /**
     * 删除评论管理
     */
    @PreAuthorize("@ss.hasPermi('portal:comment:remove')")
    @Log(title = "评论管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{commentId}")
    public AjaxResult remove(@PathVariable Long commentId) {
        return toAjax(portalCommentService.deletePortalCommentByCommentId(commentId));
    }
}