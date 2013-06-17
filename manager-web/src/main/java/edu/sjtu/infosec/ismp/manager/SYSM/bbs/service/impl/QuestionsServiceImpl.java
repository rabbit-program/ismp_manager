package edu.sjtu.infosec.ismp.manager.SYSM.bbs.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.bbs.dao.QuestionsDao;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.model.Questions;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.service.QuestionsService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.security.User;

/**
 * 
 * @author Wu Guojie
 * @date 2011-4-6
 * @version 1.0
 */
public class QuestionsServiceImpl implements QuestionsService {
	
	private QuestionsDao questionsDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setQuestionsDao(QuestionsDao questionsDao) {
		this.questionsDao = questionsDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	

	public void add(Questions questions) throws Exception {
		questionsDao.add(questions);
	}

	public void delete(Questions questions) throws Exception {
		questionsDao.delete(questions);
	}

	public void update(Questions questions) throws Exception {
		questionsDao.update(questions);
	}

	public List<Questions> findAll(PMPage page) throws Exception {
		List<Questions> list = questionsDao.findAll(page);
		int count = (Integer) questionsDao.findAllCount();
		page.setPageInfo(PMPageUtil.createPage(page, count));
		return list;
	}

	public List<Questions> findAll(int startResult, int maxResult)
			throws Exception {
		List<Questions> list = questionsDao.findAll(startResult, maxResult);
		return list;
	}

	public List<Questions> findAll(User sender) throws Exception {
		List<Questions> list = questionsDao.findAll(sender);
		return list;
	}

	public List<Questions> findAll(User sender, int startResult, int maxResult)
			throws Exception {
		List<Questions> list = questionsDao.findAll(sender, startResult, maxResult);
		return list;
	}
	
	public Questions findById(int id) throws Exception {
		return questionsDao.findById(id);
	}
}
