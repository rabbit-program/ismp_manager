package org.infosec.ismp.manager.winsensor.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommThreshold;
import org.infosec.ismp.manager.winsensor.dao.ThresholdDao;
import org.infosec.ismp.manager.winsensor.entity.ThresholdBO;
import org.infosec.ismp.manager.winsensor.service.ThresholdService;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 2:01:36 PM
 *
 */
public class ThresholdServiceImpl implements ThresholdService {
	
	private ThresholdDao dao;

	@Override
	public void addThreshold(CommThreshold commThreshold) {
		if (commThreshold == null) {
			return;
		}
		
		ThresholdBO threshold = new ThresholdBO();
		threshold.setNodeId(commThreshold.getNodeId());
		threshold.setType(commThreshold.getType());
		threshold.setSubType(commThreshold.getSubType());
		threshold.setIndex(commThreshold.getIndex());
		threshold.setSize(commThreshold.getSize());
		threshold.setLevel(commThreshold.getLevel());
		threshold.setCreateTime(new Date());
		
		dao.addThreshold(threshold);
	}

	@Override
	public void updateThreshold(Long id, Integer level, Long size) {
		ThresholdBO threshold = findThresholdById(id.longValue());
		
		if (threshold != null) {
			threshold.setLevel(level);
			threshold.setSize(size.longValue());
			dao.updateThreshold(threshold);
		}
	}

	@Override
	public void deleteThresholdByNodeId(String nodeId) {
		List<ThresholdBO> thresholds = findThresholdByNodeId(nodeId);
		
		for (ThresholdBO threshold : thresholds) {
			deleteThreshold(threshold);
		}
	}

	@Override
	public void deleteThresholdById(Long id) {
		ThresholdBO threshold = findThresholdById(id.longValue());
		if (threshold != null) {
			deleteThreshold(threshold);
		}
	}

	@Override
	public void deleteThreshold(ThresholdBO threshold) {
		dao.deleteThreshold(threshold);
	}

	@Override
	public List<ThresholdBO> findThresholdByNodeId(String nodeId) {
		return dao.findThresholdByNodeId(nodeId);
	}

	@Override
	public ThresholdBO findThresholdById(long id) {
		return dao.findThresholdById(id);
	}

	@Override
	public List<ThresholdBO> getAllThreshold() {
		return dao.getAllThreshold();
	}

	public void setDao(ThresholdDao dao) {
		this.dao = dao;
	}
}
