package org.infosec.ismp.collectd.services;

import org.infosec.ismp.eventd.sender.ObjectJmsSender;
import org.infosec.ismp.model.snmp.Results;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.stereotype.Component;

@Component
public class SnmpCollectContext {

	private ObjectJmsSender m_nestMapSnmpSender;

	public void dispatch(Results results) {
		try {
			if (results != null && results.getResultList()!=null && !results.getResultList().isEmpty()) {
				m_nestMapSnmpSender.sendSerializableObject(results);
			}
		} catch (Exception e) {
			log().debug("MQ service not start", e);
		}
	}

	public ObjectJmsSender getNestMapSnmpSender() {
		return m_nestMapSnmpSender;
	}

	public void setNestMapSnmpSender(ObjectJmsSender nestMapSnmpSender) {
		m_nestMapSnmpSender = nestMapSnmpSender;
	}

	public ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());

	}
}
