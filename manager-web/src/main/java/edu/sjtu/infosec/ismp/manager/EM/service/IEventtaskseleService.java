package edu.sjtu.infosec.ismp.manager.EM.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.model.Eventtasksele;

/**
 * 自选事件表的功能实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventtaskseleService {
	
	/**
	 * 增加指定对象
	 * @param data
	 */
	void save(String userName,Integer define_id,String str);

	
	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	void delete(String userName,String define_id,List<Serializable> ids);
	
	
	/**
	 * 通过ID查询对象
	 * 
	 * @param id
	 * 
	 */
	Eventtasksele get(Serializable id);
	

}
