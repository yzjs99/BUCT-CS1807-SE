package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.vo.ImageVO;
import com.ruoyi.system.domain.vo.VoiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MuseumexplainMapper;
import com.ruoyi.system.domain.Museumexplain;
import com.ruoyi.system.service.IMuseumexplainService;

/**
 * 博物馆讲解Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
@Service
public class MuseumexplainServiceImpl implements IMuseumexplainService 
{
    @Autowired
    private MuseumexplainMapper museumexplainMapper;

    /**
     * 查询博物馆讲解
     * 
     * @param id 博物馆讲解ID
     * @return 博物馆讲解
     */
    @Override
    public Museumexplain selectMuseumexplainById(Long id)
    {
        return museumexplainMapper.selectMuseumexplainById(id);
    }

    /**
     * 查询博物馆讲解列表
     * 
     * @param museumexplain 博物馆讲解
     * @return 博物馆讲解
     */
    @Override
    public List<Museumexplain> selectMuseumexplainList(Museumexplain museumexplain)
    {
        return museumexplainMapper.selectMuseumexplainList(museumexplain);
    }

    /**
     * 新增博物馆讲解
     * 
     * @param museumexplain 博物馆讲解
     * @return 结果
     */
    @Override
    public int insertMuseumexplain(Museumexplain museumexplain)
    {
        return museumexplainMapper.insertMuseumexplain(museumexplain);
    }

    /**
     * 修改博物馆讲解
     * 
     * @param museumexplain 博物馆讲解
     * @return 结果
     */
    @Override
    public int updateMuseumexplain(Museumexplain museumexplain)
    {
        return museumexplainMapper.updateMuseumexplain(museumexplain);
    }

    /**
     * 批量删除博物馆讲解
     * 
     * @param ids 需要删除的博物馆讲解ID
     * @return 结果
     */
    @Override
    public int deleteMuseumexplainByIds(Long[] ids)
    {
        return museumexplainMapper.deleteMuseumexplainByIds(ids);
    }

    /**
     * 删除博物馆讲解信息
     * 
     * @param id 博物馆讲解ID
     * @return 结果
     */
    @Override
    public int deleteMuseumexplainById(Long id)
    {
        return museumexplainMapper.deleteMuseumexplainById(id);
    }


    @Override
    public List<Museumexplain> selectMuseumexplainBymuseumid(Long museumid)
    {
        return museumexplainMapper.selectMuseumexplainBymuseumid(museumid);
    }
    @Override
    public List<Museumexplain> selectMuseumexplainBycreateid(Long createid)
    {
        return museumexplainMapper.selectMuseumexplainBycreateid(createid);
    }
    @Override
    public ImageVO selectMuseumexplainPicById(Long id)
    {
        return museumexplainMapper.selectMuseumexplainPicById(id);
    }
    @Override
    public VoiceVO selectMuseumexplainVoiceById(Long id)
    {
        return museumexplainMapper.selectMuseumexplainVoiceById(id);
    }

    @Override
    public void updateMuseumexplainImageById(ImageVO imageVO) {
        museumexplainMapper.updateMuseumexplainImageById(imageVO);
    }
    @Override
    public void updateMuseumexplainVoiceById(VoiceVO voiceVO) {
        museumexplainMapper.updateMuseumexplainVoiceById(voiceVO);
    }
    @Override
    public List<Museumexplain> selectMuseumexplainidBycreateid(Long createid)
    {
        return museumexplainMapper.selectMuseumexplainidBycreateid(createid);
    }
}
