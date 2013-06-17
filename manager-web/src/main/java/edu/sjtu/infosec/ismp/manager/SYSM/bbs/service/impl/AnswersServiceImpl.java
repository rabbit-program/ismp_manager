package edu.sjtu.infosec.ismp.manager.SYSM.bbs.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.bbs.dao.AnswersDao;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.model.Answers;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.service.AnswersService;

/**
 * 
 * @author Wu Guojie
 * @date 2011-4-6
 * @version 1.0
 */
public class AnswersServiceImpl implements AnswersService {
	
	private AnswersDao answersDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setAnswersDao(AnswersDao answersDao) {
		this.answersDao = answersDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	

	public void add(Answers answers) throws Exception {
		answersDao.add(answers);
	}

	public void delete(Answers answers) throws Exception {
		answersDao.delete(answers);
	}

	public void update(Answers answers) throws Exception {
		answersDao.update(answers);
	}

	public List<Answers> findAll() throws Exception {
		List<Answers> list = answersDao.findAll();
		return list;
	}

	public Answers findById(int id) throws Exception {
		return answersDao.findById(id);
	}
}
