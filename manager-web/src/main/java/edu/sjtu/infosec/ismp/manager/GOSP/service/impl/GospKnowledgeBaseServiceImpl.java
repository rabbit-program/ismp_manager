package edu.sjtu.infosec.ismp.manager.GOSP.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.GOSP.dao.GospKnowledgeBaseDao;
import edu.sjtu.infosec.ismp.manager.GOSP.model.GospKnowledgeBase;
import edu.sjtu.infosec.ismp.manager.GOSP.service.GospKnowledgeBaseService;
import edu.sjtu.infosec.ismp.security.Domain;

public class GospKnowledgeBaseServiceImpl implements GospKnowledgeBaseService {
	private GospKnowledgeBaseDao gospKnowledgeDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setGospKnowledgeDao(GospKnowledgeBaseDao gospKnowledgeDao) {
		this.gospKnowledgeDao = gospKnowledgeDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
		

	public void add(GospKnowledgeBase knowledgeBase) throws Exception {
		gospKnowledgeDao.add(knowledgeBase);
	}

	public void delete(GospKnowledgeBase knowledgeBase) throws Exception {
		gospKnowledgeDao.delete(knowledgeBase);
	}

	public void update(GospKnowledgeBase knowledgeBase) throws Exception {
		gospKnowledgeDao.update(knowledgeBase);
	}
	
	
	

	public List<GospKnowledgeBase> findAll() throws Exception {
		List<GospKnowledgeBase> list = gospKnowledgeDao.findAll();
		return list;
	}

	public GospKnowledgeBase findById(int id) throws Exception {
		return gospKnowledgeDao.findById(id);
	}
	
	
	

	public List<GospKnowledgeBase> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<GospKnowledgeBase> list = gospKnowledgeDao.findAll(startRecordTime, endRecordTime, startResult, maxResult);
		return list;
	}

	public List<GospKnowledgeBase> findAllByDomain(List<Domain> domainList)
			throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<GospKnowledgeBase> list = gospKnowledgeDao.findAllByDomain(domainList);
			return list;
		}
	}

	public List<GospKnowledgeBase> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<GospKnowledgeBase> list = gospKnowledgeDao.findAllByDomain(domainList, startRecordTime, endRecordTime, startResult, maxResult);
			return list;
		}
	}

	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		long num = gospKnowledgeDao.findAllNum(startRecordTime, endRecordTime);
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
			long num = gospKnowledgeDao.findAllNumByDomain(domainList, startRecordTime, endRecordTime);
			return num;
		}
	}


	public List<GospKnowledgeBase> findAllByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult, int id,
			Domain domain) throws Exception {
		List<GospKnowledgeBase> knowledgeBaseList = gospKnowledgeDao.findAllByDomain(startRecordTime, endRecordTime, startResult, maxResult, id, domain);
		return knowledgeBaseList;
	}

	public List<GospKnowledgeBase> findAllByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult, int id, Domain domain)
			throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<0){
			return null;
		}else{
			List<GospKnowledgeBase> knowledgeBaseList = gospKnowledgeDao.findAllByDomainList(domainList, startRecordTime, endRecordTime, startResult, maxResult, id, domain);
			return knowledgeBaseList;
		}
	}

	public long findAllNumByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int id) throws Exception {
		long totalNum = gospKnowledgeDao.findAllNumByDomain(startRecordTime, endRecordTime, id);
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
			long totalNum = gospKnowledgeDao.findAllNumByDomainList(domainList, startRecordTime, endRecordTime, id);
			return totalNum;
		}
	}

}
