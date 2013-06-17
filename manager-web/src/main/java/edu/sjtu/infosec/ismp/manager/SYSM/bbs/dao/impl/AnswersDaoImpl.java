package edu.sjtu.infosec.ismp.manager.SYSM.bbs.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.bbs.dao.AnswersDao;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.model.Answers;

/**
 * 
 * @author Wu Guojie
 * @date 2011-4-6
 * @version 1.0
 */
public class AnswersDaoImpl extends HibernateDaoSupport implements AnswersDao {

	public void add(Answers answers) throws Exception {
		getHibernateTemplate().saveOrUpdate(answers);
	}

	public void delete(Answers answers) throws Exception {
		getHibernateTemplate().delete(answers);
	}

	public void update(Answers answers) throws Exception {
		getHibernateTemplate().saveOrUpdate(answers);
		getHibernateTemplate().flush();
	}

	public List<Answers> findAll() throws Exception {
		List<Answers> list = getHibernateTemplate().loadAll(Answers.class);
		return list;
	}

	public Answers findById(int id) throws Exception {
		Answers answers = (Answers)getHibernateTemplate().get(Answers.class, id);
		return answers;
	}
}
