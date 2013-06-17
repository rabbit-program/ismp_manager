package org.infosec.ismp.manager.rmi.event.dao.queryResult;

import java.util.List;

import org.infosec.ismp.manager.rmi.event.dao.Status;
import org.infosec.ismp.manager.rmi.event.modle.Eventcorrrule;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;
import org.infosec.ismp.manager.rmi.event.util.Page;

/**
 * 存放Eventrealdisp的查询结果
 * @author wudengke 2009-6-29
 *
 */
public class EventrealdispResult {
	
	private Eventrealdisp result;

	private List<Eventrealdisp> results;
	
	private List<Object> list;
	
	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	private Page page;
	
	private Status status;
	
	private Eventcorrrule data;

	public Eventcorrrule getData() {
		return data;
	}

	public void setData(Eventcorrrule data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Eventrealdisp getResult() {
		return result;
	}

	public void setResult(Eventrealdisp result) {
		this.result = result;
	}

	public List<Eventrealdisp> getResults() {
		return results;
	}

	public void setResults(List<Eventrealdisp> results) {
		this.results = results;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
