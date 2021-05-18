package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 新闻分析对象 news
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
public class News extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 新闻编号 */
    @Excel(name = "新闻编号")
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 新闻发布时间 */
    @Excel(name = "新闻发布时间")
    private String time;

    /** 新闻内容 */
    @Excel(name = "新闻内容")
    private String content;

    /** 原文链接 */
    @Excel(name = "原文链接")
    private String link;

    /** 爬取时间 */
    @Excel(name = "爬取时间")
    private String gettime;

    /** 相关博物馆名称 */
    @Excel(name = "相关博物馆名称")
    private String mumname;

    /** 分类1 */
    @Excel(name = "分类1")
    private String classificationone;

    /** 分类2 */
    @Excel(name = "分类2")
    private String classificationtwo;

    /** 分类3 */
    @Excel(name = "分类3")
    private String classificationthree;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setTime(String time) 
    {
        this.time = time;
    }

    public String getTime() 
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
    public void setLink(String link) 
    {
        this.link = link;
    }

    public String getLink() 
    {
        return link;
    }
    public void setGettime(String gettime) 
    {
        this.gettime = gettime;
    }

    public String getGettime() 
    {
        return gettime;
    }
    public void setMumname(String mumname) 
    {
        this.mumname = mumname;
    }

    public String getMumname() 
    {
        return mumname;
    }
    public void setClassificationone(String classificationone) 
    {
        this.classificationone = classificationone;
    }

    public String getClassificationone() 
    {
        return classificationone;
    }
    public void setClassificationtwo(String classificationtwo) 
    {
        this.classificationtwo = classificationtwo;
    }

    public String getClassificationtwo() 
    {
        return classificationtwo;
    }
    public void setClassificationthree(String classificationthree) 
    {
        this.classificationthree = classificationthree;
    }

    public String getClassificationthree() 
    {
        return classificationthree;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("author", getAuthor())
            .append("time", getTime())
            .append("content", getContent())
            .append("link", getLink())
            .append("gettime", getGettime())
            .append("mumname", getMumname())
            .append("classificationone", getClassificationone())
            .append("classificationtwo", getClassificationtwo())
            .append("classificationthree", getClassificationthree())
            .toString();
    }
}
