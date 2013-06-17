package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaElemResu;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;



/**
 * 数据层 知识库资产评估要素结果Dao访问接口.
 * 


 **/
public interface DynaElemResuDao  {

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
     AsseKnowDynaElemResu find(Integer id);
     
     
      
    /**
     * 返回项目资产评估要素列表
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目资产评估要素列表
     **/
     List<AsseKnowDynaElemResu> listDynaElemResu(Integer asseInfoProjId);

     boolean checkAlertType(String type, String subType, String category);
     
    // void sendAlert(AlertInfoBO alertInfo);
     
    /**
     * 查询项目资产评估要素记录数
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目资产评估要素记录数
     **/
     int getCount(Integer asseInfoProjId);
    
    /**
     * 查询项目资产评估要素分页记录
     * @param page
     * 分页对象
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
     List<AsseKnowDynaElemResu> listDynaElemResuPage(Integer startResult, Integer maxResult, Integer asseInfoProjId);
     
     /**
      * 统计风险值
      * @param asseInfoProjId
      * 测评项目id
      * @return 风险值
      **/
     List statRiskValue(Integer asseInfoProjId);
     
     /**
      * 查询风险为高的资产数目
      * @param asseInfoProjId
      * 测评项目Id
      * @param asseInfoAsse
      * 资产
      * @return 风险为高的资产数目
      */
     Integer statHighRiskAsse(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse);
 	 
 	/**
     * 风险为中的资产数目
     * @param asseInfoProjId
     * 测评项目Id
     * @param asseInfoAsse
     * 资产
     * @return 风险为中的资产数目
     */
     Integer statMiddRiskAsse(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse);
 	 
 	/**
     * 风险为低的资产数目
     * @param asseInfoProjId
     * 测评项目Id
     * @param asseInfoAsse
     * 资产
     * @return 风险为低的资产数目
     */
     Integer statLowRiskAsse(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse);
 	
 	
}
