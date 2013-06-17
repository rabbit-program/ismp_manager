package edu.sjtu.infosec.ismp.manager.AIM.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AIM.comm.AlertQueryVO;
import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertDao;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;




public class AlertDaoImpl extends HibernateDaoSupport implements AlertDao {

	// 多条件查询告警信息 并且分页显示
	public PageResult getListPageAlertDao(Page page,
			AlertQueryVO AlertQueryEntity) {
		Criteria cri = makeTerm(AlertQueryEntity);
//		Criteria cri1 = makeTerm(AlertQueryEntity);
		// 统计记录数
		Integer count = getCountByAlertDao(AlertQueryEntity,null);
//		Integer count = 2;
		// 设置分页参数
		PageResult rs = new PageResult();
		if (page != null) {
			cri.setFirstResult(page.getBeginIndex());
			cri.setMaxResults(page.getEveryPage());
		}		
	
		if (null != page) {
			page = PageUtil.createPage(page.getEveryPage(), page
					.getCurrentPage(), count);
		}
		rs.setPageList(cri.list());
		rs.setPage(page);		
		return rs;
	}

	// 多条查询生成器
	public Criteria makeTerm(final AlertQueryVO alertEntity) {
		Criteria cri = getSession().createCriteria(AlertInfoBO.class);
		if (alertEntity != null) {
			if (null != alertEntity.getAlertReason()
					&& alertEntity.getAlertReason().trim().length()>0) {
				cri.add(Restrictions.like("alertReason", "%"
						+ alertEntity.getAlertReason() + "%"));
			}
			if (null != alertEntity.getRawContent()
					&& alertEntity.getRawContent().trim().length()>0) {
				cri.add(Restrictions.like("rawContent", "%"
						+ alertEntity.getRawContent() + "%"));
			}
			if (null != alertEntity.getBeginPriority()
					&& alertEntity.getEndPriority() != null) {
				int startPriority = alertEntity.getBeginPriority();
				int endPriority = alertEntity.getEndPriority();
				if(startPriority > endPriority) {
					startPriority += endPriority;
					endPriority = startPriority - endPriority;
					startPriority = startPriority - endPriority;
				}
				cri.add(Expression.between("level", startPriority, endPriority));
			}
			if (null != alertEntity.getSrcIp()
					&& (!alertEntity.getSrcIp().equals(""))) {
				cri.add(Restrictions.like("srcIP", "%"
						+ alertEntity.getSrcIp() + "%"));
			}
			
			if (null != alertEntity.getType()
					&& (!alertEntity.getType().equals(""))) {
				cri.add(Restrictions.eq("type", alertEntity.getType()));
			}
			
			if (null != alertEntity.getAlertType()
					&& (!alertEntity.getAlertType().equals(""))) {
				cri.add(Restrictions.eq("alertType", alertEntity.getAlertType()));
			}
			
			if (null != alertEntity.getAlertSubType()
					&& (!alertEntity.getAlertSubType().equals(""))) {
				cri.add(Restrictions.eq("alertSubType", alertEntity.getAlertSubType()));
			}
//			if (null != alertEntity.getTarget()
//					&& (!alertEntity.getTarget().equals(""))) {
//				cri.add(Restrictions.eq("target", alertEntity.getTarget()));
//			}
			if (null != alertEntity.getStatus() && alertEntity.getStatus() < 2) {
				cri.add(Restrictions.eq("status", alertEntity.getStatus()));
			}
			if (alertEntity.getBeginId() != null
					&& alertEntity.getEndId() != null) {
				int startId =alertEntity.getBeginId();
				int endId = alertEntity.getEndId();
				if(startId > endId) {
					startId += endId;
					endId = startId - endId;
					startId = startId - endId;
				}
				cri.add(Expression.between("id", startId,endId));
			}
			if (alertEntity.getBeginDate() != null
					&& alertEntity.getEndDate() != null) {
				cri.add(Restrictions.between("time",
						alertEntity.getBeginDate(), alertEntity.getEndDate()));
			}
			if (alertEntity.getTouchoffDate() != null) {
				cri.add(Restrictions
						.like("time", alertEntity.getTouchoffDate()));
			}
			if(alertEntity.getLogintime()!=null){
			    cri.add(Restrictions.gt("time", Timestamp.valueOf(alertEntity.getLogintime())));
			}
		}
		cri.addOrder(Order.desc("time"));
		return cri;
	}

