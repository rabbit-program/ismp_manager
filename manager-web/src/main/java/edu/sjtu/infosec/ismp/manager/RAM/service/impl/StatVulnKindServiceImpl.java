package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatVulnKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatVulnKindService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 静态脆弱点类别Manager实现类.
 * 


 **/
public class StatVulnKindServiceImpl  implements StatVulnKindService {

    /**
     * statVulnKindDao
     * 
     */
    private StatVulnKindDao statVulnKindDao;

    /**
     * setStatVulnKindDao
     * @param statvulnKindDao
     * 静态脆弱点类别Dao
     **/
    public void setStatVulnKindDao(StatVulnKindDao statvulnKindDao) {
        this.statVulnKindDao = statvulnKindDao;
    }
    
    /**
     * 查询静态脆弱点类别
     * 
     * @param id
     *    静态脆弱点类别id
     * @return 静态脆弱点类别对象
     **/
    public AsseKnowStatVulnKind find(Integer id) {
        
        return statVulnKindDao.find(id);
    }

    /**
     * 查询静态脆弱点类别数量
     * @return 静态脆弱点类别数量
     **/
    public int getCount() {
       
        return statVulnKindDao.getCount();
    }

    /**
     * 查询静态脆弱点类别分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    public PageResult listStatVulnKindPage(Page page) {
        
        int totalCount = statVulnKindDao.getCount();
        page = PageUtil.createPage(page, totalCount);
        List list = statVulnKindDao.listStatVulnKindPage(page);
        return new PageResult(page, list);
    }

    /**
     * 删除静态脆弱点类别对象
     * 
     * @param statVulnKind
     *   静态脆弱点类别对象
     **/
    public void remove(AsseKnowStatVulnKind statVulnKind) {
        
        statVulnKindDao.remove(statVulnKind);
    }

    /**
     * 保存/更新静态脆弱点类别对象
     * 
     * @param statVulnKind
     *    静态脆弱点类别对象
     **/
    public void saveOrUpdate(AsseKnowStatVulnKind statVulnKind) {
        statVulnKindDao.saveOrUpdate(statVulnKind);
    }

    /**
     * 返回所有静态脆弱点类别记录
     * @return 所有静态脆弱点类别列表
     **/
	public List<AsseKnowStatVulnKind> listAllStatVulnKinds() {
		
		return statVulnKindDao.listAllStatVulnKinds();
	}

}
