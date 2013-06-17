package org.infosec.ismp.manager.servicecheck;


import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.manager.rmi.scm.service.ServiceMonitor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddHTTPServiceCheckRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml",
				"serviceCheck/applicationContext-serviceCheck-rmi-client.xml");
		ServiceMonitor serviceMonitor = (ServiceMonitor)context.getBean("serviceCheckControllerClient");
		Map<String,String> parameters = new HashMap<String,String>();
		parameters.put("port", "80");
		parameters.put("url", "http://www.pudong.gov.cn");
		serviceMonitor.registerServiceMonitor("testDomain", "003", "servicecheck.monitor.http", "www.pudong.gov.cn", 5000, parameters);

	}

}
