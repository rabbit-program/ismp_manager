package edu.sjtu.infosec.ismp.manager.AIM.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import edu.sjtu.infosec.ismp.manager.AIM.comm.AlertQueryVO;
import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertDao;
import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertDwrDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.UserDao;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.User;

import uk.ltd.getahead.dwr.WebContextFactory;


public class AlertDwrDaoImpl extends HibernateDaoSupport implements AlertDwrDao {

	// 注入AlertDao 接口

	private AlertDao alertDao;
	private UserDao userdao;

	public void setAlertDao(AlertDao alertDao) {
		this.alertDao = alertDao;
	}

	//检索加权限
	private Criteria tianjiaQuanxian(Criteria cri,List<Domain> list) {
//		if(userToManager != null && userToManager.trim().length()!=0){
//			String[] mStr = userToManager.split(",");
//			List<Integer> ids = new ArrayList<Integer>();
//			if (mStr != null && mStr.length > 0) {
//				for (String mid : mStr) {
//					if(mid!=null || !mid.trim().equals("")){
//						ids.add(Integer.parseInt(mid));
//					}
//				}
//			}
//			cri.add(Restrictions.in("deparmentId", ids));
//			return cri;
//		}
		if(list!=null && list.size()>0){
			List<Integer> ids = new ArrayList<Integer>();
			for(Domain domain : list){
				ids.add(domain.getId());
			}
			cri.add(Restrictions.in("domain", ids));
		}
		return cri;
	}
	

	// 暴露给DWR 的用于检查
	public int getChecknNewAlertinfoDao(String loginTime) {
		if (loginTime != null) {
			Timestamp time = Timestamp.valueOf(loginTime);
			Criteria cri = getSession().createCriteria(AlertInfoBO.class);
			HttpSession session = WebContextFactory.get().getSession(); 
			//加权限
			OperatorDetails users = SecurityUserHolder.getCurrentUser();
//			edu.sjtu.infosec.ismp.security.User user = userdao.getUserinfoByNameDao(users.getUsername());
			List list = new ArrayList();
			cri.add(Restrictions.gt("time", Timestamp.valueOf(loginTime)));
			if(!(users.getUsername().equals("admin"))){    
//				String userToManager = users.getRoleList();
				List<Domain> listdomain = users.getDomainList();
				cri = tianjiaQuanxian(cri,listdomain);
			}
			if(cri!=null){
				return ((Integer) cri.setProjection(Projections.rowCount())
						.uniqueResult()).intValue();
			}
			return 0;
		}
		return 0;

	}

	public List getPageListAlertDwrDao(int curpage, String pagesize,
			String status, String type, String subType, String fusioin,
			String logintime) {
		// TODO Auto-generated method stub
		// 设置查询条件
		AlertQueryVO alertquer = new AlertQueryVO();
		Page page = new Page();
		// 初始化为每页10条
		page.setEveryPage(10);
		if (pagesize != null && !pagesize.equals("")) {
			page.setEveryPage(Integer.parseInt(pagesize));
		}
		page.setBeginIndex((curpage - 1) * page.getEveryPage());
		page.setCurrentPage(curpage);
		// 当前页等于空的时候
		if (curpage <= 0) {
			curpage = 1;
		}

		if (status != null && !status.equals("")) {
			alertquer.setStatus(Integer.parseInt(status));
		}
		if (type != null && !type.equals("")) {
			alertquer.setAlertType(type);
		}
		if (subType != null && !subType.equals("")) {
			alertquer.setAlertSubType(subType);
		}
		if (fusioin != null && !fusioin.equals("")) {
			alertquer.setTimedifference(Long.parseLong(fusioin));
		}
		if (logintime != null && logintime.trim().length() > 0) {
			alertquer.setLogintime(logintime);
		}
//		HttpSession session = WebContextFactory.get().getSession(); 
		//加权限
//		User user = (User) session.getAttribute("userbo");
		OperatorDetails users = SecurityUserHolder.getCurrentUser();
//		edu.sjtu.infosec.ismp.security.User user = userdao.getUserinfoByNameDao(users.getUsername());
		List list = new ArrayList();
		if(users.getUsername().equals("admin")){
			PageResult rs = alertDao.getListPageAlertDao(page, alertquer);
			list.add(0, rs.getPageList());
			list.add(1, rs.getPage());
		}else{
//			String userToManager = user.getRoleNames();
			List<Domain> listDomain = users.getDomainList();
			PageResult rs = alertDao.getListPageAlertDao(page, alertquer,listDomain);
			list.add(0, rs.getPageList());
			list.add(1, rs.getPage());
		}
		return list;
	}

	// 根据父名称 查询所有的子类型
	public List<AlertTypeBO> getSubTypeByNameDao(String parentName) {
		String Hql = "from AlertTypeBO where parentId in (select id from AlertTypeBO where typeName='"
				+ parentName + "') and typeMarker=2";
		Query query = getSession().createQuery(Hql);
		return query.list();
	}
	
	//根据父类ID 查询子类型
	
	public List<AlertTypeBO> getSubTypeByParentId(Integer id){
		String hql = "from AlertTypeBO where parentId = :pid";
		Query query = getSession().createQuery(hql);
		query.setInteger("pid", id);
		return query.list();
	}

	public List getUserPageListDao(String userName, String trueName,
			int currPage) {
		// 先计算出最大记录数
		Criteria cri = getCriteriaSplit(userName, trueName);
//		Integer maxPageSize = (Integer) cri.setProjection(Projections.rowCount()).uniqueResult();
		int maxPageSize = ((Integer) cri.setProjection((Projections.rowCount())).uniqueResult()).intValue();
						  
		// 查询当前页数需要数据
		Criteria cri1 = getCriteriaSplit(userName, trueName);
		Page page = new Page();
		if (currPage <= 0) {
			currPage = 1;
		}
		page.setCurrentPage(currPage);
		cri1.setFirstResult((currPage - 1) * page.getEveryPage());
		cri1.setMaxResults(page.getEveryPage());
		List list = new ArrayList();
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(),
				maxPageSize);
		list.add(0, cri1.list());
		list.add(1, page);
		return list;
	}

	private Criteria getCriteriaSplit(String userName, String trueName) {
		Criteria cri = getSession().createCriteria(User.class);
		if (userName != null && userName.trim().length() > 0) {
			cri.add(Restrictions.like("username",  "%"+userName+"%"));
		}
		if (trueName != null && trueName.trim().length() > 0) {
			cri.add(Restrictions.like("soothname", "%"+trueName+"%"));
		}
		return cri;
	}

}
