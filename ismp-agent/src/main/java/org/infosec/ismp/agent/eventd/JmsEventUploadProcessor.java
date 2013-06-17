package org.infosec.ismp.agent.eventd;

import java.io.StringWriter;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.model.event.Events;
import org.infosec.ismp.model.event.Log;
import org.infosec.ismp.util.ThreadCategory;

/**
 * 将Agent中的事件发送到和Manager通信的Jms服务器
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class JmsEventUploadProcessor implements EventListener {

	private Session m_session;

	private Destination m_destination;

	public JmsEventUploadProcessor(Session session, Destination destination) {
		this.m_session = session;
		this.m_destination = destination;
		addEventListener();
	}

	/**
	 * 在事件中心注册被事件处理器，关注所有事件，即所有事件都将通过Jms传递给Manager.
	 * FIXME:应该将需要上传的事件上传。
	 */
	private void addEventListener() {
		EventIpcManagerFactory.getIpcManager().addEventListener(this);
	}

	@Override
	public String getName() {
		return "Eventd:JMSEventUploadProcessor";
	}

	@Override
	public void onEvent(Event event) {
		try {
			log().debug(
					"starting send event txt message  ,destionation is : "
							+ m_destination);
			StringWriter writer = new StringWriter();
			Events events = new Events();
			events.addEvent(event);
			Log log = new Log();
			log.setEvents(events);
			log.marshal(writer);
			String txt = writer.toString();
			MessageProducer producer = m_session.createProducer(m_destination);
			Message msg = m_session.createTextMessage(txt);
			producer.send(msg);
			log().debug(
					"message sended ,message content is : " + txt
							+ " destination is : " + m_destination);
		} catch (JMSException e) {
			log().warn("when send jms message error occur " + e, e);
		} catch (MarshalException e) {
			log().warn("could not marshal event " + e, e);
		} catch (ValidationException e) {
			log().warn("could not marshal event " + e, e);
		}
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
