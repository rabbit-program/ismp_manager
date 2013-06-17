package edu.sjtu.infosec.ismp.manager.EM.service.impl;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.dao.IEventmoniinfoDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventmoniinfoCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventmoniinfoResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoniinfo;
import edu.sjtu.infosec.ismp.manager.EM.service.IEventmoniinfoService;

/**
 * 设备监控信息表的功能实现
 * @author wudengke 2009-6-29
 *
 */
public class EventmoniinfoService implements IEventmoniinfoService {

	private IEventmoniinfoDao eventmoniinfoDao;

	public void setEventmoniinfoDao(IEventmoniinfoDao eventmoniinfoDao) {
		this.eventmoniinfoDao = eventmoniinfoDao;
	}
	
	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	public void add(Eventmoniinfo data) {
		if (data.getEventType()!= null && data.getIpAddress()!= null
				&& data.getTime() != null ) {
			eventmoniinfoDao.add(data);
		}

	}

	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void add(List<Eventmoniinfo> data) {
		if (data!=null && data.size()>0) {
			eventmoniinfoDao.add(data);
		}

	}

	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	public void delete(Eventmoniinfo data) {
		if (data.getId()!= null && data.getId()>0) {
			eventmoniinfoDao.delete(data);
		}

	}

	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	public void delete(List<Serializable> ids) {
		if (ids !=null && ids.size()>0) {
			eventmoniinfoDao.delete(ids);
		}

	}

	/**
	 * 通过ID查询对象
	 * 
	 * @param id
	 * 
	 */
	public Eventmoniinfo get(Serializable id) {
		if (id !=null) {
			return eventmoniinfoDao.get(id);
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
	public void update(Eventmoniinfo data) {
		if (data.getId()!=null && data.getId()>0) {
			eventmoniinfoDao.update(data);
		}
		
	}

	/**
	 * 通过组合条件进行查询
	 * @param condition
	 * @return
	 */
	public EventmoniinfoResult queryEventmoniinfoByCondition(
			EventmoniinfoCondition condition) {
		if (condition.getPage().getCurrentPage()>0 && condition.getPage().getEveryPage()>0){
			return eventmoniinfoDao.queryEventmoniinfoByCondition(condition);
		}
		return null;
	}
}
