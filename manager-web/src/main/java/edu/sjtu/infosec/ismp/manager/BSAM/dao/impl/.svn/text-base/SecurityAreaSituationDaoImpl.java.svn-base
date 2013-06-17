package edu.sjtu.infosec.ismp.manager.BSAM.dao.impl;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessResourceFailureException;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.BSAM.comm.DateUtil;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.SecurityAreaSituationDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SecurityAreaSituation;

public class SecurityAreaSituationDaoImpl extends BaseDaoHibernate implements SecurityAreaSituationDao {

	@SuppressWarnings("unchecked")
	public List getHistoryValue(String beginTime, String endTime, Integer id,Integer firstIndex)
			throws DataAccessResourceFailureException, IllegalStateException, ParseException {
		
		StringBuffer hql = new StringBuffer();
		hql.append("from SecurityAreaSituation s where 1=1 ");
		hql.append(" and s.domain.id = ");
		hql.append(id);
		hql.append(" and s.time >= '");
		hql.append(beginTime);
		hql.append("' and s.time <= '");
		hql.append(endTime);
		hql.append(" ' order by s.time asc");
		
		Query query = this.getSession().createQuery(hql.toString());
		query.setFirstResult(firstIndex);
		query.setMaxResults(21);
		return query.list();
//		Criteria criteria = getSession().createCriteria(SecurityAreaSituation.class);
//		criteria.add(Restrictions.eq("domain.id", id));
//        criteria.add(Restrictions.ge("time", DateUtil.convertStringToDate(beginTime)));
//        criteria.add(Restrictions.le("time", DateUtil.convertStringToDate(endTime)));
//        criteria.setFirstResult(firstIndex);
//        criteria.setMaxResults(21);
//        criteria.addOrder(Order.asc("time"));
//		return criteria.list();
		
	}

	

//	===========================================================
}
