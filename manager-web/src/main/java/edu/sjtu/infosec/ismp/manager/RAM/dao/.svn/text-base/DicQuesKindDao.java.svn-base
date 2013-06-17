package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicQuesKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;



/**
 * 数据层 问题类型数据字典Dao访问接口.
 * 


 */
public interface DicQuesKindDao  {
    
    /**
     * 保存/更新问题类型
     * 
     * @param dicQuesKind
     *            问题类型
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
     * @param id
     *            问题类型id
     * @return 问题类型对象
     */
     AsseKnowDicQuesKind find(Integer id);

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
     List listDicQuesKindPage(Page page, Map paramMap);
    
}
