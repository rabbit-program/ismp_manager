package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.BusinessDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoBusi;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 数据层 业务信息Dao实现类.
 */
public class BusinessDaoImpl extends HibernateDaoSupport implements BusinessDao {

    /**
     * 查询业务信息
     */
    public AsseInfoBusi find(String businessId) {
        AsseInfoBusi business = null;
        List busiList = getHibernateTemplate().find("from AsseInfoBusi busi where busi.businessId = ?", businessId);
        if(busiList.size()>0) {
            business = (AsseInfoBusi) busiList.get(0);
        }
        return business;
    }

    /**
     * 查询该委办局所有业务信息
     */
    @SuppressWarnings("unchecked")
	public   List<AsseInfoBusi> find(Domain domain) {
        return (List<AsseInfoBusi>)getHibernateTemplate().find("from AsseInfoBusi busi where busi.domain = ?", domain);
    }

    /**
     * 查询业务信息记录数
     */
    public int getCount(Domain domain) {
        Criteria criteria = getSession().createCriteria(AsseInfoBusi.class, "busi");
        if(domain != null) {
         criteria.add(Restrictions.eq("busi.domain", domain));
        }
        return criteria.list().size();
    } 

    /**
     * 删除业务信息
     */
    public void remove(AsseInfoBusi business) {
        getHibernateTemplate().delete(business);
    }
    
    /**
     * 批量删除业务信息
     */
    public void remove(List<AsseInfoBusi> businessList){
        getHibernateTemplate().deleteAll(businessList);
    }

    /**
     * 保存/更新业务信息
     */
    public void saveOrUpdate(AsseInfoBusi business) {
        getHibernateTemplate().saveOrUpdate(business);
    }

	@SuppressWarnings("unchecked")
	public List<AsseInfoBusi> findAll(int startResult, int maxResult,Domain domain) {
		List<AsseInfoBusi>  list = null;
        Criteria criteria = getSession().createCriteria(AsseInfoBusi.class, "busi").addOrder(Order.desc("id"))
                                        .setFirstResult(startResult).setMaxResults(maxResult);
        if(domain != null) {
         criteria.add(Restrictions.eq("busi.domain", domain));
        }
        list = (List<AsseInfoBusi> )criteria.list();
        return list;
	}

}
