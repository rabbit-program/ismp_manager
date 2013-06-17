package edu.sjtu.infosec.ismp.manager.VPM.vm.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsDaily;
/**
 * 病毒告警日报-数据库操作
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusAlertDailyDao {
	/**
	 * 增
	 * @param virusAlertDaily
	 * 病毒告警日报
	 */
	void addVirusAlertDaily(VirusAlertsDaily virusAlertDaily) throws Exception;
	/**
	 * 删
	 * @param virusAlertDaily
	 * 病毒告警日报
	 */
	void deleteVirusAlertDaily(VirusAlertsDaily virusAlertDaily) throws Exception;
	/**
	 * 改
	 * @param virusAlertDaily
	 * 病毒告警日报
	 */
	void updateVirusAlertDaily(VirusAlertsDaily virusAlertDaily) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 病毒告警日报List
	 */
	List<VirusAlertsDaily> findAllVirusAlertDaily() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒告警日报List
	 */
	List<VirusAlertsDaily> findAllVirusAlertDaily(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒告警日报
	 * @return 病毒告警日报
	 */
	VirusAlertsDaily findVirusAlertDailyById(int id) throws Exception;

}
