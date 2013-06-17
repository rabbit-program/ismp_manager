package edu.sjtu.infosec.ismp.manager.SCM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SCM.comm.BaseDao;
import edu.sjtu.infosec.ismp.manager.SCM.model.Monitor;
import edu.sjtu.infosec.ismp.security.Domain;

public interface MonitorDao extends BaseDao {
	
	/**
	 * 获取监控项列表。
	 * Author：cchang
	 * @return
	 * 2010-10-27 15:48:45
	 */
	List getMonitorList();
	
	/**
	 * 获取监控项列表（分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-1 19:56:41
	 */
	List getMonitorList(int startResult, int maxResult);
	
	
	/**
	 * 获取监控项列表（分页  分域）。
	 * Author：cchang
	 * @return
	 * 2010-12-3 15:05:16
	 */
	List getMonitorListByDomain(List<Domain> userDomainList, int startResult, int maxResult);
	/**
	 * 保存或者更新监控项信息
	 * Author：cchang
	 * @param Monitor
	 * 2010-11-25 18:33:50
	 */
	void saveOrUpdateMonitor(Monitor monitor);
	/**
	 * 取得监控项列表总记录条数
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	int getCount();
	
	/**
	 * 取得监控项列表总记录条数（分域）
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	int getCountByDomain(List<Domain> userDomainList);
	
	/**
	 * 根据nodeId取得监控项
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	Monitor getMonitorByNodeId(Integer nodeId);
	
//	======================================================
}
