package org.infosec.ismp.eventd.sender;

import java.net.InetAddress;

import org.opennms.protocols.rt.ResponseWithId;

public class EventReply implements ResponseWithId<EventRequestId> {

	private InetAddress m_addr;
	
	private String m_uuid;
	
	private int m_port;
	
	public EventReply(InetAddress addr,int port, String uuid) {
		m_addr = addr;
		m_uuid = uuid;
	}


	@Override
	public EventRequestId getRequestId() {
		EventRequestId id= new EventRequestId(m_addr, m_uuid);
		return id;
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


	public int getPort() {
		return m_port;
	}


	public void setPort(int port) {
		m_port = port;
	}
	
	

}
