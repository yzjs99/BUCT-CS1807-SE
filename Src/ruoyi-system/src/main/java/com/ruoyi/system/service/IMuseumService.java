package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Museum;

/**
 * 博物馆信息Service接口
 * 
 * @author ruoyi
 * @date 2021-05-10
 */
public interface IMuseumService 
{
    /**
     * 查询博物馆信息
     * 
     * @param id 博物馆信息ID
     * @return 博物馆信息
     */
    public Museum selectMuseumById(Long id);
    public List<Museum> selectMuseumByName(String name);
    /**
     * 查询博物馆信息列表
     * 
     * @param museum 博物馆信息
     * @return 博物馆信息集合
     */
    public List<Museum> selectMuseumList(Museum museum);

    /**
     * 新增博物馆信息
     * 
     * @param museum 博物馆信息
     * @return 结果
     */
    public int insertMuseum(Museum museum);

    /**
     * 修改博物馆信息
     * 
     * @param museum 博物馆信息
     * @return 结果
     */
    public int updateMuseum(Museum museum);

    /**
     * 批量删除博物馆信息
     * 
     * @param ids 需要删除的博物馆信息ID
     * @return 结果
     */
    public int deleteMuseumByIds(Long[] ids);

    /**
     * 删除博物馆信息信息
     * 
     * @param id 博物馆信息ID
     * @return 结果
     */
    public int deleteMuseumById(Long id);
}
