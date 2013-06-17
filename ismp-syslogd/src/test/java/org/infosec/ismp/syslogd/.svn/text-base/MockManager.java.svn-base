package org.infosec.ismp.syslogd;

import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.syslogd.manager.SyslogEventProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class MockManager {
	public static void main(String[] args) throws Exception {
		Log4jConfigurer.initLogging("classpath:manager/log4j.properties");

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:manager/applicationContext.xml",
						"classpath:manager/applicationContext-manager.xml" });
		
		Eventd eventd = (Eventd)ctx.getBean("eventd");
		eventd.start();
		
		SyslogEventProcessor processor = new SyslogEventProcessor();
		
		System.out.println("--------------start manager-----------------");
	}
}
