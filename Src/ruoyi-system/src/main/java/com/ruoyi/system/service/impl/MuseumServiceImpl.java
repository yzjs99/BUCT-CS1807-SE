package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MuseumMapper;
import com.ruoyi.system.domain.Museum;
import com.ruoyi.system.service.IMuseumService;

/**
 * 博物馆信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-10
 */
@Service
public class MuseumServiceImpl implements IMuseumService 
{
    @Autowired
    private MuseumMapper museumMapper;

    /**
     * 查询博物馆信息
     * 
     * @param id 博物馆信息ID
     * @return 博物馆信息
     */
    @Override
    public Museum selectMuseumById(Long id)
    {
        return museumMapper.selectMuseumById(id);
    }
    public List<Museum> selectMuseumByName(String name)
    {
        return museumMapper.selectMuseumByName(name);
    }
    /**
     * 查询博物馆信息列表
     * 
     * @param museum 博物馆信息
     * @return 博物馆信息
     */
    @Override
    public List<Museum> selectMuseumList(Museum museum)
    {
        return museumMapper.selectMuseumList(museum);
    }

    /**
     * 新增博物馆信息
     * 
     * @param museum 博物馆信息
     * @return 结果
     */
    @Override
    public int insertMuseum(Museum museum)
    {
        return museumMapper.insertMuseum(museum);
    }

    /**
     * 修改博物馆信息
     * 
     * @param museum 博物馆信息
     * @return 结果
     */
    @Override
    public int updateMuseum(Museum museum)
    {
        return museumMapper.updateMuseum(museum);
    }

    /**
     * 批量删除博物馆信息
     * 
     * @param ids 需要删除的博物馆信息ID
     * @return 结果
     */
    @Override
    public int deleteMuseumByIds(Long[] ids)
    {
        return museumMapper.deleteMuseumByIds(ids);
    }

    /**
     * 删除博物馆信息信息
     * 
     * @param id 博物馆信息ID
     * @return 结果
     */
    @Override
    public int deleteMuseumById(Long id)
    {
        return museumMapper.deleteMuseumById(id);
    }
}
