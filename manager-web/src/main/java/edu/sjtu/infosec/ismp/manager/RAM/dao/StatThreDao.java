package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态威胁Dao访问接口.
 * 


 **/
public interface StatThreDao  {

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
    AsseKnowStatThre find(Integer id);
    
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
    List<AsseKnowStatThre> listStatThrePage(Page page);
    
    /**
     * 根据静态威胁类别返回静态威胁列表
     * @param asseInfoProjId
     *     测评项目编号
     * @param statThreKind
     *     静态威胁类别
     * @return 静态威胁列表
     **/
	List<AsseKnowStatThre> listStatThre(Integer asseInfoProjId, AsseKnowStatThreKind statThreKind);
	
	/**
     * 根据静脆弱点返回静态威胁列表
     * @param vulnPoin
     *    静态脆弱点
     * @return 静态威胁列表
     **/
	List<AsseKnowStatThre> listStatThreByVulnPoin(AsseKnowStatVulnPoin vulnPoin);
	
	/**
     * 返回所有静态威胁
     * @return 静态威胁列表
     **/
	List<AsseKnowStatThre> listAllStatThre();
}
