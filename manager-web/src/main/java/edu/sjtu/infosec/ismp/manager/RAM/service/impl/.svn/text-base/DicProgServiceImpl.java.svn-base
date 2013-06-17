package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicProgDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicProg;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicProgService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 评估流程数据字典Manager实现类.
 * 


 */
public class DicProgServiceImpl  implements DicProgService {
 
    /**
     * 评估流程数据访问对象接口
     */
    private DicProgDao dicProgDao;
    
    /**
     * @param dicprogDao
     *            评估流程数据访问对象接口(Spring Ioc容器依赖注入)
     */
    public void setDicProgDao(DicProgDao dicprogDao) {
        this.dicProgDao = dicprogDao;
    }

    /**
     * 查询评估流程
     * 
     * @param progId
     *            评估流程编号
     * @return 评估流程对象
     */
    public AsseKnowDicProg find(String progId) {
        
        return dicProgDao.find(progId);
    }

    /**
     * 查询评估流程记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 评估流程记录数
     */
    public int getCount(Map paramMap) {
        
        return dicProgDao.getCount(paramMap);
    }

    /**
     * 查询评估流程
     * @param paramMap
     *            查询条件
     * @return 评估流程列表
     */
    public List listDicProg(Map paramMap) {
        
        return dicProgDao.listDicProg(paramMap);
    }

    /**
     * 查询评估流程分页记录
     * ...
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicProgPage(Page page, Map paramMap) {
        
        return dicProgDao.listDicProgPage(page, paramMap);
    }

    /**
     * 删除评估流程
     * 
     * @param dicProg
     *            评估流程
     */
    public void remove(AsseKnowDicProg dicProg) {
        
        dicProgDao.remove(dicProg);
    }

    /**
     * 保存/更新评估流程
     * 
     * @param dicProg
     *            评估流程
     */
    public void saveOrUpdate(AsseKnowDicProg dicProg) {
        
        dicProgDao.saveOrUpdate(dicProg);
    }

}
