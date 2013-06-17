package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicRiskMatrRule;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 风险矩阵字典表Manager接口.
 * 


 */
public interface DicRiskMatrRuleService  {

	/**
     * 保存/更新矩阵规则
     * 
     * @param dicRiskMatrRule
     *            矩阵规则
     */
     void saveOrUpdate(AsseKnowDicRiskMatrRule dicRiskMatrRule);

    /**
     * 删除矩阵规则
     * 
     * @param dicRiskMatrRule
     *            矩阵规则
     */
     void remove(AsseKnowDicRiskMatrRule dicRiskMatrRule);

    /**
     * 查询矩阵规则
     * 
     * @param id
     *            矩阵规则id
     * @return 矩阵规则对象
     */
     AsseKnowDicRiskMatrRule find(String id);
     
     /**
      * 查询矩阵规则
      * @param asseImpo
      * 资产重要性
      * @param vulnSeri
      * 脆弱点严重性
      * @param threPoss
      * 威胁发生可能性
      * @return 矩阵规则对象
      */
      AsseKnowDicRiskMatrRule find(String asseImpo, String vulnSeri, String threPoss);

    /**
     * 返回所有矩阵规则
     * @return 矩阵规则列表
     */
     List<AsseKnowDicRiskMatrRule> listAllDicRiskMatrRule();

    /**
     * 查询矩阵规则记录数
     * @return 矩阵规则记录数
     */
     int getCount();
    
    /**
     * 查询矩阵规则分页记录
     * 
     * @param page
     *            分页对象
     * @return 分页记录列表
     */
     PageResult listDicRiskMatrRulePage(Page page);
}
