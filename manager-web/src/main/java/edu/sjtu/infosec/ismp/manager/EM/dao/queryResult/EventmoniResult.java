package edu.sjtu.infosec.ismp.manager.EM.dao.queryResult;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.Status;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoni;

/**
 * Ｅｖｅｎｔｍｏｎｉ查询结果
 * @author wudengke 2009-6-29
 *
 */
public class EventmoniResult {
	
	private List<Eventmoni> results;
	
	private Page page;
	
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Eventmoni> getResults() {
		return results;
	}

	public void setResults(List<Eventmoni> results) {
		this.results = results;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
