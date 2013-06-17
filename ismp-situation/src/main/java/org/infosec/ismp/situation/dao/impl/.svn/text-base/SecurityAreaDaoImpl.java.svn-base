package org.infosec.ismp.situation.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.SecurityAreaDao;
import org.infosec.ismp.situation.model.Domain;

public class SecurityAreaDaoImpl extends BaseDaoHibernate implements SecurityAreaDao {
	
	@SuppressWarnings("unchecked")
	public Map<Integer, Domain> getAllSecurityArea() {
		Map<Integer,Domain> map = new HashMap<Integer,Domain>();
		List<Domain> list = getHibernateTemplate().find("from Domain");
		for (Domain domain : list) {
			map.put(domain.getId(),domain);
		}
		return map;
	}
}
