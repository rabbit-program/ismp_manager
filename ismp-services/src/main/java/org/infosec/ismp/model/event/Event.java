package org.infosec.ismp.model.event;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 代表系统内部发生的事件，例如增加、删除节点等，便于各个子系统之间的通信。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 * TODO : 根据后面的实现添加具体的内容。
 */
public class Event implements Serializable {
	private String uuid;// 事件唯一id
	private String uei;// universal event id，事件类型代号
	private Date time;// event time

	private String source;// 来源于那个服务

	private String host;// from host;

	private int nodeId;

	private String NetInterface;

	private String service;

	private String severity;

	private Date creationTime;// create event time

	private String descr;

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	// other parameter value
	private final Map<String, String> params = new HashMap<String, String>();

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUei() {
		return uei;
	}

	public void setUei(String uei) {
		this.uei = uei;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public String getNetInterface() {
		return NetInterface;
	}

	public void setNetInterface(String netInterface) {
		NetInterface = netInterface;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void addParam(String parmName, String value) {
		params.put(parmName, value);
	}

}
