package org.infosec.ismp.manager.direct;

import java.io.Serializable;

import org.opennms.protocols.rt.ResponseWithId;

public class DirectReply implements ResponseWithId<DirectRequestId> {

	private String m_uuid;
	private Serializable reply;
	
	
	
	public DirectReply(String uuid,Serializable reply) {
		this.m_uuid = uuid;
		this.reply = reply;
	}


	@Override
	public DirectRequestId getRequestId() {
		DirectRequestId id = new DirectRequestId(m_uuid);
		return id;
	}


	public String getUuid() {
		return m_uuid;
	}


	public void setUuid(String uuid) {
		m_uuid = uuid;
	}
	
	public Serializable getReply(){
		return reply;
	}

}
