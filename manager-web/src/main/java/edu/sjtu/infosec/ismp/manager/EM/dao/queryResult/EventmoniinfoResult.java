package edu.sjtu.infosec.ismp.manager.EM.dao.queryResult;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.Status;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoniinfo;

/**
 * 存放Eventmoniinfo的查询结果
 * @author wudengke 2009-6-29
 *
 */
public class EventmoniinfoResult {
	
	private Eventmoniinfo result;

	private List<Eventmoniinfo> results;
	
	private Page page;
	
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Eventmoniinfo getResult() {
		return result;
	}

	public void setResult(Eventmoniinfo result) {
		this.result = result;
	}

	public List<Eventmoniinfo> getResults() {
		return results;
	}

	public void setResults(List<Eventmoniinfo> results) {
		this.results = results;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
