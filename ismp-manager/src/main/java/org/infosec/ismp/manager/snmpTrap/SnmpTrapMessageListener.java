package org.infosec.ismp.manager.snmpTrap;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.infosec.ismp.manager.rmi.event.modle.TrapEvent;
import org.infosec.ismp.manager.rmi.event.modle.TrapEventWrapper;
import org.infosec.ismp.manager.server.event.EventTrapReceive;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnmpTrapMessageListener implements MessageListener {

	private EventTrapReceive trapReceiver;
	private SnmpTrapLocator m_trapLocator;
	@Override
	public void onMessage(Message message) {
		ObjectMessage om = (ObjectMessage)message;
		try {
			TrapEventWrapper wrapper = (TrapEventWrapper)om.getObject();
//			System.out.println("this is snmpTrapMessageListener class");
//			System.out.println("trapEvent.getMaxSizeResponsePDU  is :"+trapEvent.getMaxSizeResponsePDU());
//			System.out.println("trapEvent.getMessageProcessingModel  is :"+trapEvent.getMessageProcessingModel());
//			System.out.println("trapEvent.getSecurityLevel  is :"+trapEvent.getSecurityLevel());
//			System.out.println("trapEvent.getSecurityModel  is :"+trapEvent.getSecurityModel());
//			System.out.println("trapEvent.getPeerAddress  is :"+trapEvent.getPeerAddress());
//			System.out.println("trapEvent.getPdu  is :"+trapEvent.getPdu());
//			System.out.println("trapEvent.getSecurityName  is :"+trapEvent.getSecurityName());
//			System.out.println("trapEvent.getTransportMapping  is :"+trapEvent.getTransportMapping());
			TrapEvent event = wrapper.getEvent();
			
			String nodeid = wrapper.getNodeId();
			String fromIp = wrapper.getIp();
			
			String domain = m_trapLocator.getDomainByNodeId(nodeid);
			
			if(domain==null){
				log().info("该trap事件对应的domain不存在，抛弃，该nodeid是:"+nodeid);
			}else{
				trapReceiver.trapAnalytic(event, domain, nodeid, fromIp);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}catch(Throwable t){
			log().warn("解析消息出现异常",t);
		}

	}
	@Autowired(required=true)
	public void setTrapReceiver(EventTrapReceive trapReceiver) {
		this.trapReceiver = trapReceiver;
	}
	@Autowired(required=true)
	public void setTrapLocator(SnmpTrapLocator trapLocator) {
		m_trapLocator = trapLocator;
	}
	
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
