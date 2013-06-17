package org.infosec.ismp.agent.winsensor.strategy.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsUpdateStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:27:04 PM
 * 
 */
public interface WindowsUpdateStrategyDao {
	public void addStrategy(WindowsUpdateStrategyBO strategy);
	
	public void updateStrategy(WindowsUpdateStrategyBO strategy);
	
	public WindowsUpdateStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<WindowsUpdateStrategyBO>findAllUnissuedStrategy();
}
