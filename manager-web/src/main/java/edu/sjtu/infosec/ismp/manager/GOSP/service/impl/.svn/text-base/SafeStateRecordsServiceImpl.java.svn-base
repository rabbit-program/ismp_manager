package edu.sjtu.infosec.ismp.manager.GOSP.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.GOSP.dao.SafeStateRecordsDao;
import edu.sjtu.infosec.ismp.manager.GOSP.model.SafeStateRecords;

import edu.sjtu.infosec.ismp.manager.GOSP.service.SafeStateRecordsService;
import edu.sjtu.infosec.ismp.security.Domain;

public class SafeStateRecordsServiceImpl implements SafeStateRecordsService {
	
	private SafeStateRecordsDao safeStateRecordsDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setSafeStateRecordsDao(SafeStateRecordsDao safeStateRecordsDao) {
		this.safeStateRecordsDao = safeStateRecordsDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	

	

	public void add(SafeStateRecords safeStateRecords) throws Exception {
		safeStateRecordsDao.add(safeStateRecords);
	}

	public void delete(SafeStateRecords safeStateRecords) throws Exception {
		safeStateRecordsDao.delete(safeStateRecords);
	}

	public void update(SafeStateRecords safeStateRecords) throws Exception {
		safeStateRecordsDao.update(safeStateRecords);
	}
	
	
	

	public List<SafeStateRecords> findAll() throws Exception {
		List<SafeStateRecords> list = safeStateRecordsDao.findAll();
		return list;
	}

	public SafeStateRecords findById(int id) throws Exception {
		return safeStateRecordsDao.findById(id);
	}
	
	
	

	public List<SafeStateRecords> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<SafeStateRecords> list = safeStateRecordsDao.findAll(startRecordTime, endRecordTime, startResult, maxResult);
		return list;
	}

	public List<SafeStateRecords> findAllByDomain(List<Domain> domainList)
			throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<SafeStateRecords> list = safeStateRecordsDao.findAllByDomain(domainList);
			return list;
		}
	}

	public List<SafeStateRecords> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<SafeStateRecords> list = safeStateRecordsDao.findAllByDomain(domainList, startRecordTime, endRecordTime, startResult, maxResult);
			return list;
		}
	}

	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		long num = safeStateRecordsDao.findAllNum(startRecordTime, endRecordTime);
		return num;
	}

	public long findAllNumByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		if(domainList == null){
			return 0;
		}else if(domainList.size()<=0){
			return 0;
		}else{
			long num = safeStateRecordsDao.findAllNumByDomain(domainList, startRecordTime, endRecordTime);
			return num;
		}
	}

	public List<SafeStateRecords> findAllByDomainAndPie(
			List<Domain> domainList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List<SafeStateRecords> levelList = safeStateRecordsDao.findAllByDomainAndPie(domainList, startRecordTime, endRecordTime);
		return levelList;
	}

	@SuppressWarnings("unchecked")
	public List findAllByDomainAndLevel(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		List levelList = safeStateRecordsDao.findAllByDomainAndLevel(domainList, startRecordTime, endRecordTime);
		return levelList;
	}

	@SuppressWarnings("unchecked")
	public List findAllByDomainAndState(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		List stateList = safeStateRecordsDao.findAllByDomainAndState(domainList, startRecordTime, endRecordTime);
		return stateList;
	}




	public List<SafeStateRecords> findAllByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult, int id,
			Domain domain) throws Exception {
		List<SafeStateRecords> netSafeList = safeStateRecordsDao.findAllByDomain(startRecordTime, endRecordTime, startResult, maxResult, id, domain);
		return netSafeList;
	}

	public List<SafeStateRecords> findAllByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult, int id, Domain domain)
			throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<0){
			return null;
		}else{
			List<SafeStateRecords> netSafeList = safeStateRecordsDao.findAllByDomainList(domainList, startRecordTime, endRecordTime, startResult, maxResult, id, domain);
			return netSafeList;
		}
	}

	public long findAllNumByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int id) throws Exception {
		long totalNum = safeStateRecordsDao.findAllNumByDomain(startRecordTime, endRecordTime, id);
		return totalNum;
	}

	public long findAllNumByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime, int id)
			throws Exception {
		if(domainList==null){
			return 0;
		}else if(domainList.size()<0){
			return 0;
		}else{
			long totalNum = safeStateRecordsDao.findAllNumByDomainList(domainList, startRecordTime, endRecordTime, id);
			return totalNum;
		}
		
	}


	@SuppressWarnings("unchecked")
	public List findAllByTimeAndLevel(Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List levelList = safeStateRecordsDao.findAllByTimeAndLevel(startRecordTime, endRecordTime);
		return levelList;
	}

	@SuppressWarnings("unchecked")
	public List findAllByTimeAndState(Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List stateList = safeStateRecordsDao.findAllByTimeAndState(startRecordTime, endRecordTime);
		return stateList;
	}
		
}
