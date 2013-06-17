package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicSecuLeveDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicSecuLeve;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 安全级别数据字典Manager实现类.
 * 


 */
public class DicSecuLeveServiceImpl  implements DicSecuLeveService{

    /**
     * 安全级别数据访问对象接口
     */
    private DicSecuLeveDao dicSecuLeveDao;

    /** 
     * @param dicsecuLeveDao
     *            安全级别数据访问对象接口(Spring Ioc容器依赖注入)
     */
    public void setDicSecuLeveDao(DicSecuLeveDao dicsecuLeveDao) {
        this.dicSecuLeveDao = dicsecuLeveDao;
    }

    /**
     * 查询安全级别
     * 
     * @param secuLeveId
     *            安全级别编号
     * @return 安全级别对象
     */
    public AsseKnowDicSecuLeve find(String secuLeveId) {
        
        return dicSecuLeveDao.find(secuLeveId);
    }

    /**
     * 查询安全级别记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 安全级别记录数
     */
    public int getCount(Map paramMap) {
        
        return dicSecuLeveDao.getCount(paramMap);
    }

    /**
     * 查询安全级别
     * @param paramMap
     *            查询条件
     * @return 安全级别列表
     */
    public List listDicSecuLeve(Map paramMap) {
        
        return dicSecuLeveDao.listDicSecuLeve(paramMap);
    }

    /**
     * 查询安全级别分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicSecuLevePage(Page page, Map paramMap) {
        
        return dicSecuLeveDao.listDicSecuLevePage(page, paramMap);
    }

    /**
     * 删除安全级别
     * 
     * @param dicSecuLeve
     *            安全级别
     */
    public void remove(AsseKnowDicSecuLeve dicSecuLeve) {
        
        dicSecuLeveDao.remove(dicSecuLeve);
    }

    /**
     * 保存/更新安全级别
     * 
     * @param dicSecuLeve
     *            安全级别
     */
    public void saveOrUpdate(AsseKnowDicSecuLeve dicSecuLeve) {
        
        dicSecuLeveDao.saveOrUpdate(dicSecuLeve);
    }

	public List findAll() {
		return dicSecuLeveDao.findAll();
	}
    
    
}
