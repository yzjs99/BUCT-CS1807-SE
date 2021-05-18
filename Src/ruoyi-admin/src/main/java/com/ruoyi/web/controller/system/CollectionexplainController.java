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
import com.ruoyi.system.domain.Collectionexplain;
import com.ruoyi.system.service.ICollectionexplainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 收藏品讲解Controller
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
@RestController
@RequestMapping("/system/collectionexplain")
public class CollectionexplainController extends BaseController
{
    @Autowired
    private ICollectionexplainService collectionexplainService;

    /**
     * 查询收藏品讲解列表
     */
    //@PreAuthorize("@ss.hasPermi('system:collectionexplain:list')")
    @GetMapping("/list")
    public TableDataInfo list(Collectionexplain collectionexplain)
    {
        startPage();
        List<Collectionexplain> list = collectionexplainService.selectCollectionexplainList(collectionexplain);
        return getDataTable(list);
    }

    /**
     * 导出收藏品讲解列表
     */
    //@PreAuthorize("@ss.hasPermi('system:collectionexplain:export')")
    @Log(title = "收藏品讲解", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Collectionexplain collectionexplain)
    {
        List<Collectionexplain> list = collectionexplainService.selectCollectionexplainList(collectionexplain);
        ExcelUtil<Collectionexplain> util = new ExcelUtil<Collectionexplain>(Collectionexplain.class);
        return util.exportExcel(list, "收藏品讲解数据");
    }

    /**
     * 获取收藏品讲解详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:collectionexplain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(collectionexplainService.selectCollectionexplainById(id));
    }

    /**
     * 新增收藏品讲解
     */
    @PreAuthorize("@ss.hasPermi('system:collectionexplain:add')")
    @Log(title = "收藏品讲解", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Collectionexplain collectionexplain)
    {
        return toAjax(collectionexplainService.insertCollectionexplain(collectionexplain));
    }

    /**
     * 修改收藏品讲解
     */
    @PreAuthorize("@ss.hasPermi('system:collectionexplain:edit')")
    @Log(title = "收藏品讲解", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Collectionexplain collectionexplain)
    {
        return toAjax(collectionexplainService.updateCollectionexplain(collectionexplain));
    }

    /**
     * 删除收藏品讲解
     */
    //@PreAuthorize("@ss.hasPermi('system:collectionexplain:remove')")
    @Log(title = "收藏品讲解", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(collectionexplainService.deleteCollectionexplainByIds(ids));
    }

    @GetMapping("/select/collectionid/{collectionid}")
    public TableDataInfo list1(@PathVariable("collectionid") Long collectionid)
    {
        List<Collectionexplain> list = collectionexplainService.selectCollectionexplainBycollectionid(collectionid);
        return getDataTable(list);
    }

    @GetMapping("/select/createid/{createid}")
    public TableDataInfo list2(@PathVariable("createid") Long createid)
    {
        List<Collectionexplain> list = collectionexplainService.selectCollectionexplainBycreateid(createid);
        return getDataTable(list);
    }
    @GetMapping("/select/pic/{id}")
    public void list3(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        response.addHeader("Accept-Ranges", "bytes");
        response.addHeader("Content-Type", "image/jpg");
        ServletOutputStream stream = response.getOutputStream();
        ImageVO temp=collectionexplainService.selectCollectionexplainPicById(id);
        stream.write(temp.getImage());
        stream.flush();
        stream.close();
    }

    @GetMapping("/select/voice/{id}")
    public void list4(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        response.addHeader("Accept-Ranges", "bytes");
        response.addHeader("Content-Type", "audio/mp3");
        ServletOutputStream stream = response.getOutputStream();
        VoiceVO temp=collectionexplainService.selectCollectionexplainVoiceById(id);
        stream.write(temp.getVoice());
        stream.flush();
        stream.close();
    }

    @PostMapping("/put/pic/{id}")
    public int list5(@PathVariable("id") Long id, HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        ImageVO temp =new ImageVO(id,data);
        collectionexplainService.updateCollectionexplainImageById(temp);
        return 1;
    }
    @PostMapping("/put/voice/{id}")
    public int list6(@PathVariable("id") Long id, HttpServletRequest request, @RequestParam("voice") MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        VoiceVO temp =new VoiceVO(id,data);
        collectionexplainService.updateCollectionexplainVoiceById(temp);
        return 1;
    }
    @GetMapping("/select/id/{createid}")
    public TableDataInfo list7(@PathVariable("createid") Long createid)
    {
        List<Collectionexplain> list = collectionexplainService.selectCollectionexplainidBycreateid(createid);
        return getDataTable(list);
    }
}
