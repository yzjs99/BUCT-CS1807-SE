package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.vo.ImageVO;
import com.ruoyi.system.domain.vo.VoiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CollectionexplainMapper;
import com.ruoyi.system.domain.Collectionexplain;
import com.ruoyi.system.service.ICollectionexplainService;

/**
 * 收藏品讲解Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
@Service
public class CollectionexplainServiceImpl implements ICollectionexplainService 
{
    @Autowired
    private CollectionexplainMapper collectionexplainMapper;

    /**
     * 查询收藏品讲解
     * 
     * @param id 收藏品讲解ID
     * @return 收藏品讲解
     */
    @Override
    public Collectionexplain selectCollectionexplainById(Long id)
    {
        return collectionexplainMapper.selectCollectionexplainById(id);
    }

    /**
     * 查询收藏品讲解列表
     * 
     * @param collectionexplain 收藏品讲解
     * @return 收藏品讲解
     */
    @Override
    public List<Collectionexplain> selectCollectionexplainList(Collectionexplain collectionexplain)
    {
        return collectionexplainMapper.selectCollectionexplainList(collectionexplain);
    }

    /**
     * 新增收藏品讲解
     * 
     * @param collectionexplain 收藏品讲解
     * @return 结果
     */
    @Override
    public int insertCollectionexplain(Collectionexplain collectionexplain)
    {
        return collectionexplainMapper.insertCollectionexplain(collectionexplain);
    }

    /**
     * 修改收藏品讲解
     * 
     * @param collectionexplain 收藏品讲解
     * @return 结果
     */
    @Override
    public int updateCollectionexplain(Collectionexplain collectionexplain)
    {
        return collectionexplainMapper.updateCollectionexplain(collectionexplain);
    }

    /**
     * 批量删除收藏品讲解
     * 
     * @param ids 需要删除的收藏品讲解ID
     * @return 结果
     */
    @Override
    public int deleteCollectionexplainByIds(Long[] ids)
    {
        return collectionexplainMapper.deleteCollectionexplainByIds(ids);
    }

    /**
     * 删除收藏品讲解信息
     * 
     * @param id 收藏品讲解ID
     * @return 结果
     */
    @Override
    public int deleteCollectionexplainById(Long id)
    {
        return collectionexplainMapper.deleteCollectionexplainById(id);
    }

    @Override
    public List<Collectionexplain> selectCollectionexplainBycollectionid(Long collectionid)
    {
        return collectionexplainMapper.selectCollectionexplainBycollectionid(collectionid);
    }
    @Override
    public List<Collectionexplain> selectCollectionexplainBycreateid(Long createid)
    {
        return collectionexplainMapper.selectCollectionexplainBycreateid(createid);
    }
    @Override
    public ImageVO selectCollectionexplainPicById(Long id)
    {
        return collectionexplainMapper.selectCollectionexplainPicById(id);
    }
    @Override
    public VoiceVO selectCollectionexplainVoiceById(Long id)
    {
        return collectionexplainMapper.selectCollectionexplainVoiceById(id);
    }
    @Override
    public void updateCollectionexplainImageById(ImageVO imageVO) {
        collectionexplainMapper.updateCollectionexplainImageById(imageVO);
    }
    @Override
    public void updateCollectionexplainVoiceById(VoiceVO voiceVO) {
        collectionexplainMapper.updateCollectionexplainVoiceById(voiceVO);
    }
    @Override
    public List<Collectionexplain> selectCollectionexplainidBycreateid(Long createid)
    {
        return collectionexplainMapper.selectCollectionexplainidBycreateid(createid);
    }

}
