package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 静态威胁Manager接口.
 * 


 */
public interface StatThreService  {

	/**
     * 保存/更新静态威胁对象
     * @param statThre
     *    静态威胁对象
     **/
    void saveOrUpdate(AsseKnowStatThre statThre);
    
    /**
     * 删除静态威胁对象
     * @param statThre
     *   静态威胁对象
     **/
    void remove(AsseKnowStatThre statThre);
    
    /**
     * 查询静态威胁
     * @param id
     *    静态威胁id
     * @return 静态威胁对象
     **/
    AsseKnowStatThre find(String id);
    
    /**
     * 查询静态威胁数量
     * @return 静态威胁数量
     **/
    int getCount();
    
    /**
     * 查询静态威胁分页记录
     * @param page
     *     分页对象
     * @return 分页记录列表
     **/
    PageResult listStatThrePage(Page page);
    
    /**
     * 根据静态威胁类别返回测评项目未选的静态威胁点
     * @param asseInfoProjId
     *     测评项目编号
     * @param statThreKind
     *     静态威胁类别
     * @return 静态威胁列表
     **/
	List<AsseKnowStatThre> listStatThre(String asseInfoProjId, AsseKnowStatThreKind statThreKind);
	
	/**
     * 返回所有静态威胁
     * @return 静态威胁列表
     **/
	List<AsseKnowStatThre> listAllStatThre();
}
