package org.infosec.ismp.manager.winsensor.windowslog.service.impl;

import java.util.List;

import org.infosec.ismp.manager.winsensor.windowslog.dao.PcLogDao;
import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogBO;
import org.infosec.ismp.manager.winsensor.windowslog.service.PcLogService;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 10:59:56 AM
 *
 */
public class PcLogServiceImpl implements PcLogService {
	
	private PcLogDao dao;

	@Override
	public void addLog(PcLogBO pcLog) {
		dao.addLog(pcLog);
	}

	@Override
	public void addLog(List<PcLogBO> pcLogs) {
		if (!pcLogs.isEmpty()) {
			dao.addLog(pcLogs);
		}
	}

	public void setDao(PcLogDao dao) {
		this.dao = dao;
	}
}
