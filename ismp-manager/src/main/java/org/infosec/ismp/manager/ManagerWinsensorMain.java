package org.infosec.ismp.manager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagerWinsensorMain {
private static Log log = LogFactory.getLog(ManagerWinsensorMain.class);
	
	private ApplicationContext context;
	
	public void init() {
		context = new ClassPathXmlApplicationContext(
				new String[] {
						"classpath:winsensor/applicationContext-dao.xml",
						"classpath:winsensor/applicationContext-service.xml",
						"classpath:winsensor/applicationContext-winsensor.xml",
						"classpath:winsensor/applicationContext-jms.xml",
						"classpath:winsensor/applicationContext-rmi-client.xml",
						"classpath:winsensor/applicationContext-rmi.xml"
				});
	}
}
