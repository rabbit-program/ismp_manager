package org.infosec.ismp.situation.dao.impl;

import java.util.List;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.MachineRoomSituationDao;
import org.infosec.ismp.situation.model.MachineRoomSituation;

public class MachineRoomSituationDaoImpl extends BaseDaoHibernate implements MachineRoomSituationDao{
	public void save(MachineRoomSituation machineRoomSituation) {
//		String sql = "insert into MACHINEROOM_SITUATION (TIME,MACHINE_ROOM_NAME,WHOLE_SITUATION) values(?,?,?)";
//		Object[] args = new Object[] { machineRoomSituation.getTime(),
//				machineRoomSituation.getManagerID(),
//				machineRoomSituation.getWholeSituation() };
//		getJdbcTemplate().update(sql, args);
	}

	public void save(final List<MachineRoomSituation> machineRoomSituations) {
		for (MachineRoomSituation machineRoomSituation : machineRoomSituations) {
			getHibernateTemplate().save(machineRoomSituation);
		}
//		String sql = "insert into MACHINEROOM_SITUATION (TIME,MACHINE_ROOM_NAME,WHOLE_SITUATION) values(?,?,?)";
//		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
//			public void setValues(PreparedStatement ps, int i)
//					throws SQLException {
//				Timestamp time = machineRoomSituations.get(i).getTime();
//				Integer name = machineRoomSituations.get(i).getManagerID();
//				float value = machineRoomSituations.get(i).getWholeSituation();
//				ps.setTimestamp(1, time);
//				ps.setInt(2, name);
//				ps.setFloat(3, value);
//			}
//
//			public int getBatchSize() {
//				return machineRoomSituations.size();
//			}
//		});
	}
}
