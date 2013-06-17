package edu.sjtu.infosec.ismp.manager.VPM.vm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsMonthlyCenter;

/**
 * 病毒管理与managerWEB通信的接口---中心病毒告警月报
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusAlertMonthlyCenterService {
	/**
	 * 增
	 * @param virusAlertMonthlyCenter
	 * 中心病毒告警月报
	 */
	void addVirusAlertMonthlyCenter(VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception;
	/**
	 * 删
	 * @param virusClients
	 * 中心病毒告警月报
	 */
	void deleteVirusAlertMonthlyCenter(VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception;
	/**
	 * 改
	 * @param virusClients
	 * 中心病毒告警月报
	 */
	void updateVirusAlertMonthlyCenter(VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 中心病毒告警月报List
	 */
	List<VirusAlertsMonthlyCenter> findAllVirusAlertMonthlyCenter() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 中心病毒告警月报List
	 */
	List<VirusAlertsMonthlyCenter> findAllVirusAlertMonthlyCenter(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询中心病毒告警月报
	 * @return 中心病毒告警月报
	 */
	VirusAlertsMonthlyCenter findVirusAlertMonthlyCenterById(int id) throws Exception;

}
