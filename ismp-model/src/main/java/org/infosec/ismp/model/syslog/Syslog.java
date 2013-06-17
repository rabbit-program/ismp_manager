package org.infosec.ismp.model.syslog;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 表示syslog信息,
 * 参见syslog文档，添加了一个属性ipaddr，因为有的syslog报文无地址，只有将接受地址认为是设备地址。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class Syslog implements Serializable{
	private String nodeid;
	private String timestamp;
	private String hostname;
	private String ipaddr;
	private String msg;
	private String facility;
	private String severity;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	
	
	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

}
