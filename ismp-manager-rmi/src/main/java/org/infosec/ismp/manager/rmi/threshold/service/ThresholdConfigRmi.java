package org.infosec.ismp.manager.rmi.threshold.service;

import org.infosec.ismp.manager.rmi.threshold.AlertType;


/**
 * @author guoxianwei
 * @date 2010-12-29 下午05:03:22
 *  阈值设置接口
 */
public interface ThresholdConfigRmi {
	
	//阈值设定
	public void setThreshConfig(String nodeid, AlertType type,String value, int level,Number threshold);
	
	
	//阈值删除
	public void deleteThreshConfig(String nodeid, AlertType type ,String value);

}

