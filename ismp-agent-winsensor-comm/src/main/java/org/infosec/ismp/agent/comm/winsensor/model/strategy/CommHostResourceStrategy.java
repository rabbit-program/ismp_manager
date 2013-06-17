package org.infosec.ismp.agent.comm.winsensor.model.strategy;


/**
 * @author Rocky
 * @version create time：Dec 6, 2010 2:02:14 PM
 * 
 */
public class CommHostResourceStrategy extends CommBaseStrategy {

	private static final long serialVersionUID = 1772275875453295561L;

	/*
	 * The URL send hostResource to sensor server.
	 */
	private String url;
	
	/*
	 * The interval that sensor client send hostResource to sensor server. Unit: second.
	 */
	private int interval;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
}
