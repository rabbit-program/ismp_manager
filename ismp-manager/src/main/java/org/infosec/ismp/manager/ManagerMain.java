package org.infosec.ismp.manager;

import java.io.File;

import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.manager.agent.AgentChecker;
import org.infosec.ismp.manager.agent.AgentFileFactory;
import org.infosec.ismp.manager.agent.AgentLocator;
import org.infosec.ismp.manager.server.event.process.EventFilter;
import org.infosec.ismp.manager.server.event.process.EventTopoStatistics;
import org.infosec.ismp.manager.server.event.util.StartUpConfig;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

public class ManagerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Log4jConfigurer.initLogging("classpath:log4j.properties");
		
		//初始化Agent资源文件
		try{
			AgentFileFactory.init(new File("d:/temp"));
		}catch(Throwable t){
			ThreadCategory.getInstance(ManagerMain.class.getClass()).fatal("初始化SNMP资源配置失败，请检查 :",t);
            System.exit(1);			
		}
		
		StartUpConfig start = new StartUpConfig();
		start.startConfig();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext.xml",
						"classpath:applicationContext-manager.xml" });
		
		
		//启动内部核心事件处理模块
		Eventd eventd = (Eventd)ctx.getBean("eventd");
		eventd.start();
		
		//agent注册事件管理、在线状态检查模块
		AgentChecker agentChecker = (AgentChecker)ctx.getBean("agentChecker");
		agentChecker.start();
		
		//启动winsensor管理器
/*		ManagerWinsensorMain sensorMain = new ManagerWinsensorMain();
		sensorMain.init();*/
		
		
		//启动日志管理器
		EventFilter filter = (EventFilter) ctx.getBean("eventFilter");
		filter.start();
		
		EventTopoStatistics topoStatistics = (EventTopoStatistics) ctx.getBean("eventTopoStatistics");
		topoStatistics.run();
		
	    //启动Syslog日志处理器
		
		
		System.out.println("--------------start manager-----------------");
	}


}
