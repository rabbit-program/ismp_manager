package org.infosec.ismp.manager.winsensor.windowslog.service;

import java.util.List;

import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogSourceBO;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 11:04:43 AM
 *
 */
public interface PcLogSourceService {
	
	public void addSource(Integer domainId, String sensorId, String sensorIp, String sensorMac);
	
	public void startMonitorSource(String sensorId);
	
	public void pauseMonitorSource(String sensorId);
	
	public void updateSourceBaseInfo(String sensorId, String computerName, String computerOSType);
	
	public void updateSource(PcLogSourceBO source);
	
	public void deleteSource(String sensorId);
	
	public List<PcLogSourceBO> getAllUnSynchronizedSource();
}
