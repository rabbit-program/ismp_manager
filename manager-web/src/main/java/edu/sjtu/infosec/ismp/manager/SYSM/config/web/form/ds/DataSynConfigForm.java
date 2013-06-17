package edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.ds;

import org.apache.struts.action.ActionForm;

public class DataSynConfigForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	
	private String centerIp;
	private String dataSynPort;
	
	public String getCenterIp() {
		return centerIp;
	}
	public void setCenterIp(String centerIp) {
		this.centerIp = centerIp;
	}
	public String getDataSynPort() {
		return dataSynPort;
	}
	public void setDataSynPort(String dataSynPort) {
		this.dataSynPort = dataSynPort;
	}
	
	
	
	
}
