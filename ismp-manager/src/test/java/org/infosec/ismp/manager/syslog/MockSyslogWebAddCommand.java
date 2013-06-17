package org.infosec.ismp.manager.syslog;

import org.infosec.ismp.manager.rmi.syslog.SyslogController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockSyslogWebAddCommand {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext-syslog-client.xml" });

		SyslogController c = (SyslogController)context.getBean("syslogControllerClient");
		c.addSyslogSource("testDomain", "222", "hillstone", "192.168.9.58");
	}
}
