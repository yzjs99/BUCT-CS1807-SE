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
import com.ruoyi.system.domain.Comments;
import com.ruoyi.system.service.ICommentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论Controller
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
@RestController
@RequestMapping("/system/comments")
public class CommentsController extends BaseController
{
    @Autowired
    private ICommentsService commentsService;

    /**
     * 查询评论列表
     */
    //@PreAuthorize("@ss.hasPermi('system:comments:list')")
    @GetMapping("/list")
    public TableDataInfo list(Comments comments)
    {
        startPage();
        List<Comments> list = commentsService.selectCommentsList(comments);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    //@PreAuthorize("@ss.hasPermi('system:comments:export')")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Comments comments)
    {
        List<Comments> list = commentsService.selectCommentsList(comments);
        ExcelUtil<Comments> util = new ExcelUtil<Comments>(Comments.class);
        return util.exportExcel(list, "评论数据");
    }

    /**
     * 获取评论详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:comments:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(commentsService.selectCommentsById(id));
    }

    //@PreAuthorize("@ss.hasPermi('system:comments:query')")
    @GetMapping(value = "/select/all/{mumid}")
    public TableDataInfo list2(@PathVariable("mumid") Long mumid)
    {
        List<Comments> list =commentsService.selectCommentsByMumid(mumid);
        return getDataTable(list);
    }

    /**
     * 新增评论
     */
    @PreAuthorize("@ss.hasPermi('system:comments:add')")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Comments comments)
    {
        return toAjax(commentsService.insertComments(comments));
    }

    /**
     * 修改评论
     */
    //@PreAuthorize("@ss.hasPermi('system:comments:edit')")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Comments comments)
    {
        return toAjax(commentsService.updateComments(comments));
    }

    /**
     * 删除评论
     */
    //@PreAuthorize("@ss.hasPermi('system:comments:remove')")
    @Log(title = "评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(commentsService.deleteCommentsByIds(ids));
    }
}
