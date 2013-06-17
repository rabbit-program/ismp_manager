package org.infosec.ismp.manager.direct;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.UUID;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;
import org.opennms.protocols.rt.IDBasedRequestLocator;
import org.opennms.protocols.rt.RequestTracker;

/**
 * 用于发送直接请求
 * @author lianglin
 *
 */

public class DirectRequestSender {
	private  RequestTracker<DirectRequest, DirectReply> s_commandTracker;
	
	public JMSSocket jmsSocket;

	
	public  void sendEvent(InetAddress host, int port, Event event,
			long timeout, DirectResponseCallback cb) throws Exception {
		initialize();
		DirectRequest request = new DirectRequest(host, port, event,
				timeout,cb);
		s_commandTracker.sendRequest(request);
	}
	
	public Serializable sendEvent(InetAddress host,int port,Event event,long timeout){
		String uuid = event.getUuid();
	    if(uuid==null){
	    	uuid = UUID.randomUUID().toString();
	    	event.setUuid(uuid);
	    }
		SingleDirectResponseCallback cb = new SingleDirectResponseCallback(host, port);
		try {
			sendEvent(host, port, event,timeout,cb);
			cb.waitFor();
		} catch (Exception e) {
			log().warn("发送事件出错", e);
		}
		if(uuid.equals(cb.getUuid())){
			return cb.getResult();
		}else{
			return null;
		}
	}
	
	
	
	public void setJmsSocket(JMSSocket jmsSocket) {
		this.jmsSocket = jmsSocket;
	}

	static ThreadCategory log(){
		return ThreadCategory.getInstance(DirectRequestSender.class.getName());
	}

	/**
	 * Initializes this singleton
	 */
	public synchronized  void initialize() throws IOException {
		if (s_commandTracker != null)
			return;
		s_commandTracker = new RequestTracker<DirectRequest, DirectReply>(
				"DirectCommand",
				new DirectMessenger(jmsSocket),
				new IDBasedRequestLocator<DirectRequestId, DirectRequest, DirectReply>());
		s_commandTracker.start();
	}
}
