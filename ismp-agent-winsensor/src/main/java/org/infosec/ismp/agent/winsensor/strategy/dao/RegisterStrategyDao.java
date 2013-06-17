package org.infosec.ismp.agent.winsensor.strategy.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.RegisterStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:26:10 PM
 * 
 */
public interface RegisterStrategyDao {
	public void addStrategy(RegisterStrategyBO strategy);
	
	public void updateStrategy(RegisterStrategyBO strategy);
	
	public RegisterStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<RegisterStrategyBO>findAllUnissuedStrategy();
}
