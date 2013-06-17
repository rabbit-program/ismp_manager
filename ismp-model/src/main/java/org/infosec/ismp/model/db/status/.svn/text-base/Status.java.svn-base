package org.infosec.ismp.model.db.status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Rocky
 * @version create time：Sep 1, 2010 1:59:27 PM
 * 
 */
public class Status implements Serializable {

	private static final long serialVersionUID = 3261750912506371988L;
    private final String nodeid;
    private final String ipAddr;
    private final String type;//数据库类型
	private final int sessionNum; // Session数
	private final int transactionNum ; // 事务数
	private final double cacheHitRatio ; // Cache命中率
	private final List<Workspace> workspaces ; // 表空间使用情况
	private final double cpuBusyRatio; // CPU繁忙度
	private final List<OracleDeadLock> oracleDeadLocks; // 死锁
	private final List<OracleProcessMemory> oracleProcessMemories; // 进程内存使用情况
	private final List<SqlserverDeadLock> sqlserverDeadLocks; // 死锁
	private final List<SqlserverProcessMemory> sqlserverProcessMemories; // 进程内存使用情况
	private  Date createTime; // 创建时间
	
	public static class Builder {
		private String nodeid = null;
		private String ipAddr = null;
		private String type = null;
		private int sessionNum = 0;
		private int transactionNum = 0;
		private double cacheHitRatio = 0.00;
		private List<Workspace> workspaces = new ArrayList<Workspace>();
		private double cpuBusyRatio = 0.00;
		private  List<OracleDeadLock> oracleDeadLocks = new ArrayList<OracleDeadLock>(); // 死锁
		private  List<OracleProcessMemory> oracleProcessMemories = new ArrayList<OracleProcessMemory>(); // 进程内存使用情况
		private  List<SqlserverDeadLock> sqlserverDeadLocks = new ArrayList<SqlserverDeadLock>(); // 死锁
		private  List<SqlserverProcessMemory> sqlserverProcessMemories = new ArrayList<SqlserverProcessMemory>(); // 进程内存使用情况

		public Builder nodeid(String nodeid) {
			this.nodeid = nodeid;
			return this;
		}
		public Builder type(String type) {
			this.type = type;
			return this;
		}
		public Builder ipAddr(String ipAddr) {
			this.ipAddr = ipAddr;
			return this;
		}
		public Builder sessionNum(int val) {
			this.sessionNum = val;
			return this;
		}

		public Builder transactionNum(int val) {
			this.transactionNum = val;
			return this;
		}

		public Builder cacheHitRatio(double val) {
			this.cacheHitRatio = val;
			return this;
		}

		public Builder workspaces(List<Workspace> val) {
			this.workspaces = val;
			return this;
		}

		public Builder oracleProcessMemories(List<OracleProcessMemory> val) {
			this.oracleProcessMemories = val;
			return this;
		}
		
		public Builder oracleDeadLocks(List<OracleDeadLock> val) {
			this.oracleDeadLocks = val;
			return this;
		}
		
		public Builder cpuBusyRatio(double val) {
			this.cpuBusyRatio = val;
			return this;
		}
		public Builder sqlserverProcessMemories(List<SqlserverProcessMemory> val) {
			this.sqlserverProcessMemories = val;
			return this;
		}
		
		public Builder sqlserverDeadLocks(List<SqlserverDeadLock> val) {
			this.sqlserverDeadLocks = val;
			return this;
		}


		public Status build() {
			return new Status(this);
		}
	}

    private Status(Builder builder) {
    	nodeid = builder.nodeid;
    	ipAddr = builder.ipAddr;
    	type = builder.type;
		sessionNum = builder.sessionNum;
		transactionNum = builder.transactionNum;
		cacheHitRatio = builder.cacheHitRatio;
		workspaces = builder.workspaces;
		oracleProcessMemories = builder.oracleProcessMemories;
		oracleDeadLocks = builder.oracleDeadLocks;
		sqlserverProcessMemories = builder.sqlserverProcessMemories;
		sqlserverDeadLocks = builder.sqlserverDeadLocks;
		cpuBusyRatio = builder.cpuBusyRatio;
		

	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public int getSessionNum() {
		return sessionNum;
	}
	public int getTransactionNum() {
		return transactionNum;
	}
	public double getCacheHitRatio() {
		return cacheHitRatio;
	}
	public List<Workspace> getWorkspaces() {
		return workspaces;
	}

	public String getNodeid(){
		return nodeid;
	}
	
	public String getIpAddr() {
		return ipAddr;
	}
	public String getType() {
		return type;
	}
	public double getCpuBusyRatio() {
		return cpuBusyRatio;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OracleDeadLock> getOracleDeadLocks() {
		return oracleDeadLocks;
	}
	public List<OracleProcessMemory> getOracleProcessMemories() {
		return oracleProcessMemories;
	}
	public List<SqlserverDeadLock> getSqlserverDeadLocks() {
		return sqlserverDeadLocks;
	}
	public List<SqlserverProcessMemory> getSqlserverProcessMemories() {
		return sqlserverProcessMemories;
	}
	public boolean equals(Object other) {
		if (!(other instanceof Status)) {
			return false;
		}
		Status rhs = (Status) other;
		return new EqualsBuilder().appendSuper(super.equals(other)).append(
				nodeid, rhs.nodeid).append(
				sessionNum, rhs.sessionNum).append(transactionNum,
				rhs.transactionNum).append(cacheHitRatio, rhs.cacheHitRatio)
				.append(workspaces, rhs.workspaces).append(cpuBusyRatio,
						rhs.cpuBusyRatio)
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
				.append(nodeid).append(sessionNum).append(transactionNum)
				.append(cacheHitRatio).append(workspaces).append(cpuBusyRatio)
				.toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"nodeid", nodeid).append(
				"sessionNum", sessionNum).append("transactionNum",
				transactionNum).append("cacheHitRatio", cacheHitRatio).append(
				"workspaces", workspaces).append("cpuBusyRatio", cpuBusyRatio).toString();
	}

}
