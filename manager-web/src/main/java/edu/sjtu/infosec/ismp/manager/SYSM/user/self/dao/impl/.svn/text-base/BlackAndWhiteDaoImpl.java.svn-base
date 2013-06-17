package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.BlackAndWhiteDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

public class BlackAndWhiteDaoImpl extends HibernateDaoSupport implements BlackAndWhiteDao {

	// 根据ID 地址和黑白标记查询;用来登录的时候判断是否在启用的黑/白名单中
	public BlackAndWhiteBO getUniqueBlackAndWhiteDao(
			BlackAndWhiteBO BlackAndWhiteBOEntity) {
		Criteria cri = termMaker(BlackAndWhiteBOEntity);
		cri.setMaxResults(1);
		return (BlackAndWhiteBO) cri.uniqueResult();
	}
//	// 多条件模糊查询
//	public List<BlackAndWhiteBO> getBlurBlackAndWhiteDao(
//			BlackAndWhiteBO BlackAndWhiteBOEntity) {
//		// TODO Auto-generated method stub
//		return termMaker(BlackAndWhiteBOEntity).list();
//	}
//
	// 多条件生成
	public Criteria termMaker(BlackAndWhiteBO BlackAndWhiteBOEntity) {
		Criteria cri = getSession().createCriteria(BlackAndWhiteBO.class);
		if (BlackAndWhiteBOEntity != null) {
			if (BlackAndWhiteBOEntity.getId() != null) {
				cri.add(Restrictions.eq("id", BlackAndWhiteBOEntity.getId()));
			}
			if (BlackAndWhiteBOEntity.getIpaddress() != null
					&& BlackAndWhiteBOEntity.getIpaddress().trim().length() > 0) {
				cri.add(Restrictions.eq("ipaddress", BlackAndWhiteBOEntity
						.getIpaddress()));
			}
			if (BlackAndWhiteBOEntity.getMarker() != null&&BlackAndWhiteBOEntity.getMarker()!=2) {
				cri.add(Restrictions.eq("marker", BlackAndWhiteBOEntity
						.getMarker()));
			}
			if (BlackAndWhiteBOEntity.getDomain()!=null&&BlackAndWhiteBOEntity.getDomain().toString().trim().length()>0&&BlackAndWhiteBOEntity.getDomain()>0) {
				cri.add(Restrictions.eq("domain", BlackAndWhiteBOEntity.getDomain()));
			}
			if (BlackAndWhiteBOEntity.getRole()!=null&&BlackAndWhiteBOEntity.getRole().trim().length()!=0) {
				cri.add(Restrictions.eq("role", BlackAndWhiteBOEntity.getRole()));
			}
			if (BlackAndWhiteBOEntity.getDepict() != null
					&& BlackAndWhiteBOEntity.getDepict().trim().length() > 0) {
				cri.add(Restrictions.like("depict", "%"+BlackAndWhiteBOEntity
						.getDepict()
						+ "%"));
			}
		}
		return cri;
	}



	// 添加黑白名单
	public void saveBlackAndWhiteDao(BlackAndWhiteBO BlackAndWhiteBOEntity) {
		getHibernateTemplate().save(BlackAndWhiteBOEntity);
	}

	// 更新黑/白名单
	public void updateBelackAndWhiteDao(BlackAndWhiteBO BlackAndWhiteBOEntity) {
		getHibernateTemplate().update(BlackAndWhiteBOEntity);
	}

	// 删除黑/白名单
	public void deleteBlackAndWhiteDao(BlackAndWhiteBO BlackAndWhiteBOEntity) {
		getHibernateTemplate().delete(BlackAndWhiteBOEntity);
	}

	// ID 模糊查询
	public BlackAndWhiteBO getBlackAndWhiteByIdDao(Integer ID) {
		return (BlackAndWhiteBO) getHibernateTemplate().get(BlackAndWhiteBO.class, ID);
	}

	// 模糊查询＋分页
	public List<BlackAndWhiteBO> getPageListBlurBlackAndWhiteDao(
			BlackAndWhiteBO BlackAndWhiteBOEntity, Page page) {
		Criteria cri = termMaker(BlackAndWhiteBOEntity);
		if (page != null) {
			cri.setFirstResult(page.getBeginIndex());
			cri.setMaxResults(page.getEveryPage());
		}
		return cri.list();
	}

	// 统计函数
	public int getCountBlurBlackAndWhiteService(
			BlackAndWhiteBO BlackAndWhiteBOEntity) {
		Criteria cri = termMaker(BlackAndWhiteBOEntity);
		return ((Integer) cri.setProjection(Projections.rowCount())
				.uniqueResult()).intValue();
	}

}
