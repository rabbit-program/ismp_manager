package org.infosec.ismp.agent.comm.winsensor.model.status;

import java.io.Serializable;

/**
 * @author Rocky
 * @version create time：Oct 13, 2010 10:08:48 AM
 * 
 */
public class ProcessStatus implements Serializable {

	private static final long serialVersionUID = 892010668633009205L;

	private String pid;
	
	private String name;
	
	private String runPath;
	
	private String description;
	
	private Long allocatedMemorySize;
	
	private Long consumedCPUTime;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRunPath() {
		return runPath;
	}

	public void setRunPath(String runPath) {
		this.runPath = runPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAllocatedMemorySize() {
		return allocatedMemorySize;
	}

	public void setAllocatedMemorySize(Long allocatedMemorySize) {
		this.allocatedMemorySize = allocatedMemorySize;
	}

	public Long getConsumedCPUTime() {
		return consumedCPUTime;
	}

	public void setConsumedCPUTime(Long consumedCPUTime) {
		this.consumedCPUTime = consumedCPUTime;
	}
}
