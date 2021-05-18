package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.vo.ImageVO;
import com.ruoyi.system.domain.vo.VoiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ExhibitexplainMapper;
import com.ruoyi.system.domain.Exhibitexplain;
import com.ruoyi.system.service.IExhibitexplainService;

/**
 * 展览讲解Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
@Service
public class ExhibitexplainServiceImpl implements IExhibitexplainService 
{
    @Autowired
    private ExhibitexplainMapper exhibitexplainMapper;

    /**
     * 查询展览讲解
     * 
     * @param id 展览讲解ID
     * @return 展览讲解
     */
    @Override
    public Exhibitexplain selectExhibitexplainById(Long id)
    {
        return exhibitexplainMapper.selectExhibitexplainById(id);
    }

    /**
     * 查询展览讲解列表
     * 
     * @param exhibitexplain 展览讲解
     * @return 展览讲解
     */
    @Override
    public List<Exhibitexplain> selectExhibitexplainList(Exhibitexplain exhibitexplain)
    {
        return exhibitexplainMapper.selectExhibitexplainList(exhibitexplain);
    }

    /**
     * 新增展览讲解
     * 
     * @param exhibitexplain 展览讲解
     * @return 结果
     */
    @Override
    public int insertExhibitexplain(Exhibitexplain exhibitexplain)
    {
        return exhibitexplainMapper.insertExhibitexplain(exhibitexplain);
    }

    /**
     * 修改展览讲解
     * 
     * @param exhibitexplain 展览讲解
     * @return 结果
     */
    @Override
    public int updateExhibitexplain(Exhibitexplain exhibitexplain)
    {
        return exhibitexplainMapper.updateExhibitexplain(exhibitexplain);
    }

    /**
     * 批量删除展览讲解
     * 
     * @param ids 需要删除的展览讲解ID
     * @return 结果
     */
    @Override
    public int deleteExhibitexplainByIds(Long[] ids)
    {
        return exhibitexplainMapper.deleteExhibitexplainByIds(ids);
    }

    /**
     * 删除展览讲解信息
     * 
     * @param id 展览讲解ID
     * @return 结果
     */
    @Override
    public int deleteExhibitexplainById(Long id)
    {
        return exhibitexplainMapper.deleteExhibitexplainById(id);
    }

    @Override
    public List<Exhibitexplain> selectExhibitexplainByexhibitid(Long exhibitid)
    {
        return exhibitexplainMapper.selectExhibitexplainByexhibitid(exhibitid);
    }
    @Override
    public List<Exhibitexplain> selectExhibitexplainBycreateid(Long createid)
    {
        return exhibitexplainMapper.selectExhibitexplainBycreateid(createid);
    }
    @Override
    public ImageVO selectExhibitexplainPicById(Long id)
    {
        return exhibitexplainMapper.selectExhibitexplainPicById(id);
    }
    @Override
    public VoiceVO selectExhibitexplainVoiceById(Long id)
    {
        return exhibitexplainMapper.selectExhibitexplainVoiceById(id);
    }

    @Override
    public void updateExhibitexplainImageById(ImageVO imageVO) {
        exhibitexplainMapper.updateExhibitexplainImageById(imageVO);
    }
    @Override
    public void updateExhibitexplainVoiceById(VoiceVO voiceVO) {
        exhibitexplainMapper.updateExhibitexplainVoiceById(voiceVO);
    }
    @Override
    public List<Exhibitexplain> selectExhibitexplainidBycreateid(Long createid)
    {
        return exhibitexplainMapper.selectExhibitexplainidBycreateid(createid);
    }
}
