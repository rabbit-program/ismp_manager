package org.infosec.ismp.situation.dao.impl;

import java.util.List;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.SecurityAreaSituationDao;
import org.infosec.ismp.situation.model.SecurityAreaSituation;

public class SecurityAreaSituationDaoImpl extends BaseDaoHibernate implements SecurityAreaSituationDao {
	public void save(SecurityAreaSituation securityAreaSituation) {
//		String sql = "insert into SECURITYAREA_SITUATION (TIME,SECURITY_AREA_NAME,SecurityArea_ID,WHOLE_SITUATION) values(?,?,?,?)";
//		Object[] args = new Object[] { securityAreaSituation.getTime(),
//				securityAreaSituation.getName(),
//				securityAreaSituation.getSecurityAreaId(),
//				securityAreaSituation.getWholeSituation() };
//		getJdbcTemplate().update(sql, args);
	}

	public void save(final List<SecurityAreaSituation> securityAreaSituations) {
		for (SecurityAreaSituation securityAreaSituation : securityAreaSituations) {
			getHibernateTemplate().save(securityAreaSituation);
		}
//		String sql = "insert into SECURITYAREA_SITUATION (TIME,SECURITY_AREA_NAME,SecurityArea_ID,WHOLE_SITUATION) values(?,?,?,?)";
//		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
//			public void setValues(PreparedStatement ps, int i)
//					throws SQLException {
//				Timestamp time = securityAreaSituations.get(i).getTime();
//				String name = securityAreaSituations.get(i).getName();
//				Integer securityArea_ID = securityAreaSituations.get(i).getSecurityAreaId();
//				float value = securityAreaSituations.get(i).getWholeSituation();
//				ps.setTimestamp(1, time);
//				ps.setString(2, name);
//				ps.setInt(3, securityArea_ID);
//				ps.setFloat(4, value);
//			}
//
//			public int getBatchSize() {
//				return securityAreaSituations.size();
//			}
//		});
	}
}
