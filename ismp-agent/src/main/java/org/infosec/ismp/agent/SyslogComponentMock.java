package org.infosec.ismp.agent;

import org.infosec.ismp.syslogd.Syslogd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SyslogComponentMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { 
						"classpath:jms/applicationContext-jms.xml",//资源定义文件
						 });
		Syslogd syslogd = (Syslogd)ctx.getBean("syslogd");
		syslogd.start();

	}

}
