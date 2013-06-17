package org.infosec.ismp.manager.rmi.event.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.infosec.ismp.manager.rmi.event.dao.queryCondition.EventmoniCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventmoniResult;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;

/**
 * 事件监测表的DAO实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventmoniDao {
	
	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	void add(Eventmoni data) ;
	
	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	void add(List<Eventmoni> data);
	
	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	void update(Eventmoni data);

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	void update(List<Eventmoni> data);
	
	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	void delete(Eventmoni data);
	
		
	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	void delete(List<Serializable> ids);
	
	/**
	 * 通过查询Eventmoni对象
	 * 
	 * @param id
	 * 
	 */
	Eventmoni get(Serializable id);
	
	/**
	 * 通过组合条件进行查询
	 * @param condition
	 * @return
	 */
	EventmoniResult queryEventmoniByCondition(EventmoniCondition condition);
	
	/**
	 * 统计所有设备ID在时间段内的事件集合
	 * @param starttime
	 * @param endtime
	 * @return 事件监测表信息
	 */
	List<Object> statisticsFaciid(Timestamp starttime,Timestamp endtime,Integer bureauId);
	
	/**
	 * 统计所有设备IP在时间段内的事件集合
	 * @param starttime
	 * @param endtime
	 * @return 事件监测表信息
	 */
	List<Object> statisticsFaciip(Timestamp starttime,Timestamp endtime,Integer bureauId);
	
	/**
	 * 通过设备IP查找记录
	 * @param faci_ip
	 * @return
	 */
	public List<Object> queryRealTimeList(String faci_ip,Integer bureauId);
	
	/**
	 * 获取最新记录的Faci_ip,total_value
	 * @return
	 */
	public List<Object> queryIpTotalByNew();
}
