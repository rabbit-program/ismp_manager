package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicSecuLeve;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 安全级别数据字典Manager接口.
 * 


 */
public interface DicSecuLeveService  {

    /**
     * 保存/更新安全级别
     * 
     * @param dicSecuLeve
     *            安全级别
     */
     void saveOrUpdate(AsseKnowDicSecuLeve dicSecuLeve);

    /**
     * 删除安全级别
     * 
     * @param dicSecuLeve
     *            安全级别
     */
     void remove(AsseKnowDicSecuLeve dicSecuLeve);

    /**
     * 查询安全级别
     * 
     * @param secuLeveId
     *            安全级别编号
     * @return 安全级别对象
     */
     AsseKnowDicSecuLeve find(String secuLeveId);

    /**
     * 查询安全级别
     * @param paramMap
     *            查询条件
     * @return 安全级别列表
     */
     List listDicSecuLeve(Map paramMap);
     
     List findAll();

    /**
     * 查询安全级别记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 安全级别记录数
     */
     int getCount(Map paramMap);
    
    /**
     * 查询安全级别分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
     List listDicSecuLevePage(Page page, Map paramMap);
    
}
