package org.infosec.ismp.manager.rmi.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author guoxianwei
 * @date 2010-12-15 下午04:25:48
 * 
 *  存放数据库收集结果
 *  
 */

public class DatabaseResultStatus implements Serializable {

	private static final long serialVersionUID = -2852908914245310286L;

	private  Integer id;
	private  String nodeid;
    private  String type;//数据库类型
	private  Integer sessionNum; // Session数
	private  Integer transactionNum ; // 事务数
	private  Double cacheHitRatio ; // Cache命中率
	private  Double cpuBusyRatio; // CPU繁忙度

	private  List<Workspace> workspaces ; // 表空间使用情况

	private  List<DeadLock> deadLocks; // 死锁

	private  List<ProcessMemory> processMemories; // 进程内存使用情况

	private  Date createTime; // 创建时间
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNodeid() {
		return nodeid;
	}
	public String getType() {
		return type;
	}
	public Integer getSessionNum() {
		return sessionNum;
	}
	public Integer getTransactionNum() {
		return transactionNum;
	}
	public Double getCacheHitRatio() {
		return cacheHitRatio;
	}
	public Double getCpuBusyRatio() {
		return cpuBusyRatio;
	}
	public List<Workspace> getWorkspaces() {
		return workspaces;
	}
	public List<DeadLock> getDeadLocks() {
		return deadLocks;
	}
	public List<ProcessMemory> getProcessMemories() {
		return processMemories;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSessionNum(Integer sessionNum) {
		this.sessionNum = sessionNum;
	}
	public void setTransactionNum(Integer transactionNum) {
		this.transactionNum = transactionNum;
	}
	public void setCacheHitRatio(Double cacheHitRatio) {
		this.cacheHitRatio = cacheHitRatio;
	}
	public void setCpuBusyRatio(Double cpuBusyRatio) {
		this.cpuBusyRatio = cpuBusyRatio;
	}
	public void setWorkspaces(List<Workspace> workspaces) {
		this.workspaces = workspaces;
	}
	public void setDeadLocks(List<DeadLock> deadLocks) {
		this.deadLocks = deadLocks;
	}
	public void setProcessMemories(List<ProcessMemory> processMemories) {
		this.processMemories = processMemories;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE);
		builder.appendSuper(super.toString()).append(
				"nodeid", nodeid).append("type", type).append(
						"sessionNum", sessionNum).append("transactionNum", transactionNum).append(
								"cacheHitRatio", cacheHitRatio).append("cpuBusyRatio", cpuBusyRatio);
		for(Workspace workspace : workspaces){
			builder.append("workspace",workspace.toString());
		}
		for(DeadLock deadlock : deadLocks){
			builder.append("deadlock",deadlock.toString());
		}
		for(ProcessMemory processMemory : processMemories){
			builder.append("processMemory",processMemory.toString());
		}
		return builder.toString();
	}
}

