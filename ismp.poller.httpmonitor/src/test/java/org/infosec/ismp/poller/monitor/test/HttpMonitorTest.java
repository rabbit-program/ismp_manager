package org.infosec.ismp.poller.monitor.test;

import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.poller.monitors.test.MonitorTest;

public class HttpMonitorTest {
	public static void main(String[] args) {
		MonitorTest test = new MonitorTest();
		test.setIpAddr("www.qidian.com");
		test.setClassName("org.infosec.ismp.poller.monitor.http.HttpMonitor");
		Map parameters = new HashMap();
		parameters.put("port", "80");
		parameters.put("url", "http://www.qidian.com");
		test.setParameters(parameters);
		test.test();
	}
}
