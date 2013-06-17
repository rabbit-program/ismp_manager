package org.infosec.ismp.manager.winsensor.windowslog.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.manager.winsensor.windowslog.dao.PcLogSourceDao;
import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogSourceBO;
import org.infosec.ismp.manager.winsensor.windowslog.service.PcLogSourceService;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 11:05:24 AM
 *
 */
public class PcLogSourceServiceImpl implements PcLogSourceService {
	
	private PcLogSourceDao dao;

	@Override
	public void addSource(Integer domainId, String sensorId, String sensorIp,
			String sensorMac) {
		PcLogSourceBO source = dao.findSourceBySensorId(sensorId);
		if (source != null) {
			source.setEnable(false);
			dao.updateSource(source);
		} 
		
		source = new PcLogSourceBO();
		source.setDomainId(domainId);
		source.setSensorId(sensorId);
		source.setSensorIp(sensorIp);
		source.setSensorMac(sensorMac);
		source.setEnable(true);
		source.setStartMonitor(false);
		source.setStartCollectSwitch(false);
		source.setCreateTime(new Date());
		source.setIsSynchronized(false);
		
		dao.addSource(source);
	}

	@Override
	public void startMonitorSource(String sensorId) {
		PcLogSourceBO source = dao.findSourceBySensorId(sensorId);
		
		if (source != null) {
			source.setStartMonitor(true);
			dao.updateSource(source);
		}
	}

	@Override
	public void pauseMonitorSource(String sensorId) {
		PcLogSourceBO source = dao.findSourceBySensorId(sensorId);
		
		if (source != null) {
			source.setStartMonitor(false);
			dao.updateSource(source);
		}
	}
	
	@Override
	public void updateSourceBaseInfo(String sensorId, String computerName,
			String computerOSType) {
		PcLogSourceBO source = dao.findSourceBySensorId(sensorId);
		
		if (source != null) {
			source.setComputerName(computerName);
			source.setComputerOSType(computerOSType);
			dao.updateSource(source);
		}
	}

	@Override
	public void updateSource(PcLogSourceBO source) {
		dao.updateSource(source);
	}

	@Override
	public void deleteSource(String sensorId) {
		PcLogSourceBO source = dao.findSourceBySensorId(sensorId);
		
		if (source != null) {
			source.setEnable(false);
			dao.updateSource(source);
		}
	}

	@Override
	public List<PcLogSourceBO> getAllUnSynchronizedSource() {
		return dao.getAllUnSynchronizedSource();
	}

	public PcLogSourceDao getDao() {
		return dao;
	}

	public void setDao(PcLogSourceDao dao) {
		this.dao = dao;
	}
}
