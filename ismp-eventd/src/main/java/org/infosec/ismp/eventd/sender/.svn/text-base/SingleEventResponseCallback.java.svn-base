
package org.infosec.ismp.eventd.sender;

import java.net.InetAddress;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.concurrent.BarrierSignaler;
import org.opennms.protocols.icmp.ICMPEchoPacket;


public class SingleEventResponseCallback implements EventResponseCallback {
	private final BarrierSignaler bs = new BarrierSignaler(1);
	@SuppressWarnings("unused")
	private Throwable error = null;
	private final InetAddress m_host;
	private final int m_port ;
	
	private String m_uuid;

	public SingleEventResponseCallback(InetAddress host,int port) {
		m_host = host;
		m_port = port;
	}
	
	

	@Override
	public void handleResponse(InetAddress address, int port, String uuid) {
		m_uuid =uuid;
		bs.signalAll();
	}



	@Override
	public void handleTimeout(InetAddress address, int port, Event event) {
		info("timed out send command to address " + address 
				+ ", command id " + event.getUuid());
		bs.signalAll();
	}



	@Override
	public void handleError(InetAddress address, int port, Event event,
			Throwable t) {
		info("an error occurred command send " + address, t);
		bs.signalAll();
	}


	private ThreadCategory log() {
		return ThreadCategory.getInstance(this.getClass());
	}


	public void waitFor(long timeout) throws InterruptedException {
		bs.waitFor(timeout);
	}

	public void waitFor() throws InterruptedException {
		info("waiting for command reply to " + m_host + " to finish");
		bs.waitFor();
		info("finished waiting for command reply to " + m_host + " to finish");
	}


	public void info(String msg) {
		log().info(msg);
	}

	public void info(String msg, Throwable t) {
		log().info(msg, t);
	}



	public String getUuid() {
		return m_uuid;
	}


}
