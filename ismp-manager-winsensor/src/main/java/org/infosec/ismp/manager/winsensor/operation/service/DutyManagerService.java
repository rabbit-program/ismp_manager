package org.infosec.ismp.manager.winsensor.operation.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;

/**
 * @author Rocky
 * @version create time: Jan 6, 2011 2:09:46 PM
 *
 */
public interface DutyManagerService {

	public void addDutyManager(List<DutyManager> dutyManagers);
	
	public void deleteDutyManager(String dutyManagerId);

	public List<DutyManager> getAllDutyManagerById(List<String> dutyManagerIds);
}
