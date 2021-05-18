package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 展览讲解对象 exhibitexplain
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
public class Exhibitexplain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 讲解编号 */
    @Excel(name = "讲解编号")
    private Long id;

    /** 讲解创建者编号 */
    @Excel(name = "讲解创建者编号")
    private Long createid;

    /** 讲解类型 */
    @Excel(name = "讲解类型")
    private Long type;

    /** 展览编号 */
    @Excel(name = "展览编号")
    private Long exhibitid;

    /** 讲解图片 */
    @Excel(name = "讲解图片")
    private byte[] image;

    /** 讲解音频 */
    @Excel(name = "讲解音频")
    private byte[] voice;

    /** 讲解文字 */
    @Excel(name = "讲解文字")
    private String text;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long sponsor;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Long state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreateid(Long createid) 
    {
        this.createid = createid;
    }

    public Long getCreateid() 
    {
        return createid;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setExhibitid(Long exhibitid) 
    {
        this.exhibitid = exhibitid;
    }

    public Long getExhibitid() 
    {
        return exhibitid;
    }
    public void setImage(byte[] image)
    {
        this.image = image;
    }

    public byte[] getImage()
    {
        return image;
    }
    public void setVoice(byte[] voice)
    {
        this.voice = voice;
    }

    public byte[] getVoice()
    {
        return voice;
    }
    public void setText(String text) 
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }
    public void setSponsor(Long sponsor) 
    {
        this.sponsor = sponsor;
    }

    public Long getSponsor() 
    {
        return sponsor;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createid", getCreateid())
            .append("type", getType())
            .append("exhibitid", getExhibitid())
            .append("image", getImage())
            .append("voice", getVoice())
            .append("text", getText())
            .append("sponsor", getSponsor())
            .append("state", getState())
            .toString();
    }
}
