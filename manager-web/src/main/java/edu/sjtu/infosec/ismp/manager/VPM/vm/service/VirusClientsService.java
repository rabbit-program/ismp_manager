package edu.sjtu.infosec.ismp.manager.VPM.vm.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 病毒管理与managerWEB通信的接口---病毒客户端
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public interface VirusClientsService {
	/**
	 * 保存病毒客户端的信息
	 * 
	 * @param virusClients
	 */
	public void saveVirusClients(VirusClients virusClients) throws Exception;
	/**
	 * 删除病毒客户端的信息
	 * 
	 * @param virusClients
	 */
	public void removeVirusClients(VirusClients virusClients) throws Exception;
	/**
	 * 修改病毒客户端的相关信息
	 * 
	 * @param virusClients
	 */
	public  void modifyVirusClients(VirusClients virusClients) throws Exception;
	/**
	 * 查询所有病毒客户端的信息
	 * @return  病毒客户端信息的List
	 */
	public List<VirusClients> findAllVirusClients() throws Exception;
	/**
	 * 查所有(分页)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClients(int startResult, int maxResult) throws Exception;
	/**
	 * 查所有数目
	 * @return 
	 */
	long findAllNum() throws Exception;
	/**
	 * 根据ID查询病毒客户端的信息
	 * @return  病毒客户端信息
	 */
	public VirusClients findVirusClientsById(int id) throws Exception;
	/**
	 * 通过"clientID"查病毒客户端
	 * @param clientID
	 * clientID
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端
	 */
	public List<VirusClients> findVirusClientsByClientId(String clientID, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"clientID"查病毒客户端(分页)
	 * @param clientID
	 * clientID
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端
	 */
	List<VirusClients> findVirusClientsByClientId(String clientID, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 通过"clientID"查病毒客户端数目
	 * @param clientID
	 * clientID
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByClientId(String clientID, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"clientID"查病毒客户端
	 * @param clientID
	 * clientID
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端
	 */
	List<VirusClients> findVirusClientsByClientIdAndDepartmentList(String clientID, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"clientID"查病毒客户端(分页)
	 * @param clientID
	 * clientID
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端
	 */
	List<VirusClients> findVirusClientsByClientIdAndDepartmentList(String clientID, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 通过"clientID"查病毒客户端数目
	 * @param clientID
	 * clientID
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByClientIdAndDepartmentList(String clientID, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 通过"自定义名称"查病毒客户端
	 * @param name
	 * 自定义名称
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	public List<VirusClients> findAllVirusClientsByName(String name, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"自定义名称"查病毒客户端(分页)
	 * @param name
	 * 自定义名称
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByName(String name, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 通过"自定义名称"查病毒客户端数目
	 * @param name
	 * 自定义名称
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByName(String name, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"自定义名称"查指定委办局列表下的所有病毒客户端
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByNameAndDepartmentList(String name, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"自定义名称"查指定委办局列表下的所有病毒客户端(分页)
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByNameAndDepartmentList(String name, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 通过"自定义名称"查指定委办局列表下的所有病毒客户端数目
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByNameAndDepartmentList(String name, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"录入时间"查病毒客户端
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	public List<VirusClients> findAllVirusClientsByRecordTime(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"录入时间"查病毒客户端(分页)
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByRecordTime(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 通过"录入时间"查病毒客户端数目
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByRecordTime(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"录入时间"查指定委办局列表下的所有病毒客户端
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByRecordTimeAndDepartmentList(List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"录入时间"查指定委办局列表下的所有病毒客户端(分页)
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByRecordTimeAndDepartmentList(List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 通过"录入时间"查指定委办局列表下的所有病毒客户端数目
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByRecordTimeAndDepartmentList(List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 查询某委办局下的所有病毒客户端
	 * @return 病毒客户端List
	 */
	public List<VirusClients> findAllVirusClientsByDepartment(Domain department) throws Exception;
	/**
	 * 查询某委办局下的所有病毒客户端(分页)
	 * @param department
	 * 委办局
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByDepartment(Domain department, int startResult, int maxResult) throws Exception;
	/**
	 * 查询某委办局下的所有病毒客户端数目
	 * @param department
	 * 委办局
	 * @return 
	 */
	long findAllNumByDepartment(Domain department) throws Exception;
	/**
	 * 查询指定委办局列表下的所有病毒客户端（包括未分配委办局的）
	 * @return 病毒客户端List
	 */
	public List<VirusClients> findAllVirusClientsByDepartmentList(List<Domain> departmentList) throws Exception;
	/**
	 * 查询指定委办局列表下的所有病毒客户端（包括未分配委办局的）(分页)
	 * @param departmentList
	 * 委办局列表
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByDepartmentList(List<Domain> departmentList, int startResult, int maxResult) throws Exception;
	/**
	 * 查询指定委办局列表下的所有病毒客户端数目（包括未分配委办局的）
	 * @param departmentList
	 * 委办局列表
	 * @return 
	 */
	long findAllNumByDepartmentList(List<Domain> departmentList) throws Exception;
	/**
	 * 查询指定委办局列表下的所有病毒客户端（除过未分配委办局的）
	 * @return 病毒客户端List
	 */
	public List<VirusClients> findAllVirusClientsByDepartmentListExceptUnknow(List<Domain> departmentList) throws Exception;
	/**
	 * 查询指定委办局列表下的所有病毒客户端（除过未分配委办局的）(分页)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByDepartmentListExceptUnknow(List<Domain> departmentList, int startResult, int maxResult) throws Exception;
	/**
	 * 查询指定委办局列表下的所有病毒客户端数目（除过未分配委办局的）
	 * @return 
	 */
	long findAllNumByDepartmentListExceptUnknow(List<Domain> departmentList) throws Exception;
	/**
	 * 通过"自定义名称"和"clientID"查病毒客户端
	 * @param name
	 * 自定义名称
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByNameAndClientId(String name, String clientID, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"自定义名称"和"clientID"查病毒客户端(分页)
	 * @param name
	 * 自定义名称
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByNameAndClientId(String name, String clientID, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 通过"自定义名称"和"clientID"查病毒客户端数目
	 * @param name
	 * 自定义名称
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByNameAndClientId(String name, String clientID, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"自定义名称"和"clientID"查指定委办局列表下的所有病毒客户端
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(String name, String clientID, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	/**
	 * 通过"自定义名称"和"clientID"查指定委办局列表下的所有病毒客户端(分页)
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(String name, String clientID, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 通过"自定义名称"和"clientID"查指定委办局列表下的所有病毒客户端数目
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByNameAndClientIdAndDepartmentList(String name, String clientID, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	
	/**
	 *  病毒客户端的查询方法------多条件查询-添加（客户端IP）查询用法到的方法
	 *  
	 *  2010-06-30
	 */
	
	/**
	 * 通过"自定义名称"和"clientID" ,clientIP 查指定委办局列表下的所有病毒客户端(分页)
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(String name, String clientID,String clientIP, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	
	/**
	 * 通过"自定义名称"和"clientID",clientIP查指定委办局列表下的所有病毒客户端数目
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByNameAndClientIdAndDepartmentList(String name, String clientID,String clientIP, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 通过"自定义名称",clientIP查指定委办局列表下的所有病毒客户端(分页)
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByNameAndDepartmentList(String name,String clientIP, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	
	/**
	 * 通过"自定义名称",clientIP查指定委办局列表下的所有病毒客户端数目
	 * @param name
	 * 自定义名称
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByNameAndDepartmentList(String name,String clientIP, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 通过"clientID",clientIP查病毒客户端(分页)
	 * @param clientID
	 * clientID
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端
	 */
	List<VirusClients> findVirusClientsByClientIdAndDepartmentList(String clientID,String clientIP, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	
	/**
	 * 通过"clientID",clientIP查病毒客户端数目
	 * @param clientID
	 * clientID
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByClientIdAndDepartmentList(String clientID,String clientIP, List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	
	/**
	 * 通过"clientIP"查指定委办局列表下的所有病毒客户端(分页)
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 病毒客户端List
	 */
	List<VirusClients> findAllVirusClientsByClientIPAndDepartmentList(String clientIP,List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	
	/**
	 * 通过"clientIP"查指定委办局列表下的所有病毒客户端数目
	 * @param departmentList
	 * 委办局列表
	 * @param startRecordTime
	 * 录入时间起始值(没有时，传null)
	 * @param endRecordTime
	 * 录入时间终止值(没有时，传null)
	 * @return 
	 */
	long findAllNumByClientIPAndDepartmentList(String clientIP,List<Domain> departmentList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	public LinkedList<Object> queryAllVirusClients(List<Domain> departmentList,VirusClients virusClients,int startResult, int maxResult,Date startRecordTime, Date endRecordTime);
	public VirusClients getVirusClientsById(Integer vcid);
	public boolean delQueryVirusClientsById(Integer vcid);
	
}

