package org.infosec.ismp.manager.servicecheck;

import org.infosec.ismp.manager.model.ServiceCheckResultEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * serviceCheck结果dao
 * @author jiel
 *
 */
@Component
public class ServiceCheckResultDao extends HibernateDao<ServiceCheckResultEntity, Long> {

}
