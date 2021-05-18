package com.ruoyi.web.controller.system;

import java.util.List;
import java.io.*;

import com.ruoyi.system.domain.vo.ImageVO;
import com.ruoyi.system.domain.vo.VoiceVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Exhibitexplain;
import com.ruoyi.system.service.IExhibitexplainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 展览讲解Controller
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
@RestController
@RequestMapping("/system/exhibitexplain")
public class ExhibitexplainController extends BaseController
{
    @Autowired
    private IExhibitexplainService exhibitexplainService;

    /**
     * 查询展览讲解列表
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitexplain:list')")
    @GetMapping("/list")
    public TableDataInfo list(Exhibitexplain exhibitexplain)
    {
        startPage();
        List<Exhibitexplain> list = exhibitexplainService.selectExhibitexplainList(exhibitexplain);
        return getDataTable(list);
    }

    /**
     * 导出展览讲解列表
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitexplain:export')")
    @Log(title = "展览讲解", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Exhibitexplain exhibitexplain)
    {
        List<Exhibitexplain> list = exhibitexplainService.selectExhibitexplainList(exhibitexplain);
        ExcelUtil<Exhibitexplain> util = new ExcelUtil<Exhibitexplain>(Exhibitexplain.class);
        return util.exportExcel(list, "展览讲解数据");
    }

    /**
     * 获取展览讲解详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitexplain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(exhibitexplainService.selectExhibitexplainById(id));
    }

    /**
     * 新增展览讲解
     */
    @PreAuthorize("@ss.hasPermi('system:exhibitexplain:add')")
    @Log(title = "展览讲解", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Exhibitexplain exhibitexplain)
    {
        return toAjax(exhibitexplainService.insertExhibitexplain(exhibitexplain));
    }

    /**
     * 修改展览讲解
     */
    @PreAuthorize("@ss.hasPermi('system:exhibitexplain:edit')")
    @Log(title = "展览讲解", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Exhibitexplain exhibitexplain)
    {
        return toAjax(exhibitexplainService.updateExhibitexplain(exhibitexplain));
    }

    /**
     * 删除展览讲解
     */
    //@PreAuthorize("@ss.hasPermi('system:exhibitexplain:remove')")
    @Log(title = "展览讲解", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(exhibitexplainService.deleteExhibitexplainByIds(ids));
    }

    @GetMapping("/select/exhibitid/{exhibitid}")
    public TableDataInfo list1(@PathVariable("exhibitid") Long exhibitid)
    {
        List<Exhibitexplain> list = exhibitexplainService.selectExhibitexplainByexhibitid(exhibitid);
        return getDataTable(list);
    }

    @GetMapping("/select/createid/{createid}")
    public TableDataInfo list2(@PathVariable("createid") Long createid)
    {
        List<Exhibitexplain> list = exhibitexplainService.selectExhibitexplainBycreateid(createid);
        return getDataTable(list);
    }
    @GetMapping("/select/pic/{id}")
    public void list3(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        response.addHeader("Accept-Ranges", "bytes");
        response.addHeader("Content-Type", "image/jpg");
        ServletOutputStream stream = response.getOutputStream();
        ImageVO temp=exhibitexplainService.selectExhibitexplainPicById(id);
        stream.write(temp.getImage());
        stream.flush();
        stream.close();
//        return temp;
    }

    @GetMapping("/select/voice/{id}")
    public void list4(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        response.addHeader("Accept-Ranges", "bytes");
        response.addHeader("Content-Type", "video/mpeg4");
        ServletOutputStream stream = response.getOutputStream();
        VoiceVO temp=exhibitexplainService.selectExhibitexplainVoiceById(id);
        stream.write(temp.getVoice());
        stream.flush();
        stream.close();
    }

    @PostMapping("/put/pic/{id}")
    public int list5(@PathVariable("id") Long id, HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        ImageVO temp =new ImageVO(id,data);
        exhibitexplainService.updateExhibitexplainImageById(temp);
        return 1;
    }
    @PostMapping("/put/voice/{id}")
    public int list6(@PathVariable("id") Long id, HttpServletRequest request, @RequestParam("voice") MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        VoiceVO temp =new VoiceVO(id,data);
        exhibitexplainService.updateExhibitexplainVoiceById(temp);
        return 1;
    }
    @GetMapping("/select/id/{createid}")
    public TableDataInfo list7(@PathVariable("createid") Long createid)
    {
        List<Exhibitexplain> list = exhibitexplainService.selectExhibitexplainidBycreateid(createid);
        return getDataTable(list);
    }
}
