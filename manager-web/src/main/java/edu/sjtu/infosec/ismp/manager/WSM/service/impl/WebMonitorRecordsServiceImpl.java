package edu.sjtu.infosec.ismp.manager.WSM.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.infosec.ismp.manager.rmi.wsm.model.SiteCheckRmiModel;
import org.infosec.ismp.manager.rmi.wsm.service.SiteCheckRmiInterface;

import edu.sjtu.infosec.ismp.manager.WSM.dao.WebMonitorRecordsDao;
import edu.sjtu.infosec.ismp.manager.WSM.model.WebMonitorRecords;
import edu.sjtu.infosec.ismp.manager.WSM.service.WebMonitorRecordsService;
import edu.sjtu.infosec.ismp.security.Domain;

public class WebMonitorRecordsServiceImpl implements WebMonitorRecordsService {
	private Timer timer = new Timer();
	
	private WebMonitorRecordsDao webMonitorRecordsDao;
	
	private SiteCheckRmiInterface siteCheckRmiInterface;
	
	private Map<String,String> hm=new HashMap<String,String>();


	public void setWebMonitorRecordsDao(WebMonitorRecordsDao webMonitorRecordsDao) {
		this.webMonitorRecordsDao = webMonitorRecordsDao;
	}

	public void setSiteCheckRmiInterface(SiteCheckRmiInterface siteCheckRmiInterface) {
		this.siteCheckRmiInterface = siteCheckRmiInterface;
	}
	
	/**
	 * 获取后台传过来的信息
	 */
	public Object[] findWebStates(String nodeId,Integer timeOut){
		Object[] obj = null;
		SiteCheckRmiModel webStates=null;
		try {
			if(hm.get("run")!="yes" && hm.get("flag")=="1"){
				TimerTask timerTask = new TimerTask(){
					public void run(){
						hm.put("flag", "0");
						hm.put("run", "yes");
					}
				};
				timer.schedule(timerTask,0,(5 * 60 * 1000));// 60 * 1000
			}
			long start =System.currentTimeMillis();
			if(hm.get("flag")=="1"){
				hm.put(nodeId, "yes");
			}else{
				webStates=siteCheckRmiInterface.getSiteCheck(nodeId);
			}
			long end =System.currentTimeMillis();
			if(webStates!=null&&!"".equals(webStates)){
				//yes:超时     no:未超时
				if((start-end)*0.001>=timeOut){
					hm.put(nodeId, "yes");
				}else{
					hm.put(nodeId, "no");
				}
				obj=new Object[4];
				if(webStates.getPingStatus().equals("Up")){
					obj[0]="在线";
				}else{
					obj[0]="不在线";
				}
				obj[1]=webStates.getResponseTime();
				if(webStates.getSiteCheckStatus().equals("NORMAL")){
					obj[2]="页面未更改";
					obj[3]=true;
				}else{
					obj[2]="页面被更改";
					obj[3]=false;
				}
			}
		} catch (Exception e) {
			hm.put(nodeId, "yes");
			hm.put("flag", "1");
			e.printStackTrace();
		}
		System.out.println("---flag---"+hm.get("flag"));
		return obj;
	}
	
	/**
	 * 获取状态是否超时
	 */
	public String findOverStates (String nodeId){
		String state=hm.get(nodeId);
		System.out.println(nodeId+"=nodeid=====state=="+state);
		return state;
	}
	/**
	 * 认可
	 */
	public boolean isChange(String nodeId){
		boolean falg = false;;
		try {
			SiteCheckRmiModel webStates=siteCheckRmiInterface.getSiteCheck(nodeId);
			if(webStates!=null&&!"".equals(webStates)){
				WebMonitorRecords webMonitor=findByNodeId(nodeId);
				if(webStates.getSiteCheckStatus()!=null&&webStates.getSiteCheckStatus()!=webMonitor.getChangeCode()){
					webMonitor.setChangeCode(webStates.getSiteCheckStatus());
					webMonitorRecordsDao.saveOrUpdate(webMonitor);
					falg=true;
					//发送数据给后台
					siteCheckRmiInterface.resetSiteCheck(nodeId);
				}
			}
		} catch (Exception e) {
			falg=false;
			throw new RuntimeException("认可-运行时异常");   
		}
		return falg;
	}
	
