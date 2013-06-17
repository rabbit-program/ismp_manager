package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeakThre;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 动态资产漏洞威胁分析Manager接口.
 * 


 */
public interface DynaLeakThreService  {

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
    AsseKnowDynaLeakThre find(String id);
    
    /**
     * 查询动态资产漏洞威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfo
     *            资产
     * @return 动态资产漏洞数量
     **/
    int getCount(AsseInfoProj asseInfoProj,List<AsseInfoAsse> asseInfo);
    
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
    boolean checkExitDynaLeakThre(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse, String asseKnowStatCveThreId);
    
    /**
     * 检查是否已存在该资产漏洞
     * @param asseInfoProj
     *            测评项目
     * @return 是否已存在
     **/
    boolean checkExitDynaLeakThreList(AsseInfoProj asseInfoProj);
    
    /**
     * 保存动态资产漏洞威胁
     * @param asseInfoProj
     *            测评项目
     **/
    void saveDynaLeakThre(AsseInfoProj asseInfoProj);
    
    /**
     * 漏洞与威胁关联
     * @param paraMap
     * 参数Map
     * @param asseInfoProj
     *            测评项目
     **/
    void relateLeakToThre(Map paraMap, AsseInfoProj asseInfoProj);

	List<AsseKnowDynaLeakThre> listDynaLeak(int startResult1, int maxResult1,
			AsseInfoProj asseInfoProj, List<AsseInfoAsse> asseInfo);
    
	List<AsseKnowDynaLeakThre> listByDynaLeakId(int dynaLeakId);
}
