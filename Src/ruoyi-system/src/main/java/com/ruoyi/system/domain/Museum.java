package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 博物馆信息对象 museum
 * 
 * @author ruoyi
 * @date 2021-05-10
 */
public class Museum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 博物馆编号 */
    @Excel(name = "博物馆编号")
    private Long id;

    /** 博物馆名称 */
    @Excel(name = "博物馆名称")
    private String name;

    /** 博物馆的类型 */
    @Excel(name = "博物馆的类型")
    private String type;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 门票 */
    @Excel(name = "门票")
    private Long ticketprice;

    /** 开放时间 */
    @Excel(name = "开放时间")
    private String openinghours;

    /** 建议游玩时间 */
    @Excel(name = "建议游玩时间")
    private String suggestedtraveltime;

    /** 博物馆等级 */
    @Excel(name = "博物馆等级")
    private String museumlevel;

    /** 文物保护单位 */
    @Excel(name = "文物保护单位")
    private String units;

    /** 旅游景区级别 */
    @Excel(name = "旅游景区级别")
    private String attractionlevel;

    /** 博物馆对应页面的编号 */
    @Excel(name = "博物馆对应页面的编号")
    private String number;

    /** 博物馆简介 */
    @Excel(name = "博物馆简介")
    private String introduction;

    /** 景点景观/藏品 */
    @Excel(name = "景点景观/藏品")
    private String scenery;

    /** 如何前往 */
    @Excel(name = "如何前往")
    private String howtogo;

    /** 周围的景点 */
    @Excel(name = "周围的景点")
    private String scenicspotsaround;

    /** 封面（图片） */
    @Excel(name = "封面", readConverterExp = "图=片")
    private String cover;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal latitude;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTicketprice(Long ticketprice) 
    {
        this.ticketprice = ticketprice;
    }

    public Long getTicketprice() 
    {
        return ticketprice;
    }
    public void setOpeninghours(String openinghours) 
    {
        this.openinghours = openinghours;
    }

    public String getOpeninghours() 
    {
        return openinghours;
    }
    public void setSuggestedtraveltime(String suggestedtraveltime) 
    {
        this.suggestedtraveltime = suggestedtraveltime;
    }

    public String getSuggestedtraveltime() 
    {
        return suggestedtraveltime;
    }
    public void setMuseumlevel(String museumlevel) 
    {
        this.museumlevel = museumlevel;
    }

    public String getMuseumlevel() 
    {
        return museumlevel;
    }
    public void setUnits(String units) 
    {
        this.units = units;
    }

    public String getUnits() 
    {
        return units;
    }
    public void setAttractionlevel(String attractionlevel) 
    {
        this.attractionlevel = attractionlevel;
    }

    public String getAttractionlevel() 
    {
        return attractionlevel;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setScenery(String scenery) 
    {
        this.scenery = scenery;
    }

    public String getScenery() 
    {
        return scenery;
    }
    public void setHowtogo(String howtogo) 
    {
        this.howtogo = howtogo;
    }

    public String getHowtogo() 
    {
        return howtogo;
    }
    public void setScenicspotsaround(String scenicspotsaround) 
    {
        this.scenicspotsaround = scenicspotsaround;
    }

    public String getScenicspotsaround() 
    {
        return scenicspotsaround;
    }
    public void setCover(String cover) 
    {
        this.cover = cover;
    }

    public String getCover() 
    {
        return cover;
    }
    public void setLongitude(BigDecimal longitude) 
    {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(BigDecimal latitude) 
    {
        this.latitude = latitude;
    }

    public BigDecimal getLatitude() 
    {
        return latitude;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("address", getAddress())
            .append("ticketprice", getTicketprice())
            .append("openinghours", getOpeninghours())
            .append("suggestedtraveltime", getSuggestedtraveltime())
            .append("museumlevel", getMuseumlevel())
            .append("units", getUnits())
            .append("attractionlevel", getAttractionlevel())
            .append("number", getNumber())
            .append("introduction", getIntroduction())
            .append("scenery", getScenery())
            .append("howtogo", getHowtogo())
            .append("scenicspotsaround", getScenicspotsaround())
            .append("cover", getCover())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("note", getNote())
            .toString();
    }
}
