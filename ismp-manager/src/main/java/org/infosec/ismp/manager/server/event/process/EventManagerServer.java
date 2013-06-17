/**
 * 上海交通大学
 */
package org.infosec.ismp.manager.server.event.process;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动事件模块的服务
 * @author  沈建宇
 * @date 2009-6-24
 */
public class EventManagerServer {
	
//	EventReceiveFromAudit auditEvent;
	
	EventTopoStatistics topoStatistics;
	
	EventFilter eventFilter;
	
	public EventManagerServer(){
		
	}
	
	/**
	 * 初始化，添加配置文件，测试用
	 */
	public void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {
						//"classpath*:ddong-applicationContext-amDao.xml",
						//"classpath*:ddong-applicationContext-resources.xml",
						"classpath:applicationContext.xml",
						"classpath:applicationContext-manager.xml"});	
		startService(context);
	}
	
	/**
	 * 启动事件服务
	 * @param context
	 */
	public void startService(ApplicationContext context){	
		topoStatistics = (EventTopoStatistics) context.getBean("eventTopoStatistics");
		topoStatistics.start();
//		auditEvent = new EventReceiveFromAudit();
//		auditEvent.start();
//		eventFilter = (EventFilter) context.getBean("eventFilter");
//		eventFilter.start();
	}
	
	public void stopService(ApplicationContext context){
//		if(auditEvent != null){
//			auditEvent.stop();
//		}
		
		if(topoStatistics != null){
			topoStatistics.stop();
		}
	}
	
	/**
	 * 测试用
	 * @param args
	 */
	public static void main(String args[]){
		EventManagerServer aa = new EventManagerServer();
	}

}
