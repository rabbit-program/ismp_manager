package org.infosec.ismp.manager.agent;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component(value="agentChecker")
public class AgentChecker extends AbstractServiceDaemon{
	private AgentLocator m_agentLocator;
	private Timer m_timer;

	// private Map<String,RegisterAgent> m_agentMaps = new
	// HashMap<String,RegisterAgent>();

	public AgentChecker() {
		super("ISMP.AgentChecker");
	}

//	public List<AgentComponent> getAllActiveAgents() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	protected void onInit() {
		Assert.state(m_agentLocator!=null,"m_agentLocator没有设置，请检查");

	}

	@Override
	protected void onStart() {
		try {
			AgentRegisterEventProcessor processor = new AgentRegisterEventProcessor(
					m_agentLocator);
			log().debug("成功注册Agent注册事件处理器");
		} catch (Throwable t) {
			log().warn("没有注册成功Agent注册事件处理器 ", t);
		}
	}
	
	private void startTimer() {
		if (m_timer != null) {
			log().debug(
					"startTimer() called,but previous timer exists;making sure it's cleaned up ");
			m_timer.cancel();
		}
		log().debug("scheduling new register timer");
		m_timer = new Timer("ISMP.AgentChecker", false);

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				checkAgent();
			}
		};
		//FIXME: 移到配置文件中
		m_timer.scheduleAtFixedRate(task, 10, 10 * 1000);

	}
	
	private void checkAgent() {
		log().debug("开始检查当前Agent的在线状态情况");
		m_agentLocator.check();
		
	}

	@Autowired(required=true)
	public void setAgentLocator(AgentLocator agentLocator) {
		m_agentLocator = agentLocator;
	}
	
	
}
