package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态脆弱点Dao访问接口.
 * 


 **/
public interface StatVulnPoinDao  {

    /**
     * 保存/更新静态脆弱点对象
     * 
     * @param statVulnKind
     *    静态脆弱点类别对象
     **/
    void saveOrUpdate(AsseKnowStatVulnPoin statVulnPoin);
    
    /**
     * 删除静态脆弱点对象
     * 
     * @param statVulnKind
     *   静态脆弱点类别对象
     **/
    void remove(AsseKnowStatVulnPoin statVulnPoin);
    
    /**
     * 查询静态脆弱点
     * 
     * @param id
     *    静态脆弱点类别id
     * @return 静态脆弱点类别对象
     **/
    AsseKnowStatVulnPoin find(Integer id);
    
    /**
     * 查询静态脆弱点数量
     * @return 静态脆弱点数量
     **/
    int getCount();
    
    /**
     * 查询静态脆弱点分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    List<AsseKnowStatVulnPoin> listStatVulnPoinPage(Page page);
    
    /**
     * 根据静态脆弱点类别返回该项目未选静态脆弱点列表
     * @param statVulnKind
     *     静态脆弱点类别
     * @return 静态脆弱点列表
     **/
	List<AsseKnowStatVulnPoin> listStatVulnPoin(Integer asseInfoProjId, AsseKnowStatVulnKind statVulnKind);
	
	/**
     * 返回所有静态脆弱点
     * @return 静态脆弱点列表
     **/
	List<AsseKnowStatVulnPoin> listAllStatVulnPoin();
	
	/**
     * 返回所有静态脆弱点
     * @return 静态脆弱点列表
     **/
	List<AsseKnowStatVulnPoin> listStatVulnPoinByKind(AsseKnowStatVulnKind vulnKind);
}
