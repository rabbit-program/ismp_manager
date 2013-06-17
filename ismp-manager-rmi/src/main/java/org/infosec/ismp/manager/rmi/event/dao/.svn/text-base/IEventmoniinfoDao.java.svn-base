package org.infosec.ismp.manager.rmi.event.dao;

import java.io.Serializable;
import java.util.List;

import org.infosec.ismp.manager.rmi.event.dao.queryCondition.EventmoniinfoCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventmoniinfoResult;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoniinfo;

/**
 * 设备监控信息表的DAO实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventmoniinfoDao {
	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	void add(Eventmoniinfo data) ;
	
	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	void add(List<Eventmoniinfo> data);
	
	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	void update(Eventmoniinfo data);

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	void update(List<Eventmoniinfo> data);
	
	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	void delete(Eventmoniinfo data);
	
		
	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	void delete(List<Serializable> ids);
	
	/**
	 * 通过ID查询对象
	 * 
	 * @param id
	 * 
	 */
	Eventmoniinfo get(Serializable id);
	
	/**
	 * 通过组合条件进行查询
	 * @param condition
	 * @return
	 */
	EventmoniinfoResult queryEventmoniinfoByCondition(EventmoniinfoCondition condition);
	
}
