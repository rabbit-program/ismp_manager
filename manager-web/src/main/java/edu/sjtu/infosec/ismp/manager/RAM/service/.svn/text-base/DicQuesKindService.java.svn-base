package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicQuesKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * 应用层 问题类型数据字典Manager接口.
 * 


 */
public interface DicQuesKindService  {
    
    /**
     * 保存/更新问题类型
     * @param dicQuesKind
     *            问题类型.
     */
     void saveOrUpdate(AsseKnowDicQuesKind dicQuesKind);

    /**
     * 删除问题类型
     * 
     * @param dicQuesKind
     *            问题类型
     */
     void remove(AsseKnowDicQuesKind dicQuesKind);

    /**
     * 查询问题类型
     * 
     * @param quesKindId
     *            问题类型编号
     * @return 问题类型对象
     */
     AsseKnowDicQuesKind find(String quesKindId);

    /**
     * 查询问题类型
     * @param paramMap
     *            查询条件
     * @return 问题类型列表
     */
     List listDicQuesKind(Map paramMap);

    /**
     * 查询问题类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 问题类型记录数
     */
     int getCount(Map paramMap);
    
    /**
     * 查询问题类型分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
     PageResult listDicQuesKindPage(Page page, Map paramMap);
    
}
