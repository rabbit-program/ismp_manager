package org.infosec.ismp.agent.winsensor.strategy.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.dao.WinsensorManagerStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.WinsensorManagerStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.service.WinsensorManagerStrategyService;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:39:50 PM
 * 
 */
public class WinsensorManagerStrategyServiceImpl implements
		WinsensorManagerStrategyService {
	
	private WinsensorManagerStrategyDao strategyDao;

	@Override
	public void addStrategy(WinsensorManagerStrategyBO strategy) {
		WinsensorManagerStrategyBO oldStrategy = findStrategy(strategy.getIp(), strategy.getSensorId(), false);
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
	public List<WinsensorManagerStrategyBO> findAllUnissuedStrategy() {
		return strategyDao.findAllUnissuedStrategy();
	}

	@Override
	public WinsensorManagerStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		return strategyDao.findStrategy(ip, sensorId, issued);
	}

	@Override
	public void updateStrategy(WinsensorManagerStrategyBO strategy) {
		strategyDao.updateStrategy(strategy);		
	}

	public WinsensorManagerStrategyDao getStrategyDao() {
		return strategyDao;
	}

	public void setStrategyDao(WinsensorManagerStrategyDao strategyDao) {
		this.strategyDao = strategyDao;
	}
}
