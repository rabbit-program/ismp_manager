package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseValue;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 知识库项目总体评估值Manager接口.
 * 


 */
public interface DynaAsseValueService  {

	
	
	/**
     * 保存/更新项目总体评估值
     * 
     * @param dynaAsseValue
     *        项目总体评估值
     **/
     void saveOrUpdate(AsseKnowDynaAsseValue dynaAsseValue);

    /**
     * 删除矩阵规则
     * @param dynaAsseValue
     *        项目总体评估值
     **/
     void remove(AsseKnowDynaAsseValue dynaAsseValue);

    /**
     * 查询项目总体评估值
     * @param id
     * 项目总体评估值id
     * @return 项目总体评估值对象
     **/
     AsseKnowDynaAsseValue findById(String id);
     
     /**
      * 查询项目总体评估值
      * @param projCode
      * 测评项目id
      * @return 项目总体评估值对象
      **/
      AsseKnowDynaAsseValue find(String projCode);
      
      /**
       * 检查是否已存在该项目总体评估值
       * @param projCode
       * 测评项目id
       * @return true/false
       **/
      boolean checkExit(String projCode);
      
    /**
     * 返回项目总体评估值
     * @param projCode
     * 测评项目id
     * @return 项目总体评估值列表
     **/
     List<AsseKnowDynaAsseValue> listDynaAsseValue(String projCode);

    /**
     * 查询项目总体评估值记录数
     * @param projCode
     * 测评项目id
     * @return 项目总体评估值记录数
     **/
     int getCount(String projCode);
    
    /**
     * 查询矩阵规则分页记录
     * @param page
     * 分页对象
     * @param projCode
     * 测评项目id
     * @return 分页记录列表
     **/
     PageResult listDynaAsseValuePage(Page page, String projCode);
     
     Object[] getExpQuesAndAdvice(String projCode);
}
