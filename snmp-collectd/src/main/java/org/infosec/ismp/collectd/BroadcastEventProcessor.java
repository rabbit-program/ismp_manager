package org.infosec.ismp.collectd;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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
public class BroadcastEventProcessor implements EventListener {
	
	
	public BroadcastEventProcessor(SnmpCollectd snmpcollectd) {
		init();
		m_snmpCollectd = snmpcollectd;
		
	}

	private SnmpCollectd m_snmpCollectd;
	
	@Override
	public String getName() {
		return "SnmpCollectd:EventBroadcastProcessor";
	}

	@Override
	public void onEvent(Event event) {

		ThreadCategory log = ThreadCategory.getInstance(getClass());
		String eventUei = event.getUei();
		if (eventUei == null)
			return;

		if (log.isDebugEnabled()) {
			log.debug("event is : " + event);
			log.debug("Received event: " + eventUei);
		}

		if (eventUei.equals(EventConstants.SNMPCOLLECTD_NODE_ADD_UEI)) {
			String nodeId = event.getNodeid();
			String ipAddr = event.getIpAddr();

			Parms parms = event.getParams();

			int port = Integer.parseInt(getValue(parms, "port"));
			String community = getValue(parms, "community");
			int snmpVersion = Integer.parseInt(getValue(parms, "version"));
			String type = getValue(parms, "deviceType");
			String brand = getValue(parms, "brand");
			InetAddress addr;
			try {
				addr = InetAddress.getByName(ipAddr);
			} catch (UnknownHostException e) {
				log.warn("地址无法解析 :"+ipAddr,e);
				return ;
			}
			SnmpAgentConfig agentConfig = getConfig(nodeId,type,brand,
					ipAddr, port, community, snmpVersion,
					addr);

			m_snmpCollectd.scheduleSnmpNode(agentConfig);

			if (log.isDebugEnabled()) {
				log.debug("add snmpcollectd node to pingd : " + nodeId);
			}

		} else if (eventUei.equals(EventConstants.SNMPCOLLECTD_NODE_DELETE_UEI)) {

			String nodeId = event.getNodeid();
			m_snmpCollectd.unscheduleSnmpService(nodeId);
			if (log.isDebugEnabled()) {
				log.debug("remove snmpcollectd node from pingd: " + nodeId);
			}

		}

	}
	private SnmpAgentConfig getConfig(String nodeid, String type, String brand,
			String ipAddr, int port, String community, int snmpVersion,
			InetAddress addr) {
		SnmpAgentConfig agentConfig = new SnmpAgentConfig(addr);
		agentConfig.setPort(port);
		agentConfig.setReadCommunity(community);
		agentConfig.setVersion(snmpVersion);
		agentConfig.setNodeid(nodeid);
		agentConfig.setType(type);
		agentConfig.setBrand(brand);
		return agentConfig;
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
	
	public void init(){
		subscribeEvent();
	}
	
	public void subscribeEvent(){
		List<String> ueiList = new ArrayList<String>();

		ueiList.add(EventConstants.SNMPCOLLECTD_NODE_ADD_UEI);
		ueiList.add(EventConstants.SNMPCOLLECTD_NODE_DELETE_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	public SnmpCollectd getSnmpCollectd() {
		return m_snmpCollectd;
	}

	@Autowired(required=true)
	public void setSnmpCollectd(SnmpCollectd snmpCollectd) {
		m_snmpCollectd = snmpCollectd;
	}
	
	
}
