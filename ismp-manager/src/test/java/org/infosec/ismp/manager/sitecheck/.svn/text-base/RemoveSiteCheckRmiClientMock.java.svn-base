package org.infosec.ismp.manager.sitecheck;


import org.infosec.ismp.manager.rmi.wsm.service.SiteCheckRmiInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RemoveSiteCheckRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","siteCheck/applicationContext-siteCheck-rmi-client.xml");
		SiteCheckRmiInterface siteCheckRmi = (SiteCheckRmiInterface)context.getBean("siteCheckControllerClient");
		siteCheckRmi.removeSiteCheck("010");
	}

}
