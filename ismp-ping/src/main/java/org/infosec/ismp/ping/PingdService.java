package org.infosec.ismp.ping;

import java.util.Date;

import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.scheduler.ReadyRunnable;
import org.infosec.ismp.util.scheduler.Schedule;

public class PingdService implements ReadyRunnable {
	public final static String STATUS_UP = "UP";
	public final static String STATUS_DOWN = "DOWN";
	
	
	private boolean isReady = true;
	private PingdMessageSend pingdsend;
	private Schedule schedule;
	private PingdModel pingdmodel;
	private PingdConfig config;
	private boolean halfIntervalWhenDown;

	public boolean isHalfIntervalWhenDown() {
		return halfIntervalWhenDown;
	}

	public void setHalfIntervalWhenDown(boolean halfIntervalWhenDown) {
		this.halfIntervalWhenDown = halfIntervalWhenDown;
	}

	public PingdConfig getConfig() {
		return config;
	}

	public void setConfig(PingdConfig config) {
		this.config = config;
	}

	private String status ;

	public PingdMessageSend getPingdsend() {
		return pingdsend;
	}

	public void setPingdsend(PingdMessageSend pingdsend) {
		this.pingdsend = pingdsend;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public boolean isReady() {
		return isReady;
	}

	/**
	 * ping主方法
	 */
	private void pingdSend() {
		log().debug(
				"进入PingdService类pingdSend()方法！nodeId:" + pingdmodel.getNodeid()
						+ "ipAdderss:" + pingdmodel.getIpAddr());
		Long pingtime = null;
		try {
			pingtime = Pinger.ping(pingdmodel.getIpInetAddr());// 获取PING通时间
		} catch (Exception e) {
			log().fatal(
					"PingdService类pingdSend()方法Pinger.ping异常！nodeId:"
							+ pingdmodel.getNodeid() + "ipAdderss:"
							+ pingdmodel.getIpAddr(), e);
		}
		if (pingtime == null)// 如果ping不通
		{
			if (STATUS_UP.equalsIgnoreCase(status)) {
				log().debug(
						"PingdService类pingdSend()方法该地址现在无法ping通！nodeId:"
								+ pingdmodel.getNodeid() + "ipAdderss:"
								+ pingdmodel.getIpAddr());				
				if (halfIntervalWhenDown) // 如果为TRUE 发送时间减半
				{
					config.setInterval(config.getInterval() / 2);
				}
			}
			status = STATUS_DOWN;
			pingdmodel.setPingFlag(status);// 如果不通设置ping状态为1
		} else// 如果ping通
		{
			if (STATUS_DOWN.equalsIgnoreCase(status)) {
				log().debug(
						"PingdService类pingdSend()方法该地址现在又可以ping通！nodeId:"
								+ pingdmodel.getNodeid() + "ipAdderss:"
								+ pingdmodel.getIpAddr() + "pingtime:"
								+ pingtime);				
				if (halfIntervalWhenDown) // 如果为TRUE 发送时间回复
				{
					config.setInterval(config.getInterval() * 2);
				}
			}
			status = STATUS_UP;
			pingdmodel.setPingFlag(status);// 如果不通设置ping状态为0
		}
		pingdmodel.setResponseTime(pingtime);
		try {
			pingdsend.springSend(pingdmodel);
			log().debug(
					"nodeId:" + pingdmodel.getNodeid() + "ipAdderss:"
							+ pingdmodel.getIpAddr() + "发功MQ队列消息成功！");
		} catch (Exception e) {
			log().fatal(
					"PingdService类pingdSend()方法发送MQ信息失败！nodeId:"
							+ pingdmodel.getNodeid() + "ipAdderss:"
							+ pingdmodel.getIpAddr(), e);
		}
	}

	public PingdModel getPingdmodel() {
		return pingdmodel;
	}

	public void setPingdmodel(PingdModel pingdmodel) {
		this.pingdmodel = pingdmodel;
	}

	@Override
	public void run() {
		pingdSend();
		log().debug(
				"pingd消息发送MQ完毕！nodeId:" + pingdmodel.getNodeid() + "ipAdderss:"
						+ pingdmodel.getIpAddr());
	}

	/**
	 * 将该服务放入调度池中
	 */
	public void schedule() {
		if (schedule == null)
			throw new IllegalStateException(
					"Cannot schedule a service whose schedule is set to null");
		schedule.schedule();
		log().debug(
				"该服务放入调度池中！nodeId:" + pingdmodel.getNodeid() + "ipAdderss:"
						+ pingdmodel.getIpAddr());
	}

	/**
	 * 取消该服务
	 */
	public void delete() {
		if (schedule == null)
			throw new IllegalStateException(
					"Cannot unschedule a service whose schedule is set to null");
		schedule.unschedule();
		log().debug(
				"取消该服务！nodeId:" + pingdmodel.getNodeid() + "ipAdderss:"
						+ pingdmodel.getIpAddr());
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
