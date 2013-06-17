package org.infosec.ismp.manager.servicecheck;


import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.manager.rmi.scm.service.ServiceMonitor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddIMAPServiceCheckRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",
				"serviceCheck/applicationContext-serviceCheck-rmi-client.xml");
		ServiceMonitor serviceMonitor = (ServiceMonitor)context.getBean("serviceCheckControllerClient");
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("port", "143");
		parameters.put("retry", "3");
		parameters.put("timeout", "3000");
		serviceMonitor.registerServiceMonitor("testDomain", "006", "servicecheck.monitor.imap", "127.0.0.1", 5000, parameters);

	}

}
