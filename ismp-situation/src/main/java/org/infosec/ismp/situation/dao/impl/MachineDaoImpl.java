package org.infosec.ismp.situation.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.MachineDao;
import org.infosec.ismp.situation.model.Machine;


public class MachineDaoImpl extends BaseDaoHibernate implements MachineDao {
	
	public Map<String, Machine> getAllMachine() {
		Map<String, Machine> res = new HashMap<String, Machine>();
		List<Machine> list = getHibernateTemplate().find("from Machine");
		for (Machine machine : list) {
			res.put(machine.getIp(),machine);
		}
		return res;
//		List rows = getJdbcTemplate()
//				.queryForList(
//						"select ma.*,mc.LOCATION as MC_LOCATION,mc.MACHINE_CABINET_NAME as MC_NAME,sy.LOCATION AS SY_LOCATION,sy.SECURITY_AREA_NAME AS SY_NAME from Machine as ma left join machine_cabinet AS mc on ma.MACHINE_CABINET_ID=mc.ID left join securityarea as sy on ma.SECURITY_AREA_ID=sy.ID order by id asc");
//		Iterator it = rows.iterator();
//		while (it.hasNext()) {
//			Machine machine = new Machine();
//			Map map = (Map) it.next();
//			String ip = map.get("IP").toString().trim();
//			machine.setIp(ip);
//			machine.setId((Integer) map.get("ID"));
//			machine.setMachineCabinetId((Integer) map.get("MACHINE_CABINET_ID"));
//			machine.setMachineCabinetName(map.get("MC_NAME").toString().trim());
//			machine.setMachineRoomNameID((Integer)map.get("MC_LOCATION"));
//			machine.setSecurityAreaId((Integer) map.get("SECURITY_AREA_ID"));
//			machine.setSecurityAreaName(map.get("SY_NAME").toString().trim());
//			machine.setNetName(map.get("SY_LOCATION").toString().trim());
//			machine.setWeight((Integer) map.get("WEIGHT"));
//			res.put(ip, machine);
//		}
		
	}
	
//	===========================================================
	
}