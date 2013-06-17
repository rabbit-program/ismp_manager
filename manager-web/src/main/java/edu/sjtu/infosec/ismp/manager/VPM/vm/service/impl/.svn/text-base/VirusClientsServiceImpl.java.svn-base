package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusClientsDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusClientsService;
import edu.sjtu.infosec.ismp.security.Domain;

public class VirusClientsServiceImpl implements VirusClientsService {
	
	private VirusClientsDao virusClientsDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusClientsDao(VirusClientsDao virusClientsDao) {
		this.virusClientsDao = virusClientsDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public List<VirusClients> findAllVirusClients() throws Exception{
		List<VirusClients> virusList= virusClientsDao.findAllVirusClients();
		return  virusList;
		
	}
	public void modifyVirusClients(VirusClients virusClients) throws Exception{
		virusClientsDao.updateVirusClients(virusClients);
		
	}
	public void removeVirusClients(VirusClients virusClients) throws Exception{
		virusClientsDao.deleteVirusClients(virusClients);
		
	}
	public void saveVirusClients(VirusClients virusClients) throws Exception  {
		virusClientsDao.addVirusClients(virusClients);
		
	}
	public List<VirusClients> findAllVirusClientsByDepartmentList(
			List<Domain> departmentList) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByDepartmentList(departmentList);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByName(String name,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
	
		return virusClientsDao.findAllVirusClientsByName(name, startRecordTime, endRecordTime);
	}
	public List<VirusClients> findAllVirusClientsByRecordTime(
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		
		return virusClientsDao.findAllVirusClientsByRecordTime(startRecordTime, endRecordTime);
	}
	public List<VirusClients> findVirusClientsByClientId(String clientID,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		
		return virusClientsDao.findVirusClientsByClientId(clientID, startRecordTime, endRecordTime);
	}
	public List<VirusClients> findAllVirusClientsByDepartment(
			Domain department) throws Exception {
		if(department!=null){
			return virusClientsDao.findAllVirusClientsByDepartment(department);
		}else{
			return null;
		}
	}
	public List<VirusClients> findAllVirusClientsByNameAndClientId(String name,
			String clientID, Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		
		return virusClientsDao.findAllVirusClientsByNameAndClientId(name, clientID, startRecordTime, endRecordTime);
	}
	public List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(
			String name, String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByNameAndClientIdAndDepartmentList(name, clientID, departmentList, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByNameAndDepartmentList(
			String name, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByNameAndDepartmentList(name, departmentList, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByRecordTimeAndDepartmentList(
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByRecordTimeAndDepartmentList(departmentList, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findVirusClientsByClientIdAndDepartmentList(
			String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findVirusClientsByClientIdAndDepartmentList(clientID, departmentList, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public VirusClients findVirusClientsById(int id) throws Exception {
		
		return virusClientsDao.findVirusClientsById(id);
	}
	public List<VirusClients> findAllVirusClientsByDepartmentListExceptUnknow(
			List<Domain> departmentList) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByDepartmentListExceptUnknow(departmentList);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClients(int startResult, int maxResult)
			throws Exception {
		List<VirusClients> virusList= virusClientsDao.findAllVirusClients(startResult, maxResult);
		return  virusList;
	}
	public List<VirusClients> findAllVirusClientsByDepartment(
			Domain department, int startResult, int maxResult)
			throws Exception {
		if(department!=null){
			return virusClientsDao.findAllVirusClientsByDepartment(department, startResult, maxResult);
		}else{
			return null;
		}
	}
	public List<VirusClients> findAllVirusClientsByDepartmentList(
			List<Domain> departmentList, int startResult, int maxResult)
			throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByDepartmentList(departmentList, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByDepartmentListExceptUnknow(
			List<Domain> departmentList, int startResult, int maxResult)
			throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByDepartmentListExceptUnknow(departmentList, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByName(String name,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
	
		return virusClientsDao.findAllVirusClientsByName(name, startRecordTime, endRecordTime, startResult, maxResult);
	}
	public List<VirusClients> findAllVirusClientsByNameAndClientId(String name,
			String clientID, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		
		return virusClientsDao.findAllVirusClientsByNameAndClientId(name, clientID, startRecordTime, endRecordTime, startResult, maxResult);
	}
	public List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(
			String name, String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByNameAndClientIdAndDepartmentList(name, clientID, departmentList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByNameAndDepartmentList(
			String name, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByNameAndDepartmentList(name, departmentList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByRecordTime(
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		
		return virusClientsDao.findAllVirusClientsByRecordTime(startRecordTime, endRecordTime, startResult, maxResult);
	}
	public List<VirusClients> findAllVirusClientsByRecordTimeAndDepartmentList(
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByRecordTimeAndDepartmentList(departmentList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findVirusClientsByClientId(String clientID,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		
		return virusClientsDao.findVirusClientsByClientId(clientID, startRecordTime, endRecordTime, startResult, maxResult);
	}
	public List<VirusClients> findVirusClientsByClientIdAndDepartmentList(
			String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findVirusClientsByClientIdAndDepartmentList(clientID, departmentList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public long findAllNum() throws Exception {
		return virusClientsDao.findAllNum();
	}
	public long findAllNumByDepartment(Domain department)
			throws Exception {
		return virusClientsDao.findAllNumByDepartment(department);
	}
	public long findAllNumByDepartmentList(List<Domain> departmentList)
			throws Exception {
		return virusClientsDao.findAllNumByDepartmentList(departmentList);
	}
	public long findAllNumByDepartmentListExceptUnknow(
			List<Domain> departmentList) throws Exception {
		return virusClientsDao.findAllNumByDepartmentListExceptUnknow(departmentList);
	}
	public long findAllNumByClientId(String clientID,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		return virusClientsDao.findAllNumByClientId(clientID, startRecordTime, endRecordTime);
	}
	public long findAllNumByClientIdAndDepartmentList(String clientID,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		return virusClientsDao.findAllNumByClientIdAndDepartmentList(clientID, departmentList, startRecordTime, endRecordTime);
	}
	public long findAllNumByName(String name, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		return virusClientsDao.findAllNumByName(name, startRecordTime, endRecordTime);
	}
	public long findAllNumByNameAndDepartmentList(String name,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		return virusClientsDao.findAllNumByNameAndDepartmentList(name, departmentList, startRecordTime, endRecordTime);
	}
	public long findAllNumByNameAndClientId(String name, String clientID,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		return virusClientsDao.findAllNumByNameAndClientId(name, clientID, startRecordTime, endRecordTime);
	}
	public long findAllNumByNameAndClientIdAndDepartmentList(String name,
			String clientID, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		return virusClientsDao.findAllNumByNameAndClientIdAndDepartmentList(name, clientID, departmentList, startRecordTime, endRecordTime);
	}
	public long findAllNumByRecordTime(Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		return virusClientsDao.findAllNumByRecordTime(startRecordTime, endRecordTime);
	}
	public long findAllNumByRecordTimeAndDepartmentList(
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		return virusClientsDao.findAllNumByRecordTimeAndDepartmentList(departmentList, startRecordTime, endRecordTime);
	}
	
	/**
	 *  病毒客户端的查询方法------多条件查询-添加（客户端IP）查询用法到的方法
	 *  
	 *  2010-06-30
	 */
	
	public long findAllNumByClientIPAndDepartmentList(String clientIP,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		
		return virusClientsDao.findAllNumByClientIPAndDepartmentList(clientIP, departmentList, startRecordTime, endRecordTime);
	}
	public long findAllNumByClientIdAndDepartmentList(String clientID,
			String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		
		return virusClientsDao.findAllNumByClientIdAndDepartmentList(clientID, clientIP, departmentList, startRecordTime, endRecordTime);
	}
	public long findAllNumByNameAndClientIdAndDepartmentList(String name,
			String clientID, String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		return virusClientsDao.findAllNumByNameAndClientIdAndDepartmentList(name, clientID, clientIP, departmentList, startRecordTime, endRecordTime);
	}
	public long findAllNumByNameAndDepartmentList(String name, String clientIP,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		
		return virusClientsDao.findAllNumByNameAndDepartmentList(name, clientIP, departmentList, startRecordTime, endRecordTime);
	}
	public List<VirusClients> findAllVirusClientsByClientIPAndDepartmentList(
			String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByClientIPAndDepartmentList(clientIP, departmentList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByNameAndClientIdAndDepartmentList(
			String name, String clientID, String clientIP,
			List<Domain> departmentList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByNameAndClientIdAndDepartmentList(name, clientID, clientIP, departmentList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findAllVirusClientsByNameAndDepartmentList(
			String name, String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findAllVirusClientsByNameAndDepartmentList(name, clientIP, departmentList, startRecordTime, endRecordTime, startResult, maxResult);
			
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusClients> findVirusClientsByClientIdAndDepartmentList(
			String clientID, String clientIP, List<Domain> departmentList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		List<VirusClients> list = new ArrayList<VirusClients>();
		if(departmentList!=null && departmentList.size()>0){
			list = virusClientsDao.findVirusClientsByClientIdAndDepartmentList(clientID, clientIP, departmentList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}

	public LinkedList<Object> queryAllVirusClients(List<Domain> departmentList,VirusClients virusClients,
			int startResult, int maxResult, Date startRecordTime,
			Date endRecordTime) {
		return virusClientsDao.queryAllVirusClients(departmentList,virusClients, startResult, maxResult, startRecordTime, endRecordTime);
	}




	public VirusClients getVirusClientsById(Integer vcid) {
		return virusClientsDao.getVirusClientsById(vcid);
	}




	public boolean delQueryVirusClientsById(Integer vcid) {
		return virusClientsDao.delQueryVirusClientsById(vcid);
	}
	
}
