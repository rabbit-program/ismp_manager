package org.infosec.ismp.manager.ping;

import org.infosec.ismp.manager.model.PingResultEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;
/**
 * pingResultEntity dao
 * @author lianglin
 *
 */
@Component
public class PingResultDao extends HibernateDao<PingResultEntity, Long>{

}
