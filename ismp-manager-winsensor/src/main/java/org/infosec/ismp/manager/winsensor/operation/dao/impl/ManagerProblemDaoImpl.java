package org.infosec.ismp.manager.winsensor.operation.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.winsensor.operation.dao.ManagerProblemDao;
import org.infosec.ismp.manager.winsensor.operation.entity.ManagerProblemBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Jan 15, 2011 4:52:43 PM
 *
 */
public class ManagerProblemDaoImpl extends HibernateDaoSupport implements ManagerProblemDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public ManagerProblemBO findProblem(String problemId) {
		if (!StringUtils.isBlank(problemId)) {
			Criteria criteria = getSession().createCriteria(ManagerProblemBO.class);
			criteria.add(Restrictions.eq("problemId", problemId));
			List<ManagerProblemBO> problems = criteria.list();
			
			if (problems.size() > 0) {
				return problems.get(0);
			}
		}
		
		return null;
	}

	@Override
	public void addProblem(ManagerProblemBO problem) {
		getHibernateTemplate().save(problem);
	}

	@Override
	public void updateProblem(ManagerProblemBO problem) {
		getHibernateTemplate().update(problem);
	}
}
