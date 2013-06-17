package edu.sjtu.infosec.ismp.manager.GOSP.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.GOSP.dao.LawsAndRulesDao;
import edu.sjtu.infosec.ismp.manager.GOSP.model.LawsAndRules;
import edu.sjtu.infosec.ismp.manager.GOSP.service.LawsAndRulesService;
import edu.sjtu.infosec.ismp.security.Domain;

public class LawsAndRulesServiceImpl implements LawsAndRulesService {
	private LawsAndRulesDao lawsAndRulesDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setLawsAndRulesDao(LawsAndRulesDao lawsAndRulesDao) {
		this.lawsAndRulesDao = lawsAndRulesDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	

	

	public void add(LawsAndRules lawsAndRules) throws Exception {
		lawsAndRulesDao.add(lawsAndRules);
	}

	public void delete(LawsAndRules lawsAndRules) throws Exception {
		lawsAndRulesDao.delete(lawsAndRules);
	}

	public void update(LawsAndRules lawsAndRules) throws Exception {
		lawsAndRulesDao.update(lawsAndRules);
	}
	
	
	

	public List<LawsAndRules> findAll() throws Exception {
		List<LawsAndRules> list = lawsAndRulesDao.findAll();
		return list;
	}

	public LawsAndRules findById(int id) throws Exception {
		return lawsAndRulesDao.findById(id);
	}
	
	
	

	public List<LawsAndRules> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<LawsAndRules> list = lawsAndRulesDao.findAll(startRecordTime, endRecordTime, startResult, maxResult);
		return list;
	}

	public List<LawsAndRules> findAllByDomain(List<Domain> domainList)
			throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<LawsAndRules> list = lawsAndRulesDao.findAllByDomain(domainList);
			return list;
		}
	}

	public List<LawsAndRules> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<LawsAndRules> list = lawsAndRulesDao.findAllByDomain(domainList, startRecordTime, endRecordTime, startResult, maxResult);
			return list;
		}
	}

	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		long num = lawsAndRulesDao.findAllNum(startRecordTime, endRecordTime);
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
			long num = lawsAndRulesDao.findAllNumByDomain(domainList, startRecordTime, endRecordTime);
			return num;
		}
	}

	public List<LawsAndRules> findAllByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult, int id,
			Domain domain) throws Exception {
		List<LawsAndRules> lawRulesList = lawsAndRulesDao.findAllByDomain(startRecordTime, endRecordTime, startResult, maxResult, id, domain);
		return lawRulesList;
	}

	public List<LawsAndRules> findAllByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult, int id, Domain domain)throws Exception {
			if(domainList == null){
				return null;
			}else if(domainList.size()<0){
				return null;
			}else{
				List<LawsAndRules> lawRulesList = lawsAndRulesDao.findAllByDomainList(domainList, startRecordTime, endRecordTime, startResult, maxResult, id, domain);
				return lawRulesList;
			}
	}

	public long findAllNumByDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int id) throws Exception {
		long totalNum = lawsAndRulesDao.findAllNumByDomain(startRecordTime, endRecordTime, id);
		return totalNum;
	}

	public long findAllNumByDomainList(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime, int id)
			throws Exception {
		if(domainList == null){
			return 0;
		}else if(domainList.size()<0){
			return 0;
		}else{
			long totalNum = lawsAndRulesDao.findAllNumByDomainList(domainList, startRecordTime, endRecordTime, id);
			return totalNum;
		}
	}

}
