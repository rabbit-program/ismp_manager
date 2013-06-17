package org.infosec.ismp.syslogd.manager;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.syslog.Syslog;
import org.infosec.ismp.model.syslog.SyslogWrapper;

/**
 * 
 * @author lianglin
 *@deprecated
 */
public class SyslogMessageListener implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		ObjectMessage message = (ObjectMessage) msg;
		try {
			SyslogWrapper log = (SyslogWrapper) message.getObject();
			Event event = convert(log);
			// System.out.println("event uei is : "+event.getUei());
			EventIpcManagerFactory.getIpcManager().sendNow(event);

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

	private Event convert(SyslogWrapper wrapper) {
		Event event = new Event();
		// event.setSyslog(wrapper);
		event.setUei(wrapper.getUei());
		event.setIpAddr(wrapper.getFromIp());
		event.setUuid(wrapper.getUuid());

		Syslog syslog = wrapper.getSyslog();
		event.addParam("timestamp", syslog.getTimestamp());
		event.addParam("facility", syslog.getFacility());
		event.addParam("severity", syslog.getSeverity());
		event.addParam("message", syslog.getMsg());
		event.addParam("ipaddr", syslog.getIpaddr());
		event.addParam("hostname", syslog.getHostname());
		
		event.addParam("domainid", wrapper.getDomain());
		event.addParam("logsource", wrapper.getLogSource());

		return event;
	}

}
