package org.infosec.ismp.agent.comm.winsensor.model.status;

import java.io.Serializable;

/**
 * @author Rocky
 * @version create time：Oct 15, 2010 10:55:10 AM
 * 
 */
public class LocalDNS implements Serializable {

	private static final long serialVersionUID = -1043271538363570874L;
	
	private String domain;
	
	private String ip;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
