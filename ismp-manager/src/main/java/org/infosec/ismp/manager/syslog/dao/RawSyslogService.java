package org.infosec.ismp.manager.syslog.dao;

import org.infosec.ismp.model.syslog.SyslogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class RawSyslogService {
	private RawSyslogDao m_syslogDao;

	@Autowired(required = true)
	public void setSyslogDao(RawSyslogDao syslogDao) {
		m_syslogDao = syslogDao;
	}

	public void saveRawSyslog(SyslogEntity syslog) {
		m_syslogDao.save(syslog);
		
	}

}
