package org.infosec.ismp.manager.rmi.sysm.config.dao;

import java.util.List;

import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDb;

/**
 * 
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
public interface SysConfigDbDao {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(SysConfigDb db) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(SysConfigDb db) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(SysConfigDb db) throws Exception;
	
	
	
	/**
	 * 查所有
	 * @return 
	 */
	List<SysConfigDb> findAll() throws Exception;
	/**
	 * 根据id查询
	 */
	SysConfigDb findById(int id);
	/**
	 * 根据name查询
	 */
	SysConfigDb findByName(String name);

}
