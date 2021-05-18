package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CommentsMapper;
import com.ruoyi.system.domain.Comments;
import com.ruoyi.system.service.ICommentsService;

/**
 * 评论Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
@Service
public class CommentsServiceImpl implements ICommentsService 
{
    @Autowired
    private CommentsMapper commentsMapper;

    /**
     * 查询评论
     * 
     * @param id 评论ID
     * @return 评论
     */
    @Override
    public Comments selectCommentsById(Long id)
    {
        return commentsMapper.selectCommentsById(id);
    }

    @Override
    public List<Comments> selectCommentsByMumid(Long mumid)
    {
        return commentsMapper.selectCommentsByMumid(mumid);
    }
    /**
     * 查询评论列表
     * 
     * @param comments 评论
     * @return 评论
     */
    @Override
    public List<Comments> selectCommentsList(Comments comments)
    {
        return commentsMapper.selectCommentsList(comments);
    }

    /**
     * 新增评论
     * 
     * @param comments 评论
     * @return 结果
     */
    @Override
    public int insertComments(Comments comments)
    {
        return commentsMapper.insertComments(comments);
    }

    /**
     * 修改评论
     * 
     * @param comments 评论
     * @return 结果
     */
    @Override
    public int updateComments(Comments comments)
    {
        return commentsMapper.updateComments(comments);
    }

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的评论ID
     * @return 结果
     */
    @Override
    public int deleteCommentsByIds(Long[] ids)
    {
        return commentsMapper.deleteCommentsByIds(ids);
    }

    /**
     * 删除评论信息
     * 
     * @param id 评论ID
     * @return 结果
     */
    @Override
    public int deleteCommentsById(Long id)
    {
        return commentsMapper.deleteCommentsById(id);
    }
}
