package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.Museum;
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
import com.ruoyi.system.domain.Museumrating;
import com.ruoyi.system.service.IMuseumratingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博物馆评分Controller
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
@RestController
@RequestMapping("/system/museumrating")
public class MuseumratingController extends BaseController
{
    @Autowired
    private IMuseumratingService museumratingService;

    /**
     * 查询博物馆评分列表
     */
    //@PreAuthorize("@ss.hasPermi('system:museumrating:list')")
    @GetMapping("/list")
    public TableDataInfo list(Museumrating museumrating)
    {
        startPage();
        List<Museumrating> list = museumratingService.selectMuseumratingList(museumrating);
        return getDataTable(list);
    }
    @GetMapping("/sortid")
    public TableDataInfo list2(Museumrating museumrating)
    {
        List<Museumrating> list = museumratingService.selectMuseumratingSortid(museumrating);
        return getDataTable(list);
    }

    /**
     * 导出博物馆评分列表
     */
    //@PreAuthorize("@ss.hasPermi('system:museumrating:export')")
    @Log(title = "博物馆评分", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Museumrating museumrating)
    {
        List<Museumrating> list = museumratingService.selectMuseumratingList(museumrating);
        ExcelUtil<Museumrating> util = new ExcelUtil<Museumrating>(Museumrating.class);
        return util.exportExcel(list, "博物馆评分数据");
    }

    /**
     * 获取博物馆评分详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:museumrating:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(museumratingService.selectMuseumratingById(id));
    }

    /**
     * 新增博物馆评分
     */
    //@PreAuthorize("@ss.hasPermi('system:museumrating:add')")
    @Log(title = "博物馆评分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Museumrating museumrating)
    {
        return toAjax(museumratingService.insertMuseumrating(museumrating));
    }

    /**
     * 修改博物馆评分
     */
    //@PreAuthorize("@ss.hasPermi('system:museumrating:edit')")
    @Log(title = "博物馆评分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Museumrating museumrating)
    {
        return toAjax(museumratingService.updateMuseumrating(museumrating));
    }

    /**
     * 删除博物馆评分
     */
    //@PreAuthorize("@ss.hasPermi('system:museumrating:remove')")
    @Log(title = "博物馆评分", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(museumratingService.deleteMuseumratingByIds(ids));
    }

}
