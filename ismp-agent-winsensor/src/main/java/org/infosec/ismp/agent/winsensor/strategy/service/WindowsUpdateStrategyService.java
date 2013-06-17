package org.infosec.ismp.agent.winsensor.strategy.service;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsUpdateStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:30:37 PM
 * 
 */
public interface WindowsUpdateStrategyService {
	public void addStrategy(WindowsUpdateStrategyBO strategy);
	
	public void updateStrategy(WindowsUpdateStrategyBO strategy);
	
	public WindowsUpdateStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<WindowsUpdateStrategyBO>findAllUnissuedStrategy();
}
