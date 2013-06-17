package org.infosec.ismp.manager.rmi.snmp;

import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.service.SnmpDeviceMonitorRmi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2010-12-28 下午01:00:17
 * 
 */
public class SnmpResultMock {

	/**
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */

	public static void main(String[] args) {


		ApplicationContext content = new ClassPathXmlApplicationContext(
				new String[] {
						"classpath:applicationContext-snmp.xml" });

		SnmpDeviceMonitorRmi snmp = (SnmpDeviceMonitorRmi) content
				.getBean("snmpDeviceCollectd");
		SnmpDeviceStatus host =  snmp.getSnmpDeviceStatus("1111");
		System.out.println(host.getHostDeviceStatus().toString());
//		WeblogicDeviceStatus weblogic = snmp.getWeblogicDeviceStatus("1111");
//		weblogic.toString();
	
	}

}