	/**
	 * 通过nodeId查找网站安全检测信息
	 */
	public WebMonitorRecords findByNodeId(String nodeId){
    	WebMonitorRecords webMonitorRecords = webMonitorRecordsDao.findByNodeId(nodeId);

		return webMonitorRecords;
	}
	
	
	
	 /**
     * 网站安全检测分页信息
     */
	public List<WebMonitorRecords> findAll(int startResult, int maxResult) {
		return webMonitorRecordsDao.findAll(startResult,maxResult);
	}

	/**
     * 查询网站安全检测
     */
	public WebMonitorRecords findById(Integer id) {
		return webMonitorRecordsDao.findById(id);
	}

	 /**
     * 删除网站安全检测信息
     */
	public void remove(Integer id) {
		if(id != null) {
			WebMonitorRecords webMonitorRecords = webMonitorRecordsDao.findById(id);
			webMonitorRecordsDao.remove(webMonitorRecords);
        }
	}

	/**
     * 批量删除网站安全检测信息
     */
	public void remove(String[] ids) {
		List<WebMonitorRecords> WebMonitorList = new ArrayList<WebMonitorRecords>();
        for(int i=0;i<ids.length;i++) {
        	WebMonitorRecords webMonitorRecords = webMonitorRecordsDao.findById(Integer.parseInt(ids[i]));
        	WebMonitorList.add(webMonitorRecords);
        }
        if(WebMonitorList.size()>0) {
        	webMonitorRecordsDao.remove(WebMonitorList);
        }
	}
	
	/**
     * 保存/更新网站安全检测信息
     */
	public void saveOrUpdate(WebMonitorRecords webMonitorRecords) {
		webMonitorRecordsDao.saveOrUpdate(webMonitorRecords);
	}


	public int getCount() {
		return 	webMonitorRecordsDao.getCount();
	}

	 /**
     * 网站安全检测分页信息
     */
	public List<WebMonitorRecords> findAllByDomain(List<Domain> userDomainList,
			int startResult, int maxResult) {
		return webMonitorRecordsDao.findAllByDomain(userDomainList,startResult,maxResult);
	}


	public int getCountByDomain(List<Domain> userDomainList) {
		return webMonitorRecordsDao.getCountByDomain(userDomainList);
	}

	public void saveAllMonitor(WebMonitorRecords Monitor) {
		Boolean flag=true;
		if(Monitor.getId()!=null){
			flag=false;
		}
		try{
		   saveOrUpdate(Monitor);
	       //发送数据给后台
	        if(flag){
		        siteCheckRmiInterface.addSiteCheck(Monitor.getDomain().getId()+"", Monitor.getNodeId()+"", Monitor.getUrl(), Monitor.getTimeInterval(), Monitor.getTimeOut());
	        }else{
	        	siteCheckRmiInterface.updateSiteCheck(Monitor.getNodeId(),  Monitor.getUrl(), Monitor.getTimeInterval(), Monitor.getTimeOut());
	        }		
		}catch (Exception e) {
			//e.printStackTrace();
			throw new RuntimeException("新增/修改-运行时异常");   
		}
	
	}

	public void removeAllMonitor(WebMonitorRecords record) {
		try {
			String nodeId = record.getNodeId();
	    	webMonitorRecordsDao.remove(record);
	    	siteCheckRmiInterface.removeSiteCheck(nodeId);
		} catch (Exception e) {
			throw new RuntimeException("删除-运行时异常");   
		}

	}

}
