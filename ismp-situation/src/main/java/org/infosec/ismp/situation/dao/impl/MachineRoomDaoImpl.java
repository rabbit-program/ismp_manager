package org.infosec.ismp.situation.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.MachineRoomDao;
import org.infosec.ismp.situation.model.MachineRoom;

public class MachineRoomDaoImpl extends BaseDaoHibernate implements MachineRoomDao {

	@Override
	public Map<Integer, MachineRoom> getAllMachineRoom() {
		Map<Integer,MachineRoom> map = new HashMap<Integer,MachineRoom>();
		List<MachineRoom> list = getHibernateTemplate().find("from MachineRoom");
		for (MachineRoom machineRoom : list) {
			map.put(machineRoom.getId(),machineRoom);
		}
		return map;
	}
	
}
