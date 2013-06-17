package edu.sjtu.infosec.ismp.manager.VPM.pm.dao;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.security.Domain;
public interface SensorClientsDao {

    /**
     * 根据条件查询 SensorClients 返回分页数，即查询条件集合
     * @param sensorClients 对象
     * @param startResult 起始
     * @param maxResult 显示个数
     * @param startDate 起始时间
     * @param endDate 末时间
     * @return
     */
	public LinkedList getSensorInfos(SensorClients sensorClients,Integer startResult, Integer maxResult, Date startDate,Date endDate);

	
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
	 * 根据条件查询 sensorClients
	 * @param doMain 委办局集合
	 * @param sensorClients 对象
     * @param startResult 起始
     * @param maxResult 显示个数
     * @param startDate 起始时间
     * @param endDate 末时间
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
	public List<SensorClients> getUnallocatedSensorInfos();
	
    /**
     * 
     * @param doMainId 委办局Id
     * @param startResult 起始
     * @param maxResult 显示个数
     * @param startDate 起始时间
     * @param endDate 末时间
     * @return
     */
	public LinkedList getSensorInfosByManagerId(SensorClients doMainId,Integer startResult, Integer maxResult,Date startDate,Date endDate);
	
	public LinkedList getSensorInfos(List<Domain> list,SensorClients sensorClients,Integer startResult, Integer maxResult,Date startDate,Date endDate);
	
	public List<SensorClients>  getSensorInfosByDoMainId(Integer domainId);
	
    public LinkedList getSensorInfosAll(List<Domain> list,Integer startResult, Integer maxResult,Date startDate,Date endDate);
    
    public LinkedList getSensorInfosByTactics(SensorClients sensorClients,Integer startResult, Integer maxResult,Date startDate,Date endDate);
}
