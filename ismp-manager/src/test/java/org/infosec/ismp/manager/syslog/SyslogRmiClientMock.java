package org.infosec.ismp.manager.syslog;

import org.infosec.ismp.manager.rmi.syslog.SyslogController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SyslogRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:syslog/applicationContext-syslog-rmiclient.xml");
		
		SyslogController controller = (SyslogController)context.getBean("syslogRmiClient");
		
		controller.addSyslogSource("0001", "0001", "hillstone", "192.168.9.58");

	}

}
