package com.ruoyi.web.controller.system;

import java.awt.image.BufferedImage;
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
import com.ruoyi.system.domain.Museumexplain;
import com.ruoyi.system.service.IMuseumexplainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 博物馆讲解Controller
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
@RestController
@RequestMapping("/system/museumexplain")
public class MuseumexplainController extends BaseController
{
    @Autowired
    private IMuseumexplainService museumexplainService;

    /**
     * 查询博物馆讲解列表
     */
    //@PreAuthorize("@ss.hasPermi('system:museumexplain:list')")
    @GetMapping("/list")
    public TableDataInfo list(Museumexplain museumexplain)
    {
        startPage();
        List<Museumexplain> list = museumexplainService.selectMuseumexplainList(museumexplain);
        return getDataTable(list);
    }

    /**
     * 导出博物馆讲解列表
     */
    //@PreAuthorize("@ss.hasPermi('system:museumexplain:export')")
    @Log(title = "博物馆讲解", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Museumexplain museumexplain)
    {
        List<Museumexplain> list = museumexplainService.selectMuseumexplainList(museumexplain);
        ExcelUtil<Museumexplain> util = new ExcelUtil<Museumexplain>(Museumexplain.class);
        return util.exportExcel(list, "博物馆讲解数据");
    }

    /**
     * 获取博物馆讲解详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:museumexplain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(museumexplainService.selectMuseumexplainById(id));
    }

    /**
     * 新增博物馆讲解
     */
    @PreAuthorize("@ss.hasPermi('system:museumexplain:add')")
    @Log(title = "博物馆讲解", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Museumexplain museumexplain)
    {
        return toAjax(museumexplainService.insertMuseumexplain(museumexplain));
    }

    /**
     * 修改博物馆讲解
     */
    @PreAuthorize("@ss.hasPermi('system:museumexplain:edit')")
    @Log(title = "博物馆讲解", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Museumexplain museumexplain)
    {
        return toAjax(museumexplainService.updateMuseumexplain(museumexplain));
    }

    /**
     * 删除博物馆讲解
     */
    //@PreAuthorize("@ss.hasPermi('system:museumexplain:remove')")
    @Log(title = "博物馆讲解", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(museumexplainService.deleteMuseumexplainByIds(ids));
    }


    @GetMapping("/select/museumid/{museumid}")
    public TableDataInfo list1(@PathVariable("museumid") Long museumid)
    {
        List<Museumexplain> list = museumexplainService.selectMuseumexplainBymuseumid(museumid);
        return getDataTable(list);
    }

    @GetMapping("/select/createid/{createid}")
    public TableDataInfo list2(@PathVariable("createid") Long createid)
    {
        List<Museumexplain> list = museumexplainService.selectMuseumexplainBycreateid(createid);
        return getDataTable(list);
    }

    @GetMapping("/select/pic/{id}")
    public void list3(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        response.addHeader("Accept-Ranges", "bytes");
        response.addHeader("Content-Type", "image/jpg");
        ServletOutputStream stream = response.getOutputStream();
        ImageVO temp=museumexplainService.selectMuseumexplainPicById(id);
        stream.write(temp.getImage());
        stream.flush();
        stream.close();
    }
    @GetMapping("/select/voice/{id}")
    public void list4(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        response.addHeader("Accept-Ranges", "bytes");
        response.addHeader("Content-Type", "audio/mp3");
        ServletOutputStream stream = response.getOutputStream();
        VoiceVO temp=museumexplainService.selectMuseumexplainVoiceById(id);
        stream.write(temp.getVoice());
        stream.flush();
        stream.close();
    }
    @PostMapping("/put/pic/{id}")
    public int list5(@PathVariable("id") Long id, HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        ImageVO temp =new ImageVO(id,data);
        museumexplainService.updateMuseumexplainImageById(temp);
        return 1;
    }
    @PostMapping("/put/voice/{id}")
    public int list6(@PathVariable("id") Long id, HttpServletRequest request, @RequestParam("voice") MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        VoiceVO temp =new VoiceVO(id,data);
        museumexplainService.updateMuseumexplainVoiceById(temp);
        return 1;
    }
    @GetMapping("/select/id/{createid}")
    public TableDataInfo list7(@PathVariable("createid") Long createid)
    {
        List<Museumexplain> list = museumexplainService.selectMuseumexplainidBycreateid(createid);
        return getDataTable(list);
    }
}
