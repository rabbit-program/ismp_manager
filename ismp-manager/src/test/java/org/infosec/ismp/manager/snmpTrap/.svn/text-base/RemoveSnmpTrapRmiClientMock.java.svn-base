package org.infosec.ismp.manager.snmpTrap;

import org.infosec.ismp.manager.rmi.snmpTrap.SnmpTrapController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RemoveSnmpTrapRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml","snmpTrap/applicationContext-snmpTrap-rmi-client.xml");
		SnmpTrapController snmpTrap = (SnmpTrapController)con.getBean("snmpTrapControllerClient");
		snmpTrap.removeSnmpTrapSource("333");
	}

}
