package org.infosec.ismp.manager.winsensor.operation.dao;

import java.util.List;

import org.infosec.ismp.manager.winsensor.operation.entity.DutyManagerBO;

/**
 * @author Rocky
 * @version create time: Jan 6, 2011 2:08:11 PM
 *
 */
public interface DutyManagerDao {

	public void addDutyManager(DutyManagerBO dutyManagerBO);
	
	public void deleteDutyManager(String dutyManagerId);
	
	public DutyManagerBO findDutyManagerById(String dutyManagerId);

	public List<DutyManagerBO> getAllDutyManagerById(List<String> dutyManagerIds);
}
