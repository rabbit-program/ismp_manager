package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseResu;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 知识库项目动态评估结果Dao访问接口.
 * 


 **/
public interface DynaAsseResuDao  {
	
	/**
     * 批量保存/更新项目动态评估结果
     * @param dynaAsseResuList
     *     项目动态评估结果集合
     **/
     void batchSaveOrUpdate(List<AsseKnowDynaAsseResu> dynaAsseResuList);
	
	/**
     * 保存/更新项目动态评估结果
     * @param dynaAsseResu
     *     项目动态评估结果
     **/
     void saveOrUpdate(AsseKnowDynaAsseResu dynaAsseResu);

    /**
     * 删除项目动态评估结果
     * @param dynaAsseResu
     *     项目动态评估结果
     **/
     void remove(AsseKnowDynaAsseResu dynaAsseResu);

    /**
     * 查询项目动态评估结果
     * @param id
     * 动态评估结果id
     * @return 动态评估结果对象
     **/
     AsseKnowDynaAsseResu find(Integer id);
     
     
      
    /**
     * 返回项目动态评估结果列表
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目动态评估结果列表
     **/
     List<AsseKnowDynaAsseResu> listDynaAsseResu(Integer asseInfoProjId);

    /**
     * 查询项目总体评估值记录数
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目总体评估值记录数
     **/
     int getCount(Integer asseInfoProjId);
    
    /**
     * 查询项目动态评估结果分页记录
     * @param page
     * 分页对象
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
     List<AsseKnowDynaAsseResu> listDynaAsseResuPage(Page page, Integer asseInfoProjId);
     
     /**
      * 统计此次项目资产风险值
      * @param asseInfoProjId
      * 测评项目id
      * @return 分页记录列表
      **/
     List listRiskNumByAsse(Integer asseInfoProjId);
}
