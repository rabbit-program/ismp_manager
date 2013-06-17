package org.infosec.ismp.agent.winsensor.strategy.service;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommBaseStrategy;
import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;
import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;

/**
 * @author Rocky
 * @version create time：Oct 21, 2010 6:20:12 PM
 * 
 */
public interface StrategyService {
	public List<BaseStrategy> getAllTypeUnissuedStrategy(WinsensorDeviceBO device);
	
	public Map<String, List<BaseStrategy>> getAllTypeUnissuedStrategy(List<String> sensorIds);
	
	public void addStrategy(List<CommBaseStrategy> strategies);
	
	public void updateStrategy(List<BaseStrategy> strategies);
}
