package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Exhibitcollection;

/**
 * 展览——藏品Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface ExhibitcollectionMapper 
{
    /**
     * 查询展览——藏品
     * 
     * @param id 展览——藏品ID
     * @return 展览——藏品
     */
    public Exhibitcollection selectExhibitcollectionById(Long id);
    public List<Exhibitcollection> selectExhibitcollectionByMuseumid(Long Museumid);
    /**
     * 查询展览——藏品列表
     * 
     * @param exhibitcollection 展览——藏品
     * @return 展览——藏品集合
     */
    public List<Exhibitcollection> selectExhibitcollectionList(Exhibitcollection exhibitcollection);

    /**
     * 新增展览——藏品
     * 
     * @param exhibitcollection 展览——藏品
     * @return 结果
     */
    public int insertExhibitcollection(Exhibitcollection exhibitcollection);

    /**
     * 修改展览——藏品
     * 
     * @param exhibitcollection 展览——藏品
     * @return 结果
     */
    public int updateExhibitcollection(Exhibitcollection exhibitcollection);

    /**
     * 删除展览——藏品
     * 
     * @param id 展览——藏品ID
     * @return 结果
     */
    public int deleteExhibitcollectionById(Long id);

    /**
     * 批量删除展览——藏品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteExhibitcollectionByIds(Long[] ids);
}
