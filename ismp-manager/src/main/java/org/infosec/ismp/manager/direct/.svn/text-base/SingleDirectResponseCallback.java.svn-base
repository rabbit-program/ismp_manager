package org.infosec.ismp.manager.direct;

import java.io.Serializable;
import java.net.InetAddress;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.concurrent.BarrierSignaler;

public class SingleDirectResponseCallback implements DirectResponseCallback {
	
	private Serializable reply;

	public SingleDirectResponseCallback(InetAddress host, int port) {
		m_host = host;
		m_port = port;
	}

	private final BarrierSignaler bs = new BarrierSignaler(1);
	@SuppressWarnings("unused")
	private Throwable error = null;
	private final InetAddress m_host;
	private final int m_port ;
	
	private String m_uuid;


	
	

	@Override
	public void handleResponse(InetAddress address,int port,Serializable reply,String uuid) {
		log().info("reply is : 	"+reply);
		m_uuid =uuid;
		this.reply=reply;
		bs.signalAll();
	}



	@Override
	public void handleTimeout(InetAddress address,int port,Event event) {
		info("timed out receive command to address " + address 
				+ ", command id " + event.getUuid());
		bs.signalAll();
	}



	@Override
	public void handleError(InetAddress address,int port,Event event,
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

	public Serializable getResult() {
		return reply;
	}

}
