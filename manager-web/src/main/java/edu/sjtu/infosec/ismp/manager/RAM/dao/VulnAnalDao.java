package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 动态脆弱点分析Dao访问接口.
 **/
public interface VulnAnalDao  {

	/**
     * 保存/更新动态脆弱点
     * 
     * @param dynaVulnPoint
     * 动态脆弱点
     **/
    void saveOrUpdate(AsseKnowDynaVuln dynaVulnPoint);
    
    /**
     * 批量保存/更新动态脆弱点
     * 
     * @param dynaVulnPoints
     * 动态脆弱点列表
     **/
    void batchSaveOrUpdate(List<AsseKnowDynaVuln> dynaVulnPoints);
    
    /**
     * 删除动态脆弱点
     * 
     * @param dynaVulnPoint
     * 动态脆弱点
     **/
    void remove(AsseKnowDynaVuln dynaVulnPoint);
    
    /**
     * 批量删除动态脆弱点
     * 
     * @param dynaVulnPoints
     *    动态脆弱点列表
     **/
    void remove(List<AsseKnowDynaVuln> dynaVulnPoints);
    
    /**
     * 查询动态脆弱点
     * 
     * @param id
     *    动态脆弱点id
     * @return 动态脆弱点对象
     **/
    AsseKnowDynaVuln find(Integer id);
    
    Object[] findByDwr(Integer id);
    
    /**
     * 查询动态脆弱点数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态脆弱点数量
     **/
	int getCount(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse);
    /**
     * 查询动态脆弱点分页记录
     * @param startResult
     *     分页对象
     * @param maxResult
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/
    List<AsseKnowDynaVuln> listDynaVulnPoint(int startResult,int maxResult,AsseInfoProj asseInfoProj,AsseInfoAsse asseInfoAsse);
    
    /**
     * 查询动态脆弱点记录
     * @param asseInfoProj
     * @return 记录列表
     **/
    List<AsseKnowDynaVuln> listDynaVulnPoint(Integer asseInfoProjId);
    
    /**
     * 查询动态脆弱点记录
     * @param asseInfoProj
     * 测评项目编号
     * @param asseKnowStatVulnKindId
     * 脆弱点类别编号
     * @return 记录列表
     **/
    List<AsseKnowDynaVuln> listDynaVulnPointByKind(Integer asseInfoProjId, Integer asseKnowStatVulnKindId);
    
    List listDynaVulnPointByKindDwr(String asseInfoProjId, String asseKnowStatVulnKindId);
    
    /**
     * 检查是否已存在该脆弱点
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param asseKnowStatVulnPoinId
     *            脆弱点Id
     * @return 是否已存在
     **/
    boolean checkExitDynaVulnPoint(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse, Integer asseKnowStatVulnPoinId);
    
    /**
     * 查询严重性为高的动态脆弱点数目
     * @param inst
     * 被测机构
     * @return 严重性为高的动态脆弱点数目
     */
    Long statHighSeriDynaVulnPoint(Integer asseInfoProjId);
	 
	 /**
	  * 查询严重性为中的动态脆弱点数目
	  * @param inst
	  * 被测机构
	  * @return 严重性为中的动态脆弱点数目
	  */
    Long statMiddSeriDynaVulnPoint(Integer asseInfoProjId);
	  
	  /**
	   * 查询严重性为低的动态脆弱点数目
	   * @param inst
	   * 被测机构
	   * @return 严重性为低的动态脆弱点数目
	   */
    Long statLowSeriDynaVulnPoint(Integer asseInfoProjId);
		
		/**
	     * 不同资产各等级漏洞数目统计
	     * @param asseInfoProj
	     * 测评项目
	     * @param asseInfoAsse
	     * 资产
	     * @param seriLeve
	     * 严重级别
	     * @return 不同资产各等级漏洞数目
	     */
    Integer statAsseDynaVulnPointNum(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse, String seriLeve);


}
