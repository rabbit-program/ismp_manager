package org.infosec.ismp.manager.winsensor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Rocky
 * @version create time：Dec 17, 2010 2:20:37 PM
 * 
 */
public class ManagerWinsensorMain {
	
	private static Log log = LogFactory.getLog(ManagerWinsensorMain.class);
	
	private ApplicationContext context;
	
	public void init() {
		context = new ClassPathXmlApplicationContext(
				new String[] {
						"classpath:applicationContext-resources.xml",
						"classpath:applicationContext-dao.xml",
						"classpath:applicationContext-service.xml",
						"classpath:applicationContext-winsensor.xml",
						"classpath:applicationContext-jms.xml",
						"classpath:applicationContext-rmi-client.xml",
						"classpath:applicationContext-rmi.xml"
				});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ManagerWinsensorMain managerWinsensorMain = new ManagerWinsensorMain();
		managerWinsensorMain.init();
	}

}
