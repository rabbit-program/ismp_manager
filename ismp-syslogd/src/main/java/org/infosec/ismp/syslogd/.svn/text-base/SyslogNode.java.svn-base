package org.infosec.ismp.syslogd;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 代表一个可以接受syslog的节点
 * @author lianglin
 *
 */
public class SyslogNode {
	/**
	 * 全局唯一标识
	 */
    private final String m_nodeid;
    /**
     * 发送syslog的地址
     */
    private final String m_ipAddr;
    
    
    
	public SyslogNode(String nodeId,String ipAddr) {
		this.m_nodeid = nodeId;
		this.m_ipAddr = ipAddr;
	}
	public String getNodeid() {
		return m_nodeid;
	}
	
	public String getIpAddr() {
		return m_ipAddr;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
    
    
}
