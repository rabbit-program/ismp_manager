package org.infosec.ismp.agent.winsensor.strategy.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.dao.RegisterStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.RegisterStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.service.RegisterStrategyService;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:38:12 PM
 * 
 */
public class RegisterStrategyServiceImpl implements RegisterStrategyService {
	
	private RegisterStrategyDao strategyDao;

	@Override
	public void addStrategy(RegisterStrategyBO strategy) {
		RegisterStrategyBO oldStrategy = findStrategy(strategy.getIp(), strategy.getSensorId(), false);
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
	public List<RegisterStrategyBO> findAllUnissuedStrategy() {
		return strategyDao.findAllUnissuedStrategy();
	}

	@Override
	public RegisterStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		return strategyDao.findStrategy(ip, sensorId, issued);
	}

	@Override
	public void updateStrategy(RegisterStrategyBO strategy) {
		strategyDao.updateStrategy(strategy);
	}

	public RegisterStrategyDao getStrategyDao() {
		return strategyDao;
	}

	public void setStrategyDao(RegisterStrategyDao strategyDao) {
		this.strategyDao = strategyDao;
	}
}
