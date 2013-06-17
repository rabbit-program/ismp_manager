package org.infosec.ismp.ping;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PingdTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
		Pingd pingd =(Pingd) context.getBean("pingd");
		pingd.onStart();

		pingd.ping("1", "192.168.9.254", 20000, true);
		pingd.ping("2", "192.168.9.136", 20000, true);
		try {
			Thread.sleep(50000);
			pingd.ping("1", "192.168.9.253", 10000, true);		
			Thread.sleep(50000);
			pingd.unping("1");
			pingd.unping("2");	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
