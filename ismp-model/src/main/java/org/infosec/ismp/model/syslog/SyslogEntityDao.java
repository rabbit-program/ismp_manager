package org.infosec.ismp.model.syslog;

import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
public class SyslogEntityDao extends HibernateDao<SyslogEntity, Long>{

}
