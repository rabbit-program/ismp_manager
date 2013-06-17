package org.infosec.ismp.servicecheck;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.model.poller.ServiceMonitor;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.scheduler.LegacyScheduler;
import org.infosec.ismp.util.scheduler.Schedule;
import org.infosec.ismp.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class ServiceCheck extends AbstractServiceDaemon {
	private final static String LOG4J_CATEGORY = "ISMP.ServiceCheck";
	private Scheduler m_scheduler;// 调度器
	private int m_threads = 10;
	private Map<String,ServiceCheckService> serviceCheckMap = new HashMap<String,ServiceCheckService>();
	private Map<String,ServiceMonitor> monitorMap = new HashMap<String,ServiceMonitor>();
	private ServiceCheckMessageSend messageSend;
	public ServiceCheckMessageSend getMessageSend() {
		return messageSend;
	}
	@Autowired(required=true)
	public void setMessageSend(ServiceCheckMessageSend messageSend) {
		this.messageSend = messageSend;
	}

	public Scheduler getScheduler() {
		return m_scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		m_scheduler = scheduler;
	}

	public int getThreads() {
		return m_threads;
	}

	public void setThreads(int threads) {
		m_threads = threads;
	}

	public ServiceCheck() {
		super(LOG4J_CATEGORY);
	}
	/**
	 * 添加一个服务
	 * @param nodeid
	 * @param serviceType
	 * @param parameters
	 */
	public void addServiceCheck(String nodeid,String serviceType,long interval,String ipAddr,Map parameters)
	{	
		if (serviceCheckMap.containsKey(nodeid)) {
			log().error("该nodeid："+nodeid+"已存在！请重新输入！");
			return;	
		}
		if(null==serviceType&&"".equals(serviceType))
		{
			log().error("请输入该nodeid："+nodeid+"中serviceType！请重新输入！");
			return;
		}
		serviceType=serviceType.toLowerCase();
		if(!monitorMap.containsKey(serviceType))
		{
			ServiceMonitor monitor=null;
			try {
				monitor = initMonitor(serviceType);
			} catch (IOException e) {
				log().warn("读取属性文件IO异常！nodeid："+nodeid,e);
				return;
			} catch (ClassNotFoundException e) {
				log().warn("该monitor服务不存在！nodeid："+nodeid,e);
				return;
			} catch (InstantiationException e) {
				log().warn("该monitor服务初始化错误！nodeid："+nodeid,e);
				return;
			} catch (IllegalAccessException e) {
				log().warn("该monitor服务不存在！nodeid："+nodeid,e);
				return;
			}
			if(null==monitor)
			{
				log().warn("资源配置文件中找不到该服务类型！nodeid："+nodeid+"serviceType："+serviceType);
				return;
			}
			monitorMap.put(serviceType, monitor);
		}
		ServiceCheckModel model = new ServiceCheckModel();
		model.setNodeid(nodeid);
		model.setType(serviceType);
		model.setMonitor((ServiceMonitor)monitorMap.get(serviceType));
		ServiceCheckConfig config = new ServiceCheckConfig();
		config.setInterval(interval);
		model.setIpAddr(ipAddr);
////		System.out.println(parameters.get("ipAddr"));
//		if(null!=parameters&&parameters.size()>0){
//			if(null!=parameters.get("interval")){
//				if(parameters.get("interval") instanceof Long){					
//					config.setInterval((Long)parameters.get("interval"));
//				}
//			}
//			if(null!=parameters.get("ipAddr")&&!"".equals(parameters.get("ipAddr"))){						
//				model.setIpAddr(parameters.get("ipAddr").toString());
//			}else
//			{
//				log().error("ServiceCheck类中addServiceCheck方法parameters中未输出ipAddr元素！nodeid："+nodeid);
//				return ;
//			}
//		}
//		else
//		{
//			log().error("请输入erviceCheck类中addServiceCheck方法parameters参数！nodeid："+nodeid);
//			return;
//		}
		model.setParameters(parameters);
		ServiceCheckService service = new ServiceCheckService();
		service.setModel(model);
		Schedule schedule =new Schedule(service,config,m_scheduler);
		service.setMessageSend(messageSend);
		service.setSchedule(schedule);
		service.schedule();
		serviceCheckMap.put(nodeid, service);
	}
	
	/**
	 * 删除一个服务
	 * @param nodeid
	 * @param type
	 * @param parameters
	 */
	public void removeServiceCheck(String nodeid)
	{
		if (serviceCheckMap.containsKey(nodeid)) {
			ServiceCheckService service =  serviceCheckMap.get(nodeid);
			service.delete();
			serviceCheckMap.remove(nodeid);
			log().debug("取消一个曾ServiceCheck服务！nodeId:"+nodeid);
		}else
		{
			log().debug("ServiceCheck服务该nodeId:"+nodeid+"不存在服务中！");
		}
	}
	@Override
	protected void onInit() {
		log().debug("init: init ServiceCheck component");
		createScheduler();
	}
	
	/**
	 * 获取monitor
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public ServiceMonitor initMonitor(String type) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	
		InputStream is = this.getClass().getResourceAsStream("/application.properties");				
		Properties props = new Properties(); 
		props.load(is);			
		String className = props.getProperty("servicecheck.monitor."+type); 
//		System.out.println(className);
		if(null==className||"".equals(className))
		{
			return null;
		}
		Class clz = Class.forName(className);
		is.close();
		return (ServiceMonitor) clz.newInstance();
		
		}
	
	private void createScheduler() {
		ThreadCategory log = log();
		// Create a scheduler
		try {
			log.debug("init: Creating "+LOG4J_CATEGORY+" scheduler");

			setScheduler(new LegacyScheduler(LOG4J_CATEGORY, m_threads));
		} catch (RuntimeException e) {
			log.fatal("init: Failed to create "+LOG4J_CATEGORY+" scheduler", e);
			throw e;
		}
	}
	@Override
	protected void onStart() {
		try {
			if (log().isDebugEnabled())
				log().debug("start: Starting snmp collectd scheduler");

			getScheduler().start();			
		} catch (RuntimeException e) {
			if (log().isEnabledFor(ThreadCategory.Level.FATAL))
				log().fatal("start: Failed to start scheduler", e);
			throw e;
		}
		
		try{
			BroadcastEventProcessor processor = new BroadcastEventProcessor(this);
		}catch (Exception ex) {
			log().error("Failed to setup event reader", ex);
			throw new UndeclaredThrowableException(ex);
		}
	}
	@Override
	protected void onStop() {
		if (log().isDebugEnabled())
			log().debug("stop: stoping snmp collectd scheduler");
		if (getScheduler() != null) {
			getScheduler().stop();
		}
	}

}
