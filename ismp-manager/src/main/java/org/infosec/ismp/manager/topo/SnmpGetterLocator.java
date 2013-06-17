package org.infosec.ismp.manager.topo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.infosec.ismp.collectd.SnmpGetterModel;
import org.infosec.ismp.manager.ComponentLocator;
import org.infosec.ismp.manager.agent.AgentComponent;
import org.infosec.ismp.manager.direct.DirectRequestSender;
import org.infosec.ismp.manager.domains.DomainComponent;
import org.infosec.ismp.manager.domains.DomainLocator;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SnmpGetterLocator implements ComponentLocator {
	
	private DomainLocator m_domainLocator;

	@Autowired(required = true)
	public void setDomainLocator(DomainLocator domainLocator) {
		m_domainLocator = domainLocator;
	}
	
	private DirectRequestSender directSnmpGetterSender;

	@Autowired(required=true)
	@Qualifier(value="snmpGetterDirectRequstSender")
	public void setDirectSnmpSender(DirectRequestSender directSnmpSender) {
		this.directSnmpGetterSender = directSnmpSender;
	}
	
	@Override
	public void init() {
		System.out.println("Ping Locator 开始初始化");
//		Assert.state(m_pingService != null, "m_pingDao不能为空，请检查");
//		Assert.state(m_domainLocator != null, "m_domainLocator不能为空，请检查");
	}

	/**
	 * SNMP不带域id的getter方法
	 * @param getType
	 * @param ipAddr
	 * @param port
	 * @param oid
	 * @param community
	 * @param version
	 * @return
	 */
	public SnmpGetterModel snmpGetter(String getType, String ipAddr, int port,String oid,
			String community,int timeout, int version) {
		List<DomainComponent> domains = m_domainLocator.getAllDomains();		
		for(DomainComponent domainComp:domains){
			String domainName = domainComp.getDomainId();
			SnmpGetterModel model = snmpGetter(getType,domainName,ipAddr,port,oid,community,timeout,version);
			if(model!=null){
				return model;
			}
		}
		return null;
	}
	
	/**
	 * SNMP带域id的getter方法
	 * @param getType
	 * @param domain
	 * @param ipAddr
	 * @param port
	 * @param oid
	 * @param community
	 * @param version
	 * @return
	 */
	public SnmpGetterModel snmpGetter(String getType,String domain, String ipAddr, int port,String oid,
			String community,int timeout, int version) {
		Event event = createSnmpGetterEvent(getType,ipAddr,port,oid,community,timeout,version);
		DomainComponent domainComp = m_domainLocator
		.createDomainIfNessary(domain);
		
		AgentComponent agent =domainComp.getRightAgent();
		
		String agentAddress = agent.getAgentAddress();
		int agentPort = agent.getAgentPort();
		
		if(null!=agentAddress){
			InetAddress host = null;
			try {
				host = InetAddress.getByName(agentAddress);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			SnmpGetterModel result =(SnmpGetterModel)directSnmpGetterSender.sendEvent(host, agentPort, event, timeout);
			return result;
		}else{
			return null;
		}
		
	}
	
	/**
	 * 构造SnmpGetterEvent
	 * @param address
	 * @return
	 */
	private Event createSnmpGetterEvent(String getType,String ipAddr, int port,String oid,
			String community,int timeout, int version) {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		if("String".equalsIgnoreCase(getType)){
			event.setUei(EventConstants.SNMPGETTER_NODE_GETSTRING_UEI);
		}else if("Column".equalsIgnoreCase(getType)){
			event.setUei(EventConstants.SNMPGETTER_NODE_GETCOLUMN_UEI);
		}else{
			event.setUei(EventConstants.SNMPGETTER_NODE_GETTABLE_UEI);
		}
		event.setTime(EventConstants.formatToString(new Date()));
		event.setIpAddr(ipAddr);
		Parms parms = new Parms();

		Parm parm = new Parm();
		parm.setParmName("port");
		Value value = new Value();		
		value.setContent(String.valueOf(port));
		parm.setValue(value);
		parms.addParm(parm);		
		
		parm = new Parm();
		parm.setParmName("oid");
		value = new Value();
		value.setContent(oid);
		parm.setValue(value);
		parms.addParm(parm);
		
		parm = new Parm();
		parm.setParmName("community");
		value = new Value();
		value.setContent(community);
		parm.setValue(value);
		parms.addParm(parm);
		
		parm = new Parm();
		parm.setParmName("timeout");
		value = new Value();
		value.setContent(String.valueOf(timeout));
		parm.setValue(value);
		parms.addParm(parm);
		
		parm = new Parm();
		parm.setParmName("version");
		value = new Value();
		value.setContent(String.valueOf(version));
		parm.setValue(value);
		parms.addParm(parm);
		event.setParams(parms);
		
		return event;
	}
}
