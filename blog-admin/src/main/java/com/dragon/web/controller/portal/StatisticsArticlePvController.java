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
import com.dragon.portal.domain.StatisticsArticlePv;
import com.dragon.portal.service.IStatisticsArticlePvService;
import com.dragon.common.utils.poi.ExcelUtil;
import com.dragon.common.core.page.TableDataInfo;

/**
 * 统计 - 文章 PV (浏览量)Controller
 * 
 * @author dragon
 * @date 2024-07-20
 */
@RestController
@RequestMapping("/portal/statisticsArticlePv")
public class StatisticsArticlePvController extends BaseController {
    @Autowired
    private IStatisticsArticlePvService statisticsArticlePvService;

    /**
     * 查询统计 - 文章 PV (浏览量)列表
     */
    @PreAuthorize("@ss.hasPermi('portal:statisticsArticlePv:list')")
    @GetMapping("/list")
    public TableDataInfo list(StatisticsArticlePv statisticsArticlePv) {
        startPage();
        List<StatisticsArticlePv> list = statisticsArticlePvService.selectStatisticsArticlePvList(statisticsArticlePv);
        return getDataTable(list);
    }

    /**
     * 导出统计 - 文章 PV (浏览量)列表
     */
    @PreAuthorize("@ss.hasPermi('portal:statisticsArticlePv:export')")
    @Log(title = "统计 - 文章 PV (浏览量)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StatisticsArticlePv statisticsArticlePv) {
        List<StatisticsArticlePv> list = statisticsArticlePvService.selectStatisticsArticlePvList(statisticsArticlePv);
        ExcelUtil<StatisticsArticlePv> util = new ExcelUtil<StatisticsArticlePv>(StatisticsArticlePv.class);
        util.exportExcel(response, list, "统计 - 文章 PV (浏览量)数据");
    }

    /**
     * 获取统计 - 文章 PV (浏览量)详细信息
     */
    @PreAuthorize("@ss.hasPermi('portal:statisticsArticlePv:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(statisticsArticlePvService.selectStatisticsArticlePvById(id));
    }

    /**
     * 新增统计 - 文章 PV (浏览量)
     */
    @PreAuthorize("@ss.hasPermi('portal:statisticsArticlePv:add')")
    @Log(title = "统计 - 文章 PV (浏览量)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StatisticsArticlePv statisticsArticlePv) {
        return toAjax(statisticsArticlePvService.insertStatisticsArticlePv(statisticsArticlePv));
    }

    /**
     * 修改统计 - 文章 PV (浏览量)
     */
    @PreAuthorize("@ss.hasPermi('portal:statisticsArticlePv:edit')")
    @Log(title = "统计 - 文章 PV (浏览量)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StatisticsArticlePv statisticsArticlePv) {
        return toAjax(statisticsArticlePvService.updateStatisticsArticlePv(statisticsArticlePv));
    }

    /**
     * 删除统计 - 文章 PV (浏览量)
     */
    @PreAuthorize("@ss.hasPermi('portal:statisticsArticlePv:remove')")
    @Log(title = "统计 - 文章 PV (浏览量)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(statisticsArticlePvService.deleteStatisticsArticlePvByIds(ids));
    }
}
