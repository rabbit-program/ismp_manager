package edu.sjtu.infosec.monitor.db.model;

import java.util.List;
import java.util.Map;

/**
 * @author Rocky
 * @version create time：Aug 3, 2010 9:23:05 PM
 * 
 */
public class OracleStatus {

	private Integer oracleSessionNum ;						//session数
	private double Cache;									//命中率
	private double cpu;										//CPU使用情况
	private Integer transactionNum;							//事物数
	private List<TableSpaceUser> tableSpaces;				//表空间使用情况
	private Map<String,Integer> lockNum;					//各类锁数量
	private Integer deadlock;								//死锁数量
	private double processMem;								//进程消耗的内存情况
	
	public Integer getOracleSessionNum() {
		return oracleSessionNum;
	}
	public void setOracleSessionNum(Integer oracleSessionNum) {
		this.oracleSessionNum = oracleSessionNum;
	}
	public double getCache() {
		return Cache;
	}
	public void setCache(double cache) {
		Cache = cache;
	}
	public double getCpu() {
		return cpu;
	}
	public void setCpu(double cpu) {
		this.cpu = cpu;
	}
	public Integer getTransactionNum() {
		return transactionNum;
	}
	public void setTransactionNum(Integer transactionNum) {
		this.transactionNum = transactionNum;
	}
	public List<TableSpaceUser> getTableSpaces() {
		return tableSpaces;
	}
	public void setTableSpaces(List<TableSpaceUser> tableSpaces) {
		this.tableSpaces = tableSpaces;
	}
	public Map<String, Integer> getLockNum() {
		return lockNum;
	}
	public void setLockNum(Map<String, Integer> lockNum) {
		this.lockNum = lockNum;
	}
	public Integer getDeadlock() {
		return deadlock;
	}
	public void setDeadlock(Integer deadlock) {
		this.deadlock = deadlock;
	}
	public double getProcessMem() {
		return processMem;
	}
	public void setProcessMem(double processMem) {
		this.processMem = processMem;
	}
	
	
}
