package edu.sjtu.infosec.ismp.manager.EM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.model.Eventtasksele;

/**
 * 自选事件表的DAO实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventtaskseleDao {
	
	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	void add(Eventtasksele data) ;
	
	/**
	 * 添加多个对象
	 * @param datas
	 */
	void add(List<Eventtasksele> datas);
	
	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	void update(Eventtasksele data);

	
	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	void delete(Eventtasksele data);
	
	/**
	 * 删除某个用户自定义事件的多个对象
	 * @param datas
	 */
	void delete(String userName,String define_id,List<Serializable> ids);
	
	
	/**
	 * 通过查询Eventtasksele对象
	 * 
	 * @param id
	 * @return Eventtasksele
	 */
	Eventtasksele get(Serializable id);
	
	/**
	 * 通过用户自定义的编号查询
	 * @param ids
	 * @return List<Eventtasksele>
	 */
	List<Eventtasksele> queryEventtaskseleBydefineid(String userName,Serializable define_id);
	
}
