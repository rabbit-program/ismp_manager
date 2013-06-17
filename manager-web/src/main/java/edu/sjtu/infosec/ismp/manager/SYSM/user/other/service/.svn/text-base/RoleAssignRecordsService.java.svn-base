package edu.sjtu.infosec.ismp.manager.SYSM.user.other.service;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.RoleAssignRecords;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;

public interface RoleAssignRecordsService {

	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(RoleAssignRecords roleAssignRecords) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(RoleAssignRecords roleAssignRecords) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(RoleAssignRecords roleAssignRecords) throws Exception;
	
	/*
	 * 根据id查询对应应急信息
	 */
	RoleAssignRecords findById(int id) throws Exception;
	/**
	 * 查询所有分配记录
	 * @param 
	 */
	List<RoleAssignRecords> findConditionsInfo(RoleAssignRecords roleAssignRecords,PMPage page,Timestamp startRecordTime, Timestamp endRecordTime);
}
