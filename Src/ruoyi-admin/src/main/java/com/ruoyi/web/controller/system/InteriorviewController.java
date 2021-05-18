package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Interiorview;
import com.ruoyi.system.service.IInteriorviewService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 内景图Controller
 * 
 * @author ruoyi
 * @date 2021-05-18
 */
@RestController
@RequestMapping("/system/interiorview")
public class InteriorviewController extends BaseController
{
    @Autowired
    private IInteriorviewService interiorviewService;

    /**
     * 查询内景图列表
     */
    //@PreAuthorize("@ss.hasPermi('system:interiorview:list')")
    @GetMapping("/list")
    public TableDataInfo list(Interiorview interiorview)
    {
        startPage();
        List<Interiorview> list = interiorviewService.selectInteriorviewList(interiorview);
        return getDataTable(list);
    }

    /**
     * 导出内景图列表
     */
    //@PreAuthorize("@ss.hasPermi('system:interiorview:export')")
    @Log(title = "内景图", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Interiorview interiorview)
    {
        List<Interiorview> list = interiorviewService.selectInteriorviewList(interiorview);
        ExcelUtil<Interiorview> util = new ExcelUtil<Interiorview>(Interiorview.class);
        return util.exportExcel(list, "内景图数据");
    }

    /**
     * 获取内景图详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:interiorview:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(interiorviewService.selectInteriorviewById(id));
    }

    /**
     * 新增内景图
     */
    //@PreAuthorize("@ss.hasPermi('system:interiorview:add')")
    @Log(title = "内景图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Interiorview interiorview)
    {
        return toAjax(interiorviewService.insertInteriorview(interiorview));
    }

    /**
     * 修改内景图
     */
    //@PreAuthorize("@ss.hasPermi('system:interiorview:edit')")
    @Log(title = "内景图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Interiorview interiorview)
    {
        return toAjax(interiorviewService.updateInteriorview(interiorview));
    }

    /**
     * 删除内景图
     */
    //@PreAuthorize("@ss.hasPermi('system:interiorview:remove')")
    @Log(title = "内景图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(interiorviewService.deleteInteriorviewByIds(ids));
    }
    @GetMapping("/select/all/{MuseumId}")
    public TableDataInfo list_2(@PathVariable("MuseumId") Long MuseumId)
    {
        List<Interiorview> list = interiorviewService.selectInteriorviewByMuseumId(MuseumId);
        return getDataTable(list);
    }

}
