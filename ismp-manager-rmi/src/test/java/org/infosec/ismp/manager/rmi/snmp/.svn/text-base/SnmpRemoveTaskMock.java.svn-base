package org.infosec.ismp.manager.rmi.snmp;

import org.infosec.ismp.manager.rmi.snmp.service.SnmpDeviceMonitorRmi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2010-12-7 下午03:18:56
 * 
 */
public class SnmpRemoveTaskMock {
	
	public static void main(String[] args) {

		ApplicationContext content = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext-db.xml",
						"classpath:applicationContext-snmp.xml" });

		SnmpDeviceMonitorRmi snmp = (SnmpDeviceMonitorRmi) content
				.getBean("snmpDeviceCollectd");

		snmp.removeSnmpDeviceMonitor("1111");
		

	}

}

