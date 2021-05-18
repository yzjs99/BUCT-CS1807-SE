package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Comments;

/**
 * 评论Service接口
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
public interface ICommentsService 
{
    /**
     * 查询评论
     * 
     * @param id 评论ID
     * @return 评论
     */
    public Comments selectCommentsById(Long id);
    public List<Comments> selectCommentsByMumid(Long mumid);
    /**
     * 查询评论列表
     * 
     * @param comments 评论
     * @return 评论集合
     */
    public List<Comments> selectCommentsList(Comments comments);

    /**
     * 新增评论
     * 
     * @param comments 评论
     * @return 结果
     */
    public int insertComments(Comments comments);

    /**
     * 修改评论
     * 
     * @param comments 评论
     * @return 结果
     */
    public int updateComments(Comments comments);

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的评论ID
     * @return 结果
     */
    public int deleteCommentsByIds(Long[] ids);

    /**
     * 删除评论信息
     * 
     * @param id 评论ID
     * @return 结果
     */
    public int deleteCommentsById(Long id);
}
