package edu.sjtu.infosec.ismp.manager.VPM.sd.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.VPM.sd.dao.SoftwareTypeInfoDao;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.TypeInfo;
/**
 * @author liuqing
 *
 */
public class SoftwareTypeInfoDaoImpl extends HibernateDaoSupport implements SoftwareTypeInfoDao{

	public void del(Integer id) {
		TypeInfo typeInfo = new TypeInfo();
		typeInfo.setId(id);
        getSession().delete(typeInfo);
	}
	public void save(TypeInfo typeInfo) {
		getHibernateTemplate().save(typeInfo);
	}
	@SuppressWarnings("unchecked")
	public List<TypeInfo> searchAll() {
		return getHibernateTemplate().find("from TypeInfo");
	}
	public void update(TypeInfo typeInfo) {
		getHibernateTemplate().update(typeInfo);
	}
}
