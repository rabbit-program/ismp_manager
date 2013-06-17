package org.infosec.ismp.manager.model.db;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author guoxianwei
 * @date 2010-12-15 下午04:36:42
 *  
 *  进程内存使用情况
 *  
 */
@Embeddable
public class ProcessMemoryEntity implements Serializable {

	private static final long serialVersionUID = 6893202823523484643L;

	private Long pid; // Oracle进程id

	private String name; // 进程名称

	private Long pgaUsedMem; // 已使用内存（单位：M）

	private Long pgaAllocMem; // 已分配内存（单位：M）

	private Long pgaMaxMem; // 最大已分配内存（单位：M）

	private Double usedRatio; // 利用率


	public Long getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public Long getPgaUsedMem() {
		return pgaUsedMem;
	}

	public Long getPgaAllocMem() {
		return pgaAllocMem;
	}

	public Long getPgaMaxMem() {
		return pgaMaxMem;
	}

	public Double getUsedRatio() {
		return usedRatio;
	}


	public void setPid(Long pid) {
		this.pid = pid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPgaUsedMem(Long pgaUsedMem) {
		this.pgaUsedMem = pgaUsedMem;
	}

	public void setPgaAllocMem(Long pgaAllocMem) {
		this.pgaAllocMem = pgaAllocMem;
	}

	public void setPgaMaxMem(Long pgaMaxMem) {
		this.pgaMaxMem = pgaMaxMem;
	}

	public void setUsedRatio(Double usedRatio) {
		this.usedRatio = usedRatio;
	}
}

