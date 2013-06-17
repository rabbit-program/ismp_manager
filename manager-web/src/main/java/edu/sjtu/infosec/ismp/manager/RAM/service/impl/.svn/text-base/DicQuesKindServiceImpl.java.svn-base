package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicQuesKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicQuesKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicQuesKindService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 问题类型数据字典Manager实现类.
 * 


 */
public class DicQuesKindServiceImpl  implements DicQuesKindService {

    /** 
     * 问题类型数据访问对象接口
     */
    private DicQuesKindDao dicQuesKindDao;
    
    /**
     * @param dicquesKindDao
     *            问题类型数据访问对象接口(Spring Ioc容器依赖注入)
     */
    public void setDicQuesKindDao(DicQuesKindDao dicquesKindDao) {
        this.dicQuesKindDao = dicquesKindDao;
    }

    /**
     * 查询问题类型
     * 
     * @param quesKindId
     *            问题类型编号
     * @return 问题类型对象
     */
    public AsseKnowDicQuesKind find(String quesKindId) {
        
        return dicQuesKindDao.find(new Integer(quesKindId));
    }

    /**
     * 查询问题类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 问题类型记录数
     */
    public int getCount(Map paramMap) {
        
        return dicQuesKindDao.getCount(paramMap);
    }

    /**
     * 查询问题类型
     * @param paramMap
     *            查询条件
     * @return 问题类型列表
     */
    public List listDicQuesKind(Map paramMap) {
        
        return dicQuesKindDao.listDicQuesKind(paramMap);
    }

    /**
     * 查询问题类型分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public PageResult listDicQuesKindPage(Page page, Map paramMap) {
        
        int totalCount = dicQuesKindDao.getCount(paramMap);
        page = PageUtil.createPage(page, totalCount);
        List list = dicQuesKindDao.listDicQuesKindPage(page, paramMap);
        return new PageResult(page, list);
    }

    /**
     * 删除问题类型
     * 
     * @param dicQuesKind
     *            问题类型
     */
    public void remove(AsseKnowDicQuesKind dicQuesKind) {
        
        dicQuesKindDao.remove(dicQuesKind);
    }

    /**
     * 保存/更新问题类型
     * 
     * @param dicQuesKind
     *            问题类型
     */
    public void saveOrUpdate(AsseKnowDicQuesKind dicQuesKind) {
        
        dicQuesKindDao.saveOrUpdate(dicQuesKind);
    }

}
