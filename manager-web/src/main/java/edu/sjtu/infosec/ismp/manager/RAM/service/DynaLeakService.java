package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 动态资产漏洞分析Manager接口.
 * 


 */
public interface DynaLeakService  {

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
    AsseKnowDynaLeak find(String id);
    
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
    List<AsseKnowDynaLeak> listDynaLeakPage(int startResult, int maxResult,AsseInfoProj asseInfoProj,List<AsseInfoAsse> asseInfoAsse);
    
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
     * 检查是否已存在该资产漏洞
     * @param asseInfoProj
     *            测评项目
     * @return 是否已存在
     **/
    boolean checkExitDynaLeakList(AsseInfoProj asseInfoProj);
    
    /**
     * 保存动态资产漏洞
     * @param asseInfoProj
     *            测评项目
     **/
    void saveDynaLeak(AsseInfoProj asseInfoProj);
    
    /**
     * 漏洞与资产关联
     * @param paraMap
     * 参数Map
     **/
    void relateLeakToAssert(Map paraMap);
    
}
