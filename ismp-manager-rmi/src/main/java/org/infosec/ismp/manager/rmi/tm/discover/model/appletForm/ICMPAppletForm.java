package org.infosec.ismp.manager.rmi.tm.discover.model.appletForm;

import java.io.Serializable;

//import edu.sjtu.infosec.ismp.base.agent.model.AgentBO;

/**
 * ICMPApplet页面数据封装类
 * @author Wu Guojie
 * @date 2009-6-9
 * @version 1.0
 */
public class ICMPAppletForm implements Serializable {
	/**
	 * 开始IP
	 */
	private String startIP;
	/**
	 * 结束IP
	 */
	private String endIP;
	/**
	 * 尝试次数
	 */
	private int tryNum;
	/**
	 * 超时时间
	 */
	private int outTime;
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
	 * @return tryNum
	 */
	public int getTryNum() {
		return tryNum;
	}

	/**
	 * @param tryNum
	 * tryNum
	 */
	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}

	/**
	 * @return outTime
	 */
	public int getOutTime() {
		return outTime;
	}

	/**
	 * @param outTime
	 * outTime
	 */
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

//	/**
//	 * @return agentBO
//	 */
//	public AgentBO getAgentBO() {
//		return agentBO;
//	}

//	/**
//	 * @param agentBO
//	 * agentBO
//	 */
//	public void setAgentBO(AgentBO agentBO) {
//		this.agentBO = agentBO;
//	}
}
