package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaElemResu;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 知识库资产评估要素结果Manager接口.
 * 


 */
public interface DynaElemResuService  {

	/**
     * 批量保存/更新项目资产评估要素
     * @param dynaElemResuList
     *    资产评估要素集合
     **/
     void batchSaveOrUpdate(List<AsseKnowDynaElemResu> dynaElemResuList);
	
	/**
     * 保存/更新项目资产评估要素
     * @param dynaElemResu
     *     项目资产评估要素
     **/
     void saveOrUpdate(AsseKnowDynaElemResu dynaElemResu);

    /**
     * 删除项目资产评估要素
     * @param dynaElemResu
     *     项目资产评估要素
     **/
     void remove(AsseKnowDynaElemResu dynaElemResu);

    /**
     * 查询项目资产评估要素
     * @param id
     * 资产评估要素id
     * @return 资产评估要素对象
     **/
     AsseKnowDynaElemResu find(String id);
     
     
      
    /**
     * 返回项目资产评估要素列表
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目资产评估要素列表
     **/
     List<AsseKnowDynaElemResu> listDynaElemResu(String asseInfoProjId);

     /**
      * 检查是否已存在该项目资产评估要素列表
      * @param asseInfoProjId
      * 测评项目id
      * @return true/false
      **/
     boolean checkExit(String asseInfoProjId);
     
    /**
     * 查询项目资产评估要素记录数
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目资产评估要素记录数
     **/
     int getCount(String asseInfoProjId);
    
    /**
     * 查询项目资产评估要素分页记录
     * @param page
     * 分页对象
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
     List<AsseKnowDynaElemResu> listDynaElemResuPage(Integer startResult, Integer maxResult, String asseInfoProjId);
     
     /**
      * 统计风险值
      * @param asseInfoProjId
      * 测评项目id
      * @return 风险值
      **/
     List statRiskValue(Integer asseInfoProjId);
}
