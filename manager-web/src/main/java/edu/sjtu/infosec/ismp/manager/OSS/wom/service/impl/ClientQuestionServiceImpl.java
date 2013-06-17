package edu.sjtu.infosec.ismp.manager.OSS.wom.service.impl;

import java.util.ArrayList;
import java.util.List;
import edu.sjtu.infosec.ismp.manager.OSS.wom.dao.ClientQuestionDao;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.ClientQuestion;
import edu.sjtu.infosec.ismp.manager.OSS.wom.service.ClientQuestionService;
import edu.sjtu.infosec.ismp.security.Domain;
/**
 * Dao层 客户端问题dao.
 */
public class ClientQuestionServiceImpl implements ClientQuestionService {
	private ClientQuestionDao clientQuestionDao;
	
	public ClientQuestionDao getClientQuestionDao() {
		return clientQuestionDao;
	}

	public void setClientQuestionDao(ClientQuestionDao clientQuestionDao) {
		this.clientQuestionDao = clientQuestionDao;
	}
	
	

	public List<ClientQuestion> findAll(int startResult, int maxResult,Domain domain,Integer state) {
		return clientQuestionDao.findAll(startResult, maxResult, domain, state);
	}

	public List<ClientQuestion> findAllByDomain(List<Domain> userDomainList,
			int startResult, int maxResult,Domain domain,Integer state) {
		return clientQuestionDao.findAllByDomain(userDomainList, startResult, maxResult, domain, state);
	}

	public ClientQuestion findById(Integer id) {
		return clientQuestionDao.findById(id);
	}

	public int getCount(Domain domain,Integer state) {
		return clientQuestionDao.getCount(domain, state);
	}

	public int getCountByDomain(List<Domain> userDomainList,Domain domain,Integer state) {
		return clientQuestionDao.getCountByDomain(userDomainList, domain, state);
	}

	public void remove(ClientQuestion clientQuestion) {
		clientQuestionDao.remove(clientQuestion);		
	}


	public void saveOrUpdate(ClientQuestion clientQuestion) {
		clientQuestionDao.saveOrUpdate(clientQuestion);		
	}

	public void remove(String[] clientQuestions) {
		List<ClientQuestion> questionList = new ArrayList<ClientQuestion>();
        for(int i=0;i<clientQuestions.length;i++) {
        	ClientQuestion workOrder = clientQuestionDao.findById(Integer.parseInt(clientQuestions[i]));
        	questionList.add(workOrder);
        }
        if(questionList.size()>0) {
        	clientQuestionDao.remove(questionList);
        }
		
	}

}
