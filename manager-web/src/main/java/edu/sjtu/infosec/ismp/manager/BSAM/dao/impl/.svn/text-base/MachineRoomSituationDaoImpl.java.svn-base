package edu.sjtu.infosec.ismp.manager.BSAM.dao.impl;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessResourceFailureException;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineRoomSituationDao;

public class MachineRoomSituationDaoImpl extends BaseDaoHibernate implements MachineRoomSituationDao {

	@SuppressWarnings("unchecked")
	public List getHistoryValue(String beginTime, String endTime, Integer id,Integer firstIndex)
			throws DataAccessResourceFailureException, IllegalStateException, ParseException {
		
		StringBuffer hql = new StringBuffer();
		hql.append("from MachineRoomSituation m where 1=1 ");
		hql.append(" and m.machineRoom.id = ");
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
//		Criteria criteria = getSession().createCriteria(MachineRoomSituation.class);
//		criteria.add(Restrictions.eq("machineRoom.id", id));
//        criteria.add(Restrictions.ge("time", DateUtil.convertStringToDate(beginTime)));
//        criteria.add(Restrictions.le("time", DateUtil.convertStringToDate(endTime)));
//        criteria.setFirstResult(firstIndex);
//        criteria.setMaxResults(21);
//        criteria.addOrder(Order.asc("time"));
//		return criteria.list();
		
	}

//	===========================================================
}
