package edu.sjtu.infosec.ismp.manager.VPM.pm.service;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.security.Domain;
public interface SensorClientsService {
	/**
	 * 根据条件查询客户端信息
	 * @param sensorClients
	 * @param startDate
	 * @param endDate
	 * LinkedList 第一个是总页数，第二个是查询结果List
	 * @return
	 */
	public LinkedList getSensorInfos(SensorClients sensorClients,Integer startResult, Integer maxResult,Date startDate,Date endDate);
	/**
	 * 
	 * saveOrUpdateSensorClients
	 *      decription : 保存或者更新sensorClients信息
	 * @param sensorInfos
	 */
	public void saveOrUpdateSensorClients(SensorClients sensorClients);
	
	/**
	 * 
	 * getSensorClients decription : 根据Id获得SensorClients
	 * 
	 * @param sensorClients
	 */
	public SensorClients getSensorClients(int id);
	
	/**
	 * 
	 * getSensorInfos
	 *      decription : 得到指定条件的的sensor及和sensor相關的信息
	 * @param sensorClients
	 * @param startResult
	 * @param maxResult
	 * @return
	 */
	public LinkedList getSensorInfosByManagerId(List<Integer> doMain,SensorClients sensorClients,Integer startResult, Integer maxResult, Date startDate,Date endDate);
	
	/**
	 * 
	 * getSensorInfoCountByManagerId decription : 根据委办局ID获得该委办局下的sensorClients
	 * 
	 * @param 
	 * @param 
	 * @return
	 */
	public List<SensorClients> getSensorInfosByManagerId(SensorClients doMainId);
	/**
	 * 
	 * getSensorInfoCountByManagerId decription : 获得该未分配委办局的sensorClients
	 * 
	 * @param 
	 * @param 
	 * @return
	 */
    public  List<SensorClients> getUnallocatedSensorInfos();
	
	
	/**
	 * 
	 * getSensorClients decription : 根据委办局Id获得SensorClients分页数据
	 * 
	 * @param
	 */
    public LinkedList getSensorInfosByManagerId(SensorClients doMainId,Integer startResult, Integer maxResult,Date startDate,Date endDate);
	
    public List<SensorClients>  getSensorInfosByDoMainId(Integer domainId);
    
    public LinkedList getSensorInfosAll(List<Domain> list,Integer startResult, Integer maxResult,Date startDate,Date endDate);
    
    public LinkedList getSensorInfos(List<Domain> list,SensorClients sensorClients,Integer startResult, Integer maxResult,Date startDate,Date endDate);
    
    public LinkedList getSensorInfosByTactics(SensorClients sensorClients,Integer startResult, Integer maxResult,Date startDate,Date endDate);
}
