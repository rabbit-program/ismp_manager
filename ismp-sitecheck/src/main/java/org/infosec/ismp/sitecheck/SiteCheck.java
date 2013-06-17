package org.infosec.ismp.sitecheck;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.scheduler.LegacyScheduler;
import org.infosec.ismp.util.scheduler.Schedule;
import org.infosec.ismp.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("siteCheck")
public class SiteCheck extends AbstractServiceDaemon {
	private final static String LOG4J_CATEGORY = "ISMP.SiteCheck";
	private Scheduler m_scheduler;// 调度器
	private int m_threads = 10;
	private HashMap<String, SiteCheckService> siteMap = new HashMap<String, SiteCheckService>();
	private SiteCheckMessageSend siteSend;
	public SiteCheckMessageSend getSiteSend() {
		return siteSend;
	}
	@Autowired(required=true)
	@Qualifier("siteSend")
	public void setSiteSend(SiteCheckMessageSend siteSend) {
		this.siteSend = siteSend;
	}

	protected SiteCheck() {
		super(LOG4J_CATEGORY);
	}

	@Override
	protected void onInit() {
		log().debug("init: init pingd component");
		createScheduler();
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
	/**
	 * 
	 * @param nodeid
	 * @param url
	 * @param interval
	 */
	public void siteCheck(String nodeid,String url,long interval){
		String urltmp="";
		if(null!=url&&!"".equals(url))
		{
			urltmp=url.toLowerCase().replaceFirst("http://", "");
		}
		
			HttpSiteMonitor	monitor = new HttpSiteMonitor("http://"+urltmp);
			try {
				monitor.httpOnline();
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log().warn("网址输入不正确或可能是协议不对或者返回的内容有问题！"+url,e);
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log().warn("发生网络异常！"+url,e);
				return;
			}		
		if (siteMap.containsKey(nodeid)) {
			log().error("该nodeid："+nodeid+"已存在！请重新输入！");
			return;	
		}
		SiteCheckConfig config = new SiteCheckConfig();
		config.setInterval(interval);
		SiteCheckModel model = new SiteCheckModel();
		model.setNodeid(nodeid);
		model.setUrl(url);
		SiteCheckService service = new SiteCheckService();
		service.setModel(model);
		service.setMonitor(monitor);
		service.setSiteSend(siteSend);
		Schedule schedule =new Schedule(service,config,m_scheduler);
		service.setSchedule(schedule);
		service.schedule();
		siteMap.put(nodeid, service);
	}
	/**
	 * 
	 * @param nodeid
	 */
	public void unSiteCheck(String nodeid){
		if (siteMap.containsKey(nodeid)) {
			SiteCheckService service =  siteMap.get(nodeid);
			service.delete();
			siteMap.remove(nodeid);
			log().debug("取消一个曾SiteCheck服务！nodeId:"+nodeid);
		}else
		{
			log().debug("SiteCheck服务该nodeId:"+nodeid+"不存在服务中！");
		}
	}
	/**
	 * 
	 * @param nodeid
	 */
	public void resetSiteCheck(String nodeid){
		if (siteMap.containsKey(nodeid)) {
			SiteCheckService service =  siteMap.get(nodeid);
			service.resetSiteCheck();
			log().debug(" 重置一个曾SiteCheck服务！nodeId:"+nodeid);
		}else
		{
			log().debug("重置SiteCheck服务该nodeId:"+nodeid+"不存在服务中！");
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

	@Override
	protected void onStop() {
		if (log().isDebugEnabled())
			log().debug("stop: stoping snmp collectd scheduler");
		if (getScheduler() != null) {
			getScheduler().stop();
		}
	}

}
