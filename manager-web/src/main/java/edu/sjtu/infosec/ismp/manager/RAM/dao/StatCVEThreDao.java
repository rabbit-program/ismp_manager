package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatCVEThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 知识库静态漏洞威胁Dao访问接口.
 * 


 **/
public interface StatCVEThreDao  {

	/**
     * 保存/更新静态漏洞威胁对象
     * @param statCVEThre
     *    静态漏洞威胁对象
     **/
    void saveOrUpdate(AsseKnowStatCVEThre statCVEThre);
    
    /**
     * 删除静态漏洞威胁对象
     * @param statCVEThre
     *   静态漏洞威胁对象
     **/
    void remove(AsseKnowStatCVEThre statCVEThre);
    
    /**
     * 查询静态漏洞威胁
     * @param id
     *    静态漏洞威胁id
     * @return 静态漏洞威胁对象
     **/
    AsseKnowStatCVEThre find(Integer id);
    
    /**
     * 查询静态漏洞威胁
     * @param cveId
     * CVE_ID
     * @return 静态漏洞威胁对象
     **/
    List find(String cveId);
    
    /**
     * 查询静态漏洞威胁数量
     * @return 静态漏洞威胁数量
     **/
    int getCount();
    
    /**
     * 查询静态漏洞威胁分页记录
     * @param page
     *     分页对象
     * @return 分页记录列表
     **/
    List<AsseKnowStatCVEThre> listStatCVEThrePage(Page page);
    
    /**
     * 根据静态威胁类别返回静态漏洞威胁列表
     * @param statThreKind
     *     静态威胁类别
     * @return 静态威胁列表
     **/
	List<AsseKnowStatCVEThre> listStatCVEThre(AsseKnowStatThreKind statThreKind);
	
	/**
     * 根据静态威胁编号返回静态漏洞威胁列表
     * @param threCode
     *    静态威胁编号
     * @return 静态漏洞威胁列表
     **/
	List<AsseKnowStatCVEThre> listStatCVEThre(String threCode);
	
	/**
     * 返回所有静态漏洞威胁
     * @return 静态漏洞威胁列表
     **/
	List<AsseKnowStatCVEThre> listAllStatCVEThre();
	
	List<AsseKnowStatCVEThre> listStatCVEThreByCVEIdScale(List CVEIdList);
}
