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
import com.ruoyi.system.domain.Museum;
import com.ruoyi.system.service.IMuseumService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博物馆信息Controller
 * 
 * @author ruoyi
 * @date 2021-05-10
 */
@RestController
@RequestMapping("/system/museum")
public class MuseumController extends BaseController
{
    @Autowired
    private IMuseumService museumService;

    /**
     * 查询博物馆信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:museum:list')")
    @GetMapping("/list")
    public TableDataInfo list(Museum museum)
    {
        startPage();
        List<Museum> list = museumService.selectMuseumList(museum);
        return getDataTable(list);
    }

    /**
     * 导出博物馆信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:museum:export')")
    @Log(title = "博物馆信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Museum museum)
    {
        List<Museum> list = museumService.selectMuseumList(museum);
        ExcelUtil<Museum> util = new ExcelUtil<Museum>(Museum.class);
        return util.exportExcel(list, "博物馆信息数据");
    }

    /**
     * 获取博物馆信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:museum:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(museumService.selectMuseumById(id));
    }
    @GetMapping(value = "select/all/{name}")
    public TableDataInfo list4(@PathVariable("name") String name)
    {
        List<Museum> list = museumService.selectMuseumByName(name);
        return getDataTable(list);
    }
    /**
     * 新增博物馆信息
     */
    //@PreAuthorize("@ss.hasPermi('system:museum:add')")
    @Log(title = "博物馆信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Museum museum)
    {
        return toAjax(museumService.insertMuseum(museum));
    }

    /**
     * 修改博物馆信息
     */
    //@PreAuthorize("@ss.hasPermi('system:museum:edit')")
    @Log(title = "博物馆信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Museum museum)
    {
        return toAjax(museumService.updateMuseum(museum));
    }

    /**
     * 删除博物馆信息
     */
    //@PreAuthorize("@ss.hasPermi('system:museum:remove')")
    @Log(title = "博物馆信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(museumService.deleteMuseumByIds(ids));
    }
}
