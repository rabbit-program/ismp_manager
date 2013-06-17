package org.infosec.ismp.manager.winsensor.history.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.manager.winsensor.history.entity.HostResourceHistoryBO;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 1:58:05 PM
 *
 */
public interface HostResourceHistoryService {
	public void addHostResource(HostResource hostResource);
	
	public void addHistory(HostResourceHistoryBO history);
	
	public void addHistory(List<HostResourceHistoryBO> histories);
	
	public void init();
}
