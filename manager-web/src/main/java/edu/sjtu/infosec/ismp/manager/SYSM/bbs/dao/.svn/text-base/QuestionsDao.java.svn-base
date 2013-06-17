package edu.sjtu.infosec.ismp.manager.SYSM.bbs.dao;

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
public interface QuestionsDao {
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
	/**
	 * findAllCount:(返回记录总数)
	 *
	 * @param  @return    设定文件
	 * @return Object    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	*/
	Object findAllCount();
}
