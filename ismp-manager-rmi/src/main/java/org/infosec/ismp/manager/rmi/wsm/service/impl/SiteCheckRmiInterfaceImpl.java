package org.infosec.ismp.manager.rmi.wsm.service.impl;

import org.infosec.ismp.manager.rmi.wsm.model.SiteCheckRmiModel;
import org.infosec.ismp.manager.rmi.wsm.service.SiteCheckRmiInterface;

public class SiteCheckRmiInterfaceImpl implements SiteCheckRmiInterface {

	public void addSiteCheck(String domainId, String nodeId, String url,
			long interval, long outTime) {
		System.out.println("domainId=="+domainId);
		System.out.println("nodeId=="+nodeId);
		System.out.println("url=="+url);
		System.out.println("interval=="+interval);
		System.out.println("outTime=="+outTime);
	}

	public SiteCheckRmiModel getSiteCheck(String nodeId) {
		SiteCheckRmiModel model = new SiteCheckRmiModel();
		int i = (int)(Math.random()*100);
		if(i%2==0){
			model.setPingStatus("Up");
		}else{
			model.setPingStatus("Down");
		}
		model.setResponseTime(i);
		if(i%2==0){
			model.setSiteCheckStatus("NORMAL");
		}else{
			model.setSiteCheckStatus("EXCEPTION");
		}
		System.out.println("nodeId="+nodeId);
		return model;
	}

	public void removeSiteCheck(String nodeId) {
		System.out.println("nodeId="+nodeId);

	}

	public void resetSiteCheck(String nodeId) {
		System.out.println("nodeId="+nodeId);
	}

	public void updateSiteCheck(String nodeId, String url, long interval,
			long outTime) {
		System.out.print("nodeId="+nodeId);
		System.out.println("url=="+url);
		System.out.println("interval=="+interval);
		System.out.println("outTime=="+outTime);
	}

}
