package org.infosec.ismp.manager.snmp;

import org.infosec.ismp.manager.snmp.processor.NetworkMessageProcessor;
import org.infosec.ismp.manager.snmp.processor.HostMessageProcessor;
import org.infosec.ismp.manager.snmp.processor.WebLogicMessageProcessor;
import org.springframework.stereotype.Component;

/**
 * @author guoxianwei
 * @date 2010-12-23 上午10:32:42
 * 
 *   信息处理门面类
 *   
 */
@Component
public final class MessageProcessor {

	NetworkMessageProcessor m_networkProcessor;

	HostMessageProcessor m_hostProcessor;

	WebLogicMessageProcessor m_weblogicProcessor;

	MessageProcessor() {
		m_networkProcessor = new NetworkMessageProcessor();
		m_hostProcessor = new HostMessageProcessor();
		m_weblogicProcessor = new WebLogicMessageProcessor();
	}

	protected NetworkMessageProcessor getNetworkProcessor() {
		return m_networkProcessor;
	}

	protected HostMessageProcessor getHostProcessor() {
		return m_hostProcessor;
	}

	protected WebLogicMessageProcessor getWeblogicProcessor() {
		return m_weblogicProcessor;
	}

}

