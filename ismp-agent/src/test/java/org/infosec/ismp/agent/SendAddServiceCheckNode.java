package org.infosec.ismp.agent;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.Value;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

public class SendAddServiceCheckNode {

	/**
	 * @param args
	 * @throws  
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SERVICECHECK_NODE_ADD_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid("123");
		event.setIpAddr("202.96.199.133");
		Parms parms = new Parms();
		
		Parm parm = new Parm();
	    parm.setParmName("serviceType");
	    Value value = new Value();
	    value.setContent("servicecheck.monitor.dns");
	    parm.setValue(value);	    
	    parms.addParm(parm);
	    
	    parm = new Parm();	    
	    parm.setParmName("port");
	    value = new Value();
	    value.setContent("53");
	    parm.setValue(value);	    
	    parms.addParm(parm);
	    
	    parm = new Parm();	    
	    parm.setParmName("lookup");
	    value = new Value();
	    value.setContent("202.96.199.133");
	    parm.setValue(value);
	    parms.addParm(parm);
	    
	    event.setParams(parms);
	    
	    System.out.println("event is : "+event);
	    StringWriter out = new StringWriter();
	    Marshaller.marshal(event, out);
	    System.out.println(out.getBuffer());
	    
	    String p = out.getBuffer().toString();
	    Unmarshaller u = new Unmarshaller(Event.class);
	    u.setIgnoreExtraAttributes(false);
        u.setIgnoreExtraElements(false);
	    Event newEvent = (Event)u.unmarshal(new StringReader(p));
	    
	    System.out.println("new Event is : "+newEvent);
	    
	    
		InetAddress address = InetAddress.getByName("127.0.0.1");
		boolean flag =EventSender.sendEvent(address, 5819, event);
		System.out.println("send flag is : "+flag);
	}

}
