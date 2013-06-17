package edu.sjtu.infosec.ismp.manager.EM.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventcorrruleResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventcorrrule;


/**
 * 关联规则表的DAO实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventcorrruleDao {
	
	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	void add(Eventcorrrule data) ;
	
	/**
	 * 添加多个对象。
	 * 
	 * @param datas
	 * 
	 */
	void add(List<Eventcorrrule> datas);
	
	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	void update(Eventcorrrule data);

	/**
	 * 同时修改多个对象。
	 * 
	 * @param data
	 * 
	 */
	void update(List<Eventcorrrule> data);
	
	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	void delete(Eventcorrrule data);
	
		
	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	void delete(List<Serializable> ids);
	
	/**
	 * 通过查询Eventcorrrule对象
	 * 
	 * @param id
	 * 
	 */
	Eventcorrrule get(Serializable id);
	
	/**
	 * 根据分页显示所有规则
	 * @param page
	 * @return
	 */
	public EventcorrruleResult queryAllByPage(Page page,String userName);
	
	/**
	 * 根据多个ID查询记录
	 * @param ruleids
	 * @return　List　Eventcorrrule
	 */
	public List<Eventcorrrule> queryEventcorule(String[] ruleids);

}
