package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseStat;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 测评状态数据字典Manager接口.
 * 


 */
public interface DicAsseStatService  {

    /**
     * 保存/更新测评状态
     * 
     * @param dicAsseStat
     *            测评状态
     */
     void saveOrUpdate(AsseKnowDicAsseStat dicAsseStat);

    /**
     * 删除测评状态
     * @param dicAsseStat
     * 测评状态
     */
     void remove(AsseKnowDicAsseStat dicAsseStat);

    /**
     * 查询测评状态.
     * 
     * @param asseStatId
     *            测评状态编号
     * @return 测评状态对象
     */
     AsseKnowDicAsseStat find(String asseStatId);

    /**
     * 查询测评状态
     * @param paramMap
     *            查询条件
     * @return 测评状态列表
     */
     List listDicAsseStat(Map paramMap);

    /**
     * 查询测评状态记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 测评状态记录数
     */
     int getCount(Map paramMap);
    
    /**
     * 查询测评状态分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
     List listDicAsseStatPage(Page page, Map paramMap);
    
}
