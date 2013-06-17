package org.infosec.ismp.manager.sitecheck;


import org.infosec.ismp.manager.rmi.wsm.service.SiteCheckRmiInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddSiteCheckRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","siteCheck/applicationContext-siteCheck-rmi-client.xml");
		SiteCheckRmiInterface siteCheckRmi = (SiteCheckRmiInterface)context.getBean("siteCheckControllerClient");
		siteCheckRmi.addSiteCheck("testDomain", "010", "www.163.com", 3000, 6000);
	}

}
