package org.infosec.ismp.manager.direct;

import java.io.File;
import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.manager.ManagerMain;
import org.infosec.ismp.manager.agent.AgentFileFactory;
import org.infosec.ismp.manager.rmi.scm.model.PollStatus;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class DirectToAgent {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Log4jConfigurer.initLogging("classpath:log4j.properties");

		// 初始化Agent资源文件
		try {
			AgentFileFactory.init(new File("d:/temp"));
		} catch (Throwable t) {
			ThreadCategory.getInstance(ManagerMain.class.getClass()).fatal(
					"初始化SNMP资源配置失败，请检查 :", t);
			System.exit(1);
		}

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext.xml",
						"classpath:jms/applicationContext-jms.xml",
						"classpath:ping/applicationContext-ping.xml" });
		
		InetAddress host = InetAddress.getByName("127.0.0.1");
		int port = 5819;
		
		DirectRequestSender directRequestSender =(DirectRequestSender)ctx.getBean("directPingSender");
		
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.DIRECTPING_NODE_PING_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setIpAddr("192.168.9.254");
		
		PollStatus result =(PollStatus)directRequestSender.sendEvent(host, port, event, 30000);
		
		System.out.println("result is : "+result);

	}

}
