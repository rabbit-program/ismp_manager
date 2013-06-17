package org.infosec.ismp.manager;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.eventd.DefaultEventHandlerImpl;
import org.infosec.ismp.eventd.EventIpcManagerDefaultImpl;
import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.eventd.EventIpcManagerProxy;
import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.eventd.adaptors.EventIpcManagerEventHandlerProxy;
import org.infosec.ismp.eventd.adaptors.udp.UdpEventReceiver;
import org.infosec.ismp.eventd.processor.EventExpander;
import org.infosec.ismp.eventd.processor.EventIpcBroadcastProcessor;
import org.infosec.ismp.eventd.processor.EventProcessor;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventListener;
import org.springframework.util.Log4jConfigurer;

/**
 * 操纵内存数据，检验流程是否正确。
 * @author root
 *
 */
public class MemoryManagerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		Log4jConfigurer.initLogging("classpath:log4j.properties");
		
		EventIpcManagerProxy eventipcProxy = new EventIpcManagerProxy();
		EventIpcManagerDefaultImpl impl = new EventIpcManagerDefaultImpl();
		EventIpcManagerFactory.setIpcManager(impl);

		impl.setHandlerPoolSize(3);
		impl.setEventIpcManagerProxy(eventipcProxy);

		// 创建事件扩充处理器
		EventExpander eventExpander = new EventExpander();
		eventExpander.afterPropertiesSet();

		// 创建事件广播处理器
		EventIpcBroadcastProcessor broadcastProcessor = new EventIpcBroadcastProcessor();
		broadcastProcessor.setEventIpcBroadcaster(impl);
		broadcastProcessor.afterPropertiesSet();

		// 创建事件处理handler
		DefaultEventHandlerImpl handlerImpl = new DefaultEventHandlerImpl();
		List<EventProcessor> processors = new ArrayList<EventProcessor>();
		processors.add(eventExpander);
		processors.add(broadcastProcessor);
		handlerImpl.setEventProcessors(processors);
		handlerImpl.afterPropertiesSet();
		impl.setEventHandler(handlerImpl);

		impl.afterPropertiesSet();

		// 创建事件接受模块
		Eventd eventd = createManagerEventd();
		eventd.start();
		
		createTestEventListener();
		
		System.out.println("--------------start manager-----------------");

	}
	
	private static Eventd createManagerEventd() throws Exception {
		Eventd eventd = new Eventd();

		EventIpcManagerEventHandlerProxy proxy = new EventIpcManagerEventHandlerProxy();

		UdpEventReceiver receiver = new UdpEventReceiver(5816, "127.0.0.1");
		receiver.addEventHandler(proxy);

		eventd.addEventReceiver(receiver);

		eventd.afterPropertiesSet();

		return eventd;
	}
	
	private static void createTestEventListener(){
		EventListener listenr = new EventListener(){

			@Override
			public String getName() {
				return "Manager:testEVentProcessor";
			}

			@Override
			public void onEvent(Event e) {
//				System.out.println("received event ,event uei is :"+e.getUei()+" serviceId is : "+e.getServiceId());
			}
			
		};
		EventIpcManagerFactory.getIpcManager().addEventListener(listenr);
	}

}
