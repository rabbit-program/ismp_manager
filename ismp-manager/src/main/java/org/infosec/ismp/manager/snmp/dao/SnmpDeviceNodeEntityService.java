package org.infosec.ismp.manager.snmp.dao;

import java.util.List;

import org.infosec.ismp.manager.model.SnmpDeviceNodeEntity;
import org.infosec.ismp.manager.threshold.dao.ThresholdConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SnmpDeviceNodeEntityService {
	
	private SnmpDeviceNodeEntityDao m_snmpDeviceDao;

	private ThresholdConfigDao m_thresholdConfigDao;

	@Autowired(required = true)
	public void setThresholdConfigDao(ThresholdConfigDao thresholdConfigDao) {
		m_thresholdConfigDao = thresholdConfigDao;
	}

	@Autowired(required = true)
	public void setSnmpDeviceDao(SnmpDeviceNodeEntityDao snmpDeviceDao) {
		m_snmpDeviceDao = snmpDeviceDao;
	}

	@Transactional
	public List<SnmpDeviceNodeEntity> getAll() {
		return m_snmpDeviceDao.getAll();
	}

	@Transactional
	public void save(SnmpDeviceNodeEntity entity) {
		m_snmpDeviceDao.save(entity);

	}

	@Transactional
	public void removeSnmpDeviceNodeByNodeId(String nodeid) {
		m_snmpDeviceDao.removeSnmpDeviceNodeByNodeId(nodeid);
		m_thresholdConfigDao.removeThresholdEntityByNodeId(nodeid);
	}
}
