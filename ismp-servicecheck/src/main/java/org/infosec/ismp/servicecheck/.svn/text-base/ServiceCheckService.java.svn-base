package org.infosec.ismp.servicecheck;

import org.infosec.ismp.model.poller.PollStatus;
import org.infosec.ismp.model.poller.ServiceMonitor;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.scheduler.ReadyRunnable;
import org.infosec.ismp.util.scheduler.Schedule;

public class ServiceCheckService implements ReadyRunnable {

	private boolean isReady = true;
	private Schedule schedule;
	private ServiceCheckMessageSend messageSend;
	private ServiceCheckModel model;
	public ServiceCheckMessageSend getMessageSend() {
		return messageSend;
	}

	public void setMessageSend(ServiceCheckMessageSend messageSend) {
		this.messageSend = messageSend;
	}

	public ServiceCheckModel getModel() {
		return model;
	}

	public void setModel(ServiceCheckModel model) {
		this.model = model;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

		public boolean isReady() {
		return isReady;
	}

	public void run() {
//		System.out.println("++++++++++++++++++++++++++");
		doServiceCheck();
		log().debug(
				"ServiceCheck消息发送MQ完毕！nodeId:" + model.getNodeid() + "URL:"
						+ model.getIpAddr());
	}
	/**
	 * 服务检测主方法
	 */
	private void doServiceCheck()
	{
		ServiceMonitor monitor = model.getMonitor();
		monitor.initialize(model.getParameters());
		ServiceCheckMonitoredService svc = new ServiceCheckMonitoredService(model.getIpAddr());
		PollStatus status = monitor.poll(svc, model.getParameters());
//		System.out.println("status is : " + status);
		System.out
				.println("response time is : " + status.getResponseTime());
		model.setPingStatus(status.getStatusName());
		if("Up".equalsIgnoreCase(status.getStatusName()))//如果状态正常，则获取检测返回时间
		{
			model.setResponseTime(status.getResponseTime());
		}else
		{
			model.setResponseTime(-1);
		}		
		try {
//			System.out.println("nodeid:"+model.getNodeid());
//			System.out.println("ipaddr:"+model.getIpAddr());
//			System.out.println("serviceType:"+model.getType());
//			System.out.println("status:"+model.getPingStatus());
//			System.out.println("responseTime:"+model.getResponseTime());
			messageSend.springSend(model);
			log().debug(
					"nodeId:" + model.getNodeid() + "URL:"
							+ model.getIpAddr() + "发功MQ队列消息成功！");
		} catch (Exception e) {
			log().fatal(
					"ServiceCheckService类doServiceCheck()方法发送MQ信息失败！nodeId:"
							+ model.getNodeid() + "URL:"
							+ model.getIpAddr(), e);
		}
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
				"ServiceCheck该服务放入调度池中！nodeId:" + model.getNodeid() + "URL:"
						+ model.getIpAddr());
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
				"ServiceCheck取消该服务！nodeId:" + model.getNodeid() + "URL:"
						+ model.getIpAddr());
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
