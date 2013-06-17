package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 */
@SuppressWarnings("unchecked")
public class ProcessesStatus  implements Serializable {

	private static final long serialVersionUID = -6257672354153562954L;
	/**
	 * 变量名称：processStatus 变量类型：List<ProcessStatus> <br>
	 * 说明：进程状态信息列表
	 */
	private List<ProcessStatus> processStatus = Collections.EMPTY_LIST;

	/**
	 * 构造方法
	 * 
	 */
	public ProcessesStatus() {

	}


	public ProcessStatus[] getProcessStatus() {
		return processStatus.toArray(new ProcessStatus[] {});
	}


	public final void setProcessStatus(List<ProcessStatus> vProcessStatus) {
		processStatus = vProcessStatus;
	}
    @Override
    public String toString() {
    	ToStringBuilder builder = new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE);
    	builder.appendSuper(super.toString());
    	for(ProcessStatus status: processStatus){
    		builder.append("ProcessStatus",status.toString());
    	}
		return builder.toString();
	}
	
}
