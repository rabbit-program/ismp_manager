package org.infosec.ismp.collectd;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;

import org.infosec.ismp.collectd.services.SnmpAvailabler;
import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.snmp.SnmpAgentConfig;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/**
 * Snmp
 * @author lianglin
 *
 */
@Component
public class DirectSnmpEventProcessor implements EventListener {
	
	private DirectSnmpMessengerSend messenger;

	public final static String STATUS_UP = "Up";
	public final static String STATUS_DOWN = "Down";
	
	
	
	@Autowired(required=true)
	@Qualifier(value="directSnmpSender")
	public void setMessenger(DirectSnmpMessengerSend messenger) {
		this.messenger = messenger;
	}

	public DirectSnmpEventProcessor() {		
		subscribeEvent();
	}
	
	/**
	 * 注册事件
	 */
	private void subscribeEvent() {
		List<String> ueiList = new ArrayList<String>();

		ueiList.add(EventConstants.DIRECTSNMP_NODE_AVAILABLE_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	@Override
	public String getName() {
		return "directSnmp:DirectSnmpEventProcessor";
	}

	@Override
	public void onEvent(Event event) {
		ThreadCategory log = ThreadCategory.getInstance(getClass());
		String eventUei = event.getUei();
		String uuid =event.getUuid();
		if (eventUei == null)
			return;

		if (log.isDebugEnabled()) {
			log.debug("event is : "+event);
			log.debug("Received event: " + eventUei);
		}

		if (eventUei.equals(EventConstants.DIRECTSNMP_NODE_AVAILABLE_UEI)) {
			String ipAddr = event.getIpAddr();
			int port = Integer.parseInt(getValue(event.getParms(),"port"));
			int version = Integer.parseInt(getValue(event.getParms(),"version"));
			String status;
			String community = getValue(event.getParms(),"community");
			InetAddress address;
			try {
				address = InetAddress.getByName(ipAddr);
			} catch (UnknownHostException e) {
				log().error("IP地址输入不正确！", e);
				return;			
			}
			SnmpAgentConfig config = new SnmpAgentConfig();
			config.setAddress(address);
			config.setPort(port);
			config.setVersion(version);
			config.setReadCommunity(community);			
			SnmpAvailabler snmp = new SnmpAvailabler(config);
			snmp.run();
			if(snmp.isAvailable()){
				status=STATUS_UP;
			}else{
				status = STATUS_DOWN;
			}
			DirectSnmpModel model  =new DirectSnmpModel();
			model.setUuid(uuid);
			model.setAddress(ipAddr);
			model.setCommunity(community);
			model.setPort(port);
			model.setStatus(status);
			model.setVersion(version);
			try {
				messenger.springSend(model);
				log().debug("ipAdderss:"
								+ ipAddr + "发功MQ队列消息成功！");
			} catch (Exception e) {
				log().fatal(
						"DirectSnmpProcessor类onEvent()方法发送MQ信息失败！ipAdderss:"
								+ ipAddr, e);
			}
			
			if (log.isDebugEnabled()) {
				log.debug("add DirectSnmp node to available : " + ipAddr);
			}

		} 
	}
	
	String getValue(Parms parms, String parmName) {
		Parm[] parm = parms.getParm();
		String value = null;
		if (parm != null && parm.length > 0) {
			for (int i = 0, count = parm.length; i < count; i++) {
				if (parm[i].getParmName().equalsIgnoreCase(parmName)) {
					value = parm[i].getValue().getContent();
					break;
				}
			}
		}

		return value;
	}
	
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
