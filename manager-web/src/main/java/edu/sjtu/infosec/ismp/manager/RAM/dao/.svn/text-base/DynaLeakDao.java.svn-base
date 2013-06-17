package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * 数据层 动态资产漏洞分析Dao访问接口.
 * 


 **/
public interface DynaLeakDao  {

	/**
     * 保存/更新动态资产漏洞
     * 
     * @param dynaLeak
     * 动态资产漏洞
     **/
    void saveOrUpdate(AsseKnowDynaLeak dynaLeak);
    
    /**
     * 批量保存/更新动态资产漏洞
     * 
     * @param dynaLeakList
     * 动态资产漏洞列表
     **/
    void batchSaveOrUpdate(List<AsseKnowDynaLeak> dynaLeakList);
    
    /**
     * 查询动态资产漏洞
     * 
     * @param id
     *    动态资产漏洞id
     * @return 动态资产漏洞对象
     **/
    AsseKnowDynaLeak find(Integer id);
    
    /**
     * 查询动态资产漏洞数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态资产漏洞数量
     **/
    int getCount(AsseInfoProj asseInfoProj,List<AsseInfoAsse> asseInfoAsse);
    
    /**
     * 查询动态资产漏洞分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/
	List<AsseKnowDynaLeak> listDynaLeakPage(int startResult, int maxResult,AsseInfoProj asseInfoProj, List<AsseInfoAsse> asseInfoAsse);
    
    /**
     * 查询动态资产漏洞记录
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞记录列表
     **/
    List<AsseKnowDynaLeak> listDynaLeak(AsseInfoProj asseInfoProj);
    
    /**
     * 检查是否已存在该资产漏洞
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param pluginId
     *      插件Id
     * @param vulId
     *      漏洞Id
     * @return 是否已存在
     **/
    boolean checkExitDynaLeak(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse, String pluginId, String vulId);
    
    /**
     * 查询严重性为高的动态资产漏洞数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为高的动态资产漏洞数目
     */
    Long statHighRiskLeak(Integer asseInfoProjId);
	
	/**
     * 查询严重性为中的动态资产漏洞数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为中的动态资产漏洞数目
     */
    Long statMiddRiskLeak(Integer asseInfoProjId);
	
	/**
     * 查询严重性为低的动态资产漏洞数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为低的动态资产漏洞数目
     */
    Long statLowRiskLeak(Integer asseInfoProjId);
	
	/**
     * 不同资产各等级漏洞数目统计
     * @param asseInfoProj
     * 测评项目
     * @param asseInfoAsse
     * 资产
     * @param seriLeve
     * 严重级别
     * @return 严重性为低的动态脆弱点数目
     */
    Integer statDynaLeakNum(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse, String seriLeve);

}
