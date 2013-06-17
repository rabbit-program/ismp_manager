package org.infosec.ismp.manager.sitecheck;

import org.infosec.ismp.manager.rmi.wsm.model.SiteCheckRmiModel;
import org.infosec.ismp.manager.rmi.wsm.service.SiteCheckRmiInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetSiteCheckResultRmiClinetMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","siteCheck/applicationContext-siteCheck-rmi-client.xml");
		SiteCheckRmiInterface siteCheckRmi = (SiteCheckRmiInterface)context.getBean("siteCheckControllerClient");
		SiteCheckRmiModel model = siteCheckRmi.getSiteCheck("010");
		if(null!=model){
			System.out.println(model.getNodeid());
			System.out.println(model.getPingStatus());
			System.out.println(model.getResponseTime());
			System.out.println(model.getSiteCheckStatus());
			System.out.println(model.getSiteCheckTime());
			System.out.println(model.getUrl());
		}
	}

}
