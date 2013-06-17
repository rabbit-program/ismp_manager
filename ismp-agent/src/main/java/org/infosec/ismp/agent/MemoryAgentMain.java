package org.infosec.ismp.agent;

import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.eventd.adaptors.EventIpcManagerEventHandlerProxy;
import org.infosec.ismp.eventd.adaptors.udp.UdpEventReceiver;
import org.infosec.ismp.syslogd.Syslogd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

/**
 * 该类启动Agent，该Agent没有持久化数据，只是操纵内存数据，为了测试流程是否正确。
 * 
 * @author lianglin
 * 
 */
public class MemoryAgentMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 加载log4j配置文件
		Log4jConfigurer.initLogging("classpath:log4j.properties");

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { 
						"classpath:applicationContext-agent.xml" });
		
		Eventd eventd = (Eventd)ctx.getBean("eventd");
		eventd.start();
		
		Syslogd syslogd = (Syslogd)ctx.getBean("syslogd");
		syslogd.start();

		// EventIpcManagerProxy eventipcProxy = new EventIpcManagerProxy();
		// EventIpcManagerDefaultImpl impl = new EventIpcManagerDefaultImpl();
		// EventIpcManagerFactory.setIpcManager(impl);
		//
		// impl.setHandlerPoolSize(3);
		// impl.setEventIpcManagerProxy(eventipcProxy);
		//
		// // 创建事件扩充处理器
		// AgentEventExpander eventExpander = new AgentEventExpander();
		// eventExpander.afterPropertiesSet();
		//
		// // 创建事件广播处理器
		// EventIpcBroadcastProcessor broadcastProcessor = new
		// EventIpcBroadcastProcessor();
		// broadcastProcessor.setEventIpcBroadcaster(eventipcProxy);
		// broadcastProcessor.afterPropertiesSet();
		//
		// // 创建事件处理handler
		// DefaultEventHandlerImpl handlerImpl = new DefaultEventHandlerImpl();
		// List<EventProcessor> processors = new ArrayList<EventProcessor>();
		// processors.add(eventExpander);
		// processors.add(broadcastProcessor);
		// handlerImpl.setEventProcessors(processors);
		// handlerImpl.afterPropertiesSet();
		//
		//
		// impl.setEventHandler(handlerImpl);
		//
		// impl.afterPropertiesSet();
		//
		// // 创建事件接受模块
		// Eventd eventd = createEventd();
		// eventd.start();
		//
		// createUdpUploader();
		//
		// SpServicePoller poller = new SpServicePoller();
		// MemorySpServicePollerConfig pollerConfig = new
		// MemorySpServicePollerConfig();
		//
		// DefaultPollContext context = new DefaultPollContext();
		// context.setDataManager(pollerConfig);
		// context.setEventManager(impl);
		//
		// PollableNetwork network = new PollableNetwork(context);
		//
		// poller.setDataManager(pollerConfig);
		// poller.setNetwork(network);
		// poller.setPollerConfig(pollerConfig);
		//
		// poller.init();
		// poller.start();
		//
		// Syslogd syslogd = new Syslogd();
		// syslogd.setSyslogdConfig(new MemorySyslogdConfig());
		// syslogd.afterPropertiesSet();
		// syslogd.start();
	}

	private static Eventd createEventd() throws Exception {
		Eventd eventd = new Eventd();

		EventIpcManagerEventHandlerProxy proxy = new EventIpcManagerEventHandlerProxy();

		UdpEventReceiver receiver = new UdpEventReceiver();
		receiver.addEventHandler(proxy);

		eventd.addEventReceiver(receiver);

		eventd.afterPropertiesSet();
		return eventd;
	}
	//
	// private static void createUdpUploader()throws Exception{
	// InetAddress addr = InetAddress.getLocalHost();
	// DatagramSocket socket = new DatagramSocket();
	// UpdEventUploadProcessor processor = new
	// UpdEventUploadProcessor(socket,addr,5816);
	// }

}
