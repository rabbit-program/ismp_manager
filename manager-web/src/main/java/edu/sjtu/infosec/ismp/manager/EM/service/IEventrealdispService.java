package edu.sjtu.infosec.ismp.manager.EM.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventrealdispCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventrealdispResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventrealdisp;

/**
 * 事件实时显示表的功能实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventrealdispService {
	

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
	void add(List<Eventrealdisp> datas);
	
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
	void update(List<Eventrealdisp> datas);
	
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
	
}
