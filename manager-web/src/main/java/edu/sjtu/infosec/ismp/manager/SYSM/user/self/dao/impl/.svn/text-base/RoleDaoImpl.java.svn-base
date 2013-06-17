package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.RoleDao;
import edu.sjtu.infosec.ismp.security.Role;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	//多条件模糊查询角色信息
	public List<Role> getBlurRoleDao(Role roleEntity) {
		return (this.termMaker(roleEntity)).list();
	}

	public Role getRoleByIdDao(Integer roleID) {		
		return (Role) getHibernateTemplate().get(Role.class, roleID);
	}
	//查询条件生成器
	public Criteria termMaker(Role RoleEntity){
		 Criteria cri=getSession().createCriteria(Role.class);
		 if(null!=RoleEntity){
			 if(null!=RoleEntity.getRole()){
				 cri.add(Restrictions.eq("role", RoleEntity.getRole()));
			 }
			 if(null!=RoleEntity.getId()){
				 cri.add(Restrictions.eq("id", RoleEntity.getId()));
			 }
		 }
		 return cri;
	}
//
//	//删除
//	public void deleteRoleDao(RoleBO roleEntity) {
//		// TODO Auto-generated method stub
//		getHibernateTemplate().delete(roleEntity);
//	}
//    //修改
//	public void saveRoleDao(RoleBO roleEntity) {
//		// TODO Auto-generated method stub
//		getHibernateTemplate().save(roleEntity);
//	}
//   //更新
//	public void updateRoleDao(RoleBO roleEntity) {
//		// TODO Auto-generated method stub
//		getHibernateTemplate().update(roleEntity);
//	}
	//根据用户ID查询所对应的角色信息
	public List<Role> getRoleByUserIdDao(Serializable userID) {	 
//		String hql = "from Role role where role.id in (select pos.roleId from UserToRoleBO pos where pos.userId=:userId)";
//		Query query = getSession().createQuery(hql);
//		query.setParameter("userId", userID); 
//		return query.list();
		return null;
	}
	
	void batchUser(Integer[] ids){
//		getHibernateTemplate();
		Query query = getSession().createSQLQuery("delete from ismp_user_domain where domain_id in(?) ");
		query.setParameter(0,ids );
		query.executeUpdate();
	}

}
