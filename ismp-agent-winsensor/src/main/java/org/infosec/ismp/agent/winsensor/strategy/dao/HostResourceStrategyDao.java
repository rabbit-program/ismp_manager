package org.infosec.ismp.agent.winsensor.strategy.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.HostResourceStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:25:52 PM
 * 
 */
public interface HostResourceStrategyDao {
	public void addStrategy(HostResourceStrategyBO strategy);
	
	public void updateStrategy(HostResourceStrategyBO strategy);
	
	public HostResourceStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<HostResourceStrategyBO>findAllUnissuedStrategy();
}
