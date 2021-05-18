package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.News;

/**
 * 新闻分析Service接口
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
public interface INewsService 
{
    /**
     * 查询新闻分析
     * 
     * @param id 新闻分析ID
     * @return 新闻分析
     */
    public News selectNewsById(Long id);

    /**
     * 查询新闻分析列表
     * 
     * @param news 新闻分析
     * @return 新闻分析集合
     */
    public List<News> selectNewsList(News news);

    /**
     * 查询新闻分析列表
     *
     * @param news 新闻分析
     * @return 新闻分析集合
     */
    public List<News> selectNewsByMumname(String mumname);

    /**
     * 新增新闻分析
     * 
     * @param news 新闻分析
     * @return 结果
     */
    public int insertNews(News news);

    /**
     * 修改新闻分析
     * 
     * @param news 新闻分析
     * @return 结果
     */
    public int updateNews(News news);

    /**
     * 批量删除新闻分析
     * 
     * @param ids 需要删除的新闻分析ID
     * @return 结果
     */
    public int deleteNewsByIds(Long[] ids);

    /**
     * 删除新闻分析信息
     * 
     * @param id 新闻分析ID
     * @return 结果
     */
    public int deleteNewsById(Long id);

    public List<News> selectNewsByMumname2(String mumname);
}
