package edu.sjtu.infosec.ismp.manager.EM.service;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventrealdisp;

/**
 * 用于页面显示一些统计信息
 * @author wudengke 2009-6-8
 *
 */
public interface IEventStatisticsService {
	
	/**
	 * 统计所有设备ID在时间段内的事件集合(主要实现事件页面拓扑图)
	 * @param starttime
	 * @param endtime
	 * @return 事件监测表信息
	 */
	List<Object> statisticsFaciid(Timestamp starttime,Timestamp endtime,Integer bureauId);
	
	/**
	 * 统计所有设备IP在时间段内的事件集合(主要实现事件页面Top10功能)
	 * @param starttime
	 * @param endtime
	 * @return 事件监测表信息
	 */
	List<Object> statisticsFaciip(Timestamp starttime,Timestamp endtime,Integer bureauId);
	
	/**
	 * 统计所有安全设备在时间段内的事件集合(实现事件页面安全设备事件总量统计)
	 * @param starttime
	 * @param endtime
	 * @return 事件实时显示表信息
	 */
	List<Object> staticticsSafety(Timestamp starttime,Timestamp endtime,Integer bureauId);
	
	/**
	 * 统计所有事件类型的各分组类型数量(实现安全设备事件类型分类统计)
	 * @param starttime
	 * @param endtime
	 * @return 事件实时显示表信息
	 */
	List<Object> staticticsEventType(Timestamp starttime,Timestamp endtime,Integer bureauId);
	
	
	/**
	 * 根据传入的规则ID，查询所有符合规则的实时事件
	 * @param id
	 * @return　List<Eventrealdisp>,Eventcorrule,page
	 */
	public List<Eventrealdisp> queryEventrealdispByRules(String ruleids,long time,Integer[] bureauIds);
	
//	/**
//	 * 查找对应设备IP的资产信息
//	 * @param faci_id
//	 * @return　AssetDeviceBO
//	 */
//	public AssetDeviceBO queryAssetDeviceBOByFaciip(String faci_id, Integer bureauId);
	
}
