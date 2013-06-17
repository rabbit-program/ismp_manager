package org.infosec.ismp.manager.agentdisc;

import java.util.Timer;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;

/**
 * Agent发现组件，该组件接受事件uei=AGENT_REGIESTER_EVENT_UEI,查看该agent是否
 * 在agent列表中，如果不在，认为发现一个新的Agent，
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class AgentDiscovery extends AbstractServiceDaemon implements
		EventListener {

	private Timer m_timer;//定时器

	public AgentDiscovery() {
		super("ISMP.AGENT_DISCOVERY");
	}

	@Override
	protected void onInit() {

	}

	@Override
	protected void onStart() {
		addEventListener();
	}

	@Override
	protected void onStop() {
		removeEventListener();
	}

	private void removeEventListener() {
		EventIpcManagerFactory.getIpcManager().removeEventListener(this,
				EventConstants.AGENT_REGIESTER_EVENT_UEI);
	}

	private void addEventListener() {
		EventIpcManagerFactory.getIpcManager().addEventListener(this,
				EventConstants.AGENT_REGIESTER_EVENT_UEI);

	}

	/**
	 * 根据接受到Agent注册事件，判断Agent是否
	 */
	@Override
	public void onEvent(Event e) {
		log().debug("received Event,uei is : " + e.getUei());
		//TODO
	}

	private void checkAgentStatus() {
		//TODO
	}

}
