package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatSecuElem;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态安全要素Dao访问接口.
 * 


 **/
public interface StatSecuElemDao  {

    /**
     * 保存/更新静态安全要素
     * 
     * @param statSecuElem
     *         静态安全要素
     **/
    void saveOrUpdate(AsseKnowStatSecuElem statSecuElem);
    
    /**
     * 删除静态安全要素
     * 
     * @param statSecuElem
     *         静态安全要素
     **/
    void remove(AsseKnowStatSecuElem statSecuElem);
    
    /**
     * 批量删除静态安全要素
     * 
     * @param statSecuElemList
     *     静态安全要素对象列表
     **/
    void remove(List<AsseKnowStatSecuElem> statSecuElemList);
    
    /**
     * 查询静态安全要素
     * 
     * @param elemCode
     *        要素编码
     * @return 静态安全要素对象
     **/
    AsseKnowStatSecuElem find(String elemCode);
    
    /**
     * 查询静态安全要素
     * 
     * @param id
     *    要素id
     * @return 静态安全要素对象
     **/
    AsseKnowStatSecuElem find(Integer id);
    
    /**
     * 查询静态安全要素数量
     * @return 静态安全要素数量
     **/
    int getCount();
    
    /**
     * 查询静态安全要素分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    List<AsseKnowStatSecuElem> listStatSecuElemPage(Page page);
    
    /**
     * 返回静态安全要素树各个根节点列表
     * @return 静态安全要素根节点列表
     **/
    List<AsseKnowStatSecuElem> findTree();

	List<AsseKnowStatSecuElem> listStatSecuElem();
}
