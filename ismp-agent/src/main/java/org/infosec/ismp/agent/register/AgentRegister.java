package org.infosec.ismp.agent.register;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.eventd.sender.SingleEventResponseCallback;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.springframework.util.Assert;

/**
 * 维持和Manager之间的注册通信，Manager在一定时间（3×interval）内收不到信息，认为该
 * Agent失去联系。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class AgentRegister extends AbstractServiceDaemon {

	private Timer m_timer;

//	private String m_agentName;
	
	private String m_managerIp;
	
	private int m_port=-1;
	
	private InetAddress m_managerAddress;
	
	private String agentId;
	
	private String uuid;
	
	private int agentPort;
	
	private String agentAddress;

	public AgentRegister() {
		super("ISMP.AgentRegister");
		uuid = UUID.randomUUID().toString();
	}

	@Override
	protected void onInit() {
		Assert.state(agentId != null, "must set agentId property");
		Assert.state(agentAddress!=null,"must set agentAddress property");
		Assert.state(agentPort!=0,"must set agentPort property");
		Assert.state(m_managerIp!=null,"must set managerIp property");
		
		Assert.state(m_port!=-1,"must set port property");
		try {
			m_managerAddress = InetAddress.getByName(m_managerIp);
		} catch (UnknownHostException e) {
			throw new RuntimeException("managerIp format is error : "+m_managerIp);
		}
		
	}

	private void doRegister() {
		log().debug("start register ");
		Event event = createRegisterEvent();
		SingleEventResponseCallback cb = new SingleEventResponseCallback(m_managerAddress, m_port);
		try {
			EventSender.sendEvent(m_managerAddress, m_port, event, 1000*30, cb);
			cb.waitFor();
		} catch (Exception e) {
			log().warn("register error : "+e);
		}
		
		String uuid = event.getUuid();
		
		if(uuid.equals(cb.getUuid())){
			System.out.println("register success");
//			Event registerEvent = createRegisterSucessEvent();
//			EventIpcManagerFactory.getIpcManager().sendNow(registerEvent);
		}else{
			System.out.println("register fail");
//			Event registerEvent = createRegisterFailureEvent();
//			EventIpcManagerFactory.getIpcManager().sendNow(registerEvent);
		}
	}
	
	
//	private Event createRegisterFailureEvent(){
//		Event event = new Event();
//		event.setUuid(UUID.randomUUID().toString());
//		event.setTime(EventConstants.formatToString(new Date()));
////		event.setCreationTime(EventConstants.formatToString(new Date()));
////		event.setFromAgent(true);
//		event.setUei(EventConstants.AGENT_REGIESTER_EVENT_UEI);
//		event.setSource("ISMP.AgentRegister");
//		
//		return event;
//	}
//	
//	private Event createRegisterSucessEvent(){
//		Event event = new Event();
//		event.setUuid(UUID.randomUUID().toString());
//		event.setTime(EventConstants.formatToString(new Date()));
////		event.setCreationTime(EventConstants.formatToString(new Date()));
////		event.setFromAgent(true);
//		event.setUei(EventConstants.AGENT_REGIESTER_SUCCESS_UEI);
//		event.setSource("ISMP.AgentRegister");
//		return event;
//	}
	
	

	private Event createRegisterEvent() {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setNodeid(agentId);
		event.setUei(EventConstants.AGENT_REGIESTER_EVENT_UEI);
		event.setSource("ISMP.AgentRegister");
		event.addParam("port", Integer.toString(agentPort));
		event.addParam("uuid",uuid);
		event.setIpAddr(agentAddress);
//		event.setTime(time)
		return event;
	}

	@Override
	protected void onStart() {
		startTimer();
	}

	private void startTimer() {
		if (m_timer != null) {
			log().debug(
					"startTimer() called,but previous timer exists;making sure it's cleaned up ");
			m_timer.cancel();
		}
		log().debug("scheduling new register timer");
		m_timer = new Timer("ISMP.AgentRegister", false);

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				doRegister();
			}

		};
		//FIXME: 移到配置文件中
		m_timer.scheduleAtFixedRate(task, 10, 100 * 1000);

	}

	@Override
	protected void onStop() {
		stopTimer();
	}

	private void stopTimer() {
		if (m_timer != null) {
			log().debug("Stoping existing timer");
			m_timer.cancel();
			m_timer = null;
		} else {
			log().debug("stopTimer() called,but there is no existing timer");
		}

	}

	

	public void setAgentPort(int agentPort) {
		this.agentPort = agentPort;
	}

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	public void setManagerIp(String managerIp) {
		m_managerIp = managerIp;
	}

	public void setPort(int port) {
		m_port = port;
	}
	
	
	
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public static void main(String[] args) throws Exception{
		AgentRegister register = new AgentRegister();
		register.setPort(5817);
//		register.setAgentName("testAgent");
		register.setManagerIp("127.0.0.1");
		register.setAgentAddress("192.168.9.169");
		register.setAgentPort(5819);
		register.afterPropertiesSet();
		register.start();
	    	
	}

}
