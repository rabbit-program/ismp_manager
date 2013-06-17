package org.infosec.ismp.manager.rmi.tm.discover.model.appletForm;

import java.io.Serializable;

//import edu.sjtu.infosec.ismp.base.agent.model.AgentBO;

/**
 * PCApplet页面数据封装类
 * @author Wu Guojie
 * @date 2009-6-9
 * @version 1.0
 */
public class PCAppletForm implements Serializable {
	/**
	 * 开始IP
	 */
	private String startIP;
	/**
	 * 结束IP
	 */
	private String endIP;
//	/**
//	 * 用于获取数据的agent
//	 */
//	private AgentBO agentBO;
	/**
	 * 操作人
	 */
	private int userId;
//	/**
//	 * 操作人
//	 */
//	private String userName;
//	/**
//	 * 权限，以“,”间隔
//	 */
//	private String roleName;
	
	



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getRoleName() {
//		return roleName;
//	}
//
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}

	/**
	 * @return startIP
	 */
	public String getStartIP() {
		return startIP;
	}

	/**
	 * @param startIP
	 * startIP
	 */
	public void setStartIP(String startIP) {
		this.startIP = startIP;
	}
	
	/**
	 * @return endIP
	 */
	public String getEndIP() {
		return endIP;
	}

	/**
	 * @param endIP
	 * endIP
	 */
	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}

	/**
	 * @return agentBO
	 */
//	public AgentBO getAgentBO() {
//		return agentBO;
//	}

	/**
	 * @param agentBO
	 * agentBO
	 */
//	public void setAgentBO(AgentBO agentBO) {
//		this.agentBO = agentBO;
//	}
	
}
