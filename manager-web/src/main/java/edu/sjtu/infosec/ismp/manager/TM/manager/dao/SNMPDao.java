package edu.sjtu.infosec.ismp.manager.TM.manager.dao;

import org.infosec.ismp.manager.rmi.tm.manager.model.SNMPEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
public class SNMPDao extends HibernateDao<SNMPEntity,Integer>{

}
