package org.infosec.ismp.manager.winsensor.history.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.infosec.ismp.manager.winsensor.Constants;
import org.infosec.ismp.manager.winsensor.history.dao.HostResourceHistoryDao;
import org.infosec.ismp.manager.winsensor.history.entity.HostResourceHistoryBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 1:57:19 PM
 *
 */
public class HostResourceHistoryDaoImpl extends HibernateDaoSupport implements HostResourceHistoryDao {

	@Override
	public void addHistory(HostResourceHistoryBO history) {
		getHibernateTemplate().save(history);
	}

	@Override
	public void addHistory(List<HostResourceHistoryBO> histories) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (int i = 0; i < histories.size(); i++) {
				session.save(histories.get(i));
				
				if (i % Constants.HIBERNATE_JDBC_BATCH_SIZE == 0) {
					session.flush();
					session.clear();
				}
			}
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
