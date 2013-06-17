package org.infosec.ismp.manager.direct;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class DirectRequestId {
     private String uuid;
     
     

	public DirectRequestId(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public int hashCode() {
		int code = HashCodeBuilder.reflectionHashCode(this);
		return code;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DirectRequestId) {
			DirectRequestId id = (DirectRequestId) obj;
			return getUuid().equals(id.getUuid());
		}
		return false;
	}
	
	
	
     
}
