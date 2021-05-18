package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 博物馆收藏对象 museumcollection
 * 
 * @author ruoyi
 * @date 2021-05-02
 */
public class Museumcollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 博物馆编号 */
    @Excel(name = "博物馆编号")
    private Long mumid;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long userid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMumid(Long mumid) 
    {
        this.mumid = mumid;
    }

    public Long getMumid() 
    {
        return mumid;
    }
    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mumid", getMumid())
            .append("userid", getUserid())
            .toString();
    }
}
