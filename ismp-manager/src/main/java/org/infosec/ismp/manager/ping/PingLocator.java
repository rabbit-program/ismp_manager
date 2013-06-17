package org.infosec.ismp.manager.ping;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.infosec.ismp.manager.ComponentLocator;
import org.infosec.ismp.manager.agent.AgentComponent;
import org.infosec.ismp.manager.direct.DirectRequestSender;
import org.infosec.ismp.manager.domains.DomainComponent;
import org.infosec.ismp.manager.domains.DomainLocator;
import org.infosec.ismp.manager.model.PingNodeEntity;
import org.infosec.ismp.manager.model.PingResultEntity;
import org.infosec.ismp.manager.rmi.scm.model.PollStatus;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 是添加Ping任务的入口类
 * 
 * @author lianglin
 * 
 */
@Component
public class PingLocator implements ComponentLocator {

	/**
	 * nodeid<->domain
	 */
	private Map<String, DomainComponent> nodeidMaps = new HashMap<String, DomainComponent>();

	private PingNodeEntityService m_pingService;
	private DomainLocator m_domainLocator;

	private DirectRequestSender directPingSender;

	@Autowired(required = true)	
	public void setDirectPingSender(@Qualifier(value="directPingSender")DirectRequestSender directRequestSender) {
		this.directPingSender = directRequestSender;
	}
	

	private DirectRequestSender directSnmpSender;

	@Autowired(required=true)
	@Qualifier(value="directSnmpSender")
	public void setDirectSnmpSender(DirectRequestSender directSnmpSender) {
		this.directSnmpSender = directSnmpSender;
	}
	
	@Autowired(required = true)
	public void setPingService(PingNodeEntityService pingService) {
		m_pingService = pingService;
	}

	@Autowired(required = true)
	public void setDomainLocator(DomainLocator domainLocator) {
		m_domainLocator = domainLocator;
	}

	public PingLocator() {
	}

	@PostConstruct
	public void init() {
		System.out.println("Ping Locator 开始初始化");
		Assert.state(m_pingService != null, "m_pingDao不能为空，请检查");
		Assert.state(m_domainLocator != null, "m_domainLocator不能为空，请检查");
		distruteAllPingNode();
	}

	public List<PingNodeEntity> getAllPingNode() {
		List<PingNodeEntity> entites = m_pingService.getAll();
		return entites;
	}

	public void distruteAllPingNode() {
		List<PingNodeEntity> entities = getAllPingNode();
		for (PingNodeEntity entity : entities) {
			String domain = entity.getDomain();
			addPingNodeToDomain(domain, entity.getNodeid(), entity.getIpaddr(),
					entity.getInterval(), entity.getHalfIntervalWhenDown());
		}
	}

	public void addPingNode(String domain, String nodeid, String ipaddr,
			long interval, boolean halfFlag) {
		boolean flag = findExistPingNode(nodeid);
		if (flag) {
			throw new RuntimeException("重复添加，该任务中nodeid:" + nodeid + "已经存在");
		}
		addPingNodeToDb(domain, nodeid, ipaddr, interval, halfFlag);
		addPingNodeToDomain(domain, nodeid, ipaddr, interval, halfFlag);
	}

	private boolean findExistPingNode(String nodeid) {
		return m_pingService.findExistPingNode(nodeid);
	}

	/**
	 * 将Ping任务添加到domainComponent
	 * 
	 * @param domain
	 * @param nodeid
	 * @param ipaddr
	 * @param interval
	 * @param halfFlag
	 */
	private void addPingNodeToDomain(String domain, String nodeid,
			String ipaddr, long interval, boolean halfFlag) {
		DomainComponent domainComp = m_domainLocator
				.createDomainIfNessary(domain);
		nodeidMaps.put(nodeid, domainComp);
		PingNode node = createPingNode(nodeid, ipaddr, interval, halfFlag);
		domainComp.addPingNode(node);
	}

	protected PingNode createPingNode(String nodeid, String ipaddr,
			long interval, boolean flag) {
		PingNode node = new PingNode();
		node.setNodeid(nodeid);
		node.setIpaddr(ipaddr);
		node.setInterval(interval);
		node.setHalfWhenDown(flag);
		return node;
	}

	private void addPingNodeToDb(String domain, String nodeid, String ipaddr,
			long interval, boolean halfFlag) {
		PingNodeEntity entity = new PingNodeEntity();
		entity.setDomain(domain);
		entity.setNodeid(nodeid);
		entity.setIpaddr(ipaddr);
		entity.setInterval(interval);
		entity.setHalfIntervalWhenDown(halfFlag);
		m_pingService.save(entity);
	}

	public void removePingNode(String nodeid) {
		removePingNodeFromDb(nodeid);
		removePingNodeFromDomain(nodeid);
		nodeidMaps.remove(nodeid);
	}

	private void removePingNodeFromDomain(String nodeid) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.removePingNode(nodeid);
			domainComp.RemovePingResult(nodeid);
		} else {
			if (log().isDebugEnabled()) {
				log().debug("removePingNode没有找到该nodeId：" + nodeid + "对应的域 ");
			}
		}
	}

	private void removePingNodeFromDb(String nodeid) {
		m_pingService.removePingNodeByNodeId(nodeid);
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	/**
	 * 用于设置某个nodeid的状态
	 * 
	 * @param nodeid
	 * @param entity
	 */
	public void setPingResult(String nodeid, PingResultEntity entity) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.putPingResult(nodeid, entity);
		}

	}

	public PingResultEntity getPingStatus(String nodeid) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			return domainComp.getPingResult(nodeid);
		}
		return null;
	}

	public String getDomainByNodeid(String nodeid) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			return domainComp.getDomainId();
		}
		return null;
	}

	public PollStatus ping(String domain,String address){
		Event event = createDirectPingEvent(address);
		DomainComponent domainComp = m_domainLocator
		.createDomainIfNessary(domain);
		
		AgentComponent agent =domainComp.getRightAgent();
		
		String agentAddress = agent.getAgentAddress();
		int port = agent.getAgentPort();
		
		if(null!=agentAddress){
			InetAddress host = null;
			try {
				host = InetAddress.getByName(agentAddress);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			PollStatus result =(PollStatus)directPingSender.sendEvent(host, port, event, 3000);
			return result;
		}else{
			return PollStatus.unavailable("Agent unavailable");
		}
		
		
	}
	/**
	 * 构造PingEvent
	 * @param address
	 * @return
	 */
	private Event createDirectPingEvent(String address) {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.DIRECTPING_NODE_PING_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setIpAddr(address);
		return event;
	}

	/**
	 * 即时获取目标地址available状态
	 * @param domain
	 * @param ipAddr
	 * @param port
	 * @param community
	 * @param version
	 */
	public boolean isSnmpAvailable(String domain, String ipAddr, int port,
			String community, int version) {
		Event event = createDirectSnmpAvailableEvent(ipAddr,port,community,version);
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
			String status =(String)directSnmpSender.sendEvent(host, agentPort, event, 3000);
			if("Up".equalsIgnoreCase(status)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}
	
	/**
	 * 构造SnmpAvailableEvent
	 * @param address
	 * @return
	 */
	private Event createDirectSnmpAvailableEvent(String ipAddr, int port,
			String community, int version) {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.DIRECTSNMP_NODE_AVAILABLE_UEI);
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
		parm.setParmName("community");
		value = new Value();
		value.setContent(community);
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
