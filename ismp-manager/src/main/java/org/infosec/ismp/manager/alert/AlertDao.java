package org.infosec.ismp.manager.alert;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
public class AlertDao extends HibernateDao<AlertInfoBO, Integer> {

}
