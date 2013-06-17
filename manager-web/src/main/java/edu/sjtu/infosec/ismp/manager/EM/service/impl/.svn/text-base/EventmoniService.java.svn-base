package edu.sjtu.infosec.ismp.manager.EM.service.impl;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventGetTopoDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventmoniDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventtaskseleDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.Status;
import edu.sjtu.infosec.ismp.manager.EM.dao.impl.EventGetTopoDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.impl.EventmoniDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.impl.EventtaskseleDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventGetTopoCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventmoniCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventGetTopoResult;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventmoniResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoni;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventtasksele;
import edu.sjtu.infosec.ismp.manager.EM.service.IEventmoniService;

/**
 * 事件监测表的功能实现
 * 
 * @author wudengke 2009-6-29
 * 
 */
public class EventmoniService implements IEventmoniService {

	private IEventmoniDao eventmoniDao;

	public void setEventmoniDao(EventmoniDao eventmoniDao) {
		this.eventmoniDao = eventmoniDao;

	}

	private IEventtaskseleDao eventtaskseleDao;

	public void setEventtaskseleDao(EventtaskseleDao eventtaskseleDao) {
		this.eventtaskseleDao = eventtaskseleDao;

	}

	private IEventGetTopoDao eventGetTopoDao;

	public void setEventGetTopoDao(EventGetTopoDao eventGetTopo) {
		this.eventGetTopoDao = eventGetTopo;
	}

	/**
	 * 添加单个对象。
	 * 
	 * @param data
	 *            需要添加的对象。
	 * 
	 */
	public void add(Eventmoni data) {
		if (data != null) {
			eventmoniDao.add(data);
		}

	}

	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void add(List<Eventmoni> data) {
		if (data != null && data.size() > 0) {
			eventmoniDao.add(data);
		}

	}

	/**
	 * 删除指定的对象。
	 * 
	 * @param data
	 * 
	 */
	public void delete(Eventmoni data) {
		if (data != null && data.getId() != null) {
			eventmoniDao.delete(data);
		}

	}

	/**
	 * 删除指定的多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void delete(List<Serializable> ids) {
		if (ids != null) {
			eventmoniDao.delete(ids);
		}
	}

	/**
	 * 通过查询Eventmoni对象
	 * 
	 * @param id
	 * 
	 */
	public Eventmoni get(Serializable id) {
		if (id != null) {
			return eventmoniDao.get(id);
		}
		return null;
	}

	/**
	 * 通过组合条件进行查询
	 * 
	 * @param condition
	 * @return
	 */
	public EventmoniResult queryEventmoniByCondition(
			EventmoniCondition condition) {
		if (condition.getPage().getCurrentPage() > 0
				&& condition.getPage().getEveryPage() > 0) {
			EventmoniResult res = eventmoniDao
					.queryEventmoniByCondition(condition);
			return res;
		}
		return null;
	}

	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data
	 *            需要修改的对象。
	 * 
	 * 
	 */
	public void update(Eventmoni data) {
		if (data != null && data.getId() != null) {
			eventmoniDao.update(data);
		}

	}

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void update(List<Eventmoni> datas) {
		if (datas != null) {
			for (int i = 0; i < datas.size(); i++) {
				if (datas.get(i).getId() == null) {
					return;
				}
			}
			eventmoniDao.update(datas);
		}

	}

	/**
	 * 通过用户做的自定义事件进行查询
	 * 
	 * @param eventid
	 *            ,Page
	 * @return EventmoniResult
	 */
	public EventGetTopoResult queryEventByCustomize(String userName,
			Serializable eventid, Integer[] bureauId, Page page) {
		EventGetTopoResult res = new EventGetTopoResult();
		EventGetTopoCondition condition = new EventGetTopoCondition();
		if (userName != null && userName.length() > 0 && bureauId != null
				&& bureauId.length > 0 && eventid == null && page.getCurrentPage() < 1
				&& page.getEveryPage() < 1) {
			res.setStatus(Status.NOCONDITION);
			return res;
		}
		List<Eventtasksele> list = eventtaskseleDao
				.queryEventtaskseleBydefineid(userName, eventid);
		if (list != null && list.size() > 0) {
			String[] ids = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getFaci_ip() != null
						&& list.get(i).getFaci_ip() != null
						&& list.get(i).getFaci_ip().length() > 0) {
					ids[i] = list.get(i).getFaci_ip();
				}
			}
			if (ids != null && ids.length > 0) {
				condition.setNetCardCodes(ids);
			}
			condition.setBureauId(bureauId);
			condition.setPage(page);
			res = eventGetTopoDao.getTopoInfo(condition);
		}
		return res;
	}
}
