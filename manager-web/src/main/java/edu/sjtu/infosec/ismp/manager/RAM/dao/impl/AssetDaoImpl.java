package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.RAM.dao.AssetDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 数据层 资产录入Dao实现类.
 */
public class AssetDaoImpl extends HibernateDaoSupport implements AssetDao {

    /**
     * 查询资产信息
     *            资产编号
     * @return 资产信息对象
     **/
    public AsseInfoAsse find(String assetCode) {
        AsseInfoAsse asseInfoAsse = null;
        List asseInfoAsseList = getHibernateTemplate().find(
                "from AsseInfoAsse asse where asse.assetCode = ?", assetCode);
        if(asseInfoAsseList!=null && asseInfoAsseList.size()>0) {
            asseInfoAsse = (AsseInfoAsse) asseInfoAsseList.get(0);
        }
        return asseInfoAsse;
    }
    
    public Object[] findByDWR(String assetCode) {
    	Object[] asseInfoAsse = null;
        List asseInfoAsseList = getHibernateTemplate().find(
                "select id, assetCode, asseInfoProjId, assetName, asseInfoBusiId, importance, memo, respMan, ip from AsseInfoAsse asse where asse.assetCode = ?", assetCode);
        if(asseInfoAsseList!=null && asseInfoAsseList.size()>0) {
            asseInfoAsse = (Object[]) asseInfoAsseList.get(0);
        }
        return asseInfoAsse;
    }

    /**
     * 查询资产信息
     * 
     * @param id
     *            资产id
     * @return 资产信息对象
     */
    public AsseInfoAsse find(Integer id) {
        AsseInfoAsse asseInfoAsse = new AsseInfoAsse();
        asseInfoAsse = (AsseInfoAsse) getHibernateTemplate().load(AsseInfoAsse.class, id);
        return asseInfoAsse;
    }
    
    /**
     * 查询该委办局资产信息
     * @return 资产信息对象列表
     **/
    @SuppressWarnings("unchecked")
	public List<AsseInfoAsse> find(Domain domain,AsseKnowDicAsseKind asseKind) {
        Criteria criteria = getSession().createCriteria(AsseInfoAsse.class, "asse");
        if(domain != null) {
            criteria.add(Expression.eq("asse.domain", domain));
        }
        if(asseKind != null) {
            criteria.add(Expression.eq("asse.asseKind", asseKind));
        }
        return criteria.list();
    }
    
    @SuppressWarnings("unchecked")
	public List<AsseInfoAsse> find1(Domain domain,
            AsseKnowDicAsseKind asseKind) {
    	 String hql = "select assetCode, assetName from AsseInfoAsse";
         if(domain != null) {
        	 hql+=" where domain.id = "+domain.getId();
         }if(asseKind != null) {
        	 hql+=" and asseKind.id = '"+asseKind.getId()+"' ";
         }
         List list = getHibernateTemplate().find(hql);
         return list;
    }
    
    /**
     * 查询该委办局资产信息
     * @return asset_device对象列表
     **/
    @SuppressWarnings("unchecked")
	public List<AssetDeviceBO> findFromAssetModule(){
        Query query = getSession().createQuery("select assetDevice " +
        		"from AssetDeviceBO assetDevice " +
        		"where assetDevice.sn NOT IN (select asse.assetCode from AsseInfoAsse asse)");
        return query.list();
    }
    
    /**
     * 查询该委办局资产信息记录数
     * @return 业务信息记录数
     **/
    @SuppressWarnings({ "deprecation", "unchecked" })
	public Long getCount(Domain domain, AsseKnowDicAsseKind asseKind) {
    	String hql = "select count(id) from AsseInfoAsse ri where 1=1 ";
		
		if(domain != null){
			hql = hql + " and ri.domain.id="+domain.getId();
		}
		if(asseKind != null){
			hql = hql + " and ri.asseKind.id="+asseKind.getId();
		}
		
		System.out.println("===findAllNum===="+hql);
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
		/*Criteria criteria=this.getSession().createCriteria(AsseInfoAsse.class);
		if(null!=domain){
			criteria.add(Expression.eq("domain", domain));
		}
       
		if(null!=asseKind){
            criteria.add(Expression.eq("asseKind", asseKind));
		}
    
		List<AsseInfoAsse> list = (List<AsseInfoAsse>)criteria.list();
		
        return list.size();*/
    }

    /**
     * 删除资产信息
     *            资产信息
     **/
    public void remove(AsseInfoAsse asseInfoAsse) {
       
        getHibernateTemplate().delete(asseInfoAsse);
    }

