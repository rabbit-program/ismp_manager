package edu.sjtu.infosec.ismp.manager.GOSP.dao;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.GOSP.model.LawsAndRules;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface LawsAndRulesDao {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(LawsAndRules lawsAndRules) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(LawsAndRules lawsAndRules) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(LawsAndRules lawsAndRules) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<LawsAndRules> findAll() throws Exception;
	/**
	 * 查指定域下的所有
	 * @return 
	 */
	List<LawsAndRules> findAllByDomain(List<Domain> domainList) throws Exception;
	
	

	//分页查询开始
	/**
	 * 查指定时间段下的所有（分页）
	 * @return 
	 */
	List<LawsAndRules> findAll(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查指定时间段下的所有数目
	 * @return 
	 */
	long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	
	/**
	 * 查指定域下的所有（分页）
	 * @return 
	 */
	List<LawsAndRules> findAllByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult) throws Exception;
	/**
	 * 查指定域和指定时间段下的所有数目
	 * @return 
	 */
	long findAllNumByDomain(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime) throws Exception;
	//分页查询结束
	
	
	
	/*
	 * 根据id查询对应法律法规信息
	 */
	LawsAndRules findById(int id) throws Exception;
	
	/**
	 * 查询指定时间段下(相关条件)的所有法律法规的相关信息
	 * @return
	 * Date：2010-11-23
	 */
	List<LawsAndRules> findAllByDomain(Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult, int id, Domain domain)throws Exception;
	
	/**
	 * 查询指定域和指定时间段下的所有法律法规的相关信息
	 * @return
	 * Date：2010-11-23
	 */
	List<LawsAndRules> findAllByDomainList(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int startResult, int maxResult, int id, Domain domain)throws Exception;
	
	/**
	 * 查询指定时间段下(相关条件)的所有法律法规的相关信息的总数
	 * @return recordTotalCount
	 * Date：2010-11-23
	 */
	
	long findAllNumByDomain(Timestamp startRecordTime, Timestamp endRecordTime, int id)throws Exception;
	
	/**
	 *  查询指定域和指定时间段下(相关条件)的所有法律法规相关信息的总数
	 * @return recordTotalCount
	 * Date：2010-11-23
	 */
	
	long findAllNumByDomainList(List<Domain> domainList, Timestamp startRecordTime, Timestamp endRecordTime, int id)throws Exception;
}
