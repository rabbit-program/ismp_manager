package org.infosec.ismp.manager.winsensor.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommThreshold;
import org.infosec.ismp.manager.winsensor.entity.ThresholdBO;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 2:01:00 PM
 *
 */
public interface ThresholdService {

	public void addThreshold(CommThreshold commThreshold);
	
	public void updateThreshold(Long id, Integer level, Long size);
	
	public void deleteThresholdByNodeId(String nodeId);
	
	public void deleteThresholdById(Long id);
	
	public void deleteThreshold(ThresholdBO threshold);
	
	public List<ThresholdBO> findThresholdByNodeId(String nodeId);
	
	public ThresholdBO findThresholdById(long id);
	
	public List<ThresholdBO> getAllThreshold();
}
