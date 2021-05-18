package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 博物馆评分对象 museumrating
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
public class Museumrating extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号  */
    @Excel(name = "编号 ")
    private Long id;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long usersid;

    /** 博物馆编号  */
    @Excel(name = "博物馆编号 ")
    private Long museumid;

    /** 评分一 */
    @Excel(name = "评分一")
    private Integer scoreone;

    /** 评分二 */
    @Excel(name = "评分二")
    private Integer scoretwo;

    /** 评分三  */
    @Excel(name = "评分三 ")
    private Integer scorethree;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsersid(Long usersid) 
    {
        this.usersid = usersid;
    }

    public Long getUsersid() 
    {
        return usersid;
    }
    public void setMuseumid(Long museumid) 
    {
        this.museumid = museumid;
    }

    public Long getMuseumid() 
    {
        return museumid;
    }
    public void setScoreone(Integer scoreone) 
    {
        this.scoreone = scoreone;
    }

    public Integer getScoreone() 
    {
        return scoreone;
    }
    public void setScoretwo(Integer scoretwo) 
    {
        this.scoretwo = scoretwo;
    }

    public Integer getScoretwo() 
    {
        return scoretwo;
    }
    public void setScorethree(Integer scorethree) 
    {
        this.scorethree = scorethree;
    }

    public Integer getScorethree() 
    {
        return scorethree;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("usersid", getUsersid())
            .append("museumid", getMuseumid())
            .append("scoreone", getScoreone())
            .append("scoretwo", getScoretwo())
            .append("scorethree", getScorethree())
            .toString();
    }
}
