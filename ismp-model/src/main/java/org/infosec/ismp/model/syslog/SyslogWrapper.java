package org.infosec.ismp.model.syslog;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SyslogWrapper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4653083131919743741L;
	private Syslog syslog;
	private String uei;
	private String fromIp;
	private String uuid;

	private String domain;
	private String logSource;
	

	public Syslog getSyslog() {
		return syslog;
	}

	public void setSyslog(Syslog syslog) {
		this.syslog = syslog;
	}

	public String getUei() {
		return uei;
	}

	public void setUei(String uei) {
		this.uei = uei;
	}

	public String getFromIp() {
		return fromIp;
	}

	public void setFromIp(String fromIp) {
		this.fromIp = fromIp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getLogSource() {
		return logSource;
	}

	public void setLogSource(String logSource) {
		this.logSource = logSource;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


	
}
