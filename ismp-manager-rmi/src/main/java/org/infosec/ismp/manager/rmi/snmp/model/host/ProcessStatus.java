/**
 * 版权所有：上海鹏越惊虹信息技术发展有限公司
 */
package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 */
public class ProcessStatus  implements Serializable {

	private static final long serialVersionUID = 7754491114817976304L;

	/**
	 * 构造方法
	 * 
	 */
	public ProcessStatus() {

	}

	private Integer index; 
	/**
	 * 变量名称：pid 变量类型：String <br>
	 * 说明：进程ID
	 */
	private String pid;

	/**
	 * 变量名称：name 变量类型：String <br>
	 * 说明：进程映像名
	 */
	private String name;

	/**
	 * 变量名称：runPath 变量类型：String <br>
	 * 说明：进程运行路径
	 */
	private String runPath;

	/**
	 * 变量名称：description 变量类型：String <br>
	 * 说明：文字描述
	 */
	private String description;

	/**
	 * 变量名称：allocatedMemorySize 变量类型：Long <br>
	 * 说明：进程占用内存容量，单位为KByte
	 */
	private Long allocatedMemorySize;

	/**
	 * 变量名称：consumedCPUTime 变量类型：Long <br>
	 * 说明：进程累计占用CPU时间，单位为毫秒
	 */
	private Long consumedCPUTime;
	
	private Integer hrSWRunIndex;

	public Integer getHrSWRunIndex() {
		return hrSWRunIndex;
	}

	public void setHrSWRunIndex(Integer hrSWRunIndex) {
		this.hrSWRunIndex = hrSWRunIndex;
	}

	public Integer getIndex() {
		return index;
	}

	public String getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public String getRunPath() {
		return runPath;
	}

	public String getDescription() {
		return description;
	}

	public Long getAllocatedMemorySize() {
		return allocatedMemorySize;
	}

	public Long getConsumedCPUTime() {
		return consumedCPUTime;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRunPath(String runPath) {
		this.runPath = runPath;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAllocatedMemorySize(Long allocatedMemorySize) {
		this.allocatedMemorySize = allocatedMemorySize;
	}

	public void setConsumedCPUTime(Long consumedCPUTime) {
		this.consumedCPUTime = consumedCPUTime;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"ifIndex", index).append("pid", pid).append("name", name)
				.append("runPath", runPath).append("description", description)
				.append("allocatedMemorySize", allocatedMemorySize).append(
						"consumedCPUTime", consumedCPUTime).append(
						"hrSWRunIndex", hrSWRunIndex).toString();
	}

}
