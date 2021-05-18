package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Museumcollection;

/**
 * 博物馆收藏Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-02
 */
public interface MuseumcollectionMapper 
{
    /**
     * 查询博物馆收藏
     * 
     * @param id 博物馆收藏ID
     * @return 博物馆收藏
     */
    public Museumcollection selectMuseumcollectionById(Long id);
    public List<Museumcollection> selectMuseumcollectionByUserid(Long userid);
    /**
     * 查询博物馆收藏列表
     * 
     * @param museumcollection 博物馆收藏
     * @return 博物馆收藏集合
     */
    public List<Museumcollection> selectMuseumcollectionList(Museumcollection museumcollection);

    /**
     * 新增博物馆收藏
     * 
     * @param museumcollection 博物馆收藏
     * @return 结果
     */
    public int insertMuseumcollection(Museumcollection museumcollection);

    /**
     * 修改博物馆收藏
     * 
     * @param museumcollection 博物馆收藏
     * @return 结果
     */
    public int updateMuseumcollection(Museumcollection museumcollection);

    /**
     * 删除博物馆收藏
     * 
     * @param id 博物馆收藏ID
     * @return 结果
     */
    public int deleteMuseumcollectionById(Long id);

    /**
     * 批量删除博物馆收藏
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMuseumcollectionByIds(Long[] ids);
}
