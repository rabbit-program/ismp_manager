package org.infosec.ismp.agent.winsensor.strategy.service;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsLogStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:30:13 PM
 * 
 */
public interface WindowsLogStrategyService {
	public void addStrategy(WindowsLogStrategyBO strategy);
	
	public void updateStrategy(WindowsLogStrategyBO strategy);
	
	public WindowsLogStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<WindowsLogStrategyBO>findAllUnissuedStrategy();
}
