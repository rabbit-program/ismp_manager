package org.infosec.ismp.manager.model.db;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionOfElements;

/**
 * @author guoxianwei
 * @date 2010-12-15 下午04:25:48
 * 
 *  存放数据库收集结果
 *  
 */
@Entity
@Table(name="database_result_entity")
public class DatabaseResultEntity implements Serializable {

	private static final long serialVersionUID = -2852908914245310286L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Integer id;
	private  String nodeid;
    private  String type;//数据库类型
	private  Integer sessionNum; // Session数
	private  Integer transactionNum ; // 事务数
	private  Double cacheHitRatio ; // Cache命中率
	private  Double cpuBusyRatio; // CPU繁忙度
	
	@CollectionOfElements(fetch=FetchType.LAZY)
	@JoinTable(name = "workspace_entity", joinColumns = @JoinColumn(name = "dbresultid"))
	private  List<WorkspaceEntity> workspaces ; // 表空间使用情况
	
	@CollectionOfElements(fetch=FetchType.LAZY)
	@JoinTable(name = "deadlock_entity", joinColumns = @JoinColumn(name = "dbresultid"))
	private  List<DeadLockEntity> deadLocks; // 死锁
	
	@CollectionOfElements(fetch=FetchType.LAZY)
	@JoinTable(name = "processmemory_entity", joinColumns = @JoinColumn(name = "dbresultid"))
	private  List<ProcessMemoryEntity> processMemories; // 进程内存使用情况
	
	@Temporal(TemporalType.TIMESTAMP)
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
	public List<WorkspaceEntity> getWorkspaces() {
		return workspaces;
	}
	public List<DeadLockEntity> getDeadLocks() {
		return deadLocks;
	}
	public List<ProcessMemoryEntity> getProcessMemories() {
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
	public void setWorkspaces(List<WorkspaceEntity> workspaces) {
		this.workspaces = workspaces;
	}
	public void setDeadLocks(List<DeadLockEntity> deadLocks) {
		this.deadLocks = deadLocks;
	}
	public void setProcessMemories(List<ProcessMemoryEntity> processMemories) {
		this.processMemories = processMemories;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}

