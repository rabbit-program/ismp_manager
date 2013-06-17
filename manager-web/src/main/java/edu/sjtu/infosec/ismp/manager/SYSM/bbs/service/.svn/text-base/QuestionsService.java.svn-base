package edu.sjtu.infosec.ismp.manager.SYSM.bbs.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.bbs.model.Questions;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.User;

/**
 * 
 * @author Wu Guojie
 * @date 2011-4-6
 * @version 1.0
 */
public interface QuestionsService {
	/**
	 * 增
	 * @param 
	 * 
	 */
	void add(Questions questions) throws Exception;
	/**
	 * 删
	 * @param 
	 * 
	 */
	void delete(Questions questions) throws Exception;
	/**
	 * 改
	 * @param 
	 * 
	 */
	void update(Questions questions) throws Exception;
	/**
	 * 查所有
	 * @return list
	 */
	List<Questions> findAll(PMPage page) throws Exception;
	/**
	 * 查所有（分页）
	 * @return list
	 */
	List<Questions> findAll(int startResult, int maxResult) throws Exception;
	/**
	 * 通过用户查
	 * @return list
	 */
	List<Questions> findAll(User sender) throws Exception;
	/**
	 * 通过用户查（分页）
	 * @return list
	 */
	List<Questions> findAll(User sender, int startResult, int maxResult) throws Exception;
	/**
	 * 通过id查
	 * @param id
	 * id
	 * @return 
	 */
	Questions findById(int id) throws Exception;
}
