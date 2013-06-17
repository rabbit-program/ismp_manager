package org.infosec.ismp.manager.winsensor.rmi;

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.agent.rmi.winsensor.service.AgentWinsensorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @author Rocky
 * @version create time：Dec 21, 2010 11:19:09 PM
 * 
 */
public class AgentWinsensorServiceTest {
	
	private ApplicationContext context;
	
	public void init() {
		context = new ClassPathXmlApplicationContext(
				new String[] {
						"classpath:applicationContext-resources.xml",
						"classpath:applicationContext-dao.xml",
						"classpath:applicationContext-service.xml",
						"classpath:applicationContext-winsensor.xml",
//						"classpath:applicationContext-jms.xml",
						"classpath:applicationContext-rmi-client.xml"
				});
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AgentWinsensorServiceTest test = new AgentWinsensorServiceTest();
		test.init();
		
		AgentWinsensorService agentWinsensorService = (AgentWinsensorService) test.context.getBean("agentWinsensorService");
		CommWinsensorDevice commDevice = new CommWinsensorDevice();
		commDevice.setIp("192.168.9.143");
		commDevice.setMac("00:1F:D0:68:96:0E");
		commDevice.setNodeId("10001");
		commDevice.setRetries(2);
		commDevice.setSensorId("c167f0c6-98d9-4c32-8c79-b226603f3949");
		commDevice.setTimeout(40000);
		
		agentWinsensorService.addMonitorDevice(commDevice);
		agentWinsensorService.startingMonitor("10001");
		
		//Count not run success.
		/*RmiProxyFactoryBean rmiAgentWinsensorService = (RmiProxyFactoryBean) test.context.getBean("agentWinsensorService");
		rmiAgentWinsensorService.setServiceUrl("rmi://localhost:1199/AgentWinsensorService");
		
		AgentWinsensorService agentWinsensorService = (AgentWinsensorService) rmiAgentWinsensorService;*/
		
/*		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceInterface(AgentWinsensorService.class);
		rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1199/AgentWinsensorService");
		rmiProxyFactoryBean.afterPropertiesSet();
		
		AgentWinsensorService agentWinsensorService = (AgentWinsensorService) rmiProxyFactoryBean.getObject();
		
		CommWinsensorDevice commDevice = new CommWinsensorDevice();
		commDevice.setIp("192.168.9.143");
		commDevice.setMac("00:1F:D0:68:96:0E");
		commDevice.setNodeId("10001");
		commDevice.setRetries(2);
		commDevice.setSensorId("c167f0c6-98d9-4c32-8c79-b226603f3949");
		commDevice.setTimeout(40000);
		
		agentWinsensorService.addMonitorDevice(commDevice);
		agentWinsensorService.startingMonitor("10001");*/
	}

}
