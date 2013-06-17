package org.infosec.ismp.collectd;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.collectd.services.SnmpGetter;
import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.snmp.SnmpAgentConfig;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SnmpGetterEventProcessor implements EventListener {
	private SnmpGetterMessengerSend messenger;
	
	@Autowired(required=true)
	public void setMessenger(SnmpGetterMessengerSend messenger) {
		this.messenger = messenger;
	}
	public SnmpGetterEventProcessor(){
		subscribeEvent();
	}
	/**
	 * 注册事件
	 */
	private void subscribeEvent() {
		List<String> ueiList = new ArrayList<String>();

		ueiList.add(EventConstants.SNMPGETTER_NODE_GETCOLUMN_UEI);
		ueiList.add(EventConstants.SNMPGETTER_NODE_GETSTRING_UEI);
		ueiList.add(EventConstants.SNMPGETTER_NODE_GETTABLE_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	@Override
	public String getName() {
		return "snmpGetter:SnmpGetterEventProcessor";
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
		
		String ipAddr = event.getIpAddr();
		int port = Integer.parseInt(getValue(event.getParms(),"port"));
		int version = Integer.parseInt(getValue(event.getParms(),"version"));
		String community = getValue(event.getParms(),"community");
		String oid = getValue(event.getParms(),"oid");
		int timeout = Integer.parseInt(getValue(event.getParms(),"timeout"));
		InetAddress address;
		try {
			address = InetAddress.getByName(ipAddr);
		} catch (UnknownHostException e) {
			log.error("IP地址输入不正确！", e);
			return;			
		}
		SnmpAgentConfig config = new SnmpAgentConfig();
		config.setAddress(address);
		config.setPort(port);
		config.setVersion(version);
		config.setReadCommunity(community);	
		config.setTimeout(timeout);
		SnmpGetterModel model  =new SnmpGetterModel();
		model.setUuid(uuid);
		model.setAddress(ipAddr);
		model.setCommunity(community);
		model.setPort(port);
		model.setOid(oid);
		model.setTimeout(timeout);
		model.setVersion(version);
		SnmpGetter snmp = new SnmpGetter(config);
		if (eventUei.equals(EventConstants.SNMPGETTER_NODE_GETSTRING_UEI)) {
			model.setSnmpString(snmp.getSnmpString(oid));			
		}else if(eventUei.equals(EventConstants.SNMPGETTER_NODE_GETCOLUMN_UEI)){
			model.setSnmpColumn(snmp.getSnmpArray(oid));
		}else if(eventUei.equals(EventConstants.SNMPGETTER_NODE_GETTABLE_UEI)){
			model.setSnmpTable(snmp.getSnmpTable(oid));
		}
		try {
			messenger.springSend(model);
			log.debug("ipAdderss:"
							+ ipAddr + "发功MQ队列消息成功！");
		} catch (Exception e) {
			log.fatal(
					"SnmpGetterEventProcessor类onEvent()方法发送MQ信息失败！ipAdderss:"
							+ ipAddr, e);
		}
		
		if (log.isDebugEnabled()) {
			log.debug("add SnmpGetter node to getter : " + ipAddr);
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

}
