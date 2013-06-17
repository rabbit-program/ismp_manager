package edu.sjtu.infosec.ismp.manager.OSS.klbm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.OSS.klbm.dao.OssKnowledgeBaseDao;
import edu.sjtu.infosec.ismp.manager.OSS.klbm.model.OssKnowledgeBase;
import edu.sjtu.infosec.ismp.manager.OSS.klbm.service.OssKnowledgeBaseService;
import edu.sjtu.infosec.ismp.security.Domain;

public class OssKnowledgeBaseServiceImpl implements OssKnowledgeBaseService {
	private OssKnowledgeBaseDao ossKnowledgeDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setOssKnowledgeDao(OssKnowledgeBaseDao ossKnowledgeDao) {
		this.ossKnowledgeDao = ossKnowledgeDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	

	

	public void add(OssKnowledgeBase knowledgeBase) throws Exception {
		ossKnowledgeDao.add(knowledgeBase);
	}

	public void delete(OssKnowledgeBase knowledgeBase) throws Exception {
		ossKnowledgeDao.delete(knowledgeBase);
	}

	public void update(OssKnowledgeBase knowledgeBase) throws Exception {
		ossKnowledgeDao.update(knowledgeBase);
	}
	
	
	

	public List<OssKnowledgeBase> findAll() throws Exception {
		List<OssKnowledgeBase> list = ossKnowledgeDao.findAll();
		return list;
	}

	public OssKnowledgeBase findById(int id) throws Exception {
		return ossKnowledgeDao.findById(id);
	}
	
	
	

	public List<OssKnowledgeBase> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<OssKnowledgeBase> list = ossKnowledgeDao.findAll(startRecordTime, endRecordTime, startResult, maxResult);
		return list;
	}

	public List<OssKnowledgeBase> findAllByDomain(List<Domain> domainList)
			throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<OssKnowledgeBase> list = ossKnowledgeDao.findAllByDomain(domainList);
			return list;
		}
	}

	public List<OssKnowledgeBase> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<OssKnowledgeBase> list = ossKnowledgeDao.findAllByDomain(domainList, startRecordTime, endRecordTime, startResult, maxResult);
			return list;
		}
	}

	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		long num = ossKnowledgeDao.findAllNum(startRecordTime, endRecordTime);
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
			long num = ossKnowledgeDao.findAllNumByDomain(domainList, startRecordTime, endRecordTime);
			return num;
		}
	}


	public List<OssKnowledgeBase> findAllByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult, int id,
			Domain domain) throws Exception {
		List<OssKnowledgeBase> ossKBList = ossKnowledgeDao.findAllByDomain(startRecordTime, endRecordTime, startResult, maxResult, id, domain);
		return ossKBList;
	}


	public List<OssKnowledgeBase> findAllByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult, int id, Domain domain)
			throws Exception {
			if(domainList==null){
				return null;
			}else if(domainList.size()<0){
				return null;
			}else{
				List<OssKnowledgeBase> ossKBList = ossKnowledgeDao.findAllByDomainList(domainList, startRecordTime, endRecordTime, startResult, maxResult, id, domain);
				return ossKBList;
			}
		
	}


	public long findAllNumByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int id) throws Exception {
		long totalNum = ossKnowledgeDao.findAllNumByDomain(startRecordTime, endRecordTime, id);
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
			long totalNum = ossKnowledgeDao.findAllNumByDomainList(domainList, startRecordTime, endRecordTime, id);
			return totalNum;
		}
	}

}
