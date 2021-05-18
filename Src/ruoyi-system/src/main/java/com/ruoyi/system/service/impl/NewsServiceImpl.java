package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.NewsMapper;
import com.ruoyi.system.domain.News;
import com.ruoyi.system.service.INewsService;

/**
 * 新闻分析Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
@Service
public class NewsServiceImpl implements INewsService 
{
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询新闻分析
     * 
     * @param id 新闻分析ID
     * @return 新闻分析
     */
    @Override
    public News selectNewsById(Long id)
    {
        return newsMapper.selectNewsById(id);
    }

    /**
     * 查询新闻分析列表
     * 
     * @param news 新闻分析
     * @return 新闻分析
     */
    @Override
    public List<News> selectNewsList(News news)
    {
        return newsMapper.selectNewsList(news);
    }

    /**
     * 查询新闻分析列表
     *
     * @param mumname 新闻分析
     * @return 新闻分析
     */
    @Override
    public List<News> selectNewsByMumname(String mumname)
    {
        return newsMapper.selectNewsByMumname(mumname);
    }
    @Override
    public List<News> selectNewsByMumname2(String mumname)
    {
        return newsMapper.selectNewsByMumname2(mumname);
    }
    /**
     * 新增新闻分析
     * 
     * @param news 新闻分析
     * @return 结果
     */
    @Override
    public int insertNews(News news)
    {
        return newsMapper.insertNews(news);
    }

    /**
     * 修改新闻分析
     * 
     * @param news 新闻分析
     * @return 结果
     */
    @Override
    public int updateNews(News news)
    {
        return newsMapper.updateNews(news);
    }

    /**
     * 批量删除新闻分析
     * 
     * @param ids 需要删除的新闻分析ID
     * @return 结果
     */
    @Override
    public int deleteNewsByIds(Long[] ids)
    {
        return newsMapper.deleteNewsByIds(ids);
    }

    /**
     * 删除新闻分析信息
     * 
     * @param id 新闻分析ID
     * @return 结果
     */
    @Override
    public int deleteNewsById(Long id)
    {
        return newsMapper.deleteNewsById(id);
    }
}
