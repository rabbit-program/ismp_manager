package org.infosec.ismp.agent.winsensor.strategy.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.strategy.entity.SoftwareUpdateStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:26:28 PM
 * 
 */
public interface SoftwareUpdateStrategyDao {
	public void addStrategy(SoftwareUpdateStrategyBO strategy);
	
	public void updateStrategy(SoftwareUpdateStrategyBO strategy);
	
	public SoftwareUpdateStrategyBO findStrategy(String ip, String sensorId, boolean issued);
	
	public List<SoftwareUpdateStrategyBO>findAllUnissuedStrategy();
}