	// 统计记录数
	public int getCountByAlertDao(AlertQueryVO AlertQueryEntity, Criteria cri) {
		if (AlertQueryEntity != null) {
			Criteria cri1 = makeTerm(AlertQueryEntity);
			return ((Integer) cri1.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		} else {
			return ((Integer) cri.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		}
		

//		Criteria cri1 = getSession().createCriteria(AlertInfoBO.class);
		
//		return ((Integer) cri1.setProjection(Projections.rowCount()).uniqueResult()).intValue();
//		return cri1.list().size();
	}

	public AlertInfoBO getByIdAlertDao(Integer alertid) {
		return (AlertInfoBO) getHibernateTemplate().get(AlertInfoBO.class,
				alertid);
	}

	// 更新告警信息的方法
	public void updateAlertDao(AlertInfoBO alertInfoEntity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(alertInfoEntity);
	}
	
	//添加告警信息方法
	public void addAlertDao(AlertInfoBO alertInfoEntity){
		this.getHibernateTemplate().save(alertInfoEntity);
	}

	public PageResult getListPageAlertDao(Page page,
			AlertQueryVO AlertQueryEntity, List<Domain> list) {
		Criteria cri = makeTerm(AlertQueryEntity);
		cri = tianjiaQuanxian(cri,list);
		if(cri!=null){
		// 统计记录数
		Integer count = getCountByAlertDao(AlertQueryEntity,null,list);
		// 设置分页参数
		PageResult rs = new PageResult();
		if (page != null) {
			cri.setFirstResult(page.getBeginIndex());
			cri.setMaxResults(page.getEveryPage());
		}		
	
		if (null != page) {
			page = PageUtil.createPage(page.getEveryPage(), page
					.getCurrentPage(), count);
		}
		rs.setPageList(cri.list());
		rs.setPage(page);		
		return rs;
		}else{
			return null;
		}
			
	}
	// 统计记录数，加权限
	public int getCountByAlertDao(AlertQueryVO AlertQueryEntity, Criteria cri,List<Domain> set) {
		if (AlertQueryEntity != null) {
			Criteria cri1 = makeTerm(AlertQueryEntity);
			cri1 = tianjiaQuanxian(cri1,set);
			if(cri1!=null){
				return ((Integer) cri1.setProjection((Projections.rowCount()))
						.uniqueResult()).intValue();
			}else{
				return 0;
			}
		} else {
			cri = tianjiaQuanxian(cri,set);
			if(cri!=null){
				return ((Integer) cri.setProjection((Projections.rowCount()))
						.uniqueResult()).intValue();
			}else{
				return 0;
			}
		}

	}
	
	//检索加权限
	private Criteria tianjiaQuanxian(Criteria cri,List<Domain> set) {
		/*if(userToManager != null && userToManager.trim().length()!=0){
			String[] mStr = userToManager.split(",");
			List<Integer> ids = new ArrayList<Integer>();
			if (mStr != null && mStr.length > 0) {
				for (String mid : mStr) {
					if(mid!=null || !mid.trim().equals("")){
						ids.add(Integer.parseInt(mid));
					}
				}
			}
			cri.add(Restrictions.in("deparmentId", ids));
			return cri;
		}
		return null;*/
		if(set!=null && set.size()>0){
			List<Integer> ids =new ArrayList<Integer>();
			for(Domain domain :set){
				ids.add(domain.getId());
			}
			cri.add(Restrictions.in("domain", ids));
		}
		return cri;
	}
}
