package edu.sjtu.infosec.ismp.manager.VPM.vm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsMonthly;

/**
 * 病毒管理与managerWEB通信的接口---病毒告警月报
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusAlertMonthlyService {
	/**
	 * 增
	 * @param virusAlertMonthly
	 * 病毒告警月报
	 */
	void addVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly) throws Exception;
	/**
	 * 删
	 * @param virusAlertMonthly
	 * 病毒告警月报
	 */
	void deleteVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly) throws Exception;
	/**
	 * 改
	 * @param virusAlertMonthly
	 * 病毒告警月报
	 */
	void updateVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 病毒告警月报List
	 */
	List<VirusAlertsMonthly> findAllVirusAlertMonthly() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒告警月报List
	 */
	List<VirusAlertsMonthly> findAllVirusAlertMonthly(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒告警月报
	 * @return 病毒告警月报
	 */
	VirusAlertsMonthly findVirusAlertMonthlyById(int id) throws Exception;

}
