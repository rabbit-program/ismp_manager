package org.infosec.ismp.poller;

import java.util.Collection;

import org.infosec.ismp.model.poller.ServiceMonitor;
import org.infosec.ismp.poller.pollable.Service;

public interface PollerConfig {

	void releaseAllServiceMonitors();

	int getThreads();

	ServiceMonitor getServiceMonitor(String svcName);

	String getCriticalService();

	boolean serviceUnresponsiveEnabled();

	Collection<Service> getServiceCollection();

	/**
	 * 是否有关键IP测试是否outage
	 * @return
	 */
	boolean pathOutageEnabled();

	String getNextOutageIdSql();

}
