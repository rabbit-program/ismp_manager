package edu.sjtu.infosec.ismp.manager.SYSM.bbs.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.bbs.model.Answers;

/**
 * 
 * @author Wu Guojie
 * @date 2011-4-6
 * @version 1.0
 */
public interface AnswersService {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(Answers answers) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(Answers answers) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(Answers answers) throws Exception;
	/**
	 * 查所有
	 * @return list
	 */
	List<Answers> findAll() throws Exception;
	/**
	 * 通过id查
	 * @param id
	 * id
	 * @return 
	 */
	Answers findById(int id) throws Exception;
}
