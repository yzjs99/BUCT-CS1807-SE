package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论点赞对象 commentlike
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
public class Commentlike extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 评论编号 */
    @Excel(name = "评论编号")
    private Long commentid;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userid;

    /** 是否点赞 */
    @Excel(name = "是否点赞")
    private Integer islike;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCommentid(Long commentid) 
    {
        this.commentid = commentid;
    }

    public Long getCommentid() 
    {
        return commentid;
    }
    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }
    public void setIslike(Integer islike) 
    {
        this.islike = islike;
    }

    public Integer getIslike() 
    {
        return islike;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("commentid", getCommentid())
            .append("userid", getUserid())
            .append("islike", getIslike())
            .toString();
    }
}
