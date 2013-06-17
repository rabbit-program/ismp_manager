package org.infosec.ismp.agent.winsensor.strategy.service;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.HostResourceStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:29:03 PM
 * 
 */
public interface HostResourceStrategyService {
	public void addStrategy(HostResourceStrategyBO strategy);
	
	public void updateStrategy(HostResourceStrategyBO strategy);
	
	public HostResourceStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<HostResourceStrategyBO>findAllUnissuedStrategy();
}
