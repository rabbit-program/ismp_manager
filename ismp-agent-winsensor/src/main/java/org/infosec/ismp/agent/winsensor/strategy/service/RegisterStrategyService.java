package org.infosec.ismp.agent.winsensor.strategy.service;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.RegisterStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:29:30 PM
 * 
 */
public interface RegisterStrategyService {
	public void addStrategy(RegisterStrategyBO strategy);
	
	public void updateStrategy(RegisterStrategyBO strategy);
	
	public RegisterStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<RegisterStrategyBO>findAllUnissuedStrategy();
}
