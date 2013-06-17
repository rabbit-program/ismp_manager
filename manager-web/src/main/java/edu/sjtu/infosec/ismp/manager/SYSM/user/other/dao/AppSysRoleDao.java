package edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysRole;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface AppSysRoleDao {
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
	/**
	 * 查指定域下的所有
	 * @return 
	 */
	List<AppSysRole> findAllByDomain(List<Domain> domainList) throws Exception;
	
	

//分页查询开始
	/**
	 * 查指定时间段下的所有（分页）
	 * @return 
	 */
	List<AppSysRole> findAll(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查指定时间段下的所有数目
	 * @return 
	 */
	long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 查指定域下的所有（分页）
	 * @return 
	 */
	List<AppSysRole> findAllByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查指定域和指定时间段下的所有数目
	 * @return 
	 */
	long findAllNumByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
//分页查询结束
	
	
	
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
