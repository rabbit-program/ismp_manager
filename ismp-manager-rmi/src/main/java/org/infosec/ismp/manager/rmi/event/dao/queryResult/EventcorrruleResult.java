package org.infosec.ismp.manager.rmi.event.dao.queryResult;

import java.util.List;

import org.infosec.ismp.manager.rmi.event.modle.Eventcorrrule;
import org.infosec.ismp.manager.rmi.event.util.Page;

/**
 * 存放Eventcorrrule的查询结果
 * @author wudengke
 * @version 创建时间：2009-6-17 上午10:25:26
 * 
 */
public class EventcorrruleResult {
	
	private List<Eventcorrrule> evcors;
	
	private Page page;

	public List<Eventcorrrule> getEvcors() {
		return evcors;
	}

	public void setEvcors(List<Eventcorrrule> evcors) {
		this.evcors = evcors;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


}
