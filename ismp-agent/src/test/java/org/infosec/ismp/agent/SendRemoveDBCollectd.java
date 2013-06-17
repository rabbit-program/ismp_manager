package org.infosec.ismp.agent;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * @author guoxianwei
 * @date 2010-12-2 下午04:07:33
 * 
 */
public class SendRemoveDBCollectd {
	public static void main(String[] args) throws UnknownHostException {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.DB_COLLECT_NODE_DELETE_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid("123");
		Parms parms = new Parms();
		
		Parm parm = new Parm();
	    parm.setParmName("url");
	    Value value = new Value();
	    value.setContent("jdbc:sqlserver://192.168.9.85:1433;DatabaseName=master");
	    parm.setValue(value);
	    
	    parms.addParm(parm);
	    event.setParams(parms);
		InetAddress address = InetAddress.getByName("127.0.0.1");
		boolean flag =EventSender.sendEvent(address, 5819, event);
		System.out.println("send flag is : "+flag);
		
	}


}

