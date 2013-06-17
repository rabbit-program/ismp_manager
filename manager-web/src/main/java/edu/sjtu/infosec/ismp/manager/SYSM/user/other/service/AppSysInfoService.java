package edu.sjtu.infosec.ismp.manager.SYSM.user.other.service;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.Domain;

public interface AppSysInfoService {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(AppSysInfo appSysInfo) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(AppSysInfo appSysInfo) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(AppSysInfo appSysInfo) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<AppSysInfo> findAll() throws Exception;
	/**
	 * 查指定域下的所有
	 * @return 
	 */
	List<AppSysInfo> findAllByDomain(List<Domain> domainList) throws Exception;
	
	/*
	 * 根据id查询对应应急信息
	 */
	AppSysInfo findById(int id) throws Exception;
	
	/**
	 * 查询所有系统权限信息
	 * @param 
	 */
	List<AppSysInfo> findConditionsInfo(AppSysInfo syInfo,List<Domain> domainList,PMPage page,Timestamp startRecordTime, Timestamp endRecordTime);
	
	
}
