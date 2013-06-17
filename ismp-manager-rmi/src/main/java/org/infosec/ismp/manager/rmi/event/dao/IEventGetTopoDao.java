package org.infosec.ismp.manager.rmi.event.dao;

import java.sql.Timestamp;
import java.util.List;

import org.infosec.ismp.manager.rmi.event.dao.queryCondition.EventGetTopoCondition;
import org.infosec.ismp.manager.rmi.event.dao.queryResult.EventGetTopoResult;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;

/**
 * 从拓朴数据库取数据
 * @author wudengke 2009-6-29
 *
 */
public interface IEventGetTopoDao {
	
	/**
	 * 获取TOPO设备IP和MAC地址和设备名
	 * @return
	 */
	public List<Object> getTopoInfo();
	
	/**
	 * 分页，多条件获取TOPO设备IP和MAC地址和设备名
	 * @return
	 */
	public EventGetTopoResult getTopoInfo(EventGetTopoCondition condition);
	
	/**
	 * 统计域事件总量
	 * @return
	 */
	public List<Object> StatisticsDomain(Timestamp starttime,Timestamp endtime,Integer bueauId);
	
	public NodeEntity queryByIpBureauId(String ip,Integer bureauId);

}
