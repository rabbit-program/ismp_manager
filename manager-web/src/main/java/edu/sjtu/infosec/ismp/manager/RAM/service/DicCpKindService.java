package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicCpKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 测评类型数据字典Manager接口.
 * 


 */
public interface DicCpKindService  {

    /**
     * 保存/更新测评类型
     * .
     * @param dicCpKind
     *  测评类型
     */
     void saveOrUpdate(AsseKnowDicCpKind dicCpKind);

    /**
     * 删除测评类型..
     * 
     * @param dicCpKind
     *            测评类型
     */
     void remove(AsseKnowDicCpKind dicCpKind);

    /**
     * 查询测评类型
     * 
     * @param cpKindId
     *            测评类型编号
     * @return 测评类型对象
     */
     AsseKnowDicCpKind find(String cpKindId);

    /**
     * 查询测评类型
     * @param paramMap
     *            查询条件
     * @return 测评类型列表
     */
     List listDicCpKind(Map paramMap);

    /**
     * 查询测评类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 测评类型记录数
     */
     int getCount(Map paramMap);
    
    /**
     * 查询测评类型分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
     List listDicCpKindPage(Page page, Map paramMap);
    
}
