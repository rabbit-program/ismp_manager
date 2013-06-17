package edu.sjtu.infosec.ismp.manager.SYSM.user.other.service;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysRole;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;

public interface AppSysRoleService {

	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(AppSysRole appSysRole) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(AppSysRole appSysRole) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(AppSysRole appSysRole) throws Exception;
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<AppSysRole> findAll() throws Exception;
	/*
	 * 根据id查询对应应急信息
	 */
	AppSysRole findById(int id) throws Exception;
	/**
	 * 查询所有系统的权限
	 * @param 
	 */
	List<AppSysRole> findASIById(int asid) throws Exception;
	/**
	 * 查询所有系统权限
	 * @param 
	 */
	List<AppSysRole> findConditionsInfo(AppSysRole appSysRole,PMPage page,Timestamp startRecordTime, Timestamp endRecordTime);
	
}
