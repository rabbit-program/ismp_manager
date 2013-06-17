package edu.sjtu.infosec.ismp.manager.BSAM.dao.impl;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessResourceFailureException;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineCabinetSituationDao;


public class MachineCabinetSituationDaoImpl extends BaseDaoHibernate implements MachineCabinetSituationDao {

	@SuppressWarnings("unchecked")
	public List getHistoryValue(String beginTime, String endTime, Integer id,Integer firstIndex)
			throws DataAccessResourceFailureException, IllegalStateException, ParseException {
		
		StringBuffer hql = new StringBuffer();
		hql.append("from MachineCabinetSituation m where 1=1 ");
		hql.append(" and m.machineCabinet.id = ");
		hql.append(id);
		hql.append(" and m.time >= '");
		hql.append(beginTime);
		hql.append("' and m.time <= '");
		hql.append(endTime);
		hql.append(" ' order by m.time asc");
		
		Query query = this.getSession().createQuery(hql.toString());
		query.setFirstResult(firstIndex);
		query.setMaxResults(21);
		return query.list();
//		Criteria criteria = getSession().createCriteria(MachineCabinetSituation.class);
//		criteria.add(Restrictions.eq("machineCabinet.id", id));
//        criteria.add(Restrictions.ge("time", DateUtil.convertStringToDate(beginTime)));
//        criteria.add(Restrictions.le("time", DateUtil.convertStringToDate(endTime)));
//        criteria.setFirstResult(firstIndex);
//        criteria.setMaxResults(21);
//        criteria.addOrder(Order.asc("time"));
//		return criteria.list();
	}

	

//	===========================================================
}
