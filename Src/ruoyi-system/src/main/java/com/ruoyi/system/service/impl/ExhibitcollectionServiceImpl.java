package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ExhibitcollectionMapper;
import com.ruoyi.system.domain.Exhibitcollection;
import com.ruoyi.system.service.IExhibitcollectionService;

/**
 * 展览——藏品Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Service
public class ExhibitcollectionServiceImpl implements IExhibitcollectionService 
{
    @Autowired
    private ExhibitcollectionMapper exhibitcollectionMapper;

    /**
     * 查询展览——藏品
     * 
     * @param id 展览——藏品ID
     * @return 展览——藏品
     */
    @Override
    public Exhibitcollection selectExhibitcollectionById(Long id)
    {
        return exhibitcollectionMapper.selectExhibitcollectionById(id);
    }

    /**
     * 查询展览——藏品列表
     * 
     * @param exhibitcollection 展览——藏品
     * @return 展览——藏品
     */
    @Override
    public List<Exhibitcollection> selectExhibitcollectionList(Exhibitcollection exhibitcollection)
    {
        return exhibitcollectionMapper.selectExhibitcollectionList(exhibitcollection);
    }

    /**
     * 新增展览——藏品
     * 
     * @param exhibitcollection 展览——藏品
     * @return 结果
     */
    @Override
    public int insertExhibitcollection(Exhibitcollection exhibitcollection)
    {
        return exhibitcollectionMapper.insertExhibitcollection(exhibitcollection);
    }

    /**
     * 修改展览——藏品
     * 
     * @param exhibitcollection 展览——藏品
     * @return 结果
     */
    @Override
    public int updateExhibitcollection(Exhibitcollection exhibitcollection)
    {
        return exhibitcollectionMapper.updateExhibitcollection(exhibitcollection);
    }

    /**
     * 批量删除展览——藏品
     * 
     * @param ids 需要删除的展览——藏品ID
     * @return 结果
     */
    @Override
    public int deleteExhibitcollectionByIds(Long[] ids)
    {
        return exhibitcollectionMapper.deleteExhibitcollectionByIds(ids);
    }

    /**
     * 删除展览——藏品信息
     * 
     * @param id 展览——藏品ID
     * @return 结果
     */
    @Override
    public int deleteExhibitcollectionById(Long id)
    {
        return exhibitcollectionMapper.deleteExhibitcollectionById(id);
    }
    @Override
    public List<Exhibitcollection> selectExhibitcollectionByMuseumid(Long Museumid)
    {
        return exhibitcollectionMapper.selectExhibitcollectionByMuseumid(Museumid);
    }
}
