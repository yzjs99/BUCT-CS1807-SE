package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Museumrating;

/**
 * 博物馆评分Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-01
 */
public interface MuseumratingMapper 
{
    /**
     * 查询博物馆评分
     * 
     * @param id 博物馆评分ID
     * @return 博物馆评分
     */
    public Museumrating selectMuseumratingById(Long id);

    /**
     * 查询博物馆评分列表
     * 
     * @param museumrating 博物馆评分
     * @return 博物馆评分集合
     */
    public List<Museumrating> selectMuseumratingList(Museumrating museumrating);
    public List<Museumrating> selectMuseumratingSortid(Museumrating museumrating);

    /**
     * 新增博物馆评分
     * 
     * @param museumrating 博物馆评分
     * @return 结果
     */
    public int insertMuseumrating(Museumrating museumrating);

    /**
     * 修改博物馆评分
     * 
     * @param museumrating 博物馆评分
     * @return 结果
     */
    public int updateMuseumrating(Museumrating museumrating);

    /**
     * 删除博物馆评分
     * 
     * @param id 博物馆评分ID
     * @return 结果
     */
    public int deleteMuseumratingById(Long id);

    /**
     * 批量删除博物馆评分
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMuseumratingByIds(Long[] ids);
}
