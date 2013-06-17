package org.infosec.ismp.agent;

import org.infosec.ismp.agent.register.AgentRegister;
import org.infosec.ismp.collectd.DirectSnmpEventProcessor;
import org.infosec.ismp.collectd.SnmpCollectd;
import org.infosec.ismp.collectd.SnmpGetterEventProcessor;
import org.infosec.ismp.database.collectd.DatabaseCollectd;
import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.ping.DirectPingProcessor;
import org.infosec.ismp.ping.Pingd;
import org.infosec.ismp.servicecheck.ServiceCheck;
import org.infosec.ismp.sitecheck.SiteCheck;
import org.infosec.ismp.syslogd.Syslogd;
import org.infosec.ismp.trapd.Trapd;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

/**
 * 启动Agent程序
 * 
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 * 
 */
public class AgentMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 加载log4j配置文件
		Log4jConfigurer.initLogging("classpath:log4j.properties");

		// 初始化snmp资源文件
		try {
				SnmpConfigFactoryInitializer.init(new String[]{"classpath:snmpresources/snmpResource.xml"
						,"classpath:snmpresources/snmpHostResource.xml"
						,"classpath:snmpresources/snmpConfigCisco.xml"
						,"classpath:snmpresources/snmpConfigWeblogic.xml"
						,"classpath:snmpresources/snmpFirewallH3c.xml"
						,"classpath:snmpresources/snmpFirewallLeadsec.xml"
						,"classpath:snmpresources/snmpFirewallTopsec.xml"
						,"classpath:snmpresources/snmpFirewallWibeda.xml"
						,"classpath:snmpresources/snmpRouterCisco.xml"
						,"classpath:snmpresources/snmpRouterH3c.xml"
						,"classpath:snmpresources/snmpSwitchCisco.xml"
						,"classpath:snmpresources/snmpSwitchH3c.xml"
						
						
				});
		} catch (Throwable t) {
			ThreadCategory.getInstance(AgentMain.class.getClass()).fatal(
					"初始化SNMP资源配置失败，请检查 :", t);
			System.exit(1);
		}
		// 加载spring配置文件

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext.xml",
						"classpath:applicationContext-agent.xml" });

		AgentRegister register = (AgentRegister) ctx.getBean("register");
		register.start();

		// 启动事件模块
		Eventd eventd = (Eventd) ctx.getBean("eventd");

		eventd.start();

		// 启动syslog日志模块
		Syslogd syslogd = (Syslogd) ctx.getBean("syslogd");
		syslogd.start();

		// 启动设备Ping模块

		Pingd pingd = (Pingd) ctx.getBean("pingd");
		pingd.start();

		// 初始化页面检测模块
		SiteCheck siteCheck = (SiteCheck) ctx.getBean("siteCheck");
		siteCheck.start();

		// 初始化服务检测模块
		ServiceCheck serviceCheck = (ServiceCheck) ctx.getBean("serviceCheck");
		serviceCheck.start();

		DirectPingProcessor dp = ctx.getBean(DirectPingProcessor.class);

		DirectSnmpEventProcessor snmp = ctx
				.getBean(DirectSnmpEventProcessor.class);

		SnmpGetterEventProcessor snmpgetter = ctx
				.getBean(SnmpGetterEventProcessor.class);

		Trapd trapd = ctx.getBean(Trapd.class);
		trapd.start();

		// 初始化snmp采集模块
		SnmpCollectd snmpCollectd = (SnmpCollectd) ctx.getBean("snmpCollectd");
		snmpCollectd.start();

		// 初始化snmp采集模块
		DatabaseCollectd dbCollectd = (DatabaseCollectd) ctx
				.getBean("dbcollectd");
		dbCollectd.start();
//
//		WinsensorMain main = new WinsensorMain();
//		main.init();
//		main.start();

		System.out.println("-------start ismp aagent--------------");
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
