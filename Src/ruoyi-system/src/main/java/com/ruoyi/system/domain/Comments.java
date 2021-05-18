package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论对象 comments
 * 
 * @author ruoyi
 * @date 2021-05-07
 */
public class Comments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论编号 */
    @Excel(name = "评论编号")
    private Long id;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userid;

    /** 博物馆编号 */
    @Excel(name = "博物馆编号")
    private Long mumid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }
    public void setMumid(Long mumid) 
    {
        this.mumid = mumid;
    }

    public Long getMumid() 
    {
        return mumid;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userid", getUserid())
            .append("mumid", getMumid())
            .append("username", getUsername())
            .append("time", getTime())
            .append("content", getContent())
            .toString();
    }
}
