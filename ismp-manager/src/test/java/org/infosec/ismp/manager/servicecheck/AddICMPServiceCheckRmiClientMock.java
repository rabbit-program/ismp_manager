package org.infosec.ismp.manager.servicecheck;


import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.manager.rmi.scm.service.ServiceMonitor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddICMPServiceCheckRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",
				"serviceCheck/applicationContext-serviceCheck-rmi-client.xml");
		ServiceMonitor serviceMonitor = (ServiceMonitor)context.getBean("serviceCheckControllerClient");
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("retry", "3");
		parameters.put("timeout", "3000");
		serviceMonitor.registerServiceMonitor("testDomain", "005", "servicecheck.monitor.icmp", "127.0.0.1", 5000, parameters);

	}

}
