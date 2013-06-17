package org.infosec.ismp.agent.winsensor.operation.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.agent.winsensor.operation.dao.ProblemDao;
import org.infosec.ismp.agent.winsensor.operation.entity.ProblemBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Jan 14, 2011 6:05:31 PM
 *
 */
public class ProblemDaoImpl extends HibernateDaoSupport implements ProblemDao {

	@SuppressWarnings("unchecked")
	@Override
	public ProblemBO findProblem(String problemId) {
		if (!StringUtils.isBlank(problemId)) {
			Criteria criteria = getSession().createCriteria(ProblemBO.class);
			criteria.add(Restrictions.eq("problemId", problemId));
			List<ProblemBO> problems = criteria.list();
			
			if (problems.size() > 0) {
				return problems.get(0);
			}
		}
		
		return null;
	}

	@Override
	public void addProblem(ProblemBO problem) {
		getHibernateTemplate().save(problem);
	}

	@Override
	public void updateProblem(ProblemBO problem) {
		getHibernateTemplate().update(problem);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProblemBO> getAllUnuploadProblem() {
		Criteria criteria = getSession().createCriteria(ProblemBO.class);
		criteria.add(Restrictions.isNull("ifManagerReceived"));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProblemBO> getAllStateChangedProblems() {
		Criteria criteria = getSession().createCriteria(ProblemBO.class);
		criteria.add(
				Restrictions.or(Restrictions.or(Restrictions.eq("ifSendProbClosed", false), Restrictions.eq("ifSendGeneWorkOrders", false)), 
				Restrictions.or(Restrictions.eq("ifSendWorkOrdersClosed", false), Restrictions.eq("ifSendOrdersCompleted", false))));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProblemBO> findBySensorId(String sensorId) {
		Criteria criteria = getSession().createCriteria(ProblemBO.class);
		criteria.add(Restrictions.eq("sensorId", sensorId));
		criteria.add(
				Restrictions.or(Restrictions.or(Restrictions.eq("ifSendProbClosed", false), Restrictions.eq("ifSendGeneWorkOrders", false)), 
				Restrictions.or(Restrictions.eq("ifSendWorkOrdersClosed", false), Restrictions.eq("ifSendOrdersCompleted", false))));
		criteria.addOrder(Order.asc("createTime"));
		
		return criteria.list();
	}
}
