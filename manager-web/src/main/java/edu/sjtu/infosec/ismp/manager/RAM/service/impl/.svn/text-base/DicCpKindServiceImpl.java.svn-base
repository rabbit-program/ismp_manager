package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicCpKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicCpKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicCpKindService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 测评类型数据字典Manager实现类.
 * 


 */
public class DicCpKindServiceImpl  implements DicCpKindService {

    /**
     * 测评类型数据访问对象接口
     */
    private DicCpKindDao dicCpKindDao;
     
    /**
     * @param diccpKindDao
     *            测评类型数据访问对象接口(Spring Ioc容器依赖注入)
     */
    public void setDicCpKindDao(DicCpKindDao diccpKindDao) {
        this.dicCpKindDao = diccpKindDao;
    }

    /**
     * 查询测评类型
     * 
     * @param cpKindId
     *            测评类型编号
     * @return 测评类型对象
     */
    public AsseKnowDicCpKind find(String cpKindId) {
        
        return dicCpKindDao.find(cpKindId);
    }

    /**
     * 查询测评类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 测评类型记录数
     */
    public int getCount(Map paramMap) {
        
        return dicCpKindDao.getCount(paramMap);
    }

    /**
     * 查询测评类型
     * @param paramMap
     *            查询条件
     * @return 测评类型列表
     */
    public List listDicCpKind(Map paramMap) {
        
        return dicCpKindDao.listDicCpKind(paramMap);
    }

    /**
     * 查询测评类型分页记录
     * ..
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicCpKindPage(Page page, Map paramMap) {
        
        return dicCpKindDao.listDicCpKindPage(page, paramMap);
    }

    /**
     * 删除测评类型
     * 
     * @param dicCpKind
     *            测评类型
     */
    public void remove(AsseKnowDicCpKind dicCpKind) {
        
        dicCpKindDao.remove(dicCpKind);
    }

    /**
     * 保存/更新测评类型
     * 
     * @param dicCpKind
     *            测评状态
     */
    public void saveOrUpdate(AsseKnowDicCpKind dicCpKind) {
        
        dicCpKindDao.saveOrUpdate(dicCpKind);
    }

}
