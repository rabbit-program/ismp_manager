package edu.sjtu.infosec.ismp.security;

import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * 角色对象的泛型Hibernate Dao.
 * 
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 * 
 */
@Component
public class RoleDao extends HibernateDao<Role, String> {
}
