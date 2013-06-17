package edu.sjtu.infosec.ismp.manager.EM.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetDeviceDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventcorrruleDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventmoniDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventrealdispDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.impl.EventcorrruleDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.impl.EventmoniDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.RuleCondition;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventcorrrule;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventrealdisp;
import edu.sjtu.infosec.ismp.manager.EM.service.IEventStatisticsService;

/**
 * 用于页面显示一些统计信息
 * @author wudengke 2009-6-8
 *
 */
public class EventStatisticsService implements IEventStatisticsService {
		//IOC注入
	private IEventmoniDao eventmoniDao;   
	    
	public void setEventmoniDao(EventmoniDao eventmoniDao) {
	    	this.eventmoniDao = eventmoniDao;
			
		}
	  //IOC注入
	private IEventrealdispDao  eventrealdispDao;

	public void setEventrealdispDao(IEventrealdispDao eventrealdispDao) {
			this.eventrealdispDao = eventrealdispDao;
		}
		//IOC注入
	private IEventcorrruleDao eventcorrruleDao;
		

	public void setEventcorrruleDao(EventcorrruleDao eventcorrruleDao) {
			this.eventcorrruleDao = eventcorrruleDao;
		}
	//IOC注入
	private AssetDeviceDao assetDeviceDao;	
	

	public void setAssetDeviceDao(AssetDeviceDao assetDeviceDao) {
		this.assetDeviceDao = assetDeviceDao;
	}

	/**
	 * 统计所有设备ID在时间段内的事件集合(主要实现事件页面拓扑图)
	 * @param starttime
	 * @param endtime
	 * @return 事件监测表信息
	 */
	public List<Object> statisticsFaciid(Timestamp starttime, Timestamp endtime,Integer bureauId) {
		if (starttime!=null && endtime!=null) {
			return eventmoniDao.statisticsFaciid(starttime, endtime,bureauId);
		}
		return null;
	}

	/**
	 * 统计所有设备IP在时间段内的事件集合(主要实现事件页面Top10功能)
	 * @param starttime
	 * @param endtime
	 * @return 事件监测表信息
	 */
	public List<Object> statisticsFaciip(Timestamp starttime, Timestamp endtime,Integer bureauId) {
		if (starttime!=null && endtime!=null) {
			return eventmoniDao.statisticsFaciip(starttime, endtime, bureauId);
		}
		return null;
	}
	
	/**
	 * 根据传入的规则ID，查询所有符合规则的实时事件
	 * @param id
	 * @return　List<Eventrealdisp>,Eventcorrule,page
	 */
	public List<Eventrealdisp> queryEventrealdispByRules(String ruleids,long time,Integer[] bureauIds) {
		RuleCondition condition = new RuleCondition();
		if (ruleids!=null && ruleids.trim().length()>0 && time>0) {
			String[] ids = ruleids.split(",");
			List<Eventcorrrule> list = eventcorrruleDao.queryEventcorule(ids);
			condition = analysisDate(condition,list);
			condition.setRulelength(time);
			condition.setBureauId(bureauIds);
			List<Eventrealdisp> res= eventrealdispDao.queryBycorrrule(condition);
			return res;
		}
		return null;
	}
	private RuleCondition analysisDate(RuleCondition condition,List<Eventcorrrule> datas){
		for (int i=0;i<datas.size();i++) {
			if (datas.get(i).getDest_ip().equals("类型相同")){
				condition.setDestip_same(true);
			}
			if (datas.get(i).getDest_port().equals("类型相同")){
				condition.setDestport_same(true);
			}
			if (datas.get(i).getCorr_type().equals("类型相同")) {
				condition.setEventtype_same(true);
			}
			if (datas.get(i).getProt_rule().equals("类型相同")) {
				condition.setProtocol_same(true);
			}
			if (datas.get(i).getSrc_ip().equals("类型相同")) {
				condition.setSrcip_same(true);
			}
		}
		return condition;
	}
	
//	/**
//	 * 查找对应设备IP的资产信息
//	 * @param faci_id
//	 * @return　AssetDeviceBO
//	 */
//	public AssetDeviceBO queryAssetDeviceBOByFaciip(String faci_ip,Integer bureauId) {
//		AssetDeviceBO entity = new AssetDeviceBO();
//		entity.setIp(faci_ip);
//		entity.setLocationId(bureauId);
//		List<AssetDeviceBO> list = assetDeviceDao.getListByAssetDevice(entity);
//		if(list.size() > 0 && list != null){
//			return list.get(0);
//		}else{
//			return null;
//		}
//	}
	

	/**
	 * 统计所有安全设备在时间段内的事件集合(实现事件页面安全设备事件总量统计)
	 * @param starttime
	 * @param endtime
	 * @return 事件实时显示表信息
	 */
	public List<Object> staticticsEventType(Timestamp starttime,
			Timestamp endtime,Integer bureauId) {
		if (starttime!=null && endtime!=null) {
		return eventrealdispDao.staticticsEventType(starttime, endtime, bureauId);
		}
		return null;
	}
	
	/**
	 * 统计所有事件类型的各分组类型数量(实现安全设备事件类型分类统计)
	 * @param starttime
	 * @param endtime
	 * @return 事件实时显示表信息
	 */
	public List<Object> staticticsSafety(Timestamp starttime, Timestamp endtime, Integer bureauId) {
		if (starttime!=null && endtime!=null) {
			return eventrealdispDao.staticticsSafety(starttime, endtime, bureauId);
		}
		return null;
	}
}
