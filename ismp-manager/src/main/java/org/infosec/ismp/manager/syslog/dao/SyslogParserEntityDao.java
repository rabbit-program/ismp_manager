package org.infosec.ismp.manager.syslog.dao;

import java.util.List;

import org.infosec.ismp.manager.model.syslog.SyslogParserEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
@Transactional
public class SyslogParserEntityDao extends
		HibernateDao<SyslogParserEntity, Integer> {
	@Transactional(readOnly = true)
	public String getRawSyslogParserClass(String handleType) {
		SyslogParserEntity entity = getSyslogParserEntity(handleType);
		if (entity != null) {
			return entity.getRawParserClass();
		} else {
			return null;
		}
	}
	@Transactional(readOnly = true)
	public String getSpecialSyslogParserClass(String handleType) {
		SyslogParserEntity entity = getSyslogParserEntity(handleType);
		if (entity != null) {
			return entity.getSpecialParserClass();
		} else {
			return null;
		}
	}

	@Transactional(readOnly = true)
	public SyslogParserEntity getSyslogParserEntity(String handleType) {
		List<SyslogParserEntity> parsers = find(
				"from SyslogParserEntity p where p.handleType=?", handleType);
		if (parsers != null && parsers.size() > 0) {
			SyslogParserEntity entity = (SyslogParserEntity) parsers.get(0);
			return entity;
		}
		return null;
	}
//	public String getDeepSyslogParserClass(String type) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
