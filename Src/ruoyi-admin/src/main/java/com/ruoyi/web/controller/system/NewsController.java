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
import com.ruoyi.system.domain.News;
import com.ruoyi.system.service.INewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻分析Controller
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
@RestController
@RequestMapping("/system/news")
public class NewsController extends BaseController
{
    @Autowired
    private INewsService newsService;

    /**
     * 查询新闻分析列表
     */
    //@PreAuthorize("@ss.hasPermi('system:news:list')")
    @GetMapping("/list")
    public TableDataInfo list(News news)
    {
        startPage();
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }

    /**
     * 导出新闻分析列表
     */
    //@PreAuthorize("@ss.hasPermi('system:news:export')")
    @Log(title = "新闻分析", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(News news)
    {
        List<News> list = newsService.selectNewsList(news);
        ExcelUtil<News> util = new ExcelUtil<News>(News.class);
        return util.exportExcel(list, "新闻分析数据");
    }

    /**
     * 获取新闻分析详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:news:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(newsService.selectNewsById(id));
    }

    /**
     * 获取新闻分析详细信息 博物馆名字查找
     */
    //@PreAuthorize("@ss.hasPermi('system:news:query')")
    @GetMapping(value = "/select/all/{mumname}")
    public TableDataInfo getInfobyname(@PathVariable("mumname") String mumname)
    {
        List<News> list = newsService.selectNewsByMumname(mumname);
        return getDataTable(list);
    }
    @GetMapping(value = "/select2/all/{mumname}")
    public TableDataInfo getInfobyname2(@PathVariable("mumname") String mumname)
    {
        List<News> list = newsService.selectNewsByMumname2(mumname);
        return getDataTable(list);
    }

    /**
     * 新增新闻分析
     */
    //@PreAuthorize("@ss.hasPermi('system:news:add')")
    @Log(title = "新闻分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody News news)
    {
        return toAjax(newsService.insertNews(news));
    }

    /**
     * 修改新闻分析
     */
    //@PreAuthorize("@ss.hasPermi('system:news:edit')")
    @Log(title = "新闻分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody News news)
    {
        return toAjax(newsService.updateNews(news));
    }

    /**
     * 删除新闻分析
     */
    //@PreAuthorize("@ss.hasPermi('system:news:remove')")
    @Log(title = "新闻分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(newsService.deleteNewsByIds(ids));
    }
}
