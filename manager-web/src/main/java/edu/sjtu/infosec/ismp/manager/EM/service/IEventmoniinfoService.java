package edu.sjtu.infosec.ismp.manager.EM.service;
import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventmoniinfoCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventmoniinfoResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoniinfo;

/**
 * 设备监控信息表的功能实现
 * @author wudengke 2009-6-29
 *
 */
public interface IEventmoniinfoService {
	
	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	void add(Eventmoniinfo data) ;
	
	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	void add(List<Eventmoniinfo> datas);
	
	
	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	void delete(Eventmoniinfo data);
	
		
	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	void delete(List<Serializable> ids);
	
	/**
	 * 通过ID查询对象
	 * 
	 * @param id
	 * 
	 */
	Eventmoniinfo get(Serializable id);
	
	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	void update(Eventmoniinfo data);
	
	/**
	 * 通过组合条件进行查询
	 * @param condition
	 * @return
	 */
	EventmoniinfoResult queryEventmoniinfoByCondition(EventmoniinfoCondition condition);
}
