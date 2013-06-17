package org.infosec.ismp.manager.topo;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.infosec.ismp.collectd.SnmpGetterModel;
import org.infosec.ismp.manager.direct.DirectReply;
import org.infosec.ismp.manager.direct.JMSSocket;
import org.infosec.ismp.manager.rmi.scm.model.PollStatus;
import org.springframework.jms.core.JmsTemplate;

public class SnmpGetterSocket extends JMSSocket {	

	@Override
	protected List<DirectReply> processMessage(Message message) {
		ObjectMessage map = (ObjectMessage) message;
		List<DirectReply> list = new ArrayList<DirectReply>();
		try {
			SnmpGetterModel model =(SnmpGetterModel) map.getObject();
			String uuid = model.getUuid();
			DirectReply directReply = new DirectReply(uuid,model);
			list.add(directReply);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return list;
	}

}
