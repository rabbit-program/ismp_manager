package org.infosec.ismp.manager.winsensor.windowslog.dao;

import java.util.List;

import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogSourceBO;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 11:03:58 AM
 *
 */
public interface PcLogSourceDao {

	public void addSource(PcLogSourceBO source);
	
	public void updateSource(PcLogSourceBO source);
	
	public PcLogSourceBO findSourceBySensorId(String sensorId);
	
	public List<PcLogSourceBO> getAllUnSynchronizedSource();
}