    /**
     * 批量删除资产信息
     *            资产信息对象列表
     **/
    public void remove(List<AsseInfoAsse> asseInfoAsseList) {
        
        getHibernateTemplate().deleteAll(asseInfoAsseList);
    }

    /**
     * 保存/更新资产信息
     * 资产信息
     **/
    public void saveOrUpdate(AsseInfoAsse asseInfoAsse) {
        
        getHibernateTemplate().saveOrUpdate(asseInfoAsse);
    }

    /**
     * 查询资产信息
     * ip地址
     * 资产信息对象
     */
	public  List<AsseInfoAsse>  findByIP(String ip) {
		List<AsseInfoAsse> asseInfoAsseList = (List<AsseInfoAsse>)getHibernateTemplate().find("from AsseInfoAsse asse where asse.ip = ?", ip);
        return asseInfoAsseList;
	}

	/**
     * 查询该委办局资产信息记录
     *            被测机构
     * 资产信息列表
     */
	public List<AsseInfoAsse> listAsse(Domain domain) {
		Criteria criteria = getSession().createCriteria(AsseInfoAsse.class, "asse")
                                        .addOrder(Order.asc("id"));
		if(domain != null) {
           criteria.add(Expression.eq("asse.domain", domain));
         }
        return criteria.list();
	}
	
	/**
     * 查询该委办局资产重要性为高的资产数目
     * @param inst
     * 被测机构
     * @return 重要性为高的资产数目
     */
	public Long statHighImpoAsse(Domain domain) {
		Long count = 0L;
		List list = getHibernateTemplate().find("select COUNT(importance) " +
                "from AsseInfoAsse " +
                "where importance='H' and domain=?",domain);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询该委办局资产重要性为中的资产数目
     * @param inst
     * 被测机构
     * @return 重要性为高的资产数目
     */
	public Long statMiddImpoAsse(Domain domain) {
		Long count = 0L;
		List list = getHibernateTemplate().find("select COUNT(importance) " +
                "from AsseInfoAsse " +
                "where importance='M' and domain=?",domain);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询该委办局资产重要性为低的资产数目
     * @param inst
     * 被测机构
     * @return 重要性为高的资产数目
     */
	public Long statLowImpoAsse(Domain domain) {
		Long count = 0L;
		List list = getHibernateTemplate().find("select COUNT(importance) " +
                "from AsseInfoAsse " +
                "where importance='L' and domain=?",domain);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}

	
	public Object[] listDistinctAssetName(Domain domain) {
		List list = getHibernateTemplate().find("select DISTINCT assetName from AsseInfoAsse" +
				" where domain=?", domain);
		return list.toArray();
	}

	public Integer getMaxId() {
		
		Integer maxId = 1;
		List list = getHibernateTemplate().find("select max(id) from AsseInfoAsse");
		if(list!=null && list.size()>0) {
			maxId = (Integer) list.get(0);
		}
		return maxId;
	}

	public AsseKnowDicAsseKind findAsseKind(String assetKindIdSelect) {
		AsseKnowDicAsseKind asseKind = null;
        List asseKindList = getHibernateTemplate().find(
                "from AsseKnowDicAsseKind asseKind where asseKind.assetKindId = ?", assetKindIdSelect);
        if(asseKindList!=null && asseKindList.size()>0) {
        	asseKind = (AsseKnowDicAsseKind) asseKindList.get(0);
        }
        return asseKind;
	}
	
	 /**
     * 查询该委办局资产信息分页记录
     **/
	@SuppressWarnings("unchecked")
	public List<AsseInfoAsse> findAll(int startResult, int maxResult,Domain domain, AsseKnowDicAsseKind asseKind) {
		  Criteria criteria = getSession().createCriteria(AsseInfoAsse.class, "asse")
										          .addOrder(Order.desc("id"))
										          .setFirstResult(startResult)
										          .setMaxResults(maxResult);
		if(domain != null) {
			criteria.add(Expression.eq("asse.domain", domain));
		}
		if(asseKind != null) {
			criteria.add(Expression.eq("asse.asseKind", asseKind));
		}
		return (List<AsseInfoAsse>)criteria.list();
	}

	public List<AsseInfoAsse> findByAsseKindId(String domain, String asseKindId) {
		 String hql = "select assetCode, assetName from AsseInfoAsse";
         if(domain != null) {
        	 hql+=" where domain.id = "+domain;
         }if(asseKindId != null) {
        	 hql+=" and asseKind.assetKindId = '"+asseKindId+"' ";
         }
         List list = getHibernateTemplate().find(hql);
         return list;
	}

}
