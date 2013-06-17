package org.infosec.ismp.eventd.sender;

import org.springframework.util.Assert;

public class ObjectJmsSenderFactory {
	private static ObjectJmsSender m_objectJmsSender;

	public static ObjectJmsSender getObjectJmsSender() {
		Assert.state(m_objectJmsSender != null,
		"this factory has not been initialized");
		return m_objectJmsSender;
	}

	public static void setObjectJmsSender(ObjectJmsSender objectJmsSender) {
		ObjectJmsSenderFactory.m_objectJmsSender = objectJmsSender;
	}

	
}
