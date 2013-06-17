package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 动态脆弱点分析Manager接口.
 * 
 */
public interface VulnAnalService  {

	/**
     * 保存/更新动态脆弱点
     * @param paraMap
     * 参数Map
     * @param dynaVulnPoint
     * 动态脆弱点
     **/
    void saveOrUpdate(Map paraMap, AsseKnowDynaVuln dynaVulnPoint);
    
    /**
     * 批量保存/更新动态脆弱点
     * @param paraMaps
     * 参数Map
     * @param asseInfoProj
     * 测评项目
     **/
    void batchSaveOrUpdate(Map paraMaps, AsseInfoProj asseInfoProj);
    
    /**
     * 删除动态脆弱点
     * 
     * @param dynaVulnPoint
     * 动态脆弱点
     **/
    void remove(String dynaVulnPointId);
    
    /**
     * 批量删除动态脆弱点
     * 
     * @param dynaVulnPoints
     *    动态脆弱点列表
     **/
    void remove(String[] dynaVulnPointIds);
    
    /**
     * 查询动态脆弱点
     * 
     * @param id
     *    动态脆弱点id
     * @return 动态脆弱点对象
     **/
    AsseKnowDynaVuln find(Integer id);
    
    Object[] findByDwr(String id);
    
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
    List<AsseKnowDynaVuln>  listDynaVulnPoint(int startResult,int maxResult,AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse);
    
    /**
     * 查询动态脆弱点记录
     * @param asseInfoProj
     * @return 记录列表
     **/
    List<AsseKnowDynaVuln> listDynaVulnPoint(String asseInfoProjId);
    
    /**
     * 查询动态脆弱点记录
     * @param asseInfoProj
     * 测评项目编号
     * @param asseKnowStatVulnKindId
     * 脆弱点类别编号
     * @return 记录列表
     **/
    List<AsseKnowDynaVuln> listDynaVulnPointByKind(String asseInfoProjId, String asseKnowStatVulnKindId);
    
    List listDynaVulnPointByKindDwr(String asseInfoProjId, String asseKnowStatVulnKindId);
    
    /**
     * 检查是否已存在该脆弱点
     * @param asseInfoProj
     *            测评项目
     * @param statVulnPoinId
     *          脆弱点Id
     * @return 是否已存在
     **/
    boolean checkExitDynaVulnPoint(AsseInfoProj asseInfoProj, String assetCode, Integer statVulnPoinId);

	
}
