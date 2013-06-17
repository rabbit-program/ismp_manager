package edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.impl;

import java.util.List;

import org.hibernate.Criteria;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.DomainDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;

public class DomainServiceImpl implements DomainService {
	
	private DomainDao domainDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setDomainDao(DomainDao domainDao) {
		this.domainDao = domainDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	

	public void add(Domain domain) throws Exception {
		domainDao.add(domain);
	}

	public void delete(Domain domain) throws Exception {
		domainDao.delete(domain);
	}

	public void update(Domain domain) throws Exception {
		domainDao.update(domain);
	}

	public List<Domain> findAll() throws Exception {
		List<Domain> list = domainDao.findAll();
		return list;
	}

	public long findAllNum() throws Exception {
		long num = domainDao.findAllNum();
		return num;
	}

	public Domain findById(int id) throws Exception {
		return domainDao.findById(id);
	}
	
	public int getCountByParam(Domain domain) throws Exception {
		return domainDao.getCountByParam(domain);
	}
	
	public PageResult findByParam(Domain domain,Page page) throws Exception{
		List list = domainDao.findByParam(domain, page);
		int count =getCountByParam(domain);
		PageResult rs=new PageResult();
		page=PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), count);
		rs.setPage(page);
		rs.setPageList(list);
		return rs;
	}
	
	
	public void saveOrUpdateAll(List<Domain> domains) throws Exception {
		domainDao.saveOrUpdateAll(domains);
	}
	public void deleteAll(List<Domain> domains) throws Exception {
		domainDao.deleteAll(domains);
		
	}
	
}
