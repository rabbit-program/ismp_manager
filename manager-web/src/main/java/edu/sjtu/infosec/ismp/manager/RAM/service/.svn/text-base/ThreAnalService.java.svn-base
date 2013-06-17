package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaThre;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 动态威胁分析Manager接口.
 * 


 */
public interface ThreAnalService  {

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
    void remove(String[] dynaThreIds);
    
    /**
     * 查询动态威胁
     * 
     * @param id
     *    动态威胁id
     * @return 动态威胁对象
     **/
    AsseKnowDynaThre find(String id);
    
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
     * @param dynaVulnPointId
     *       动态脆弱点Id
     * @return 动态威胁数量
     **/
    int getCount(AsseInfoProj asseInfoProj,String dynaVulnPointId);
    
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
    PageResult listDynaThrePage(Page page,AsseInfoProj asseInfoProj,AsseInfoAsse asseInfoAsse);
    
    /**
     * 查询脆弱点威胁关联分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param dynaVulnPointId
     *       动态脆弱点Id
     * @return 分页记录列表
     **/
    PageResult listDynaVulnThrePage(Page page,AsseInfoProj asseInfoProj,String dynaVulnPointId);
    
    List<AsseKnowDynaThre> listAllByVuln(int startResult, int maxResult,AsseInfoProj asseInfoProj, String vulnIdSelect);
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
     * 脆弱点分析后，返回该测评项目动态威胁列表
     * @param asseInfoProjId
     *            测评项目Id
     * @return 是否已存在
     **/
    List listDynaThresByDynaVuln(String asseInfoProjId);
    
    /**
     * 脆弱点分析后，批量保存该测评项目动态威胁点
     * @param asseInfoProjId
     *            测评项目Id
     **/
    void batchSaveDynaThres(String asseInfoProjId);
    
    /**
     * 批量进行威胁与资产关联
     * @param paraMaps
     * 参数Map
     * @param asseInfoProj
     * 测评项目
     **/
    void relateToAssert(Map paraMaps, AsseInfoProj asseInfoProj);
    
    /**
     * 批量进行动态威胁与动态脆弱点关联
     * @param paraMaps
     * 参数Map
     * @param asseInfoProj
     * 测评项目
     **/
    void relateToVuln(Map paraMaps, AsseInfoProj asseInfoProj);

	List<AsseKnowDynaThre> findAll(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse);
	
	List<AsseKnowDynaThre> ListThreByVulnId(int vulnId);
}
