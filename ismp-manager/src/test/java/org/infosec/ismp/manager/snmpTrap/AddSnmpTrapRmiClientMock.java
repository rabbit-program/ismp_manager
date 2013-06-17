package org.infosec.ismp.manager.snmpTrap;

import org.infosec.ismp.manager.rmi.snmpTrap.SnmpTrapController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddSnmpTrapRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con  = 
			new ClassPathXmlApplicationContext("applicationContext.xml","snmpTrap/applicationContext-snmpTrap-rmi-client.xml");
		SnmpTrapController snmpTrap = (SnmpTrapController)con.getBean("snmpTrapControllerClient");
		snmpTrap.addSnmpTrapSource("testDomain", "333", "snmpTrapType1", "192.168.9.145");
	}

}
