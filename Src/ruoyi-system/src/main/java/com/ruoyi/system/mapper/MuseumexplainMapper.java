package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Museumexplain;
import com.ruoyi.system.domain.vo.ImageVO;
import com.ruoyi.system.domain.vo.VoiceVO;

/**
 * 博物馆讲解Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
public interface MuseumexplainMapper 
{
    /**
     * 查询博物馆讲解
     * 
     * @param id 博物馆讲解ID
     * @return 博物馆讲解
     */
    public Museumexplain selectMuseumexplainById(Long id);

    /**
     * 查询博物馆讲解列表
     * 
     * @param museumexplain 博物馆讲解
     * @return 博物馆讲解集合
     */
    public List<Museumexplain> selectMuseumexplainList(Museumexplain museumexplain);

    /**
     * 新增博物馆讲解
     * 
     * @param museumexplain 博物馆讲解
     * @return 结果
     */
    public int insertMuseumexplain(Museumexplain museumexplain);

    /**
     * 修改博物馆讲解
     * 
     * @param museumexplain 博物馆讲解
     * @return 结果
     */
    public int updateMuseumexplain(Museumexplain museumexplain);

    /**
     * 删除博物馆讲解
     * 
     * @param id 博物馆讲解ID
     * @return 结果
     */
    public int deleteMuseumexplainById(Long id);

    /**
     * 批量删除博物馆讲解
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMuseumexplainByIds(Long[] ids);
    public List<Museumexplain> selectMuseumexplainBymuseumid(Long museumid);
    public List<Museumexplain> selectMuseumexplainBycreateid(Long createid);
    public ImageVO selectMuseumexplainPicById(Long id);
    public VoiceVO selectMuseumexplainVoiceById(Long id);
    public int updateMuseumexplainImageById(ImageVO imageVO);
    public int updateMuseumexplainVoiceById(VoiceVO voiceVO);
    public List<Museumexplain> selectMuseumexplainidBycreateid(Long createid);
}
