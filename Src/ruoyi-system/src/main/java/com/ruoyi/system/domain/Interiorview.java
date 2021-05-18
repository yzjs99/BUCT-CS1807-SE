package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 内景图对象 interiorview
 * 
 * @author ruoyi
 * @date 2021-05-18
 */
public class Interiorview extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** key（自增）不能为空 */
    @Excel(name = "key", readConverterExp = "自=增")
    private Long id;

    /** 不能为空 */
    @Excel(name = "不能为空")
    private Long museumid;

    /** 不能为空 */
    @Excel(name = "不能为空")
    private String address;

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
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("museumid", getMuseumid())
            .append("address", getAddress())
            .toString();
    }
}
