package org.infosec.ismp.situation.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.MachineCabinetDao;
import org.infosec.ismp.situation.model.MachineCabinet;


public class MachineCabinetDaoImpl extends BaseDaoHibernate implements MachineCabinetDao {
	
	public Map<Integer, MachineCabinet> getAllMachineCabinet() {
		Map<Integer,MachineCabinet> map = new HashMap<Integer,MachineCabinet>();
		List<MachineCabinet> list = getHibernateTemplate().find("from MachineCabinet");
		for (MachineCabinet machineCabinet : list) {
			map.put(machineCabinet.getId(),machineCabinet);
		}
//		List rows = getJdbcTemplate().queryForList("SELECT * FROM Machine_Cabinet");   
//		Iterator it = rows.iterator();   
//		while(it.hasNext()) {
//			Map ma = (Map) it.next();
//			int id = (Integer) ma.get("ID");
//			Integer location =Integer.parseInt(ma.get("LOCATION").toString().trim());
//			map.put(id, location);
//		}
	//	map.put(1, "行政中心机房");
		return map;
	}
	
}
