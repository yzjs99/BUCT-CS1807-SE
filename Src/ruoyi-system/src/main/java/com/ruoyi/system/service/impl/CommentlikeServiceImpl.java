package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CommentlikeMapper;
import com.ruoyi.system.domain.Commentlike;
import com.ruoyi.system.service.ICommentlikeService;

/**
 * 评论点赞Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
@Service
public class CommentlikeServiceImpl implements ICommentlikeService 
{
    @Autowired
    private CommentlikeMapper commentlikeMapper;

    /**
     * 查询评论点赞
     * 
     * @param id 评论点赞ID
     * @return 评论点赞
     */
    @Override
    public Commentlike selectCommentlikeById(Long id)
    {
        return commentlikeMapper.selectCommentlikeById(id);
    }
    public List<Commentlike> selectCommentlikeByCommentid(Long commentid)
    {
        return commentlikeMapper.selectCommentlikeByCommentid(commentid);
    }
    /**
     * 查询评论点赞列表
     * 
     * @param commentlike 评论点赞
     * @return 评论点赞
     */
    @Override
    public List<Commentlike> selectCommentlikeList(Commentlike commentlike)
    {
        return commentlikeMapper.selectCommentlikeList(commentlike);
    }

    /**
     * 新增评论点赞
     * 
     * @param commentlike 评论点赞
     * @return 结果
     */
    @Override
    public int insertCommentlike(Commentlike commentlike)
    {
        return commentlikeMapper.insertCommentlike(commentlike);
    }

    /**
     * 修改评论点赞
     * 
     * @param commentlike 评论点赞
     * @return 结果
     */
    @Override
    public int updateCommentlike(Commentlike commentlike)
    {
        return commentlikeMapper.updateCommentlike(commentlike);
    }

    /**
     * 批量删除评论点赞
     * 
     * @param ids 需要删除的评论点赞ID
     * @return 结果
     */
    @Override
    public int deleteCommentlikeByIds(Long[] ids)
    {
        return commentlikeMapper.deleteCommentlikeByIds(ids);
    }

    /**
     * 删除评论点赞信息
     * 
     * @param id 评论点赞ID
     * @return 结果
     */
    @Override
    public int deleteCommentlikeById(Long id)
    {
        return commentlikeMapper.deleteCommentlikeById(id);
    }
}
