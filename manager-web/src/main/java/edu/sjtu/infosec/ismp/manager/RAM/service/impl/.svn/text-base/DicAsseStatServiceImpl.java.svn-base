package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicAsseStatDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseStat;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicAsseStatService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 测评状态数据字典Manager实现类.
 * 


 */
public class DicAsseStatServiceImpl  implements DicAsseStatService{

    /**
     * 测评状态数据访问对象接口
     */
    private DicAsseStatDao dicAsseStatDao;
     
    /**
     * @param dicasseStatDao
     *            测评状态数据访问对象接口(Spring Ioc容器依赖注入)
     */
    public void setDicAsseStatDao(DicAsseStatDao dicasseStatDao) {
        this.dicAsseStatDao = dicasseStatDao;
    }
    
    /**
     * 查询测评状态
     * 
     * @param asseStatId
     *            测评状态编号
     * @return 测评状态对象
     */
    public AsseKnowDicAsseStat find(String asseStatId) {
        
        return dicAsseStatDao.find(asseStatId);
    }

    /**
     * 查询测评状态记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 测评状态记录数
     */
    public int getCount(Map paramMap) {
        
        return dicAsseStatDao.getCount(paramMap);
    }

    /**
     * 查询测评状态
     * @param paramMap
     *            查询条件
     * @return 测评状态列表
     */
    public List listDicAsseStat(Map paramMap) {
        
        return dicAsseStatDao.listDicAsseStat(paramMap);
    }

    /**
     * 查询测评状态分页记录.
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicAsseStatPage(Page page, Map paramMap) {
        
        return dicAsseStatDao.listDicAsseStatPage(page, paramMap);
    }

    /**
     * 删除测评状态
     * 
     * @param dicAsseStat
     *            测评状态
     */
    public void remove(AsseKnowDicAsseStat dicAsseStat) {
        
        dicAsseStatDao.remove(dicAsseStat);
    }

    /**
     * 保存/更新测评状态
     * 
     * @param dicAsseStat
     *            测评状态
     */
    public void saveOrUpdate(AsseKnowDicAsseStat dicAsseStat) {
        
        dicAsseStatDao.saveOrUpdate(dicAsseStat);
    }

}
