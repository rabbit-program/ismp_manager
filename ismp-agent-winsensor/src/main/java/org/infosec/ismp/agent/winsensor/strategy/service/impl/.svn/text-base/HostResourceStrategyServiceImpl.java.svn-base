package org.infosec.ismp.agent.winsensor.strategy.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.dao.HostResourceStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.HostResourceStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.service.HostResourceStrategyService;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:37:49 PM
 * 
 */
public class HostResourceStrategyServiceImpl implements
		HostResourceStrategyService {
	
	private HostResourceStrategyDao strategyDao;

	@Override
	public void addStrategy(HostResourceStrategyBO strategy) {
		HostResourceStrategyBO oldStrategy = findStrategy(strategy.getIp(), strategy.getSensorId(), false);
		if (oldStrategy != null) {
			oldStrategy.setIssued(1);
			oldStrategy.setCovered(1);
			oldStrategy.setIssueTime(new Date());
			strategyDao.updateStrategy(oldStrategy);
		}
		
		if (strategy.getCreateTime() == null) {
			strategy.setCreateTime(new Date());
		}
		strategyDao.addStrategy(strategy);
	}

	@Override
	public List<HostResourceStrategyBO> findAllUnissuedStrategy() {
		return strategyDao.findAllUnissuedStrategy();
	}

	@Override
	public HostResourceStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		return strategyDao.findStrategy(ip, sensorId, issued);
	}

	@Override
	public void updateStrategy(HostResourceStrategyBO strategy) {
		strategyDao.updateStrategy(strategy);
	}

	public HostResourceStrategyDao getStrategyDao() {
		return strategyDao;
	}

	public void setStrategyDao(HostResourceStrategyDao strategyDao) {
		this.strategyDao = strategyDao;
	}
}
