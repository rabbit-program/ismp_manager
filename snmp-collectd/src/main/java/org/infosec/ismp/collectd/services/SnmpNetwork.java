package org.infosec.ismp.collectd.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.snmp.SnmpAgentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SnmpNetwork {

	private SnmpCollectContext m_snmpContext;

	private Map<String, SnmpCollectableService> m_members = Collections
			.synchronizedMap(new HashMap<String, SnmpCollectableService>());

	public SnmpNetwork() {
	}

	public SnmpCollectableService createSnmpCollectableService(
			SnmpAgentConfig agentConfig) {
		SnmpCollectableService service = new SnmpCollectableService(agentConfig, this);
		addMember(agentConfig.getNodeid(), service);
		return service;
	}

	public SnmpCollectableService getSnmpCollectableService(String nodeid) {
		String key = nodeid;
		return m_members.get(key);
	}

	public void removeNodeid(String key) {
		m_members.remove(key);
	}

	@Autowired(required = true)
	public void setSnmpContext(SnmpCollectContext snmpContext) {
		m_snmpContext = snmpContext;
	}

	public SnmpCollectContext getSnmpContext() {
		return m_snmpContext;
	}

	private void addMember(String nodeid, SnmpCollectableService service) {
		m_members.put(nodeid, service);
	}

}
