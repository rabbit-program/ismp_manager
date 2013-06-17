package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 应用层 业务录入Manager接口.
 */
public interface BusinessService  {

    /**
     * 保存/更新业务信息
     */
    void saveOrUpdate(AsseInfoBusi business);

    /**
     * 删除业务信息
     */
    void remove(String businessId);

    /**
     * 批量删除业务信息
     */
    void remove(String [] businessIds);
    
    /**
     * 查询业务信息
     */
    AsseInfoBusi findByBusinessId(String businessId);

    /**
     * 查询该委办局所有业务信息
     */
    List<AsseInfoBusi> find(Domain domain);

    /**
     * 查询业务信息记录数
     */
    int getCount(Domain domain);

    /**
     * 查询业务信息分页记录
     */
   List<AsseInfoBusi> findAll(int startResult, int maxResult,Domain domain);    
}
