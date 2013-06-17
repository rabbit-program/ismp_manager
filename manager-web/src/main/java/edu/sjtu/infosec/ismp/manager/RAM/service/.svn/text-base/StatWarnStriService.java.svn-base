package edu.sjtu.infosec.ismp.manager.RAM.service;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatWarnStri;

/**
 * 应用层 知识库静态安全阈值Manager接口.
 * 


 */
public interface StatWarnStriService  {

	/**
     * 保存/更新静态安全阈值对象
     * 
     * @param statWarnStri
     *    静态安全阈值对象
     **/
    void saveOrUpdate(AsseKnowStatWarnStri statWarnStri);
    
    /**
     * 删除静态安全阈值对象
     * 
     * @param statWarnStri
     *   静态安全阈值对象
     **/
    void remove(AsseKnowStatWarnStri statWarnStri);
    
    /**
     * 查询静态安全阈值
     * 
     * @param id
     *    静态安全阈值id
     * @return 静态安全阈值对象
     **/
    AsseKnowStatWarnStri find(Integer id);
    
    /**
     * 获取静态安全阈值
     * @return 静态安全阈值
     **/
    AsseKnowStatWarnStri getWarnStri();
    
    /**
     * 返回是否告警
     * @return y/n
     **/
    String retIsWarn(Integer vulnHighNum,Integer vulnMiduNum,Integer vulnLowNum);
}
