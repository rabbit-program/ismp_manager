package org.infosec.ismp.manager.syslog;

import org.infosec.ismp.manager.model.syslog.SyslogNodeEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;
/**
 * syslog node dao
 * @author lianglin
 *
 */
@Component
public class SyslogNodeDao extends HibernateDao<SyslogNodeEntity, Long> {
    
}
