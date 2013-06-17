package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicProg;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 评估流程数据字典Manager接口.
 * 


 */
public interface DicProgService  {

    /**
     * 保存/更新评估流程
     * @param dicProg
     *            评估流程.
     */
     void saveOrUpdate(AsseKnowDicProg dicProg);

    /**
     * 删除评估流程
     * 
     * @param dicProg
     *            评估流程
     */
     void remove(AsseKnowDicProg dicProg);

    /**
     * 查询评估流程
     * 
     * @param progId
     *            评估流程编号
     * @return 评估流程对象
     */
     AsseKnowDicProg find(String progId);

    /**
     * 查询评估流程
     * @param paramMap
     *            查询条件
     * @return 评估流程列表
     */
     List listDicProg(Map paramMap);

    /**
     * 查询评估流程记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 评估流程记录数
     */
     int getCount(Map paramMap);
    
    /**
     * 查询评估流程分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
     List listDicProgPage(Page page, Map paramMap);
    
}
