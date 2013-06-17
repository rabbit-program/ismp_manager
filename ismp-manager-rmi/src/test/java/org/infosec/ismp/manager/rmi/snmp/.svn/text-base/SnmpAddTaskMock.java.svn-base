package org.infosec.ismp.manager.rmi.snmp;

import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceRmiBean;
import org.infosec.ismp.manager.rmi.snmp.service.SnmpDeviceMonitorRmi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2010-12-17 下午04:40:09
 * 
 */
public class SnmpAddTaskMock {


	public static void main(String[] args) {


		ApplicationContext content = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext-snmp.xml" });

		SnmpDeviceMonitorRmi snmp = (SnmpDeviceMonitorRmi) content
				.getBean("snmpDeviceCollectd");
		SnmpDeviceRmiBean rmiBean = new SnmpDeviceRmiBean();
		rmiBean.setIpAddr("192.168.9.147");
		rmiBean.setCommunity("public");
		rmiBean.setDeviceType("server");
		rmiBean.setBrand("server");
		rmiBean.setDomain("testDomain");
		rmiBean.setHalfWhenDown(true);
		rmiBean.setInterval(Long.valueOf("10000"));
		rmiBean.setNodeid("1111");
		rmiBean.setPort(161);
		rmiBean.setVersion("2");
		snmp.addSnmpDeviceMonitor(rmiBean);
		

	
	}

}

