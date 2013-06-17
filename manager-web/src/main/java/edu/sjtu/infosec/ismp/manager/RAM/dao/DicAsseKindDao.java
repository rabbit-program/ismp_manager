package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * 数据层 资产类型数据字典Dao访问接口.
 * 


 */
public interface DicAsseKindDao  {
    /**
     * 保存/更新资产类型.
     * @param dicAsseKind
     *            资产类型
     */
     void saveOrUpdate(AsseKnowDicAsseKind dicAsseKind);

    /**
     * 删除资产类型
     * 
     * @param dicAsseKind
     *            资产类型
     */
     void remove(AsseKnowDicAsseKind dicAsseKind);

    /**
     * 查询资产类型
     * 
     * @param assetKindId
     *            资产类型编号
     * @return 资产类型对象
     */
     AsseKnowDicAsseKind find(String assetKindId);

     /**
      * 查询资产类型
      * 
      * @param id
      *            资产类型id
      * @return 资产类型对象
      */
     AsseKnowDicAsseKind find(Integer id);
     
    /**
     * 查询资产类型
     * @param paramMap
     *            查询条件
     * @return 资产类型列表
     */
     List listDicAsseKind(Map paramMap);
     List listDicAsseKindByid();
    /**
     * 查询资产类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 资产类型记录数
     */
     int getCount(Map paramMap);
    
     /**
      * 查询资产类型分页记录
      * 
      * @param page
      *            分页对象
      * @param paramMap
      *            查询条件
      * @return 分页记录列表
      */
      List listDicAsseKindPage(Page page, Map paramMap);
    
      /**
       * 查询资产类型树父节点
       * @return 资产类型树父节点列表
       */
      List listRootNode();
      List listRootNode1();
      
      /**
       * 查询选择的资产类型
       * @return 选择的资产类型列表
       */
      List listChildNode();
      List listChildNode1();
      
      List listChildNode(String assetKindId);
}
