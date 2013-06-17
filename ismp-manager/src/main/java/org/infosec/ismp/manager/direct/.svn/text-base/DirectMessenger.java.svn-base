package org.infosec.ismp.manager.direct;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

import org.apache.log4j.Logger;
import org.opennms.protocols.rt.Messenger;

public class DirectMessenger implements Messenger<DirectRequest, DirectReply> {
	
	private final JMSSocket m_jmsSocket;
	
	

	public JMSSocket getJmsSocket() {
		return m_jmsSocket;
	}
	

	public DirectMessenger(JMSSocket jmsSocket) {
	   this.m_jmsSocket = jmsSocket;
	}

	@Override
	public void sendRequest(DirectRequest request) throws Exception {
		System.out.println("before send command");
		request.sendCommand(m_jmsSocket);
		System.out.println("after send command");
	}

	@Override
	public void start(final Queue<DirectReply> replyQueue) {
		Thread socketReader = new Thread("Direct-Command-Reply-Reader") {

			public void run() {
				try {
					processPackets(replyQueue);
				} catch (Throwable t) {
					errorf(t, "Unexpected exception on Thread %s!", this);
				}
			}
		};
		socketReader.start();
		
	}
	
	void processPackets(Queue<DirectReply> pendingReplies) {
		while (true) {
			try {
				List<DirectReply> replys = getJmsSocket().receive();
                if(replys!=null){
    			    for(DirectReply reply:replys){
    					pendingReplies.offer(reply);
    			    }
                }

			} catch (IOException e) {
				errorf(e, "I/O Error occurred reading from ICMP Socket");
			} catch (IllegalArgumentException e) {
				// this is not an EchoReply so ignore it
			} catch (Throwable t) {
				errorf(t, "Unexpect Exception processing reply packet!");
			}

		}
	}
	
	private Logger log() {
		return Logger.getLogger(getClass());
	}

	void debugf(String format, Object... args) {
		if (log().isDebugEnabled()) {
			log().debug(String.format(format, args));
		}
	}

	private void errorf(String format, Object... args) {
		log().error(String.format(format, args));
	}

	void errorf(Throwable t, String format, Object... args) {
		log().error(String.format(format, args), t);
	}

}
