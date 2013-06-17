package edu.sjtu.infosec.ismp.manager.SYSM.bbs.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.dao.QuestionsDao;
import edu.sjtu.infosec.ismp.manager.SYSM.bbs.model.Questions;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.User;

/**
 * 
 * @author Wu Guojie
 * @date 2011-4-6
 * @version 1.0
 */
public class QuestionsDaoImpl extends HibernateDaoSupport implements QuestionsDao {

	public void add(Questions questions) throws Exception {
		Query query =  getSession().createSQLQuery("INSERT INTO bbs_questions(ip,user_id,q_title,q_details,create_time)" +
				" VALUES(?,?,?,?,?)");
		query.setString(0, questions.getIp());
		query.setInteger(1,questions.getSender().getId());
		query.setString(2, questions.getQ_title());
		query.setString(3, questions.getQ_details());
		query.setTimestamp(4, questions.getCreateTime());
		query.executeUpdate();
	}

	public void delete(Questions questions) throws Exception {
		getHibernateTemplate().delete(questions);
	}

	public void update(Questions questions) throws Exception {
		getHibernateTemplate().saveOrUpdate(questions);
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public List<Questions> findAll(PMPage page) throws Exception {
		Criteria criteria= this.getSession().createCriteria(Questions.class);
		criteria.setFirstResult(page.getBeginIndex());
	    criteria.setMaxResults(page.getEveryPage());
	   return  criteria.list();
	}

	public Questions findById(int id) throws Exception {
		Questions questions = (Questions)getHibernateTemplate().get(Questions.class, id);
		return questions;
	}

	public Object findAllCount() {
		Criteria criteria= this.getSession().createCriteria(Questions.class);
		criteria.setProjection(Projections.count("id"));
	return  criteria.uniqueResult();
	}

	public List<Questions> findAll() throws Exception {
		
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Questions> findAll(int startResult, int maxResult)
			throws Exception {
		
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Questions> findAll(User sender) throws Exception {
		
		// TODO Auto-generated method stub
		return null;
		
	}

	public List<Questions> findAll(User sender, int startResult, int maxResult)
			throws Exception {
		
		// TODO Auto-generated method stub
		return null;
		
	}
}
