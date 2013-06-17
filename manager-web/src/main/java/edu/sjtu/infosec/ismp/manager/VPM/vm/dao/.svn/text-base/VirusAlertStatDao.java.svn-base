package edu.sjtu.infosec.ismp.manager.VPM.vm.dao;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopVirus;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsStat;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
/**
 * 病毒告警详细信息-数据库操作
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusAlertStatDao {
	/**
	 * 增
	 * @param virusAlertStat
	 * 病毒告警详细信息
	 */
	void addVirusAlertStat(VirusAlertsStat virusAlertStat) throws Exception;
	/**
	 * 删
	 * @param virusAlertStat
	 * 病毒告警详细信息
	 */
	void deleteVirusAlertStat(VirusAlertsStat virusAlertStat) throws Exception;
	/**
	 * 改
	 * @param virusAlertStat
	 * 病毒告警详细信息
	 */
	void updateVirusAlertStat(VirusAlertsStat virusAlertStat) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 病毒告警详细信息List
	 */
	List<VirusAlertsStat> findAllVirusAlertStat() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒告警详细信息List
	 */
	List<VirusAlertsStat> findAllVirusAlertStat(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒告警详细信息
	 * @return 病毒告警详细信息
	 */
	VirusAlertsStat findVirusAlertStatById(int id) throws Exception;
	
	
	
	
	

	/**
	 * 查询指定客户端列表下的所有病毒告警详细信息
	 * @return 指定客户端列表下的所有病毒告警详细信息
	 */
	List<VirusAlertsStat> findAllByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询指定客户端列表下的所有病毒告警详细信息(分页)
	 * @return 指定客户端列表下的所有病毒告警详细信息
	 */
	List<VirusAlertsStat> findAllByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查询指定客户端列表下的已处理病毒告警详细信息
	 * @return 指定客户端列表下的已处理病毒告警详细信息
	 */
	List<VirusAlertsStat> findKilledByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询指定客户端列表下的已处理病毒告警详细信息(分页)
	 * @return 指定客户端列表下的已处理病毒告警详细信息
	 */
	List<VirusAlertsStat> findKilledByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查询指定客户端列表下的未处理病毒告警详细信息
	 * @return 指定客户端列表下的未处理病毒告警详细信息
	 */
	List<VirusAlertsStat> findUnkilledByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询指定客户端列表下的未处理病毒告警详细信息(分页)
	 * @return 指定客户端列表下的未处理病毒告警详细信息
	 */
	List<VirusAlertsStat> findUnkilledByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;

	
	/**
	 * 查询指定客户端列表下的所有病毒告警详细信息数目
	 * @return 指定客户端列表下的所有病毒告警详细信息数目
	 */
	long findAllNumByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询指定客户端列表下的已处理病毒告警详细信息数目
	 * @return 指定客户端列表下的已处理病毒告警详细信息数目
	 */
	long findKilledNumByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询指定客户端列表下的未处理病毒告警详细信息数目
	 * @return 指定客户端列表下的未处理病毒告警详细信息数目
	 */
	long findUnkilledNumByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;

	
	
	
	
	
	/**
	 * 查询某客户端下的所有病毒告警详细信息
	 * @return 某客户端下的所有病毒告警详细信息
	 */
	List<VirusAlertsStat> findAllByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询某客户端下的所有病毒告警详细信息(分页)
	 * @return 某客户端下的所有病毒告警详细信息
	 */
	List<VirusAlertsStat> findAllByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查询某客户端下的已处理病毒告警详细信息
	 * @return 某客户端下的已处理病毒告警详细信息
	 */
	List<VirusAlertsStat> findKilledByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询某客户端下的已处理病毒告警详细信息(分页)
	 * @return 某客户端下的已处理病毒告警详细信息
	 */
	List<VirusAlertsStat> findKilledByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查询某客户端下的未处理病毒告警详细信息
	 * @return 某客户端下的未处理病毒告警详细信息
	 */
	List<VirusAlertsStat> findUnkilledByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询某客户端下的未处理病毒告警详细信息(分页)
	 * @return 某客户端下的未处理病毒告警详细信息
	 */
	List<VirusAlertsStat> findUnkilledByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	

	/**
	 * 查询某客户端下的所有病毒告警详细信息数目
	 * @return 某客户端下的所有病毒告警详细信息数目
	 */
	long findAllNumByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询某客户端下的已处理病毒告警详细信息数目
	 * @return 某客户端下的已处理病毒告警详细信息数目
	 */
	long findKilledNumByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询某客户端下的未处理病毒告警详细信息数目
	 * @return 某客户端下的未处理病毒告警详细信息数目
	 */
	long findUnkilledNumByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;


	/**
	 * 查询某客户端下的TOP病毒
	 * @return 某客户端下的TOP病毒
	 */
	List<TopVirus> findTopVirusCountByVirusClients(VirusClients virusClients, Timestamp startRecordTime, Timestamp endRecordTime, int topNum) throws Exception;
	/**
	 * 查询指定客户端列表下的TOP病毒
	 * @return 指定客户端列表下的TOP病毒
	 */
	List<TopVirus> findTopVirusCountByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime, int topNum) throws Exception;
	
	/**
	 * 查询指定客户端列表下的病毒感染TOP客户端
	 * @return 指定客户端列表下的病毒感染TOP客户端
	 */
	List<TopClients> findTopClientsCountByVirusClientsList(List<VirusClients> virusClientsList, Timestamp startRecordTime, Timestamp endRecordTime, int topNum) throws Exception;
}
