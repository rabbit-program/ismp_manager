package org.infosec.ismp.model.syslog;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * agent将收到的的syslog封装成本对象，发送给Manager；
 * @author lianglin
 *
 */
public class RawSyslog implements Serializable {
	/**
	 * 对应syslog源的唯一id
	 */
	private String m_nodeid;
	/**
	 * 收到发来报文的对方地址
	 */
	private String m_ipaddr;
	/**
	 * 收到报文的原始内容
	 */
	private byte[] m_contents;
	/**
	 * 表示收到信息的Agent标识
	 */
	private String m_agent;
	/**
	 * 发送时间
	 */
	private Date m_sendTime;
	
	public String getNodeid() {
		return m_nodeid;
	}
	public void setNodeid(String nodeid) {
		m_nodeid = nodeid;
	}
	public String getIpaddr() {
		return m_ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		m_ipaddr = ipaddr;
	}
	public byte[] getContents() {
		return m_contents;
	}
	public void setContents(byte[] contents) {
		m_contents = contents;
	}
	public String getAgent() {
		return m_agent;
	}
	public void setAgent(String agent) {
		m_agent = agent;
	}
	public Date getSendTime() {
		return m_sendTime;
	}
	public void setSendTime(Date sendTime) {
		m_sendTime = sendTime;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
	
}
