package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetDailyAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetMonthlyAvailabilityBO;
import edu.sjtu.infosec.ismp.util.RandomCodeUtil;


/**
 * AssetDailyAvailabilityDao接口的实现类
 * 
 * @author Breggor
 * 
 */
@SuppressWarnings("unchecked")
public class AssetDailyAvailabilityDaoImpl extends HibernateDaoSupport
		implements AssetDailyAvailabilityDao {
	/**
	 * 实现接口方法
	 */
	public void saveAssetDailyAvailability(AssetDailyAvailabilityBO entity) {
		getHibernateTemplate().save(entity);

	}

	public void updateAssetDailyAvailability(AssetDailyAvailabilityBO entity) {
		getHibernateTemplate().update(entity);
	}

	public void deleteAssetDailyAvailability(AssetDailyAvailabilityBO entity) {
		getHibernateTemplate().delete(entity);

	}

	public AssetDailyAvailabilityBO getAssetDailyAvailability(
			Serializable entityId) {
		return (AssetDailyAvailabilityBO) getHibernateTemplate().get(
				AssetDailyAvailabilityBO.class, entityId);
	}

	public List<AssetDailyAvailabilityBO> getListByAssetDailyAvailability(
			AssetDailyAvailabilityBO entity) {
		return (List<AssetDailyAvailabilityBO>) spliceCriteria(entity).list();

	}

	public AssetMonthlyAvailabilityBO getAverageAssetMonthlyAvailability(
			Integer assetId, Integer type, Timestamp currentDate) {
		// 前一天时间
		Date startDate = new Date(currentDate.getTime() - 86400000);
		// 现在时间
		Date endDate = new Date(currentDate.getTime());

		AssetMonthlyAvailabilityBO entity = new AssetMonthlyAvailabilityBO();
		entity.setSingleCode(RandomCodeUtil.getSingleRandomCode());

		String hql = "select avg(daily.usedPercent) from AssetDailyAvailabilityBO daily where daily.assetId =:assetId and daily.availabilityType =:type and (daily.time>=:start and daily.time<:end)";
		Query query = getSession().createQuery(hql);
		query.setParameter("assetId", assetId);
		query.setParameter("type", type);
		query.setParameter("start", startDate);
		query.setParameter("end", endDate);
		Double percent = (Double) query.uniqueResult(); 
		
		entity.setAssetId(assetId);
		entity.setAvailabilityType(type);
		if (percent == null)
			entity.setUsedPercent(0);
		else
			entity.setUsedPercent(percent.intValue());
		entity.setTime(currentDate);
		return entity;
	};

	public List<Integer> getDayChartData(Timestamp date,
			AssetDailyAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>(); 
		Date end = new Date(date.getTime());
		Date begin = new Date(end.getYear(),end.getMonth(),end.getDate(),0,0,0); 
		String hql = "select daily.time, avg(daily.usedPercent) from AssetDailyAvailabilityBO daily "
						+ "where daily.assetId = ? and daily.availabilityType = ? "
						+ "and (daily.time>= ? and daily.time<?) group by hour(daily.time)";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		//System.out.println(list.size());
		int[] a = new int[24];
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Timestamp date1 = (Timestamp) obj[0];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			a[calendar.get(Calendar.HOUR_OF_DAY)] = ((Double) obj[1]).intValue();  
		}
		data = Arrays.asList(ArrayUtils.toObject(a));
		return data;
	}

	/**
	 * 生成查询条件
	 */
	private Criteria spliceCriteria(
			AssetDailyAvailabilityBO assetDailyAvailability) {
		Criteria criteria = getSession().createCriteria(
				AssetDailyAvailabilityBO.class);

		if (null == assetDailyAvailability) {
			return criteria;
		}
		if (null != assetDailyAvailability.getId()) {
			criteria.add(Restrictions.eq("id", assetDailyAvailability.getId()));
		}
		if (null != assetDailyAvailability.getAssetId()) {
			criteria.add(Restrictions.eq("assetId", assetDailyAvailability
					.getAssetId()));
		}
		if (null != assetDailyAvailability.getAvailabilityType()) {
			criteria.add(Restrictions.eq("availabilityType",
					assetDailyAvailability.getAvailabilityType()));
		}
		if (null != assetDailyAvailability.getUsedPercent()) {
			criteria.add(Restrictions.eq("usedPercent", assetDailyAvailability
					.getUsedPercent()));
		}
		if (null != assetDailyAvailability.getTime()) {
			criteria.add(Restrictions.eq("time", assetDailyAvailability
					.getTime()));
		}
		return criteria;
	} 
}
