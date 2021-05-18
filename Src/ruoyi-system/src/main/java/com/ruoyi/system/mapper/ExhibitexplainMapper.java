package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Exhibitexplain;
import com.ruoyi.system.domain.vo.ImageVO;
import com.ruoyi.system.domain.vo.VoiceVO;

/**
 * 展览讲解Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-16
 */
public interface ExhibitexplainMapper 
{
    /**
     * 查询展览讲解
     * 
     * @param id 展览讲解ID
     * @return 展览讲解
     */
    public Exhibitexplain selectExhibitexplainById(Long id);

    /**
     * 查询展览讲解列表
     * 
     * @param exhibitexplain 展览讲解
     * @return 展览讲解集合
     */
    public List<Exhibitexplain> selectExhibitexplainList(Exhibitexplain exhibitexplain);

    /**
     * 新增展览讲解
     * 
     * @param exhibitexplain 展览讲解
     * @return 结果
     */
    public int insertExhibitexplain(Exhibitexplain exhibitexplain);

    /**
     * 修改展览讲解
     * 
     * @param exhibitexplain 展览讲解
     * @return 结果
     */
    public int updateExhibitexplain(Exhibitexplain exhibitexplain);

    /**
     * 删除展览讲解
     * 
     * @param id 展览讲解ID
     * @return 结果
     */
    public int deleteExhibitexplainById(Long id);

    /**
     * 批量删除展览讲解
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteExhibitexplainByIds(Long[] ids);
    public List<Exhibitexplain> selectExhibitexplainByexhibitid(Long exhibitid);
    public List<Exhibitexplain> selectExhibitexplainBycreateid(Long createid);
    public ImageVO selectExhibitexplainPicById(Long id);
    public VoiceVO selectExhibitexplainVoiceById(Long id);
    public int updateExhibitexplainImageById(ImageVO imageVO);
    public int updateExhibitexplainVoiceById(VoiceVO voiceVO);
    public List<Exhibitexplain> selectExhibitexplainidBycreateid(Long createid);
}
