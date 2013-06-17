package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态脆弱点类别Dao访问接口.
 * 


 **/
public interface StatVulnKindDao  {

    /**
     * 保存/更新静态脆弱点类别对象
     * 
     * @param statVulnKind
     *    静态脆弱点类别对象
     **/
    void saveOrUpdate(AsseKnowStatVulnKind statVulnKind);
    
    /**
     * 删除静态脆弱点类别对象
     * 
     * @param statVulnKind
     *   静态脆弱点类别对象
     **/
    void remove(AsseKnowStatVulnKind statVulnKind);
    
    /**
     * 查询静态脆弱点类别
     * 
     * @param id
     *    静态脆弱点类别id
     * @return 静态脆弱点类别对象
     **/
    AsseKnowStatVulnKind find(Integer id);
    
    /**
     * 查询静态脆弱点类别数量
     * @return 静态脆弱点类别数量
     **/
    int getCount();
    
    /**
     * 查询静态脆弱点类别分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    List<AsseKnowStatVulnKind> listStatVulnKindPage(Page page);
    
    /**
     * 返回所有静态脆弱点类别记录
     * @return 所有静态脆弱点类别列表
     **/
    List<AsseKnowStatVulnKind> listAllStatVulnKinds();
}
