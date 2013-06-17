package org.infosec.ismp.model.syslog;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 定义syslog事件代号和对应的匹配方案
 * 
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 * 
 */
public class UeiMatch implements Serializable {
	

    private String syslogSrcId;
    private String domainId;
	/**
	 * 对应的地址
	 */
	private String m_ipAddr;

	// private String className;

	private String m_syslogType;
	
	

	public String getIpAddr() {
		return m_ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		m_ipAddr = ipAddr;
	}

	public String getSyslogType() {
		return m_syslogType;
	}

	public void setSyslogType(String syslogType) {
		m_syslogType = syslogType;
	}
	
	

	public String getSyslogSrcId() {
		return syslogSrcId;
	}

	public void setSyslogSrcId(String syslogSrcId) {
		this.syslogSrcId = syslogSrcId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}


	
	
	

	

}
