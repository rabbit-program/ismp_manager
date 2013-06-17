package edu.sjtu.infosec.ismp.manager.AIM.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertRuleDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertRuleBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;


public class AlertRuleDaoImpl extends HibernateDaoSupport implements
		AlertRuleDao {

	// 查询所有的告警规则并且分页显示
	public PageResult getPageAlertRuleDao(Page page, AlertRuleBO queryVo) {
		Criteria cri = makeTerm(queryVo);
		if (page != null) {
			cri.setFirstResult(page.getBeginIndex());
			cri.setMaxResults(page.getEveryPage());
		}
		PageResult rs = new PageResult();
		rs.setPageList(cri.list());
//		List listR = cri.list();
//		if(listR!=null && listR.size()>0){
//			rs.setPageList(listR);
//		}else{
//			rs.setPageList(null);
//		}
//		rs.setPageList(cri.list());
		// 统计记录数
		Integer count = getCountAlertRuleDao(queryVo);
		Page pageu = page;
		if (null != page) {
			pageu = PageUtil.createPage(page.getEveryPage(), page
					.getCurrentPage(), count);
		}
		// 封装查询结果跟 page对象
		rs.setPage(pageu);
		return rs;
	}

	// 添加告警规则信息
	public void saveAlertRuleDao(AlertRuleBO alertRuleBoEntity) {
		getHibernateTemplate().save(alertRuleBoEntity);
	}

	// 生成查询条件
	public Criteria makeTerm(AlertRuleBO o) {
		Criteria cri = getSession().createCriteria(AlertRuleBO.class);
		AlertRuleBO alertRuleBo = (AlertRuleBO) o;
		if (alertRuleBo.getDeprecated() != null) {
			cri.add(Restrictions.eq("deprecated", alertRuleBo.getDeprecated()));
		}else{
			cri.add(Restrictions.eq("deprecated", 1));
		}
		return cri;
	}

	// 统计函数
	public int getCountAlertRuleDao(AlertRuleBO queryVO) {
		// TODO Auto-generated method stub
		Criteria cri = makeTerm(queryVO);
		return ((Integer) cri.setProjection(Projections.rowCount())
				.uniqueResult()).intValue();
	}

	// 删除告警规则
	public void deleteAlterRuleDao(Integer AlertRuleEntityId) {
		// TODO Auto-generated method stub
		AlertRuleBO alertRulebo = null;
		alertRulebo = getByIdAlertRuleDao(AlertRuleEntityId);
		if (alertRulebo != null) {
			alertRulebo.setDeprecated(0);
			getHibernateTemplate().update(alertRulebo);
		}
	}

	// ID 查询告警规则
	public AlertRuleBO getByIdAlertRuleDao(Integer AlertRuleEntityId) {
		return (AlertRuleBO) getHibernateTemplate().get(AlertRuleBO.class,
				AlertRuleEntityId);
	}

	// 更新告警规则
	public void updateAlterRuleDao(AlertRuleBO alertRuleboEntity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(alertRuleboEntity);
	}

	public PageResult getPageAlertRuleDao(Page page, AlertRuleBO queryVo,
			List<Domain> userToManager) {
		Criteria cri = makeTerm(queryVo);
		cri = tianjiaQuanxian(cri,userToManager);
		if(cri != null){
			if (page != null) {
				cri.setFirstResult(page.getBeginIndex());
				cri.setMaxResults(page.getEveryPage());
			}
			PageResult rs = new PageResult();
			rs.setPageList(cri.list());
			// 统计记录数
			Integer count = getCountAlertRuleDao(queryVo,userToManager);
			Page pageu = page;
			if (null != page) {
				pageu = PageUtil.createPage(page.getEveryPage(), page
						.getCurrentPage(), count);
			}
			// 封装查询结果跟 page对象
			rs.setPage(pageu);
			return rs;
		}
		return null;
	}
	
	//检索加权限
	private Criteria tianjiaQuanxian(Criteria cri,List<Domain> list) {
		if(list!=null && list.size()>0){
			List<Integer> ids = new ArrayList<Integer>();
			for(Domain d:list){
				ids.add(d.getId());
			}
			cri.add(Restrictions.in("deparmentId", ids));
			return cri;
		}
		return null;
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
	}
	// 统计函数，加权限
	public int getCountAlertRuleDao(AlertRuleBO queryVO,List<Domain> userToManager) {
		// TODO Auto-generated method stub
		Criteria cri = makeTerm(queryVO);
		cri = tianjiaQuanxian(cri,userToManager);
		if(cri != null){
			return ((Integer) cri.setProjection(Projections.rowCount())
					.uniqueResult()).intValue();
		}else{
			return 0;
		}
		
	}
}
