package org.infosec.ismp.manager.winsensor.patch.dao.impl;

import org.infosec.ismp.manager.winsensor.patch.dao.PatchClientDao;
import org.infosec.ismp.manager.winsensor.patch.entity.PatchClientBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Dec 29, 2010 4:45:59 PM
 *
 */
public class PatchClientDaoImpl extends HibernateDaoSupport implements PatchClientDao {

	@Override
	public void addClient(PatchClientBO client) {
		getHibernateTemplate().save(client);
	}
}
