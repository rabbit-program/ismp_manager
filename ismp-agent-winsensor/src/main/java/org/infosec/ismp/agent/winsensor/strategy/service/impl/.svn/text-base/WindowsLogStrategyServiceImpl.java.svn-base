package org.infosec.ismp.agent.winsensor.strategy.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.dao.WindowsLogStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsLogStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.service.WindowsLogStrategyService;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:39:03 PM
 * 
 */
public class WindowsLogStrategyServiceImpl implements WindowsLogStrategyService {
	
	private WindowsLogStrategyDao strategyDao;

	@Override
	public void addStrategy(WindowsLogStrategyBO strategy) {
		WindowsLogStrategyBO oldStrategy = findStrategy(strategy.getIp(), strategy.getSensorId(), false);
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
	public List<WindowsLogStrategyBO> findAllUnissuedStrategy() {
		return strategyDao.findAllUnissuedStrategy();
	}

	@Override
	public WindowsLogStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		return strategyDao.findStrategy(ip, sensorId, issued);
	}

	@Override
	public void updateStrategy(WindowsLogStrategyBO strategy) {
		strategyDao.updateStrategy(strategy);		
	}

	public WindowsLogStrategyDao getStrategyDao() {
		return strategyDao;
	}

	public void setStrategyDao(WindowsLogStrategyDao strategyDao) {
		this.strategyDao = strategyDao;
	}
}
