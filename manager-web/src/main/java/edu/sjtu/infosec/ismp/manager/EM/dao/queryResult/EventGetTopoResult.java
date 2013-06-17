package edu.sjtu.infosec.ismp.manager.EM.dao.queryResult;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.Status;

public class EventGetTopoResult {
	
	private List<Object[]> datas;
	
	private Page page;
	
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Object[]> getDatas() {
		return datas;
	}

	public void setDatas(List<Object[]> datas) {
		this.datas = datas;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
