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
import com.ruoyi.system.domain.Museumcollection;
import com.ruoyi.system.service.IMuseumcollectionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博物馆收藏Controller
 * 
 * @author ruoyi
 * @date 2021-05-02
 */
@RestController
@RequestMapping("/system/museumcollection")
public class MuseumcollectionController extends BaseController
{
    @Autowired
    private IMuseumcollectionService museumcollectionService;

    /**
     * 查询博物馆收藏列表
     */
    //@PreAuthorize("@ss.hasPermi('system:museumcollection:list')")
    @GetMapping("/list")
    public TableDataInfo list(Museumcollection museumcollection)
    {
        startPage();
        List<Museumcollection> list = museumcollectionService.selectMuseumcollectionList(museumcollection);
        return getDataTable(list);
    }

    /**
     * 导出博物馆收藏列表
     */
    //@PreAuthorize("@ss.hasPermi('system:museumcollection:export')")
    @Log(title = "博物馆收藏", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Museumcollection museumcollection)
    {
        List<Museumcollection> list = museumcollectionService.selectMuseumcollectionList(museumcollection);
        ExcelUtil<Museumcollection> util = new ExcelUtil<Museumcollection>(Museumcollection.class);
        return util.exportExcel(list, "博物馆收藏数据");
    }

    /**
     * 获取博物馆收藏详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:museumcollection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(museumcollectionService.selectMuseumcollectionById(id));
    }
    //@PreAuthorize("@ss.hasPermi('system:museumcollection:query')")
    @GetMapping(value = "select/all/{userid}")
    public TableDataInfo list3(@PathVariable("userid") Long userid)
    {
        List<Museumcollection> list = museumcollectionService.selectMuseumcollectionByUserid(userid);
        return getDataTable(list);
    }
    /**
     * 新增博物馆收藏
     */
    //@PreAuthorize("@ss.hasPermi('system:museumcollection:add')")
    @Log(title = "博物馆收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Museumcollection museumcollection)
    {
        return toAjax(museumcollectionService.insertMuseumcollection(museumcollection));
    }

    /**
     * 修改博物馆收藏
     */
    //@PreAuthorize("@ss.hasPermi('system:museumcollection:edit')")
    @Log(title = "博物馆收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Museumcollection museumcollection)
    {
        return toAjax(museumcollectionService.updateMuseumcollection(museumcollection));
    }

    /**
     * 删除博物馆收藏
     */
    //@PreAuthorize("@ss.hasPermi('system:museumcollection:remove')")
    @Log(title = "博物馆收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(museumcollectionService.deleteMuseumcollectionByIds(ids));
    }
}
