package org.infosec.ismp.eventd.sender;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

import org.apache.log4j.Logger;
import org.infosec.ismp.ping.PingRequest;
import org.opennms.protocols.rt.Messenger;

public class EventMessager implements
		Messenger<EventRequest, EventReply> {
	private UdpEventSocket m_eventSocket;

	public EventMessager() throws IOException {
		m_eventSocket = new UdpEventSocket();
	}

	public UdpEventSocket getEventSocket() {
		return m_eventSocket;
	}

	@Override
	public void sendRequest(EventRequest command) throws Exception {
		command.sendCommand(getEventSocket());

	}

	@Override
	public void start(final Queue<EventReply> replyQueue) {
		Thread socketReader = new Thread("Agent-Command-Reply-Reader") {

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

	void processPackets(Queue<EventReply> pendingReplies) {
		while (true) {
			try {
				List<EventReply> replys = getEventSocket().receive();

			    for(EventReply reply:replys){
			    	
			    	debugf("Found an command reply addr = %s, port = %d, created reply %s",
							reply.getAddr().getHostAddress(), reply.getPort(),
							 reply);
					pendingReplies.offer(reply);
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
