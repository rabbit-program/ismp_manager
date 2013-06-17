package org.infosec.ismp.manager.ping;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;

import org.infosec.ismp.manager.direct.DirectReply;
import org.infosec.ismp.manager.direct.JMSSocket;
import org.infosec.ismp.manager.rmi.scm.model.PollStatus;
import org.springframework.jms.core.JmsTemplate;

public class DirectPingSocket extends JMSSocket {
	
	

	@Override
	protected List<DirectReply> processMessage(Message message) {
		MapMessage map = (MapMessage) message;
		List<DirectReply> list = new ArrayList<DirectReply>();
		try {
			String uuid = map.getString("uuid");
			String ipAddr = map.getString("ipAddr");
			Long responseTime = map.getLong("responseTime");
			String pingFlag = map.getString("pingFlag");
			String pingTime = map.getString("pingTime");
			PollStatus poll=PollStatus.decode(pingFlag, responseTime.doubleValue());
			DirectReply directReply = new DirectReply(uuid,poll);
			list.add(directReply);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return list;
	}

}
