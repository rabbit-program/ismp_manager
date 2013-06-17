package edu.sjtu.infosec.ismp.manager.VPM.vm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlerts;

/**
 * 病毒管理与managerWEB通信的接口---病毒告警
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusAlertService {
	/**
	 * 增
	 * @param virusAlert
	 * 病毒告警
	 */
	void addVirusAlert(VirusAlerts virusAlert) throws Exception;
	/**
	 * 删
	 * @param virusAlert
	 * 病毒告警
	 */
	void deleteVirusAlert(VirusAlerts virusAlert) throws Exception;
	/**
	 * 改
	 * @param VirusAlerts
	 * 病毒告警
	 */
	void updateVirusAlert(VirusAlerts virusAlert) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 病毒告警List
	 */
	List<VirusAlerts> findAllVirusAlert() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒告警List
	 */
	List<VirusAlerts> findAllVirusAlert(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒告警
	 * @return 病毒告警
	 */
	VirusAlerts findVirusAlertById(int id) throws Exception;

}
