package org.infosec.ismp.syslogd;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockHillstoneFireWallParser {

//////////////////////////////////////////////////////////////////////////////////	
	private static ClassPathXmlApplicationContext appContext;

	static {
		try {
			appContext = new ClassPathXmlApplicationContext(new String[] {
					"classpath:manager/applicationContext.xml",
					"classpath:manager/syslog/applicationContext-syslog-test.xml"
			   });
		} catch (Throwable t) {
			throw new Error(t);
		}
	}
	
	public static void main(String[] args) {
//		HillstoneFireWallParser h = (HillstoneFireWallParser) appContext.getBean("hillstoneFireWallParser");
//		
//		Syslog sys = new Syslog();
//		sys.setFacility("1");
//		sys.setSeverity("1");
//		sys.setHostname("hillstone");
//		sys.setIpaddr("192.168.9.119");
//		sys.setTimestamp("Sep 19 13:43:20");
//		sys.setMsg("46083603 Traffic@FLOW: srcip 222.72.248.170, srcport 54645, dstip 202.120.200.7, dstport 443, protocol TCP, vr trust-vr, nattype dnat, transip 192.168.16.1, transport 443, ruleid 11");
//		
//		SyslogWrapper syslog = new SyslogWrapper();
//		syslog.setDomain("1");
//		syslog.setFromIp("192.168.9.119");
//		syslog.setLogSource("AAAAAAAAAAAAAAAAAAAAAAAAA");
//		syslog.setUei("hillstoneSyslog");
//		syslog.setUuid("uuid");
//		syslog.setSyslog(sys);
		
//		h.createRunnable(syslog).run();
	}

}
