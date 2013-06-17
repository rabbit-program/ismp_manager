package org.infosec.ismp.manager.rmi.event.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.infosec.ismp.manager.rmi.event.dao.queryCondition.EventrealdispCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryCondition.RuleCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventrealdispResult;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;

/**
 * 事件实时显示表的DAO实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventrealdispDao {
	

	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	void add(Eventrealdisp data) ;
	
	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	void add(List<Eventrealdisp> data);
	
	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	void update(Eventrealdisp data);

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	void update(List<Eventrealdisp> data);
	
	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	void delete(Eventrealdisp data);
	
		
	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	void delete(List<Serializable> ids);
	
	/**
	 * 通过查询Eventrealdisp对象
	 * 
	 * @param id
	 * 
	 */
	Eventrealdisp get(Serializable id);
	
	/**
	 * 通过组合条件进行查询
	 * @param condition
	 * @return
	 */
	EventrealdispResult queryEventrealdispByCondition(EventrealdispCondition condition);
	
	/**
	 * 统计所有安全设备在时间段内的事件集合
	 * @param starttime
	 * @param endtime
	 * @return 事件实时显示表信息
	 */
	List<Object> staticticsSafety(Timestamp starttime,Timestamp endtime,final Integer bureauId);
	
	/**
	 * 统计所有事件类型的各分组类型数量
	 * @param starttime
	 * @param endtime
	 * @return 事件实时显示表信息
	 */
	List<Object> staticticsEventType(Timestamp starttime,Timestamp endtime,final Integer bureauId);
	
	/**
	 * 查询关联规则内条件记录集
	 * @param condition
	 * @return  List<Eventrealdisp>
	 */
	public List<Eventrealdisp> queryBycorrrule(RuleCondition condition);
	
}
