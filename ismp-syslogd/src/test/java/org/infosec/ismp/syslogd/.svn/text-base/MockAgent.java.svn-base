package org.infosec.ismp.syslogd;

import org.infosec.ismp.eventd.Eventd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class MockAgent {
    public static void main(String[] args) throws Exception{
    	// 加载log4j配置文件
		Log4jConfigurer.initLogging("classpath:agent/log4j.properties");

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { 
						"classpath:agent/applicationContext.xml", 
						"classpath:agent/applicationContext-agent.xml" });
		
		Eventd eventd = (Eventd)ctx.getBean("eventd");
		eventd.start();
		
//		AgentRegister register = (AgentRegister)ctx.getBean("agentRegister");
//		register.start();
		
		
		Syslogd syslogd = (Syslogd)ctx.getBean("syslogd");
//		syslogd.start();
	}
}
