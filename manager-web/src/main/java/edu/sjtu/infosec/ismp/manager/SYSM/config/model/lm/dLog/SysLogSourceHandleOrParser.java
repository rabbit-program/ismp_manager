package edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lm_dl_syslog_handle_or_parser")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysLogSourceHandleOrParser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 457309958903726796L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * agent 应该使用哪个Class来处理Message
	 */
	@Column(name="agent_handle_class")
	private String agentHandleClass;
	
	/**
	 * managerServer 应该使用哪个Filter来处理Message
	 */
	@Column(name="server_handle_class")
	private String serverHandleClass;
	
	/**
	 * managerWeb 应该使用哪个Servlet来处理Action摆渡
	 */
	@Column(name="web_handle_class")
	private String webHandleClass;
	
	/**
	 * 用于辨别哪类设备的处理
	 */
	@Column(name="handle_type")
	private String handleType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgentHandleClass() {
		return agentHandleClass;
	}

	public void setAgentHandleClass(String agentHandleClass) {
		this.agentHandleClass = agentHandleClass;
	}

	public String getServerHandleClass() {
		return serverHandleClass;
	}

	public void setServerHandleClass(String serverHandleClass) {
		this.serverHandleClass = serverHandleClass;
	}

	public String getWebHandleClass() {
		return webHandleClass;
	}

	public void setWebHandleClass(String webHandleClass) {
		this.webHandleClass = webHandleClass;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}
	
}
