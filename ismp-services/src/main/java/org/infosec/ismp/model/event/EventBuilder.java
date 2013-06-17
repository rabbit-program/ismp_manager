package org.infosec.ismp.model.event;

import java.util.Collection;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * 工具类，用于方便创建事件
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class EventBuilder {

	private final Event m_event;

	public EventBuilder(String uei, String source) {
		this(uei, source, new Date());
	}

	public EventBuilder(String uei, String source, Date date) {
		m_event = new Event();
		m_event.setUei(uei);
		setTime(date);
		setCreationTime(date);
		setSource(source);
	}

	public EventBuilder(Event event) {
		this(event, new Date());
	}

	public EventBuilder(Event event, String source) {
		this(event);
		setSource(source);
	}

	public EventBuilder(Event event, Date date) {
		m_event = event;
		setSource(event.getSource());
		setTime(date);
		setCreationTime(date);
	}

	public Event getEvent() {
		return m_event;
	}

	public EventBuilder setTime(Date date) {
		m_event.setTime(date);
		return this;
	}

	public EventBuilder setCreationTime(Date date) {
		m_event.setCreationTime(date);
		return this;
	}

	public EventBuilder setSource(String source) {
		m_event.setSource(source);
		return this;

	}

	public EventBuilder setSeverity(String severity) {
		m_event.setSeverity(EventConstants.getSeverityString(EventConstants
				.getSeverity(severity)));
		return this;
	}

	public EventBuilder setNodeid(int nodeid) {
		m_event.setNodeId(nodeid);
		return this;
	}

	public EventBuilder setHost(String hostname) {
		m_event.setHost(hostname);
		return this;
	}

	public EventBuilder setInterface(String ipAddress) {
		m_event.setNetInterface(ipAddress);
		return this;
	}

	public EventBuilder setService(String serviceName) {
		m_event.setService(serviceName);
		return this;
	}

	public EventBuilder addParam(String parmName, String val) {
		m_event.addParam(parmName, val);

		return this;
	}

	public EventBuilder setParam(String parmName, String val) {
		return addParam(parmName, val);
	}

	public EventBuilder addParam(String parmName, long val) {
		return addParam(parmName, Long.toString(val));
	}

	public EventBuilder addParam(String parmName, int val) {
		return addParam(parmName, Integer.toString(val));
	}

	public EventBuilder addParam(String parmName, char ch) {
		return addParam(parmName, Character.toString(ch));
	}

	public EventBuilder addParam(String parmName, Collection<String> vals) {
		String val = StringUtils.collectionToCommaDelimitedString(vals);
		return addParam(parmName, val);

	}

	public EventBuilder setDescription(String descr) {
		m_event.setDescr(descr);
		return this;
	}

}
