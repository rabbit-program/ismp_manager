package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface DomainDao {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(Domain domain) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(Domain domain) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(Domain domain) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<Domain> findAll() throws Exception;
	/**
	 * 查所有
	 * @return 
	 */
	long findAllNum() throws Exception;
	
	/**
	 * 查所有
	 * @return 
	 */
	Domain findById(int id) throws Exception ;
	
	/**
	 * 模糊查询
	 * @param domainvo
	 * @return
	 */
	List<Domain> findByParam(Domain domain,Page page)throws Exception ;
	/**
	 * 得到记录数
	 */
	public int getCountByParam(Domain domain)throws Exception ;
	
	void saveOrUpdateAll(List<Domain> domains)throws Exception;
	
	void deleteAll(List<Domain> domains) throws Exception;
}
