package org.infosec.ismp.manager.winsensor.windowslog.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.infosec.ismp.manager.winsensor.Constants;
import org.infosec.ismp.manager.winsensor.windowslog.dao.PcLogDao;
import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 10:58:50 AM
 *
 */
public class PcLogDaoImpl extends HibernateDaoSupport implements PcLogDao {

	@Override
	public void addLog(PcLogBO pcLog) {
		getHibernateTemplate().save(pcLog);
	}

	@Override
	public void addLog(List<PcLogBO> pcLogs) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			for (int i=0; i < pcLogs.size(); i++) {
				session.save(pcLogs.get(i));
				
				if (i % Constants.HIBERNATE_JDBC_BATCH_SIZE == 0) {
					session.flush();
					session.clear();
				}
			}
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
