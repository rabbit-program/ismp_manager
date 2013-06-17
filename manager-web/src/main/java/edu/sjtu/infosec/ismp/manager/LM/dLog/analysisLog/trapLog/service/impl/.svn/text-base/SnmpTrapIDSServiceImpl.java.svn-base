package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.dao.SnmpTrapIDSDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.service.SnmpTrapIDSService;
import edu.sjtu.infosec.ismp.security.Domain;

@SuppressWarnings("unchecked")
public class SnmpTrapIDSServiceImpl implements SnmpTrapIDSService {
	
	private SnmpTrapIDSDao snmpTrapIDSDao;
	
	public List<?> getSnmpTrapIDSLog(Class clazz, List<Domain> domain,String logSourceLogo,
			Integer pageNo, Integer pageRowNum) throws Exception {
		return snmpTrapIDSDao.getSnmpTrapIDSLog(clazz, domain, logSourceLogo, pageNo, pageRowNum);
	}

	public Integer getSnmpTrapIDSLogCount(Class clazz, List<Domain> domain,String logSourceLogo)
			throws Exception {
		return snmpTrapIDSDao.getSnmpTrapIDSLogCount(clazz, domain, logSourceLogo);
	}

	public SnmpTrapIDSDao getSnmpTrapIDSDao() {
		return snmpTrapIDSDao;
	}

	public void setSnmpTrapIDSDao(SnmpTrapIDSDao snmpTrapIDSDao) {
		this.snmpTrapIDSDao = snmpTrapIDSDao;
	}
}
