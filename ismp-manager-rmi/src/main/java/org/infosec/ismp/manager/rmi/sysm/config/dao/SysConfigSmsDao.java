package org.infosec.ismp.manager.rmi.sysm.config.dao;

import java.util.List;

import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigSms;

/**
 * 
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
public interface SysConfigSmsDao {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(SysConfigSms sms) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(SysConfigSms sms) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(SysConfigSms sms) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<SysConfigSms> findAll() throws Exception;
	/**
	 * 根据id查询
	 */
	SysConfigSms findById(int id);
	/**
	 * 根据name查询
	 */
	SysConfigSms findByName(String name);

}
