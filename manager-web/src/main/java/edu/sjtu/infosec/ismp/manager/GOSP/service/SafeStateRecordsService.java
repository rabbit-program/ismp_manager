package edu.sjtu.infosec.ismp.manager.GOSP.service;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.GOSP.model.SafeStateRecords;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface SafeStateRecordsService {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(SafeStateRecords safeStateRecords) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(SafeStateRecords safeStateRecords) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(SafeStateRecords safeStateRecords) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<SafeStateRecords> findAll() throws Exception;
	/**
	 * 查指定域下的所有
	 * @return 
	 */
	List<SafeStateRecords> findAllByDomain(List<Domain> domainList) throws Exception;
	
	

	//分页查询开始
	/**
	 * 查指定时间段下的所有（分页）
	 * @return 
	 */
	List<SafeStateRecords> findAll(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查指定时间段下的所有数目
	 * @return 
	 */
	long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 查指定域下的所有（分页）
	 * @return 
	 */
	List<SafeStateRecords> findAllByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查指定域和指定时间段下的所有数目
	 * @return 
	 */
	long findAllNumByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	//分页查询结束
	
	
	
	/*
	 * 根据id查询对应等保信息
	 */
	SafeStateRecords findById(int id) throws Exception;
	
	/**
	 * 查指定域和时间段下的等保状态的等级
	 * @return 
	 * Date:2010-11-19
	 */
	List<SafeStateRecords> findAllByDomainAndPie(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 查指定域和时间段下的等保状态的-等级(List集合放两列值)
	 * @return
	 * Date:2010-11-19 
	 */
	@SuppressWarnings("unchecked")
	List findAllByDomainAndLevel(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 查指定域和时间段下的等保状态的-状态(List集合放两列值)
	 * @return 
	 * Date:2010-11-19
	 */
	@SuppressWarnings("unchecked")
	List findAllByDomainAndState(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 查询指定时间段下(相关条件)的所有知识库的相关信息
	 * @return （本方法条件查询用到）
	 * Date：2010-11-22
	 */
	List<SafeStateRecords> findAllByDomain(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult, int id, Domain domain)throws Exception;
	
	/**
	 * 查询指定域和指定时间段下的所有知识库的相关信息
	 * @return （本方法条件查询用到）
	 * Date：2010-11-22
	 */
	List<SafeStateRecords> findAllByDomainList(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult, int id, Domain domain)throws Exception;
	
	/**
	 * 查询指定时间段下(相关条件)的所有法律法规的相关信息的总数
	 * @return recordTotalCount
	 * Date：2010-11-23
	 */
	
	long findAllNumByDomain(Timestamp startRecordTime, Timestamp endRecordTime, int id)throws Exception;
	
	/**
	 * 查询指定域和指定时间段下的所有法律法规的相关信息
	 * @return recordTotalCount
	 * Date：2010-11-23
	 */
	
	long findAllNumByDomainList(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int id)throws Exception;
	
	/**
	 * 查指时间段下的等保状态的等级(List集合放两列值)
	 * @return (本方法为Pie填充数据)
	 * Date:2010-12-20
	 */
	@SuppressWarnings("unchecked")
	List findAllByTimeAndLevel(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 查指时间段下的等保状态的-状态(List集合放两列值)
	 * @return (本方法为Pie填充数据)
	 * Date:2010-12-20
	 */
	@SuppressWarnings("unchecked")
	List findAllByTimeAndState(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
}
