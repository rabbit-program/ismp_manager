package org.infosec.ismp.agent;

import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.database.collectd.UnSupportTypeException;
import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * @author guoxianwei
 * @date 2010-12-2 下午03:07:04
 * 
 */
public class SendAddSnmpCollectd {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SNMPCOLLECTD_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid("123");
		event.setIpAddr("192.168.9.146");
		Parms parms = new Parms();
		
		Parm parm = new Parm();
	    parm.setParmName("interval");
	    Value value = new Value();
	    value.setContent("3000");
	    parm.setValue(value);
	    
	    parms.addParm(parm);
	    /*		 * @param url  jdbc:sqlserver://127.0.0.1:7581;DatabaseName=model
		 * @param username  sa
		 * @param password 123456
		 * @param dbname model
		 * @param type  sqlserver
		 * @param version 2000
		 * @param interval 3000  ms
		 * @throws UnSupportTypeException */
	    parm = new Parm();
	    parm.setParmName("type");
	    value = new Value();
	    value.setContent("hostResource");
	    parm.setValue(value);
	    parms.addParm(parm);
	    
	    parm = new Parm();
	    parm.setParmName("port");
	    value = new Value();
	    value.setContent("161");
	    parm.setValue(value);
	    parms.addParm(parm);
	    
	    parm = new Parm();
	    parm.setParmName("community");
	    value = new Value();
	    value.setContent("public");
	    parm.setValue(value);
	    parms.addParm(parm);
	    
	    parm = new Parm();
	    parm.setParmName("snmpVersion");
	    value = new Value();
	    value.setContent("2");
	    parm.setValue(value);
	    parms.addParm(parm);

	    event.setParams(parms);
	    
	    
		InetAddress address = InetAddress.getByName("127.0.0.1");
		boolean flag =EventSender.sendEvent(address, 5819, event);
		System.out.println("send flag is : "+flag);

	}

}

