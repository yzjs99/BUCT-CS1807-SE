package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 展览——藏品对象 exhibitcollection
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class Exhibitcollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 博物馆编号 */
    @Excel(name = "博物馆编号")
    private Long museumid;

    /** 藏品所属展览名字 */
    @Excel(name = "藏品所属展览名字")
    private String exhibitname;

    /** 展览简介 */
    @Excel(name = "展览简介")
    private String exhibitsummary;

    /** 藏品名称 */
    @Excel(name = "藏品名称")
    private String collectionname;

    /** 藏品图片地址 */
    @Excel(name = "藏品图片地址")
    private String collectionimageurl;

    /** 藏品简介 */
    @Excel(name = "藏品简介")
    private String collectionsummary;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMuseumid(Long museumid) 
    {
        this.museumid = museumid;
    }

    public Long getMuseumid() 
    {
        return museumid;
    }
    public void setExhibitname(String exhibitname) 
    {
        this.exhibitname = exhibitname;
    }

    public String getExhibitname() 
    {
        return exhibitname;
    }
    public void setExhibitsummary(String exhibitsummary) 
    {
        this.exhibitsummary = exhibitsummary;
    }

    public String getExhibitsummary() 
    {
        return exhibitsummary;
    }
    public void setCollectionname(String collectionname) 
    {
        this.collectionname = collectionname;
    }

    public String getCollectionname() 
    {
        return collectionname;
    }
    public void setCollectionimageurl(String collectionimageurl) 
    {
        this.collectionimageurl = collectionimageurl;
    }

    public String getCollectionimageurl() 
    {
        return collectionimageurl;
    }
    public void setCollectionsummary(String collectionsummary) 
    {
        this.collectionsummary = collectionsummary;
    }

    public String getCollectionsummary() 
    {
        return collectionsummary;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("museumid", getMuseumid())
            .append("exhibitname", getExhibitname())
            .append("exhibitsummary", getExhibitsummary())
            .append("collectionname", getCollectionname())
            .append("collectionimageurl", getCollectionimageurl())
            .append("collectionsummary", getCollectionsummary())
            .toString();
    }
}
