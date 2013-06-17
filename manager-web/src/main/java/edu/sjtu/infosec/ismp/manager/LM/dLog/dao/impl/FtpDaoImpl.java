package edu.sjtu.infosec.ismp.manager.LM.dLog.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.LM.dLog.dao.FtpDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.Ftp;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.security.Domain;

public class FtpDaoImpl extends HibernateDaoSupport implements FtpDao {

	@SuppressWarnings("unchecked")
	public List<FtpSource> getAllFtpSource(FtpSource ftpSource,
			List<Domain> domain, Integer pageNo, Integer pageRowNum)
			throws Exception {
		Criteria criteria = spliceCriteria(ftpSource,domain,pageNo,pageRowNum);
		return criteria.list();
	}

	/**
	 * spliceCriteria decription : 带分页功能的多条件查询语句拼接
	 * @param sysLogSource
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private Criteria spliceCriteria(FtpSource ftpSource,List<Domain> domain,
			Integer pageNo,Integer pageRowNum) {
		Criteria criteria = getSession().createCriteria(
				FtpSource.class);

		if (ftpSource != null) {
			// 产生范例对像
			Example example = Example.create(ftpSource);
			// 排除属性为null
			// example.excludeNone();
			// 对String属性都用模糊匹配方式
			example.enableLike(MatchMode.ANYWHERE);
			criteria.add(example);
			
			if(domain.size() > 0)
				criteria.add(Expression.in("domain",domain));
			
			criteria.addOrder(Order.desc("createTime"));
			if(ftpSource.getId() != null) {
				criteria.add(Expression.eq("id", ftpSource.getId()));
			}
		}

		// 添加分页查询条件：起始页
		if (null != pageNo) {
			criteria.setFirstResult(pageNo.intValue());
		}

		// 添加分页查询条件：每页需要显示的数目
		if (null != pageRowNum) {
			criteria.setMaxResults(pageRowNum.intValue());
		}
		return criteria;
	}

	@SuppressWarnings("unchecked")
	public List<Ftp> getFtpBySource(String HQL, Integer pageNo,
			Integer pageRowNum) throws Exception {
		Query ftpQuery = this.getSession().createQuery(HQL);
		ftpQuery.setFirstResult(pageNo);
		ftpQuery.setMaxResults(pageRowNum);
		return ftpQuery.list();
	}
}
