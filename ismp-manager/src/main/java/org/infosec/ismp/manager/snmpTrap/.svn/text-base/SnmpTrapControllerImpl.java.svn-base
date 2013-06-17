package org.infosec.ismp.manager.snmpTrap;

import org.infosec.ismp.manager.rmi.snmpTrap.SnmpTrapController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnmpTrapControllerImpl implements SnmpTrapController {
	private SnmpTrapLocator locator;
	
	@Autowired(required=true)
	public void setLocator(SnmpTrapLocator locator) {
		this.locator = locator;
	}

	@Override
	public void addSnmpTrapSource(String domain, String nodeid,
			String snmpTrapType, String snmpTrapAddress) {
		locator.addSnmpTrapNode(domain, nodeid, snmpTrapType, snmpTrapAddress);

	}

	@Override
	public void removeSnmpTrapSource(String nodeid) {
		locator.removeSnmpTrapNode(nodeid);
	}

}
