package org.infosec.ismp.manager.winsensor.windowslog.dao;

import java.util.List;

import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogBO;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 10:58:15 AM
 *
 */
public interface PcLogDao {

	public void addLog(PcLogBO pcLog);
	
	public void addLog(List<PcLogBO> pcLogs);
}
