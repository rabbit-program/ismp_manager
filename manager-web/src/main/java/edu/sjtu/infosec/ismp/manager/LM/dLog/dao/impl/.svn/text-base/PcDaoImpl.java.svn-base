package edu.sjtu.infosec.ismp.manager.LM.dLog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.LM.dLog.dao.PcDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.PcLog;

public class PcDaoImpl extends HibernateDaoSupport implements PcDao {

	@SuppressWarnings("unchecked")
	public List<PcLog> getPcLogBySensor(String HQL, Integer pageNo,
			Integer pageRowNum) throws Exception {
		Query pcQuery = this.getSession().createQuery(HQL);
		pcQuery.setFirstResult(pageNo);
		pcQuery.setMaxResults(pageRowNum);
		return pcQuery.list();
	}

	public Integer getPcLogBySensorCount(String HQL) throws Exception {
		Query pcQuery = this.getSession().createQuery(HQL);
		if(!pcQuery.list().isEmpty()){
			return Integer.parseInt(pcQuery.list().get(0).toString());
		}else{
			return 0;
		}
	}
}
