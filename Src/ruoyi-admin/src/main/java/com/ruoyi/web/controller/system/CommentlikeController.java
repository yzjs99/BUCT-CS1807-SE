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
import com.ruoyi.system.domain.Commentlike;
import com.ruoyi.system.service.ICommentlikeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论点赞Controller
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
@RestController
@RequestMapping("/system/commentlike")
public class CommentlikeController extends BaseController
{
    @Autowired
    private ICommentlikeService commentlikeService;

    /**
     * 查询评论点赞列表
     */
    //@PreAuthorize("@ss.hasPermi('system:commentlike:list')")
    @GetMapping("/list")
    public TableDataInfo list(Commentlike commentlike)
    {
        startPage();
        List<Commentlike> list = commentlikeService.selectCommentlikeList(commentlike);
        return getDataTable(list);
    }

    /**
     * 导出评论点赞列表
     */
    //@PreAuthorize("@ss.hasPermi('system:commentlike:export')")
    @Log(title = "评论点赞", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Commentlike commentlike)
    {
        List<Commentlike> list = commentlikeService.selectCommentlikeList(commentlike);
        ExcelUtil<Commentlike> util = new ExcelUtil<Commentlike>(Commentlike.class);
        return util.exportExcel(list, "评论点赞数据");
    }

    /**
     * 获取评论点赞详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:commentlike:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(commentlikeService.selectCommentlikeById(id));
    }

    @GetMapping(value = "/select/all/{commentid}")
    public TableDataInfo list_1(@PathVariable("commentid") Long commentid)
    {
        List<Commentlike> list = commentlikeService.selectCommentlikeByCommentid(commentid);
        return getDataTable(list);
    }
    /**
     * 新增评论点赞
     */
    //@PreAuthorize("@ss.hasPermi('system:commentlike:add')")
    @Log(title = "评论点赞", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Commentlike commentlike)
    {
        return toAjax(commentlikeService.insertCommentlike(commentlike));
    }

    /**
     * 修改评论点赞
     */
    //@PreAuthorize("@ss.hasPermi('system:commentlike:edit')")
    @Log(title = "评论点赞", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Commentlike commentlike)
    {
        return toAjax(commentlikeService.updateCommentlike(commentlike));
    }

    /**
     * 删除评论点赞
     */
    //@PreAuthorize("@ss.hasPermi('system:commentlike:remove')")
    @Log(title = "评论点赞", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(commentlikeService.deleteCommentlikeByIds(ids));
    }
}
