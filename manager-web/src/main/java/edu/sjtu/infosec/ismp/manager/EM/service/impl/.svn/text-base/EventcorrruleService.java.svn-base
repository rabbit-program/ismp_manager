package edu.sjtu.infosec.ismp.manager.EM.service.impl;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventcorrruleDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventcorrruleResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventcorrrule;
import edu.sjtu.infosec.ismp.manager.EM.service.IEventcorrruleService;

/**
 * 关联规则表的功能实现
 * @author wudengke 2009-6-29
 *
 */
public class EventcorrruleService implements IEventcorrruleService {
	
	private IEventcorrruleDao eventcorrruleDao;

	public void setEventcorrruleDao(IEventcorrruleDao eventcorrruleDao) {
		this.eventcorrruleDao = eventcorrruleDao;
	}
	
	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	public void add(Eventcorrrule data) {
		if (data.getCorr_type() != null && data.getDest_ip() != null
				&& data.getDest_ip().trim().length() > 0
				&& data.getDest_port() != null
				&& data.getDest_port().trim().length() > 0
				&& data.getOperation() != null && data.getProt_rule() != null
				&& data.getProt_rule().trim().length() > 0
				&& data.getRule_name() != null
				&& data.getRule_name().trim().length() > 0
				&& data.getSrc_ip() != null
				&& data.getSrc_ip().trim().length() > 0) {
			eventcorrruleDao.add(data);
		}

	}
	
	/**
	 * 添加多个对象。
	 * 
	 * @param datas
	 * 
	 */
	public void add(List<Eventcorrrule> datas) {
		if (datas!=null) {
			eventcorrruleDao.add(datas);
		}

	}
	
	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	public void delete(Eventcorrrule data) {
		if (data!=null && data.getId()>0) {
			eventcorrruleDao.delete(data);
		}

	}
	
	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	public void delete(List<Serializable> ids) {
		if (ids!=null && ids.size()>0) {
			eventcorrruleDao.delete(ids);
		}

	}
	
	/**
	 * 通过查询Eventcorrrule对象
	 * 
	 * @param id
	 * 
	 */
	public Eventcorrrule get(Serializable id) {
		if (id!=null) {
			return eventcorrruleDao.get(id);
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
	public void update(Eventcorrrule data) {
		if (data != null && data.getId()>0) {
			eventcorrruleDao.update(data);
		}

	}

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void update(List<Eventcorrrule> datas) {
		if (datas != null && datas.size()>0) {
			eventcorrruleDao.update(datas);
		}

	}

	/**
	 * 根据分页显示所有关联规则
	 * @param page
	 * @return　List<Eventcorrrule>
	 */
	public EventcorrruleResult queryAllByPage(Page page,String userName) {
		if (page!=null && page.getCurrentPage()>0 && page.getEveryPage()>0 && userName!=null && userName.length() >0) {
			return eventcorrruleDao.queryAllByPage(page, userName);
		}
		return null;
	}

}
