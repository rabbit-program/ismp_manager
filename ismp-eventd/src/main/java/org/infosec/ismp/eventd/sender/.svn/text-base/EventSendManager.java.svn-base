package org.infosec.ismp.eventd.sender;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.eventd.UndeclaredEventException;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.concurrent.RunnableConsumerThreadPool;
import org.infosec.ismp.util.queue.FifoQueue;
import org.infosec.ismp.util.queue.FifoQueueException;
import org.infosec.ismp.util.queue.FixedLengthQueue;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 事件发送管理器，发送失败，会缓存一定数量的event，当注册成功时，在发送。
 * 
 * @author lianglin
 * 
 */
@Component
public class EventSendManager implements EventListener, InitializingBean {

	private EventSender m_eventSender;

	private Integer m_handPoolSize;

	private String m_sendAddress;
	private Integer m_sendPort;

	private InetAddress m_sendAddr;
	/**
	 * The thread pool handling the events
	 */
	private RunnableConsumerThreadPool m_eventHandlerPool;

	private FifoQueue<Event> failureEvents = new FixedLengthQueue<Event>(30);

	private volatile boolean m_sendFlag = false;
	
	protected void createEventSelectorAndSubscribe(){
//		List<String> ueis = new ArrayList<String>();
//		ueis.add(EventConstants.AGENT_REGIESTER_SUCCESS_UEI);
//		ueis.add(EventConstants.AGENT_REGIESTER_FAILURE_UEI);
//		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueis);
		
	}

	public void sendEvent(Event event) {
		if (!m_sendFlag) {
			try {
				failureEvents.add(event);
			} catch (FifoQueueException e) {
				log().warn("add event from failureQueue ", e);
			} catch (InterruptedException e) {
				log().warn("add event from failureQueue ", e);
			}
			return;
		}

		Runnable r = createSendEventRunnable(event);
		try {
			m_eventHandlerPool.getRunQueue().add(r);
		} catch (InterruptedException e) {
			log().warn(
					"Unable to queue event  to the send event handler pool queue: "
							+ e, e);

			throw new UndeclaredEventException(e);
		} catch (FifoQueueException e) {
			log().warn(
					"Unable to queue event  to the send event handler pool queue: "
							+ e, e);

			throw new UndeclaredEventException(e);
		}
	}

	private Runnable createSendEventRunnable(final Event event) {
		return new Runnable() {
			@Override
			public void run() {
				boolean flag = false;
				SingleEventResponseCallback cb = new SingleEventResponseCallback(
						m_sendAddr, m_sendPort);
				try {
					m_eventSender.sendEvent(m_sendAddr, m_sendPort, event,
							30 * 1000, cb);
					cb.waitFor();
					if (event.getUuid().equals(cb.getUuid())) {
						flag = true;
					}
				} catch (Exception e) {
					log().warn(
							"事件发送失败 ,地址是 " + m_sendAddr + " port is : "
									+ m_sendPort + " event is : " + event);
				}

				if (!flag) {
					try {
						failureEvents.add(event);
					} catch (FifoQueueException e1) {
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}

			}

		};
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.state(m_eventHandlerPool == null,
				"afterPorpertiesSet() has already been called");
		Assert.state(m_handPoolSize != null, "m_handPoolSize must be set");
		Assert.state(m_sendAddress != null, "sendAddress must be set");
		Assert.state(m_sendPort != null);

		m_sendAddr = InetAddress.getByName(m_sendAddress);

		m_eventSender = new EventSender();

		m_eventHandlerPool = new RunnableConsumerThreadPool(
				"SendEventHandlerPool", 0.6f, 1.0f, m_handPoolSize);
		m_eventHandlerPool.start();
		
		createEventSelectorAndSubscribe();
	}

	@Override
	public String getName() {
		return "EventSendManager";
	}

	@Override
	public void onEvent(Event e) {
//		System.out.println("-------------------xxxxxxxxxxxx------------------------");
//		System.out.println("event uei is : "+e.getUei());
//		System.out.println("-------------------xxxxxxxxxxxx-----------------------");
//		String uei = e.getUei();
//		if (EventConstants.AGENT_REGIESTER_SUCCESS_UEI.equals(uei)) {
//			m_sendFlag = true;
//
//			while (failureEvents.size() > 0) {
//				Event fe = null;
//				try {
//					fe = failureEvents.remove();
//				} catch (FifoQueueException e1) {
//					log().warn("get event from failureQueue ", e1);
//				} catch (InterruptedException e1) {
//					log().warn("get event from failureQueue ", e1);
//				}
//				if (fe != null)
//					sendEvent(fe);
//			}
//
//		} else if (EventConstants.AGENT_REGIESTER_FAILURE_UEI.equals(uei)) {
//			m_sendFlag = false;
//		}

	}

	public int getHandPoolSize() {
		return m_handPoolSize;
	}



	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	public void setHandPoolSize(int handPoolSize) {
		m_handPoolSize = handPoolSize;
	}

	public void setSendAddress(String sendAddress) {
		m_sendAddress = sendAddress;
	}

	public void setSendPort(Integer sendPort) {
		m_sendPort = sendPort;
	}

	
}
