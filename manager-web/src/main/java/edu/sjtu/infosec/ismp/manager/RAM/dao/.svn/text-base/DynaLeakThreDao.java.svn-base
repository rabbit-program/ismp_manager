package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeakThre;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 动态资产漏洞威胁分析Dao访问接口.
 * 


 **/
public interface DynaLeakThreDao  {

	/**
     * 保存/更新动态资产漏洞威胁
     * 
     * @param dynaLeakThre
     * 动态资产漏洞威胁
     **/
    void saveOrUpdate(AsseKnowDynaLeakThre dynaLeakThre);
    
    /**
     * 批量保存/更新动态资产漏洞威胁
     * 
     * @param dynaLeakThreList
     * 动态资产漏洞列表
     **/
    void batchSaveOrUpdate(List<AsseKnowDynaLeakThre> dynaLeakThreList);
    
    /**
     * 查询动态资产漏洞威胁
     * 
     * @param id
     *    动态资产漏洞威胁id
     * @return 动态资产漏洞威胁对象
     **/
    AsseKnowDynaLeakThre find(Integer id);
    
    /**
     * 查询动态资产漏洞威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态资产漏洞数量
     **/
    int getCount(AsseInfoProj asseInfoProj,List<AsseInfoAsse> asseInfoAsse);
    
    /**
     * 查询动态资产漏洞威胁记录
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞记录列表
     **/
    List<AsseKnowDynaLeakThre> listDynaLeakThre(AsseInfoProj asseInfoProj);
    
    /**
     * 检查是否已存在该资产漏洞威胁
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param asseKnowStatCveThreId
     *      静态威胁Id
     * @return 是否已存在
     **/
    boolean checkExitDynaLeakThre(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse, Integer asseKnowStatCveThreId);
	
    /**
     * 查询可能性为高的动态漏洞威胁数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为高的动态漏洞威胁数目
     **/
    Long statHighPossDynaLeakThre(Integer asseInfoProjId);
	 
	 /**
	  * 查询可能性为中的动态漏洞威胁数目
	  * @param asseInfoProjId
	  * 测评项目Id
	  * @return 可能性为中的动态漏洞威胁数目
	  **/
    Long statMiddPossDynaLeakThre(Integer asseInfoProjId);
	 
	 /**
	  * 查询可能性为低的动态漏洞威胁点数目
	  * @param asseInfoProjId
	  * 测评项目Id
	  * @return 可能性为低的动态漏洞威胁数目
	  **/
    Long statLowPossDynaLeakThre(Integer asseInfoProjId);
	 
	  /**
	   * 不同可能性等级的漏洞威胁数量统计
	   * @param asseInfoProj
	   * 测评项目
	   * @param asseInfoAsse
	   * 资产
	   * @param possibility
	   * 严重级别
	   * @return 不同可能性等级的漏洞威胁数量
	   **/
    Integer statAsseDynaLeakThreNum(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse, String possibility);

	List<AsseKnowDynaLeakThre> listDynaLeakThrePage(int startResult1,
			int maxResult1, AsseInfoProj asseInfoProj,List<AsseInfoAsse> asseInfo);

	List<AsseKnowDynaLeakThre> listByDynaLeakId(int dynaLeakId);
	   
}
