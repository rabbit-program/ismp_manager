package org.infosec.ismp.manager.rmi.tm.discover.model.appletForm;

import java.io.Serializable;
import java.util.List;

//import edu.sjtu.infosec.ismp.base.agent.model.AgentBO;

/**
 * CDPApplet页面数据封装类
 * @author Wu Guojie
 * @date 2009-6-9
 * @version 1.0
 */
public class CDPAppletForm implements Serializable {
	/**
	 * 开始IP
	 */
	private String startIP;
	/**
	 * 搜索深度
	 */
	private int searchDepth;
	/**
	 * 开始端口
	 */
	private int startPort;
	/**
	 * 结束端口
	 */
	private int endPort;
	/**
	 * 团体名
	 */
	private List<String> communityList;
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
	 * @return searchDepth
	 */
	public int getSearchDepth() {
		return searchDepth;
	}

	/**
	 * @param searchDepth
	 * searchDepth
	 */
	public void setSearchDepth(int searchDepth) {
		this.searchDepth = searchDepth;
	}

	/**
	 * @return startPort
	 */
	public int getStartPort() {
		return startPort;
	}

	/**
	 * @param startPort
	 * startPort
	 */
	public void setStartPort(int startPort) {
		this.startPort = startPort;
	}

	/**
	 * @return endPort
	 */
	public int getEndPort() {
		return endPort;
	}

	/**
	 * @param endPort
	 * endPort
	 */
	public void setEndPort(int endPort) {
		this.endPort = endPort;
	}

	/**
	 * @return communityList
	 */
	public List<String> getCommunityList() {
		return communityList;
	}

	/**
	 * @param communityList
	 * communityList
	 */
	public void setCommunityList(List<String> communityList) {
		this.communityList = communityList;
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
