package edu.sjtu.infosec.ismp.manager.EM.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.dao.IEventtaskseleDao;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventtasksele;
import edu.sjtu.infosec.ismp.manager.EM.service.IEventtaskseleService;

/**
 * 自选事件表的功能实现
 * @author wudengke 2009-6-29
 *
 */
public class EventtaskseleService implements IEventtaskseleService {

	private IEventtaskseleDao eventtaskseleDao;

	public void setEventtaskseleDao(IEventtaskseleDao eventtaskseleDao) {
		this.eventtaskseleDao = eventtaskseleDao;
	}

	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	public void delete(String userName,String define_id,List<Serializable> ids) {
		if (define_id!= null && ids!=null && ids.size()>0) {
			eventtaskseleDao.delete(userName,define_id, ids);
		}

	}

	/**
	 * 通过ID查询对象
	 * 
	 * @param id
	 * 
	 */
	public Eventtasksele get(Serializable id) {
		if (id != null) {
			return eventtaskseleDao.get(id);
		}
		return null;
	}

	/**
	 * 增加指定对象
	 * @param data
	 */
	public void save(String userName,Integer id, String str) {
		if (id != null && str != null && str.trim().length() > 0) {
			List<Eventtasksele> list = eventtaskseleDao
					.queryEventtaskseleBydefineid(userName,id);
			String[] strs = str.split(",");
			List<Eventtasksele> datas = new ArrayList<Eventtasksele>();
			for (int i = 0; i < strs.length; i++) {
				boolean bo = false;
				for (int j = 0; j < list.size(); j++) {
					if (strs[i].trim().equals(list.get(j).getFaci_ip().toString().trim())) {
						bo = true;
					}
				}
				if (bo == false) {
					Eventtasksele ev = new Eventtasksele();
					ev.setDefine_id(id);
					ev.setUserName(userName);
					ev.setFaci_ip(strs[i].trim());
					datas.add(ev);
				}
			}
			if (datas!=null && datas.size()>0) {
				eventtaskseleDao.add(datas);
			}
		}

	}
}
