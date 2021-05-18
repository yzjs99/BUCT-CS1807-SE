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
import com.ruoyi.system.domain.Exhibitcollection;
import com.ruoyi.system.service.IExhibitcollectionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 展览——藏品Controller
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@RestController
@RequestMapping("/system/exhibitcollection")
public class ExhibitcollectionController extends BaseController
{
    @Autowired
    private IExhibitcollectionService exhibitcollectionService;

    /**
     * 查询展览——藏品列表
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitcollection:list')")
    @GetMapping("/list")
    public TableDataInfo list(Exhibitcollection exhibitcollection)
    {
        startPage();
        List<Exhibitcollection> list = exhibitcollectionService.selectExhibitcollectionList(exhibitcollection);
        return getDataTable(list);
    }

    /**
     * 导出展览——藏品列表
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitcollection:export')")
    @Log(title = "展览——藏品", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Exhibitcollection exhibitcollection)
    {
        List<Exhibitcollection> list = exhibitcollectionService.selectExhibitcollectionList(exhibitcollection);
        ExcelUtil<Exhibitcollection> util = new ExcelUtil<Exhibitcollection>(Exhibitcollection.class);
        return util.exportExcel(list, "展览——藏品数据");
    }

    /**
     * 获取展览——藏品详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitcollection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(exhibitcollectionService.selectExhibitcollectionById(id));
    }

    /**
     * 新增展览——藏品
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitcollection:add')")
    @Log(title = "展览——藏品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Exhibitcollection exhibitcollection)
    {
        return toAjax(exhibitcollectionService.insertExhibitcollection(exhibitcollection));
    }

    /**
     * 修改展览——藏品
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitcollection:edit')")
    @Log(title = "展览——藏品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Exhibitcollection exhibitcollection)
    {
        return toAjax(exhibitcollectionService.updateExhibitcollection(exhibitcollection));
    }

    /**
     * 删除展览——藏品
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitcollection:remove')")
    @Log(title = "展览——藏品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(exhibitcollectionService.deleteExhibitcollectionByIds(ids));
    }
    @GetMapping(value = "select/all/{Museumid}")
    public TableDataInfo list1(@PathVariable("Museumid") Long Museumid)
    {
        List<Exhibitcollection> list = exhibitcollectionService.selectExhibitcollectionByMuseumid(Museumid);
        return getDataTable(list);
    }
}
