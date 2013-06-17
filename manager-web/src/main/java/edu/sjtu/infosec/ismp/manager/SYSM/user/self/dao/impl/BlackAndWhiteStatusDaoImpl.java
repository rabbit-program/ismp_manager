package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.impl;

import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.BlackAndWhiteStatusDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteStatusBO;

public class BlackAndWhiteStatusDaoImpl extends HibernateDaoSupport  implements BlackAndWhiteStatusDao{

	//查询黑白名单的启用状态
	public BlackAndWhiteStatusBO getBlackAndWhiteStatusDao(){
		Criteria cri=getSession().createCriteria(BlackAndWhiteStatusBO.class);
		cri.setMaxResults(1);
		return (BlackAndWhiteStatusBO) cri.uniqueResult();
	}	
	//修改黑明白单的启用状态
	public void updateBlackAndWhiteStatusDao(BlackAndWhiteStatusBO BlackAndWhiteStatusBOEntity){
//		Criteria cri=getSession().createCriteria(BlackAndWhiteStatusBO.class);
		getHibernateTemplate().update(BlackAndWhiteStatusBOEntity);
//		cri.setMaxResults(1);
	}	
	//添加黑白名单状态，该方法是在数据表没记录的时候才调用的
	public void saveBlackAndWhiteStatusDao(BlackAndWhiteStatusBO BlackAndWhiteStatusBOEntity){
		// TODO Auto-generated method stub
		getHibernateTemplate().save(BlackAndWhiteStatusBOEntity);
	}

	//删除所数据
	public void  deleteAllBlackAndWhiteStatusDao(){		
		getSession().createQuery("delete from BlackAndWhiteStatusBO").executeUpdate();	
	}
}
