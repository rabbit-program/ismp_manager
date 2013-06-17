package edu.sjtu.infosec.ismp.manager.EM.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventmoniCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventGetTopoResult;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventmoniResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoni;

/**
 * 事件监测表的功能实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventmoniService {
	
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
	 * 通过用户做的自定义事件进行查询
	 * @param eventid,Page
	 * @return EventmoniResult
	 */
	public EventGetTopoResult queryEventByCustomize(String userName,Serializable eventid, Integer[] bureauId,Page page);

}
