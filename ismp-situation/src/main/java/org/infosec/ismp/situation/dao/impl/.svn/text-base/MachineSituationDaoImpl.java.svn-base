package org.infosec.ismp.situation.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.MachineSituationDao;
import org.infosec.ismp.situation.model.MachineSituation;

public class MachineSituationDaoImpl extends BaseDaoHibernate implements MachineSituationDao{
	public void save(MachineSituation machineSituation) {
//		String sql = "insert into machine_situation (TIME,IP,MACHINE_ID,ATTACK_THREAT,VIRUS_CONDITION,INVALID_CONNECTION,WHOLE_SITUATION) values(?,?,?,?,?,?,?)";
//		Object[] args = new Object[] { machineSituation.getTime(),
//				machineSituation.getIp(), machineSituation.getMachineId(),
//				machineSituation.getAttackThreat(),
//				machineSituation.getVirusCondition(),
//				machineSituation.getInvalidConnection(),
//				machineSituation.getWholeSituation() };
//		getJdbcTemplate().update(sql, args);
	}
	
	public void save(final List<MachineSituation> machineSituations) {
		
		for (Iterator iterator = machineSituations.iterator(); iterator.hasNext();) {
			MachineSituation machineSituation = (MachineSituation) iterator.next();
			getHibernateTemplate().save(machineSituation);
			
		}
		
//		String sql = "insert into machine_situation (TIME,IP,MACHINE_ID,ATTACK_THREAT,VIRUS_CONDITION,INVALID_CONNECTION,WHOLE_SITUATION) values(?,?,?,?,?,?,?)";
//		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
//			public void setValues(PreparedStatement ps, int i)throws SQLException {
//				Timestamp time = machineSituations.get(i).getTime();
//				String ip = machineSituations.get(i).getIp();
//				Integer machineId = machineSituations.get(i).getMachineId();
//				float attackThreat = machineSituations.get(i).getAttackThreat();
//				float virusCondition = machineSituations.get(i).getVirusCondition();
//				float invalidConnection = machineSituations.get(i).getInvalidConnection();
//				float wholeSituation = machineSituations.get(i).getWholeSituation();
//				ps.setTimestamp(1, time);
//				ps.setString(2, ip);
//				ps.setInt(3, machineId);
//				ps.setFloat(4, attackThreat);
//				ps.setFloat(5, virusCondition);
//				ps.setFloat(6, invalidConnection);
//				ps.setFloat(7, wholeSituation);
//			}
//
//			public int getBatchSize() {
//				return machineSituations.size();
//			}
//		});
	}
}
