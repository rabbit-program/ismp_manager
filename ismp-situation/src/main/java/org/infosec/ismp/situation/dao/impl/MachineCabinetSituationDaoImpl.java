package org.infosec.ismp.situation.dao.impl;

import java.util.List;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.MachineCabinetSituationDao;
import org.infosec.ismp.situation.model.MachineCabinetSituation;

public class MachineCabinetSituationDaoImpl extends BaseDaoHibernate implements MachineCabinetSituationDao{
	public void save(MachineCabinetSituation machineCabinetSituation) {
//		String sql = "insert into MACHINECABINET_SITUATION (TIME,MACHINE_CABINET_ID,MACHINE_CABINET_NAME,WHOLE_SITUATION) values(?,?,?,?)";
//		Object[] args = new Object[] { machineCabinetSituation.getTime(),
//				machineCabinetSituation.getMachineCabinetId(),
//				machineCabinetSituation.getName(),
//				machineCabinetSituation.getWholeSituation() };
//		getJdbcTemplate().update(sql, args);
	}

	public void save(final List<MachineCabinetSituation> machineCabinetSituations) {
		
		for (MachineCabinetSituation machineCabinetSituation : machineCabinetSituations) {
			getHibernateTemplate().save(machineCabinetSituation);
		}
		
//		String sql = "insert into MACHINECABINET_SITUATION (TIME,MACHINE_CABINET_ID,MACHINE_CABINET_NAME,WHOLE_SITUATION) values(?,?,?,?)";
//		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
//			public void setValues(PreparedStatement ps, int i)
//					throws SQLException {
//				Timestamp time = machineCabinetSituations.get(i).getTime();
//				Integer machineCabinetId = machineCabinetSituations.get(i).getMachineCabinetId();
//				String name = machineCabinetSituations.get(i).getName();
//				float value = machineCabinetSituations.get(i).getWholeSituation();
//				ps.setTimestamp(1, time);
//				ps.setInt(2, machineCabinetId);
//				ps.setString(3, name);
//				ps.setFloat(4, value);
//			}
//
//			public int getBatchSize() {
//				return machineCabinetSituations.size();
//			}
//		});
	}
}
