package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 动态威胁分析Dao访问接口.
 * 


 **/
public interface ThreAnalDao  {

	/**
     * 保存/更新动态威胁
     * 
     * @param dynaThre
     * 动态威胁
     **/
    void saveOrUpdate(AsseKnowDynaThre dynaThre);
    
    /**
     * 批量保存/更新动态威胁
     * 
     * @param dynaThres
     * 动态威胁列表
     **/
    void batchSaveOrUpdate(List<AsseKnowDynaThre> dynaThres);
    
    /**
     * 删除动态威胁
     * 
     * @param dynaThre
     * 动态威胁
     **/
    void remove(AsseKnowDynaThre dynaThre);
    
    /**
     * 批量删除动态威胁
     * 
     * @param dynaThres
     *    动态威胁列表
     **/
    void remove(List<AsseKnowDynaThre> dynaThres);
    
    /**
     * 查询动态威胁
     * 
     * @param id
     *    动态威胁id
     * @return 动态威胁对象
     **/
    AsseKnowDynaThre find(Integer id);
    
    Object[] findByDwr(String id);
    
    /**
     * 查询动态威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态威胁数量
     **/
    int getCount(AsseInfoProj asseInfoProj,AsseInfoAsse asseInfoAsse);
    
    /**
     * 查询动态威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param dynaVuln
     *            动态脆弱点
     * @return 动态威胁数量
     **/
    int getCount(AsseInfoProj asseInfoProj,AsseKnowDynaVuln dynaVuln);
    
    /**
     * 查询动态威胁分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/
    List<AsseKnowDynaThre> listDynaThrePage(Page page,AsseInfoProj asseInfoProj,AsseInfoAsse asseInfoAsse);
    
    /**
     * 查询脆弱点威胁关联分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param dynaVuln
     *       动态脆弱点
     * @return 分页记录列表
     **/
    List<AsseKnowDynaThre> listDynaVulnThrePage(Page page,AsseInfoProj asseInfoProj,AsseKnowDynaVuln dynaVuln);
    
    /**
     * 查询动态威胁记录
     * @param asseInfoProjId
     *            测评项目Id
     * @return 记录列表
     **/
    List<AsseKnowDynaThre> listDynaThre(Integer asseInfoProjId);
    
    /**
     * 检查是否已存在该威胁
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param asseKnowStatThreId
     *            威胁Id
     * @return 是否已存在
     **/
    boolean checkExitDynaVulnPoint(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse, Integer asseKnowStatThreKindId, Integer asseKnowStatThreId);
    
    /**
     * 查询可能性为高的动态威胁数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为高的动态威胁数目
     */
    Long statHighPossDynaThre(Integer asseInfoProjId);
	
	/**
     * 查询可能性为中的动态威胁数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为中的动态威胁数目
     */
    Long statMiddPossDynaThre(Integer asseInfoProjId);
	
	/**
     * 查询可能性为低的动态威胁点数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为低的动态威胁数目
     */
    Long statLowPossDynaThre(Integer asseInfoProjId);
	
	/**
     * 不同可能性等级的威胁数量统计
     * @param asseInfoProj
     * 测评项目
     * @param asseInfoAsse
     * 资产
     * @param possibility
     * 严重级别
     * @return 不同可能性等级的威胁数量
     */
    Integer statAsseDynaThreNum(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse, String possibility);

	List<AsseKnowDynaThre> findAll(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse);

	List<AsseKnowDynaThre> listAllByVuln(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, AsseKnowDynaVuln dynaVulnPoint);

	List<AsseKnowDynaThre> ListThreByVulnId(int vulnId);
	
}
