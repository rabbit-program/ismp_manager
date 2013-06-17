package edu.sjtu.infosec.ismp.manager.SCM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SCM.model.Monitor;
import edu.sjtu.infosec.ismp.security.Domain;

public interface MonitorService {
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
	 * 根据监控项的id删除监控项
	 * Author：cchang
	 * @param id
	 * 2010-10-20 上午10:57:30
	 */
	void deleteMonitorById(Integer id);
	
	/**
	 * 根据监控项的id查找监控项
	 * @param id
	 * @return
	 * 2010-10-26 15:23:48
	 */
	Monitor getMonitorById(Integer id);
	
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
	 * 从后台取得监控项状态
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	public Integer getMonitorStates(String nodeId,Integer timeOut);
	
	/**
	 * 获取状态是否超时
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	public String getMonitorOverStates(String nodeId);
	
}
