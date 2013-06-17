package edu.sjtu.infosec.ismp.manager.OSS.wom.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.OSS.wom.dao.WorkOrderDao;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.WorkOrder;
import edu.sjtu.infosec.ismp.security.Domain;
/**
 * Dao层 派工单dao.
 */
public class WorkOrderDaoImpl extends HibernateDaoSupport implements WorkOrderDao {
	 /**
     * 保存/更新派工单
     */
    public void saveOrUpdate(WorkOrder workOrder){
		this.getHibernateTemplate().saveOrUpdate(workOrder);
    }

    /**
     * 删除派工单
     */
    public void remove(WorkOrder workOrder){
    	this.getHibernateTemplate().delete(workOrder);
    }

    /**
     * 批量删除派工单
     */
    public void remove(List<WorkOrder> workOrderList){
		this.getHibernateTemplate().deleteAll(workOrderList);

	}

    /**
     * 查询派工单
     */
    public WorkOrder findById(Integer id){
    	WorkOrder workOrder = (WorkOrder)getHibernateTemplate().get(WorkOrder.class, id);
		return workOrder;
    	
    }
    /**
     * 根据问题id查询派工单
     */
    @SuppressWarnings("unchecked")
	public WorkOrder findByQuestion(Integer questionId){
    	WorkOrder order = null;
        Criteria criteria = this.getSession().createCriteria(WorkOrder.class);
        if(questionId!=null){
        	criteria.add(Restrictions.eq("question.id", questionId));
        }else{
        	criteria.add(Restrictions.eq("question.id", null));
        }
        
        criteria.add(Restrictions.ne("state", 4));
        
        List<WorkOrder> list = criteria.list();
        if(list!=null&&list.size()>0){
        	order=list.get(0);
        }
        
		return order;
    }
    /**
     * 根据值班人员id查询派工单
     */
    public WorkOrder findByRoster(Integer rosterId){
    	   Criteria criteria = this.getSession().createCriteria(WorkOrder.class);
           if(rosterId!=null){
           	criteria.add(Restrictions.eq("operator.id", rosterId));
           }else{
           	criteria.add(Restrictions.eq("question.id", null));
           }
           
   		return (WorkOrder) criteria.list().get(0);
    }
    
    /**
     * 派工单分页信息
     */
    @SuppressWarnings("unchecked")
	public List<WorkOrder> findAll(int startResult, int maxResult,Domain domain,Integer state){
    	List<WorkOrder>  list = null;
        Criteria criteria = this.getSession().createCriteria(WorkOrder.class)
        								.addOrder(Order.desc("createTime"))
                                        .setFirstResult(startResult).setMaxResults(maxResult);
        if(domain!=null){
        	criteria.add(Restrictions.eq("domain", domain));
        }
        if(state!=null&&state>0){
        	criteria.add(Restrictions.eq("state", state));
        }
        list = (List<WorkOrder> )criteria.list();
        return list;
	}
    
    /**
     * 委办局下派工单分页信息
     */
    @SuppressWarnings("unchecked")
	public List<WorkOrder> findAllByDomain(List<Domain> userDomainList,int startResult, int maxResult,Domain domain,Integer state){
    	List<WorkOrder>  list = null;
        Criteria criteria = this.getSession().createCriteria(WorkOrder.class)
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
        list = (List<WorkOrder> )criteria.list();
        return list;
	}
    /**
     * 派工单查询记录总条数
     */
    public int getCount(Domain domain,Integer state){
    	Criteria criteria =this.getSession().createCriteria(WorkOrder.class);
   	   if(domain!=null){
        	criteria.add(Restrictions.eq("domain", domain));
        }
        if(state!=null&&state>0){
        	criteria.add(Restrictions.eq("state", state));
        }
		return criteria.list().size();
	}
	 /**
     * 委办局下派工单查询记录总条数
     */
    public int getCountByDomain(List<Domain> userDomainList,Domain domain,Integer state){
    	Criteria criteria =this.getSession().createCriteria(WorkOrder.class);
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

	@SuppressWarnings("unchecked")
	public String findSN() {
		String sn = "000000000";
		String sql =" select max(sn) from WorkOrder";
		List list=this.getHibernateTemplate().find(sql);
		if(list!=null&&list.size()>0&&list.get(0)!=null){
			sn=(String) list.get(0);
		}
		return sn;
	}

	@SuppressWarnings("unchecked")
	public List<Roster> findOperator() {
		List<Roster> list =this.getHibernateTemplate().find("from Roster");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Roster findOperatorById(Integer id) {
		Roster roster =null;
		List<Roster> list =this.getHibernateTemplate().find("from Roster where id="+id);
		if(list!=null&&list.size()>0){
			roster = list.get(0);
		}
		return roster;
	}


}
