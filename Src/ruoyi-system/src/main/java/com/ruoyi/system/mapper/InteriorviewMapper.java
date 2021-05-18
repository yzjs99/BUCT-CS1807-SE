package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Interiorview;

/**
 * 内景图Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-18
 */
public interface InteriorviewMapper 
{
    /**
     * 查询内景图
     * 
     * @param id 内景图ID
     * @return 内景图
     */
    public Interiorview selectInteriorviewById(Long id);

    /**
     * 查询内景图列表
     * 
     * @param interiorview 内景图
     * @return 内景图集合
     */
    public List<Interiorview> selectInteriorviewList(Interiorview interiorview);

    /**
     * 新增内景图
     * 
     * @param interiorview 内景图
     * @return 结果
     */
    public int insertInteriorview(Interiorview interiorview);

    /**
     * 修改内景图
     * 
     * @param interiorview 内景图
     * @return 结果
     */
    public int updateInteriorview(Interiorview interiorview);

    /**
     * 删除内景图
     * 
     * @param id 内景图ID
     * @return 结果
     */
    public int deleteInteriorviewById(Long id);

    /**
     * 批量删除内景图
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInteriorviewByIds(Long[] ids);
    public List<Interiorview> selectInteriorviewByMuseumId(Long MuseumId);
}
