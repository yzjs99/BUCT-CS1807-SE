package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Commentlike;

/**
 * 评论点赞Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
public interface CommentlikeMapper 
{
    /**
     * 查询评论点赞
     * 
     * @param id 评论点赞ID
     * @return 评论点赞
     */
    public Commentlike selectCommentlikeById(Long id);
    public List<Commentlike> selectCommentlikeByCommentid(Long commentid);

    /**
     * 查询评论点赞列表
     * 
     * @param commentlike 评论点赞
     * @return 评论点赞集合
     */
    public List<Commentlike> selectCommentlikeList(Commentlike commentlike);

    /**
     * 新增评论点赞
     * 
     * @param commentlike 评论点赞
     * @return 结果
     */
    public int insertCommentlike(Commentlike commentlike);

    /**
     * 修改评论点赞
     * 
     * @param commentlike 评论点赞
     * @return 结果
     */
    public int updateCommentlike(Commentlike commentlike);

    /**
     * 删除评论点赞
     * 
     * @param id 评论点赞ID
     * @return 结果
     */
    public int deleteCommentlikeById(Long id);

    /**
     * 批量删除评论点赞
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCommentlikeByIds(Long[] ids);
}
