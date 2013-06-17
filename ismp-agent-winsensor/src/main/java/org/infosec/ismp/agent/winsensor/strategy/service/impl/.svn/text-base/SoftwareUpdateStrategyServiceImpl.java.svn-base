package org.infosec.ismp.agent.winsensor.strategy.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.dao.SoftwareUpdateStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.SoftwareUpdateStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.service.SoftwareUpdateStrategyService;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:38:37 PM
 * 
 */
public class SoftwareUpdateStrategyServiceImpl implements
		SoftwareUpdateStrategyService {
	
	private SoftwareUpdateStrategyDao strategyDao;

	@Override
	public void addStrategy(SoftwareUpdateStrategyBO strategy) {
		SoftwareUpdateStrategyBO oldStrategy = findStrategy(strategy.getIp(), strategy.getSensorId(), false);
		if (oldStrategy != null) {
			oldStrategy.setCovered(1);
			oldStrategy.setIssued(1);
			oldStrategy.setIssueTime(new Date());
			strategyDao.updateStrategy(oldStrategy);
		}
		
		if (strategy.getCreateTime() == null) {
			strategy.setCreateTime(new Date());
		}
		strategyDao.addStrategy(strategy);
	}

	@Override
	public List<SoftwareUpdateStrategyBO> findAllUnissuedStrategy() {
		return strategyDao.findAllUnissuedStrategy();
	}

	@Override
	public SoftwareUpdateStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		return strategyDao.findStrategy(ip, sensorId, issued);
	}

	@Override
	public void updateStrategy(SoftwareUpdateStrategyBO strategy) {
		strategyDao.updateStrategy(strategy);
	}

	public SoftwareUpdateStrategyDao getStrategyDao() {
		return strategyDao;
	}

	public void setStrategyDao(SoftwareUpdateStrategyDao strategyDao) {
		this.strategyDao = strategyDao;
	}
}
