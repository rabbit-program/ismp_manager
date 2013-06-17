package org.infosec.ismp.poller.monitors.test;

import java.util.Map;

import org.infosec.ismp.model.poller.PollStatus;
import org.infosec.ismp.model.poller.ServiceMonitor;

public class MonitorTest {
	private Map<String, Object> m_parameters;

	private String m_ipAddr;

	private String className;

	private ServiceMonitor m_monitor;

	private void initMonitor() {
		if (m_monitor == null) {
			try {
				Class clz = Class.forName(className);
				m_monitor = (ServiceMonitor) clz.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private PollStatus testPoll() {
		if (m_monitor != null) {
			m_monitor.initialize(m_parameters);
			TestMonitoredService svc = new TestMonitoredService(m_ipAddr);
			PollStatus status = m_monitor.poll(svc, m_parameters);
			System.out.println("status is : " + status);
			System.out
					.println("response time is : " + status.getResponseTime());
			return status;
		}
		return null;
	}

	public void setParameters(Map<String, Object> parameters) {
		m_parameters = parameters;
	}

	public void setIpAddr(String ipAddr) {
		m_ipAddr = ipAddr;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public PollStatus test() {
		initMonitor();
		return testPoll();
	}

}
