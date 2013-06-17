package edu.sjtu.infosec.ismp.manager.OSS.wom.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.sjtu.infosec.ismp.manager.OSS.wom.dao.ClientQuestionDao;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.ClientQuestion;
import edu.sjtu.infosec.ismp.security.Domain;

public class ClientQuestionDaoImpl extends HibernateDaoSupport implements ClientQuestionDao  {
	 /**
     * 保存/更新客户端问题
     */
	public void saveOrUpdate(ClientQuestion clientQuestion){
		this.getHibernateTemplate().saveOrUpdate(clientQuestion);
    }

    /**
     * 删除客户端问题
     */
	public void remove(ClientQuestion clientQuestion){
    	this.getHibernateTemplate().delete(clientQuestion);
    }

    /**
     * 批量删除客户端问题
     */
	public void remove(List<ClientQuestion> clientQuestionList){
		this.getHibernateTemplate().deleteAll(clientQuestionList);
	}

    /**
     * 查询资产客户端问题
     */
	public ClientQuestion findById(Integer id){
		ClientQuestion clientQuestion = (ClientQuestion)getHibernateTemplate().get(ClientQuestion.class, id);
		return clientQuestion;
    }
    
    /**
     * 客户端问题分页信息
     */
    @SuppressWarnings("unchecked")
	public  List<ClientQuestion> findAll(int startResult, int maxResult,Domain domain,Integer state){
    	List<ClientQuestion>  list = null;
        Criteria criteria = this.getSession().createCriteria(ClientQuestion.class)
        								.addOrder(Order.desc("createTime"))
                                        .setFirstResult(startResult).setMaxResults(maxResult);
        if(domain!=null){
        	criteria.add(Restrictions.eq("domain", domain));
        }
        if(state!=null&&state>0){
        	criteria.add(Restrictions.eq("state", state));
        }
        list = (List<ClientQuestion> )criteria.list();
        return list;
	}
    
    /**
     * 委办局下客户端问题分页信息
     */
    @SuppressWarnings("unchecked")
	public List<ClientQuestion> findAllByDomain(List<Domain> userDomainList,int startResult, int maxResult,Domain domain,Integer state){
    	List<ClientQuestion>  list = null;
        Criteria criteria = this.getSession().createCriteria(ClientQuestion.class, "ques")
        								.addOrder(Order.desc("createTime"))
                                        .setFirstResult(startResult).setMaxResults(maxResult);
        if(domain!=null){
        	criteria.add(Restrictions.eq("domain", domain));
        }
        if(state!=null&&state>0){
        	criteria.add(Restrictions.eq("state", state));
        }
        if(userDomainList!=null){
        	criteria.add(Restrictions.in("domain", userDomainList));
        }
        list = (List<ClientQuestion> )criteria.list();
        return list;
	}
    /**
     * 客户端问题查询记录总条数
     */
    public int getCount(Domain domain,Integer state){
    	Criteria criteria =this.getSession().createCriteria(ClientQuestion.class);
    	 if(domain!=null){
         	criteria.add(Restrictions.eq("domain", domain));
         }
         if(state!=null&&state>0){
         	criteria.add(Restrictions.eq("state", state));
         }
		return criteria.list().size();
	}
	 /**
     * 委办局下客户端问题查询记录总条数
     */
    public int getCountByDomain(List<Domain> userDomainList,Domain domain,Integer state){
    	Criteria criteria =this.getSession().createCriteria(ClientQuestion.class);
		 if(domain!=null){
	     	criteria.add(Restrictions.eq("domain", domain));
	     }
	     if(state!=null&&state>0){
	     	criteria.add(Restrictions.eq("state", state));
	     }
	     if(userDomainList!=null){
		        criteria.add(Restrictions.in("domain", userDomainList));
		 }
		return criteria.list().size();
	}

}
