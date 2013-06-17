package org.infosec.ismp.collectd.services;

import org.infosec.ismp.util.scheduler.ScheduleInterval;

/**
 * 每个Snmp collect service 对应的配置
 * 
 * @author lianglin
 * 
 */
public class SnmpCollectableConfig implements ScheduleInterval {

	private SnmpCollectableService m_collectableService;
	
	public SnmpCollectableConfig(SnmpCollectableService service) {
		this.m_collectableService = service;
	}

	/**
	 * 采集的间隔,取决于上次采集是否成功,如果没有成功,将采集间隔缩短到30秒,常规为3分钟.
	 */
	@Override
	public long getInterval() {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		if (m_collectableService.isDeleted()) {
			return -1;
		}
		if (m_collectableService.isCollectFailed()) {
			return 30 * 1000L;
		}
		return 3 * 60 * 1000;
	}

	/**
	 * 是否暂停该服务
	 */
	@Override
	public boolean scheduledSuspension() {
		if (m_collectableService.isCollectFailed()) {
			long lastSuccessTime = m_collectableService.getLastSuccessTime();
			long now = System.currentTimeMillis();
			if (now - lastSuccessTime > 30 * 1000 * 10L) {
                if(!m_collectableService.isSnmpAvailable()){
                	return true;
                }
			}
		}
		return false;
	}
}
