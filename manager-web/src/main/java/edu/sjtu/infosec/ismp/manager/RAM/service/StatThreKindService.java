package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 静态威胁类别Manager接口.
 * 


 */
public interface StatThreKindService  {

	/**
     * 保存/更新静态威胁类别对象
     * 
     * @param statThreKind
     *    静态脆弱点类别对象
     **/
    void saveOrUpdate(AsseKnowStatThreKind statThreKind);
    
    /**
     * 删除静态威胁类别对象
     * 
     * @param statThreKind
     *   静态威胁类别对象
     **/
    void remove(AsseKnowStatThreKind statThreKind);
    
    /**
     * 查询静态威胁类别
     * 
     * @param id
     *    静态威胁类别id
     * @return 静态威胁类别对象
     **/
    AsseKnowStatThreKind find(String id);
    
    AsseKnowStatThreKind findByKind(String kind);
    
    /**
     * 查询静态威胁类别数量
     * @return 静态威胁类别数量
     **/
    int getCount();
    
    /**
     * 查询静态威胁类别分页记录
     * @param page
     * 分页对象
     * @return 分页记录列表
     **/
    PageResult listStatThreKindPage(Page page);
    
    /**
     * 返回所有静态威胁类别
     * @return 所有静态威胁类别列表
     **/
    List<AsseKnowStatThreKind> listAllStatThreKind();
}
