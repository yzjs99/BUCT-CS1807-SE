package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 users
 * 
 * @author ruoyi
 * @date 2021-05-10
 */
public class Users extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String name;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 头像 */
    @Excel(name = "头像")
    private String pic;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birth;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 用户是否被禁止发评论 */
    @Excel(name = "用户是否被禁止发评论")
    private Long isforbidded;

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
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setBirth(Date birth) 
    {
        this.birth = birth;
    }

    public Date getBirth() 
    {
        return birth;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setIsforbidded(Long isforbidded) 
    {
        this.isforbidded = isforbidded;
    }

    public Long getIsforbidded() 
    {
        return isforbidded;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("password", getPassword())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("pic", getPic())
            .append("birth", getBirth())
            .append("note", getNote())
            .append("isforbidded", getIsforbidded())
            .toString();
    }
}
