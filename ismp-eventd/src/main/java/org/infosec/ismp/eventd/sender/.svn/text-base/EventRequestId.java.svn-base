package org.infosec.ismp.eventd.sender;

import java.net.InetAddress;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class EventRequestId {
	private InetAddress m_addr;
	private String m_uuid;

	public EventRequestId(InetAddress addr, String uuid) {
		m_addr = addr;
		m_uuid = uuid;
	}

	public InetAddress getAddr() {
		return m_addr;
	}

	public void setAddr(InetAddress addr) {
		m_addr = addr;
	}

	public String getUuid() {
		return m_uuid;
	}

	public void setUuid(String uuid) {
		m_uuid = uuid;
	}

	

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EventRequestId) {
			EventRequestId id = (EventRequestId) obj;
			return getAddr().getHostAddress().equals(
					id.getAddr().getHostAddress())
					&& getUuid().equals(id.getUuid());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int code = HashCodeBuilder.reflectionHashCode(this);
		return code;
	}

}
