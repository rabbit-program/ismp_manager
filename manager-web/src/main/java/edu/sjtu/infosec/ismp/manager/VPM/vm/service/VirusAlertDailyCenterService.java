package edu.sjtu.infosec.ismp.manager.VPM.vm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsDailyCenter;

/**
 * 病毒管理与managerWEB通信的接口---中心病毒告警日报
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusAlertDailyCenterService {
	/**
	 * 增
	 * @param virusAlertDailyCenter
	 * 中心病毒告警日报
	 */
	void addVirusAlertDailyCenter(VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception;
	/**
	 * 删
	 * @param virusAlertDailyCenter
	 * 中心病毒告警日报
	 */
	void deleteVirusAlertDailyCenter(VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception;
	/**
	 * 改
	 * @param virusAlertDailyCenter
	 * 中心病毒告警日报
	 */
	void updateVirusAlertDailyCenter(VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 中心病毒告警日报List
	 */
	List<VirusAlertsDailyCenter> findAllVirusAlertDailyCenter() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 中心病毒告警日报List
	 */
	List<VirusAlertsDailyCenter> findAllVirusAlertDailyCenter(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询中心病毒告警日报
	 * @return 中心病毒告警日报
	 */
	VirusAlertsDailyCenter findVirusAlertDailyCenterById(int id) throws Exception;

}
