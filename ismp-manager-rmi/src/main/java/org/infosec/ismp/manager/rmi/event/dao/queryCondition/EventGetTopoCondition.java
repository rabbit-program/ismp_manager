package org.infosec.ismp.manager.rmi.event.dao.queryCondition;

import org.infosec.ismp.manager.rmi.event.util.Page;


/**
 * 存放取Topo时的条件
 * @author wudengke 2009-6-29
 *
 */
public class EventGetTopoCondition {
	
	//一系列设备IP地址
	private String[] netCardCodes;
	
	//分页
	private Page page;
	
	private Integer[] bureauId;

	public Integer[] getBureauId() {
		return bureauId;
	}

	public void setBureauId(Integer[] bureauId) {
		this.bureauId = bureauId;
	}

	public String[] getNetCardCodes() {
		return netCardCodes;
	}

	public void setNetCardCodes(String[] netCardCodes) {
		this.netCardCodes = netCardCodes;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
