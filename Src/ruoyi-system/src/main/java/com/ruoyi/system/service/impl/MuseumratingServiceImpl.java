package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MuseumratingMapper;
import com.ruoyi.system.domain.Museumrating;
import com.ruoyi.system.service.IMuseumratingService;

/**
 * 博物馆评分Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
@Service
public class MuseumratingServiceImpl implements IMuseumratingService 
{
    @Autowired
    private MuseumratingMapper museumratingMapper;

    /**
     * 查询博物馆评分
     * 
     * @param id 博物馆评分ID
     * @return 博物馆评分
     */
    @Override
    public Museumrating selectMuseumratingById(Long id)
    {
        return museumratingMapper.selectMuseumratingById(id);
    }

    /**
     * 查询博物馆评分列表
     * 
     * @param museumrating 博物馆评分
     * @return 博物馆评分
     */
    @Override
    public List<Museumrating> selectMuseumratingList(Museumrating museumrating)
    {
        return museumratingMapper.selectMuseumratingList(museumrating);
    }
    @Override
    public List<Museumrating> selectMuseumratingSortid(Museumrating museumrating)
    {
        return museumratingMapper.selectMuseumratingSortid(museumrating);
    }

    /**
     * 新增博物馆评分
     * 
     * @param museumrating 博物馆评分
     * @return 结果
     */
    @Override
    public int insertMuseumrating(Museumrating museumrating)
    {
        return museumratingMapper.insertMuseumrating(museumrating);
    }

    /**
     * 修改博物馆评分
     * 
     * @param museumrating 博物馆评分
     * @return 结果
     */
    @Override
    public int updateMuseumrating(Museumrating museumrating)
    {
        return museumratingMapper.updateMuseumrating(museumrating);
    }

    /**
     * 批量删除博物馆评分
     * 
     * @param ids 需要删除的博物馆评分ID
     * @return 结果
     */
    @Override
    public int deleteMuseumratingByIds(Long[] ids)
    {
        return museumratingMapper.deleteMuseumratingByIds(ids);
    }

    /**
     * 删除博物馆评分信息
     * 
     * @param id 博物馆评分ID
     * @return 结果
     */
    @Override
    public int deleteMuseumratingById(Long id)
    {
        return museumratingMapper.deleteMuseumratingById(id);
    }
}
