package org.infosec.ismp.ping;

import org.infosec.ismp.util.scheduler.ScheduleInterval;

public class PingdConfig implements ScheduleInterval {
	private long interval=30000;

	public void setInterval(long interval) {
		this.interval = interval;
	}

	@Override
	public long getInterval() {
		return interval;
	}

	@Override
	public boolean scheduledSuspension() {
		return false;
	}

}
