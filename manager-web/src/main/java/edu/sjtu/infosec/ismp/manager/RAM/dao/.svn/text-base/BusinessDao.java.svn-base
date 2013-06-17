package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.security.Domain;


/**
 * 数据层 业务录入Dao访问接口.
 */
public interface BusinessDao  {

    /**
     * 保存/更新业务信息
     */
    void saveOrUpdate(AsseInfoBusi business);

    /**
     * 删除业务信息
     */
    void remove(AsseInfoBusi business);

    /**
     * 批量删除业务信息
     */
    void remove(List<AsseInfoBusi> businessList);
    
    /**
     * 查询业务信息
     */
    AsseInfoBusi find(String businessId);

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
