package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MuseumcollectionMapper;
import com.ruoyi.system.domain.Museumcollection;
import com.ruoyi.system.service.IMuseumcollectionService;

/**
 * 博物馆收藏Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-02
 */
@Service
public class MuseumcollectionServiceImpl implements IMuseumcollectionService 
{
    @Autowired
    private MuseumcollectionMapper museumcollectionMapper;

    /**
     * 查询博物馆收藏
     * 
     * @param id 博物馆收藏ID
     * @return 博物馆收藏
     */
    @Override
    public Museumcollection selectMuseumcollectionById(Long id)
    {
        return museumcollectionMapper.selectMuseumcollectionById(id);
    }
    @Override
    public List<Museumcollection> selectMuseumcollectionByUserid(Long userid)
    {
        return museumcollectionMapper.selectMuseumcollectionByUserid(userid);
    }
    /**
     * 查询博物馆收藏列表
     * 
     * @param museumcollection 博物馆收藏
     * @return 博物馆收藏
     */
    @Override
    public List<Museumcollection> selectMuseumcollectionList(Museumcollection museumcollection)
    {
        return museumcollectionMapper.selectMuseumcollectionList(museumcollection);
    }

    /**
     * 新增博物馆收藏
     * 
     * @param museumcollection 博物馆收藏
     * @return 结果
     */
    @Override
    public int insertMuseumcollection(Museumcollection museumcollection)
    {
        return museumcollectionMapper.insertMuseumcollection(museumcollection);
    }

    /**
     * 修改博物馆收藏
     * 
     * @param museumcollection 博物馆收藏
     * @return 结果
     */
    @Override
    public int updateMuseumcollection(Museumcollection museumcollection)
    {
        return museumcollectionMapper.updateMuseumcollection(museumcollection);
    }

    /**
     * 批量删除博物馆收藏
     * 
     * @param ids 需要删除的博物馆收藏ID
     * @return 结果
     */
    @Override
    public int deleteMuseumcollectionByIds(Long[] ids)
    {
        return museumcollectionMapper.deleteMuseumcollectionByIds(ids);
    }

    /**
     * 删除博物馆收藏信息
     * 
     * @param id 博物馆收藏ID
     * @return 结果
     */
    @Override
    public int deleteMuseumcollectionById(Long id)
    {
        return museumcollectionMapper.deleteMuseumcollectionById(id);
    }
}
