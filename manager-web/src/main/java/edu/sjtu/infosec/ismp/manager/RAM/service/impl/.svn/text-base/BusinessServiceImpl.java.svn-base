package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.BusinessDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.manager.RAM.service.BusinessService;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 应用层 业务录入Manager实现类.
 */
public class BusinessServiceImpl  implements BusinessService {

    /**
     * 业务信息数据访问对象接口
     */
    private BusinessDao businessDao;

    public void setBusinessDao(BusinessDao businessDao) {
        this.businessDao = businessDao;
    }

    /**
     * 查询业务信息
     */
    public AsseInfoBusi findByBusinessId(String businessId) {
        return businessDao.find(businessId);
    }

    /**
     * 查询该委办局所有业务信息
     */
    public  List<AsseInfoBusi> find(Domain domain) {
        return businessDao.find(domain);
    }

    /**
     * 查询业务信息记录数
     */
    public int getCount(Domain domain) {
        return businessDao.getCount(domain);
    }
    /**
     * 删除业务信息
     */
    public void remove(String businessId) {
        if(businessId!=null) {
            AsseInfoBusi business = findByBusinessId(businessId);
            businessDao.remove(business);
        }
    }

    /**
     * 批量删除业务信息
     */
    public void remove(String [] businessIds){
        List<AsseInfoBusi> businessList = new ArrayList<AsseInfoBusi>();
        for(int i=0;i<businessIds.length;i++) {
            AsseInfoBusi business = findByBusinessId(businessIds[i]);
            businessList.add(business);
        }
        if(businessList.size()>0) {
            businessDao.remove(businessList);
        }
    }
    
    /**
     * 保存/更新业务信息
     */
    public void saveOrUpdate(AsseInfoBusi business) {
        businessDao.saveOrUpdate(business);
    }

    
    /**
     * 查询业务信息分页记录
     */
	public List<AsseInfoBusi> findAll(int startResult, int maxResult, Domain domain) {
		return businessDao.findAll(startResult,maxResult,domain);
	}
    
    
}
