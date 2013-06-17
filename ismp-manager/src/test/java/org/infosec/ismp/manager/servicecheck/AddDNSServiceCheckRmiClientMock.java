package org.infosec.ismp.manager.servicecheck;


import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.manager.rmi.scm.service.ServiceMonitor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddDNSServiceCheckRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",
				"serviceCheck/applicationContext-serviceCheck-rmi-client.xml");
		ServiceMonitor serviceMonitor = (ServiceMonitor)context.getBean("serviceCheckControllerClient");
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("port", "53");
		parameters.put("lookup", "202.96.199.133");
		serviceMonitor.registerServiceMonitor("testDomain", "001", "servicecheck.monitor.dns", "202.96.199.133", 10000, parameters);

	}

}
