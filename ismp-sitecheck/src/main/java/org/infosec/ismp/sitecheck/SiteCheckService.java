package org.infosec.ismp.sitecheck;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.apache.activemq.management.PollCountStatisticImpl;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.htmlparser.util.ParserException;
import org.infosec.ismp.model.poller.PollStatus;
import org.infosec.ismp.ping.Pinger;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.scheduler.ReadyRunnable;
import org.infosec.ismp.util.scheduler.Schedule;

import com.sun.tools.javac.util.Log;

public class SiteCheckService implements ReadyRunnable {
	public final static String SITECHECK_STATUS_NORMAL = "NORMAL";
	public final static String SITECHECK_STATUS_EXCEPTION = "EXCEPTION";
	public final static String STATUS_UP = "Up";
	public final static String STATUS_DOWN = "Down";
	private boolean isReset = false; //当做重置操作时候为true 表示该次检测为重置后第一次检测
	private boolean isReady = true;
	private Schedule schedule;
	private SiteCheckModel model;
	private SiteCheckMessageSend siteSend;
	private String siteCheckStatus = SITECHECK_STATUS_NORMAL; //解析网站状态   "NORMAL", "EXCEPTION", "Down"
	private Set linkSet; // 网站链接元素集合
	private Set scriptSet; // 网站script元素集合
	private HttpSiteMonitor monitor; //用来获取访问站点返回时间和访问状态

	public HttpSiteMonitor getMonitor() {
		return monitor;
	}

	public void setMonitor(HttpSiteMonitor monitor) {
		this.monitor = monitor;
	}

	public SiteCheckMessageSend getSiteSend() {
		return siteSend;
	}

	public void setSiteSend(SiteCheckMessageSend siteSend) {
		this.siteSend = siteSend;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public SiteCheckModel getModel() {
		return model;
	}

	public void setModel(SiteCheckModel model) {
		this.model = model;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public boolean isReady() {
		return isReady;
	}

	public void run() {
		siteCheck();
		log().debug(
				"SiteCheck消息发送MQ完毕！nodeId:" + model.getNodeid() + "URL:"
						+ monitor.getIpAddr());
	}

	/**
	 * sitecheck服务主方法
	 */
	private void siteCheck() {
		siteCheckStatus =  SITECHECK_STATUS_NORMAL;
		try {
			monitor.httpOnline();//用来测试网站是否可以请求到
		} catch (HttpException e) {
			e.printStackTrace();
			log().warn("网址输入不正确或可能是协议不对或者返回的内容有问题！"+monitor.getIpAddr(),e);
			return;
		} catch (IOException e) {
			e.printStackTrace();
			log().warn("发生网络异常！"+monitor.getIpAddr(),e);
			return;
		}	
//		System.out.println("monitor.getStatusCode()==========================="+monitor.getStatusCode());
//		System.out.println("monitor.getResponseTime()==========================="+monitor.getResponseTime());
		String pingStatus = monitor.getStatusCode();
		long responseTime = monitor.getResponseTime();		
		if (STATUS_UP.equalsIgnoreCase(pingStatus))
		{
			try {
				siteCheckParser(monitor.getIpAddr());
			} catch (ParserException e) {
				log().warn(
						"SiteCheckService类SiteCheck()方法siteCheckParser失败！nodeId:"
								+ model.getNodeid() + "URL:"
								+ monitor.getIpAddr(), e);		
				return;
			} catch (NoSuchAlgorithmException e) {
				log().fatal(
						"SiteCheckService类SiteCheck()方法siteCheckParser失败！nodeId:"
								+ model.getNodeid() + "URL:"
								+ monitor.getIpAddr(), e);
				return;
			}
		}else
		{
			siteCheckStatus =  STATUS_DOWN;
		}
		model.setPingStatus(pingStatus);// ping状态 "Down" ,"Up"
		model.setResponseTime(responseTime);
		model.setSiteCheckStatus(siteCheckStatus);//解析网站状态   "NORMAL", "EXCEPTION", "Down"
		model.setReset(isReset);
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");	
//		System.out.println("pingStatus:"+pingStatus);	
//		System.out.println("siteCheckStatus:"+siteCheckStatus);	
		try {
			siteSend.springSend(model);
			log().debug(
					"nodeId:" + model.getNodeid() + "URL:"
							+ monitor.getIpAddr() + "发功MQ队列消息成功！");
		} catch (Exception e) {
			log().fatal(
					"SiteCheckService类SiteCheck()方法发送MQ信息失败！nodeId:"
							+ model.getNodeid() + "URL:"
							+ monitor.getIpAddr(), e);
		}
		isReset=false;
	}

	/**
	 * 验证页面超链元素和script元素
	 * 
	 * @param url
	 * @return
	 * @throws ParserException
	 * @throws NoSuchAlgorithmException
	 */
	private void siteCheckParser(String url) throws ParserException,
			NoSuchAlgorithmException {
		SiteCheckParser parser = new SiteCheckParser(url);
		Set linkSetTmp = parser.getLinkText();// 获取解析页面超链集合
		Set scriptSetTmp = parser.getScriptText();// 获取解析页面script集合
		if (null != linkSet) { // 如果不为NULL 说明不是第一次解析该网站 ，则监控与第一次解析页面是否有改变
			for (Iterator iterator = linkSetTmp.iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				if (!linkSet.contains(key)) {// 判断链接内容是否存在

//						System.out.println("key:"+key);						
						siteCheckStatus = SITECHECK_STATUS_EXCEPTION;

				}
			}
		} else// 程序启动第一次解析该网站获取链接集合
		{
			log().debug("程序启动第一次解析该网站获取链接集合,URL:" + url);
			linkSet = linkSetTmp;
			siteCheckStatus = SITECHECK_STATUS_NORMAL;
		}
		if (null != scriptSet) { // 如果不为NULL 说明不是第一次解析该网站 ，则监控与第一次解析页面是否有改变
			for (Iterator iterator = scriptSetTmp.iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				if (!scriptSet.contains(key)) { 
					siteCheckStatus = SITECHECK_STATUS_EXCEPTION;
//					System.out.println("scriptKey"+key);
				}
			}
		} else// 程序启动第一次解析该网站获取script集合
		{
			log().debug("程序启动第一次解析该网站获取script集合,URL:" + url);
			scriptSet = scriptSetTmp;
			siteCheckStatus = SITECHECK_STATUS_NORMAL;
		}
//		System.out.println("linkSetTmp.size():"+linkSetTmp.size());
//		System.out.println("scriptSetTmp.size():"+scriptSetTmp.size());
//		System.out.println("linkSet.size():"+linkSet.size());
//		System.out.println("scriptSet.size():"+scriptSet.size());
//		System.out.println("siteCheckStatus:"+siteCheckStatus);
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
				"SiteCheck该服务放入调度池中！nodeId:" + model.getNodeid() + "URL:"
						+ monitor.getIpAddr());
	}

	/**
	 * 重置sitecheck方法
	 */
	public void resetSiteCheck() {
		linkSet = null;
		scriptSet = null;
		isReset = true;
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
				"SiteCheck取消该服务！nodeId:" + model.getNodeid() + "URL:"
						+ monitor.getIpAddr());
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
