package org.infosec.ismp.agent.winsensor.strategy.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.dao.WindowsUpdateStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsUpdateStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.service.WindowsUpdateStrategyService;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:39:25 PM
 * 
 */
public class WindowsUpdateStrategyServiceImpl implements
		WindowsUpdateStrategyService {
	
	private WindowsUpdateStrategyDao strategyDao;

	@Override
	public void addStrategy(WindowsUpdateStrategyBO strategy) {
		WindowsUpdateStrategyBO oldStrategy = findStrategy(strategy.getIp(), strategy.getSensorId(), false);
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
	public List<WindowsUpdateStrategyBO> findAllUnissuedStrategy() {
		return strategyDao.findAllUnissuedStrategy();
	}

	@Override
	public WindowsUpdateStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		return strategyDao.findStrategy(ip, sensorId, issued);
	}

	@Override
	public void updateStrategy(WindowsUpdateStrategyBO strategy) {
		strategyDao.updateStrategy(strategy);
	}

	public WindowsUpdateStrategyDao getStrategyDao() {
		return strategyDao;
	}

	public void setStrategyDao(WindowsUpdateStrategyDao strategyDao) {
		this.strategyDao = strategyDao;
	}
}
