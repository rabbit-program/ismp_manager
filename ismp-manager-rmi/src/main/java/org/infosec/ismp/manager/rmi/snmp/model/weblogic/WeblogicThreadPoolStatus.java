package org.infosec.ismp.manager.rmi.snmp.model.weblogic;


/**
 * @author Rocky
 * @version create time：Sep 9, 2010 4:20:15 PM
 * 
 */
public class WeblogicThreadPoolStatus {

	private static final long serialVersionUID = -8276860255210780949L;
	
	private String name;		//线程池名
	
	private String type;			//线程池类型
	
	private Integer executeThreadTotalCount;		//正在执行的线程数量
	
	private Integer executeThreadIdleCount;		//空闲线程数量
	
	private Integer requestCount;		//queue中request数量
	
	private Integer requestCapacity;		//queue能接受request的最大容量
	
	private Long completedRequestCount;		//已完成request的数量
	
	public WeblogicThreadPoolStatus() {

	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Integer getExecuteThreadTotalCount() {
		return executeThreadTotalCount;
	}

	public Integer getExecuteThreadIdleCount() {
		return executeThreadIdleCount;
	}

	public Integer getRequestCount() {
		return requestCount;
	}

	public Integer getRequestCapacity() {
		return requestCapacity;
	}

	public Long getCompletedRequestCount() {
		return completedRequestCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setExecuteThreadTotalCount(Integer executeThreadTotalCount) {
		this.executeThreadTotalCount = executeThreadTotalCount;
	}

	public void setExecuteThreadIdleCount(Integer executeThreadIdleCount) {
		this.executeThreadIdleCount = executeThreadIdleCount;
	}

	public void setRequestCount(Integer requestCount) {
		this.requestCount = requestCount;
	}

	public void setRequestCapacity(Integer requestCapacity) {
		this.requestCapacity = requestCapacity;
	}

	public void setCompletedRequestCount(Long completedRequestCount) {
		this.completedRequestCount = completedRequestCount;
	}


}
