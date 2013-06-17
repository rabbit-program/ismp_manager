package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatVulnKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatVulnPoinDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatVulnPoinService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 静态脆弱点Manager实现类.
 * 


 **/
public class StatVulnPoinServiceImpl  implements StatVulnPoinService {

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
     * statVulnPoinDao
     * 
     */
    private StatVulnPoinDao statVulnPoinDao;
    
    /**
     * setStatVulnPoinDao
     * @param statvulnPoinDao
     * 静态脆弱点Dao
     **/
    public void setStatVulnPoinDao(StatVulnPoinDao statvulnPoinDao) {
        this.statVulnPoinDao = statvulnPoinDao;
    }

    /**
     * 查询静态脆弱点
     * 
     * @param id
     *    静态脆弱点类别id
     * @return 静态脆弱点类别对象
     **/
    public AsseKnowStatVulnPoin find(String id) {
        
    	AsseKnowStatVulnPoin statVulnPoin = new AsseKnowStatVulnPoin();
    	if(id!=null && !"".equals(id)) {
    		statVulnPoin = statVulnPoinDao.find(new Integer(id));
        }
    	return statVulnPoin;
    }

    /**
     * 查询静态脆弱点数量
     * @return 静态脆弱点数量
     **/
    public int getCount() {
        
        return statVulnPoinDao.getCount();
    }

    /**
     * 查询静态脆弱点分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    public PageResult listStatVulnPoinPage(Page page) {
        
        int totalCount = statVulnPoinDao.getCount();
        page = PageUtil.createPage(page, totalCount);
        List list = statVulnPoinDao.listStatVulnPoinPage(page);
        return new PageResult(page, list);
    }

    /**
     * 删除静态脆弱点对象
     * 
     * @param statVulnPoin
     *   静态脆弱点类别对象
     **/
    public void remove(AsseKnowStatVulnPoin statVulnPoin) {
        
        statVulnPoinDao.remove(statVulnPoin);
    }

    /**
     * 保存/更新静态脆弱点对象
     * 
     * @param statVulnPoin
     *    静态脆弱点类别对象
     **/
    public void saveOrUpdate(AsseKnowStatVulnPoin statVulnPoin) {
        
        statVulnPoinDao.saveOrUpdate(statVulnPoin);
    }

    /**
     * 根据静态脆弱点类别编号返回静态脆弱点列表
     * @param statVulnKindId
     *     静态脆弱点类别编号
     * @return 静态脆弱点列表
     **/
	public List<AsseKnowStatVulnPoin> listStatVulnPoinByKindId(
			String asseInfoProjId,String statVulnKindId) {
		
		List<AsseKnowStatVulnPoin> statVulnPoinList = null;
		if(asseInfoProjId!=null && statVulnKindId!=null && !"".equals(statVulnKindId)) {
		 AsseKnowStatVulnKind statVulnKind = statVulnKindDao.find(new Integer(statVulnKindId));
		 statVulnPoinList = statVulnPoinDao.listStatVulnPoin(new Integer(asseInfoProjId),statVulnKind);
		}
		return statVulnPoinList;
	}

	/**
     * 返回所有静态脆弱点
     * @return 静态脆弱点列表
     **/
	public List<AsseKnowStatVulnPoin> listAllStatVulnPoin() {
		
		return statVulnPoinDao.listAllStatVulnPoin();
	}

	/**
     * 返回所有静态脆弱点
     * * @param statVulnKindId
     *     静态脆弱点类别编号
     * @return 静态脆弱点列表
     **/
	public List<AsseKnowStatVulnPoin> listStatVulnPoinByKind(
			String statVulnKindId) {
		
		List<AsseKnowStatVulnPoin> list = new ArrayList<AsseKnowStatVulnPoin>();
		if(statVulnKindId!=null && !"".equals(statVulnKindId)) {
			AsseKnowStatVulnKind vulnKind = statVulnKindDao.find(new Integer(statVulnKindId));
			list = statVulnPoinDao.listStatVulnPoinByKind(vulnKind);
		}
		return list;
	}

}
