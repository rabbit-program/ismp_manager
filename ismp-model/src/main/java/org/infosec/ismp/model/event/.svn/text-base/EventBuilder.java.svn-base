package org.infosec.ismp.model.event;

import java.util.Collection;
import java.util.Date;

import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
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
//		setCreationTime(date);
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
//		setCreationTime(date);
	}

	public Event getEvent() {
		return m_event;
	}

	public EventBuilder setTime(Date date) {
		m_event.setTime(EventConstants.formatToString(date));
		return this;
	}
	
//	public EventBuilder setFromAgent(boolean flag){
//		m_event.setFromAgent(flag);
//		return this;
//	}

//	public EventBuilder setCreationTime(Date date) {
//		m_event.setCreationTime(EventConstants.formatToString(date));
//		return this;
//	}

	public EventBuilder setSource(String source) {
		m_event.setSource(source);
		return this;

	}

//	public EventBuilder setSeverity(String severity) {
//		m_event.setSeverity(EventConstants.getSeverityString(EventConstants
//				.getSeverity(severity)));
//		return this;
//	}

	

	public EventBuilder setHost(String hostname) {
		m_event.setHost(hostname);
		return this;
	}

//	public EventBuilder setInterface(String ipAddress) {
//		m_event.setInterface(ipAddress);
//		return this;
//	}

//	public EventBuilder setService(String serviceName) {
//		m_event.setService(serviceName);
//		return this;
//	}

	public EventBuilder addParam(String parmName, String val) {
		if (parmName != null) {
			Value value = new Value();
			value.setContent(val);

			Parm parm = new Parm();
			parm.setParmName(parmName);
			parm.setValue(value);

			if (m_event.getParms() == null) {
				Parms parms = new Parms();
				m_event.setParms(parms);
			}

			m_event.getParms().addParm(parm);
		}

		return this;
	}

	public EventBuilder setParam(String parmName, String val) {
		Parms parms = m_event.getParms();
		if (parms == null) {
			return addParam(parmName, val);
		}

		for (Parm parm : parms.parmCollection()) {
			if (parm.getParmName().equals(val)) {
				Value value = new Value();
				value.setContent(val);
				parm.setValue(value);
				return this;
			}
		}

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

	// public EventBuilder setAlarmData(AlarmData alarmData) {
	// if (alarmData != null) {
	// m_event.setAlarmData(alarmData);
	// }
	// return this;
	// }
	//
	// public EventBuilder setNode(OnmsNode node) {
	// if (node != null) {
	// m_event.setNodeid(node.getId().longValue());
	// }
	// return this;
	// }
	//
	// public EventBuilder setIpInterface(OnmsIpInterface iface) {
	// if (iface != null) {
	// if (iface.getNode() != null) {
	// m_event.setNodeid(iface.getNode().getId().longValue());
	// }
	// m_event.setInterface(iface.getIpAddress());
	// }
	// return this;
	// }
	//
	// public EventBuilder setMonitoredService(
	// OnmsMonitoredService monitoredService) {
	// if (monitoredService != null) {
	// m_event.setNodeid(monitoredService.getNodeid().longValue());
	// m_event.setInterface(monitoredService.getIpAddress());
	// m_event.setService(monitoredService.getServiceName());
	// }
	// return this;
	// }
	//
	// public EventBuilder setSnmpVersion(String version) {
	// ensureSnmp();
	// m_event.getSnmp().setVersion(version);
	// return this;
	// }
	//
	// private void ensureSnmp() {
	// if (m_event.getSnmp() == null) {
	// m_event.setSnmp(new Snmp());
	// }
	//
	// }
	//
	// public EventBuilder setEnterpriseId(String enterprise) {
	// ensureSnmp();
	// m_event.getSnmp().setId(enterprise);
	// return this;
	// }
	//
	// public EventBuilder setGeneric(int generic) {
	// ensureSnmp();
	// m_event.getSnmp().setGeneric(generic);
	// return this;
	// }
	//
	// public EventBuilder setSpecific(int specific) {
	// ensureSnmp();
	// m_event.getSnmp().setSpecific(specific);
	// return this;
	// }
	//
	// public EventBuilder setSnmpHost(String snmpHost) {
	// m_event.setSnmphost(snmpHost);
	// return this;
	//
	// }

	public void setField(String name, String val) {
		BeanWrapper w = new BeanWrapperImpl(m_event);
		w.setPropertyValue(name, val);
	}

	// private void ensureLogmsg() {
	// if (m_event.getLogmsg() == null) {
	// m_event.setLogmsg(new Logmsg());
	// }
	// }
	//
	// public EventBuilder setLogDest(String dest) {
	// ensureLogmsg();
	// m_event.getLogmsg().setDest(dest);
	// return this;
	// }
	//
	// public EventBuilder setLogMessage(String content) {
	// ensureLogmsg();
	// m_event.getLogmsg().setContent(content);
	// return this;
	// }

	public EventBuilder setDescription(String descr) {
		m_event.setDescr(descr);
		return this;
	}

	public EventBuilder addParms(final Parms parms) {
		m_event.setParms(parms);
		return this;
	}

}
