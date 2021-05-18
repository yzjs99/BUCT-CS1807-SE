package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InteriorviewMapper;
import com.ruoyi.system.domain.Interiorview;
import com.ruoyi.system.service.IInteriorviewService;

/**
 * 内景图Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-18
 */
@Service
public class InteriorviewServiceImpl implements IInteriorviewService 
{
    @Autowired
    private InteriorviewMapper interiorviewMapper;

    /**
     * 查询内景图
     * 
     * @param id 内景图ID
     * @return 内景图
     */
    @Override
    public Interiorview selectInteriorviewById(Long id)
    {
        return interiorviewMapper.selectInteriorviewById(id);
    }

    /**
     * 查询内景图列表
     * 
     * @param interiorview 内景图
     * @return 内景图
     */
    @Override
    public List<Interiorview> selectInteriorviewList(Interiorview interiorview)
    {
        return interiorviewMapper.selectInteriorviewList(interiorview);
    }

    /**
     * 新增内景图
     * 
     * @param interiorview 内景图
     * @return 结果
     */
    @Override
    public int insertInteriorview(Interiorview interiorview)
    {
        return interiorviewMapper.insertInteriorview(interiorview);
    }

    /**
     * 修改内景图
     * 
     * @param interiorview 内景图
     * @return 结果
     */
    @Override
    public int updateInteriorview(Interiorview interiorview)
    {
        return interiorviewMapper.updateInteriorview(interiorview);
    }

    /**
     * 批量删除内景图
     * 
     * @param ids 需要删除的内景图ID
     * @return 结果
     */
    @Override
    public int deleteInteriorviewByIds(Long[] ids)
    {
        return interiorviewMapper.deleteInteriorviewByIds(ids);
    }

    /**
     * 删除内景图信息
     * 
     * @param id 内景图ID
     * @return 结果
     */
    @Override
    public int deleteInteriorviewById(Long id)
    {
        return interiorviewMapper.deleteInteriorviewById(id);
    }
    public List<Interiorview> selectInteriorviewByMuseumId(Long MuseumId)
    {
        return interiorviewMapper.selectInteriorviewByMuseumId(MuseumId);
    }

}
