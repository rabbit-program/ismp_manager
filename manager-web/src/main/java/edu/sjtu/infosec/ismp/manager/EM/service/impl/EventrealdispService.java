package edu.sjtu.infosec.ismp.manager.EM.service.impl;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.dao.IEventrealdispDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventrealdispCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventrealdispResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventrealdisp;
import edu.sjtu.infosec.ismp.manager.EM.service.IEventrealdispService;

/**
 * 事件实时显示表的功能实现
 * @author wudengke 2009-6-29
 *
 */
public class EventrealdispService implements IEventrealdispService {
	
	private IEventrealdispDao  eventrealdispDao;

	public void setEventrealdispDao(IEventrealdispDao eventrealdispDao) {
		this.eventrealdispDao = eventrealdispDao;
	}


	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	public void add(Eventrealdisp data) {
		if (data != null){
			eventrealdispDao.add(data);
		}

	}

	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void add(List<Eventrealdisp> datas) {
		if (datas !=null && datas.size()>0) {
			eventrealdispDao.add(datas);
		}

	}

	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	public void delete(Eventrealdisp data) {
		if (data.getId()!=null && data.getId()>0) {
			eventrealdispDao.delete(data);
		}

	}

	
	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	public void delete(List<Serializable> ids) {
		if (ids != null && ids.size()>0) {
			eventrealdispDao.delete(ids);
		}

	}

	/**
	 * 通过查询Eventrealdisp对象
	 * 
	 * @param id
	 * 
	 */
	public Eventrealdisp get(Serializable id) {
		if (id != null) {
			return eventrealdispDao.get(id);
		}
		return null;
	}


	/**
	 * 通过组合条件进行查询
	 * @param condition
	 * @return
	 */
	public EventrealdispResult queryEventrealdispByCondition(
			EventrealdispCondition condition) {
		if (condition.getPage().getCurrentPage()>0 && condition.getPage().getEveryPage()>0){
			return eventrealdispDao.queryEventrealdispByCondition(condition);
		}
		return null;
	}

	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	public void update(Eventrealdisp data) {
		if (data.getId()!=null && data.getId()>0) {
			eventrealdispDao.update(data);
		}

	}

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void update(List<Eventrealdisp> data) {
		if (data != null ) {
			eventrealdispDao.update(data);
		}

	}
}
