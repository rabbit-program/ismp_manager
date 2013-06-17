package org.infosec.ismp.agent.winsensor.strategy.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.WinsensorManagerStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:28:10 PM
 * 
 */
public interface WinsensorManagerStrategyDao {
	public void addStrategy(WinsensorManagerStrategyBO strategy);
	
	public void updateStrategy(WinsensorManagerStrategyBO strategy);
	
	public WinsensorManagerStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<WinsensorManagerStrategyBO>findAllUnissuedStrategy();
}
