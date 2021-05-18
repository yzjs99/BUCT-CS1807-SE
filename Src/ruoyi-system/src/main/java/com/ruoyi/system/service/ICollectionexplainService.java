package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Collectionexplain;
import com.ruoyi.system.domain.vo.ImageVO;
import com.ruoyi.system.domain.vo.VoiceVO;

/**
 * 收藏品讲解Service接口
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
public interface ICollectionexplainService 
{
    /**
     * 查询收藏品讲解
     * 
     * @param id 收藏品讲解ID
     * @return 收藏品讲解
     */
    public Collectionexplain selectCollectionexplainById(Long id);

    /**
     * 查询收藏品讲解列表
     * 
     * @param collectionexplain 收藏品讲解
     * @return 收藏品讲解集合
     */
    public List<Collectionexplain> selectCollectionexplainList(Collectionexplain collectionexplain);

    /**
     * 新增收藏品讲解
     * 
     * @param collectionexplain 收藏品讲解
     * @return 结果
     */
    public int insertCollectionexplain(Collectionexplain collectionexplain);

    /**
     * 修改收藏品讲解
     * 
     * @param collectionexplain 收藏品讲解
     * @return 结果
     */
    public int updateCollectionexplain(Collectionexplain collectionexplain);

    /**
     * 批量删除收藏品讲解
     * 
     * @param ids 需要删除的收藏品讲解ID
     * @return 结果
     */
    public int deleteCollectionexplainByIds(Long[] ids);

    /**
     * 删除收藏品讲解信息
     * 
     * @param id 收藏品讲解ID
     * @return 结果
     */
    public int deleteCollectionexplainById(Long id);
    public List<Collectionexplain> selectCollectionexplainBycollectionid(Long collectionid);
    public List<Collectionexplain> selectCollectionexplainBycreateid(Long createid);
    public ImageVO selectCollectionexplainPicById(Long id);
    public VoiceVO selectCollectionexplainVoiceById(Long id);
    public void updateCollectionexplainImageById(ImageVO imageVO);
    public void updateCollectionexplainVoiceById(VoiceVO voiceVO);
    public List<Collectionexplain> selectCollectionexplainidBycreateid(Long createid);
}
