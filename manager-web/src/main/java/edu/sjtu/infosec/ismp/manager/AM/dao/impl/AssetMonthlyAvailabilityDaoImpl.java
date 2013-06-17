package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetMonthlyAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;


/**
 * AssetMonthlyAvailabilityDao接口的实现类
 * 
 * @author Breggor
 * 
 */
@SuppressWarnings("unchecked")
public class AssetMonthlyAvailabilityDaoImpl extends HibernateDaoSupport
		implements AssetMonthlyAvailabilityDao {

	/**
	 * 实现接口方法
	 */
	public void saveAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity) {
		getHibernateTemplate().save(entity);

	}

	public void updateAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity) {
		getHibernateTemplate().update(entity);
	}

	public void deleteAssetMonthlyAvailability(AssetMonthlyAvailabilityBO entity) {
		getHibernateTemplate().delete(entity);
	}

	public AssetMonthlyAvailabilityBO getAssetMonthlyAvailability(
			Serializable entityId) {
		return (AssetMonthlyAvailabilityBO) getHibernateTemplate().get(
				AssetMonthlyAvailabilityBO.class, entityId);
	}

	public List<AssetMonthlyAvailabilityBO> getListByAssetMonthlyAvailability(
			AssetMonthlyAvailabilityBO entity) {
		return (List<AssetMonthlyAvailabilityBO>) spliceCriteria(entity).list();

	}

	public List<Integer> getMonthChartData(Timestamp date,
			AssetMonthlyAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>(); 
		Date end = new Date(date.getTime()); 
		Date begin = new Date(end.getYear(), end.getMonth(), 1, 0, 0, 0); 
		String hql =  
				"select monthly.time, avg(monthly.usedPercent) from AssetMonthlyAvailabilityBO monthly "
						+ "where monthly.assetId = ? and monthly.availabilityType = ? "
						+ "and (monthly.time>= ? and monthly.time< ?) group by day(monthly.time)";
		Query query =getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		//System.out.println(list.size() + "month size..........");
		int[] a = new int[31];
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Timestamp date1 = (Timestamp) obj[0];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			a[calendar.get(Calendar.DAY_OF_MONTH) - 1] = ((Double) obj[1]).intValue();
		}
		data = Arrays.asList(ArrayUtils.toObject(a));
		return data; 

	}
	public List<Integer> getYearChartData(Timestamp date,
			AssetMonthlyAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>(); 
		Date end = new Date(date.getTime()); 
		Date begin = new Date(end.getYear(), 0, 1, 0, 0, 0); 
		String hql =  
				"select monthly.time, avg(monthly.usedPercent) from AssetMonthlyAvailabilityBO monthly "
						+ "where monthly.assetId = ? and monthly.availabilityType = ? "
						+ "and (monthly.time>= ? and monthly.time< ?) group by month(monthly.time)";
		Query query =getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		//System.out.println(list.size() + "year size..........");
		int[] a = new int[12];
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Timestamp date1 = (Timestamp) obj[0];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			a[calendar.get(Calendar.MONTH)] = ((Double) obj[1]).intValue();
		}
		data = Arrays.asList(ArrayUtils.toObject(a)); 
		return data; 
	}
	

	/**
	 * 生成查询条件
	 */
	private Criteria spliceCriteria(
			AssetMonthlyAvailabilityBO assetMonthlyAvailability) {
		Criteria criteria = getSession().createCriteria(
				AssetMonthlyAvailabilityBO.class);

		if (null == assetMonthlyAvailability) {
			return criteria;
		}
		if (null != assetMonthlyAvailability.getId()) {
			criteria.add(Restrictions
					.eq("id", assetMonthlyAvailability.getId()));
		}
		if (null != assetMonthlyAvailability.getAssetId()) {
			criteria.add(Restrictions.eq("assetId", assetMonthlyAvailability
					.getAssetId()));
		}
		if (null != assetMonthlyAvailability.getAvailabilityType()) {
			criteria.add(Restrictions.eq("availabilityType",
					assetMonthlyAvailability.getAvailabilityType()));
		}
		if (null != assetMonthlyAvailability.getUsedPercent()) {
			criteria.add(Restrictions.eq("usedPercent",
					assetMonthlyAvailability.getUsedPercent()));
		}
		if (null != assetMonthlyAvailability.getTime()) {
			criteria.add(Restrictions.eq("time", assetMonthlyAvailability
					.getTime()));
		}
		return criteria;
	} 
	 
}
