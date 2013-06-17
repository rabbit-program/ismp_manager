package edu.sjtu.infosec.ismp.manager.ERM.dao;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.model.RespFilePrint;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface RespInfoDao {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(RespInfoBO respInfo) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(RespInfoBO respInfo) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(RespInfoBO respInfo) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<RespInfoBO> findAll() throws Exception;
	/**
	 * 查指定域下的所有
	 * @return 
	 */
	List<RespInfoBO> findAllByDomain(List<Domain> domainList) throws Exception;
	
	

//分页查询开始
	/**
	 * 查指定时间段下的所有（分页）
	 * @return 
	 */
	List<RespInfoBO> findAll(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult,int id,Domain domain,String respname,String sysname,String updatetime) throws Exception;
	/**
	 * 查指定时间段下的所有数目
	 * @return 
	 */
	long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime,int id,String respname,String sysname,String updatetime) throws Exception;
	
	/**
	 * 查指定域下的所有（分页）
	 * @return 
	 */
	List<RespInfoBO> findAllByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult,int id,Domain domain,String respname,String sysname,String updatetime) throws Exception;
	/**
	 * 查指定域和指定时间段下的所有数目
	 * @return 
	 */
	long findAllNumByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime,int id,String respname,String sysname,String updatetime) throws Exception;
//分页查询结束
	
	
	
	/*
	 * 根据id查询对应应急信息
	 */
	RespInfoBO findrespInfoById(int id);
	
	//根据id查询文件打印内容
	List<RespFilePrint> findFileContentById(RespInfoBO id);
	
	void saveorupdate(RespFilePrint file);
	
	//根据RespInfoBO删除文件打印内容
	void deleteFileByRespInfo(RespInfoBO resp);
}
