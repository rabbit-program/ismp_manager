package org.infosec.ismp.manager.rmi.wsm.service;


import org.infosec.ismp.manager.rmi.wsm.model.SiteCheckRmiModel;

/**
 * 网页检测服务RMI接口
 * @author jiel
 *
 */
public interface SiteCheckRmiInterface {

	/**
	 * 新增检测页面
	 * @param domainId
	 * @param nodeId
	 * @param url
	 * @param interval
	 * @param outTime
	 */
	public void addSiteCheck(String domainId,String nodeId,String url,long interval,long outTime);
	/**
	 * 删除检测页面	
	 * @param nodeId
	 */
	public void removeSiteCheck(String nodeId);
	/**
	 * 重置检测页面
	 * @param nodeId
	 */
	public void resetSiteCheck(String nodeId);
	/**
	 * 修改检测页面
	 * @param nodeId
	 * @param url
	 * @param interval
	 * @param outTime
	 */
	public void updateSiteCheck(String nodeId,String url,long interval,long outTime);
	/**
	 * 获取检测结果
	 * @param nodeId
	 * @return
	 */
	public SiteCheckRmiModel getSiteCheck(String nodeId);
}
