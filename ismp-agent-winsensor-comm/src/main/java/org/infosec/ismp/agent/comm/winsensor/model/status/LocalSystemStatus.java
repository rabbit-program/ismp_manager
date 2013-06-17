package org.infosec.ismp.agent.comm.winsensor.model.status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rocky
 * @version create time：Oct 15, 2010 10:27:43 AM
 * 
 */
public class LocalSystemStatus implements Serializable {

	private static final long serialVersionUID = -1751618676946692758L;

	/*
	 * 配置
	 */
	private String phyInfo;
	
	/*
	 * 操作系统版本信息
	 */
	private String osInfo;
	
	/*
	 * 注册信息
	 */
	private String registry;
	
	/*
	 * 描叙
	 */
	private String description;
	
	/*
	 * 计算机名
	 */
	private String computerName;
	
	/*
	 * 用户名
	 */
	private String userName;
	
	/*
	 * 工作组/域名
	 */
	private String domain;
	
	/*
	 * 存活时间
	 */
	private String aliveTime;
	
	/*
	 * 本地DNS缓存
	 */
	private List<LocalDNS> localDNS = new ArrayList<LocalDNS>();
	
	/*
	 * 本地APR缓存
	 */
	private List<LocalARP> localARP = new ArrayList<LocalARP>();
	
	/*
	 * 本地路由表
	 */
	private List<LocalRouter> localRouter = new ArrayList<LocalRouter>();

	public String getPhyInfo() {
		return phyInfo;
	}

	public void setPhyInfo(String phyInfo) {
		this.phyInfo = phyInfo;
	}

	public String getOsInfo() {
		return osInfo;
	}

	public void setOsInfo(String osInfo) {
		this.osInfo = osInfo;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAliveTime() {
		return aliveTime;
	}

	public void setAliveTime(String aliveTime) {
		this.aliveTime = aliveTime;
	}

	public List<LocalDNS> getLocalDNS() {
		return localDNS;
	}

	public void setLocalDNS(List<LocalDNS> localDNS) {
		this.localDNS = localDNS;
	}

	public List<LocalARP> getLocalARP() {
		return localARP;
	}

	public void setLocalARP(List<LocalARP> localARP) {
		this.localARP = localARP;
	}

	public List<LocalRouter> getLocalRouter() {
		return localRouter;
	}

	public void setLocalRouter(List<LocalRouter> localRouter) {
		this.localRouter = localRouter;
	}
}