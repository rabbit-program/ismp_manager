package org.infosec.ismp.servicecheck;

import org.infosec.ismp.util.scheduler.ScheduleInterval;

public class ServiceCheckConfig implements ScheduleInterval {

	private long interval=30000;

	public void setInterval(long interval) {
		this.interval = interval;
	}
	public long getInterval() {
		return interval;
	}

	public boolean scheduledSuspension() {
		// TODO Auto-generated method stub
		return false;
	}
}
