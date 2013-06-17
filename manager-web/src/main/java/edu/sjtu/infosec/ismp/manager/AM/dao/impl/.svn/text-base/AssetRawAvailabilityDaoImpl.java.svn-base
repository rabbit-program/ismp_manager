package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetRawAvailabilityDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDailyAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetRawAvailabilityBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.util.RandomCodeUtil;


/**
 * AssetRawAvailabilityDao接口的实现类
 * 
 * @author Breggor
 * 
 */
@SuppressWarnings("unchecked")
public class AssetRawAvailabilityDaoImpl extends HibernateDaoSupport implements
		AssetRawAvailabilityDao {
	/**
	 * 实现接口方法
	 */
	public void saveAssetRawAvailability(AssetRawAvailabilityBO entity) {
		getHibernateTemplate().save(entity);

	}

	public void saveAssetRawAvailability(List<AssetRawAvailabilityBO> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);

	}

	public void updateAssetRawAvailability(AssetRawAvailabilityBO entity) {
		getHibernateTemplate().update(entity);
	}

	public void deleteAssetRawAvailability(AssetRawAvailabilityBO entity) {
		getHibernateTemplate().delete(entity);

	}

	public AssetRawAvailabilityBO getAssetRawAvailability(Serializable entityId) {
		return (AssetRawAvailabilityBO) getHibernateTemplate().get(
				AssetRawAvailabilityBO.class, entityId);
	}

	public List<AssetRawAvailabilityBO> getListByAssetRawAvailability(
			AssetRawAvailabilityBO entity) {
		return (List<AssetRawAvailabilityBO>) spliceCriteria(entity).list();

	}

	public List<AssetRawAvailabilityBO> getPageListByAssetRawAvailability(
			Page page, AssetRawAvailabilityBO entity) {
		Criteria criteria = spliceCriteria(entity);
		if (page != null) {
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
		}
		return criteria.list();

	}

	public AssetDailyAvailabilityBO getAverageAssetRawAvailability(
			Integer assetId, Integer type, Timestamp currentDate) {
		Date startDate = new Date(currentDate.getTime() - 3600000); // 1000 * 60 * 60 * 24
		Date endDate = new Date(currentDate.getTime());

		AssetDailyAvailabilityBO assetDailyAvailability = new AssetDailyAvailabilityBO();
		assetDailyAvailability.setSingleCode(RandomCodeUtil
				.getSingleRandomCode());
		String hql = "select avg(raw.usedPercent) from AssetRawAvailabilityBO raw where raw.assetId =:assetId and raw.availabilityType =:avType and (raw.time >=:start and raw.time<:end)";

		Query query = getSession().createQuery(hql);
		query.setParameter("assetId", assetId);
		query.setParameter("avType", type);
		query.setParameter("start", startDate);
		query.setParameter("end", endDate);
		Double percent = (Double) query.uniqueResult();

		assetDailyAvailability.setAssetId(assetId);
		assetDailyAvailability.setAvailabilityType(type);
		if (percent == null)
			assetDailyAvailability.setUsedPercent(0);
		else
			assetDailyAvailability.setUsedPercent(percent.intValue());

		assetDailyAvailability.setTime(currentDate);
		return assetDailyAvailability;
	}
	public Integer getAverAssetRawAval(
			Integer assetId, Integer type, Timestamp currentDate) {
		
		Date startDate = new Date(currentDate.getTime()); // 1000 * 60 * 60 * 24
		startDate.setHours(0);
		startDate.setMinutes(0);
		startDate.setSeconds(0);
		
		Date endDate = new Date(currentDate.getTime());
		
		AssetDailyAvailabilityBO assetDailyAvailability = new AssetDailyAvailabilityBO();
//		原代码		
		assetDailyAvailability.setSingleCode(RandomCodeUtil
				.getSingleRandomCode());
		
		/*
		 * lisiwen   重写上面注释点的代码
		 */
//		assetDailyAvailability.setSingleCode(RandomCodeUtil.getRandomString(19));
//		Calendar cale = Calendar.getInstance();
//		Date tasktime=cale.getTime(); 
//		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		//存储利用率=3   网络利用率=4
		String hql = "select avg(raw.usedPercent) from AssetRawAvailabilityBO raw where raw.assetId =:assetId and raw.availabilityType =:avType and (raw.time >=:start and raw.time<:end)";
		
		System.out.println("assetId="+assetId+"，type="+type+"，startDate="+startDate+"，endDate="+endDate);
		Query query = getSession().createQuery(hql);
		query.setParameter("assetId", assetId);
		query.setParameter("avType", type);
		query.setParameter("start", startDate);
		query.setParameter("end", endDate);
		
		Object percent =query.uniqueResult();
//		System.out.println("该集合的长度是:"+percent.size());
		int percentint=10;
		if(percent==null)
		{
			percentint=-1;
		}else
		{
			
			long c=Math.round(new Double(percent.toString()));
			percentint=Integer.parseInt(Long.toString(c));
		}

//		System.out.println("percent:"+percent);
//		System.out.println("percentintCCC:"+percentint);
//		System.out.println("-----------------------------");
		
		return percentint;
	}

	public List<Integer> getHourChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>();
		Date end = new Date(date.getTime());
		Date begin = new Date(end.getYear(), end.getMonth(), end.getDate(), 0,
				0, 0);
		String hql = "select daily.time, avg(daily.totalQuantity) from AssetRawAvailabilityBO daily "
				+ "where daily.assetId = ? and daily.availabilityType = ? "
				+ "and (daily.time>= ? and daily.time<?) group by hour(daily.time)";

		Query query = getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		// System.out.println(list.size());
		int[] a = new int[24];
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Timestamp date1 = (Timestamp) obj[0];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			a[calendar.get(Calendar.HOUR_OF_DAY)] = ((Double) obj[1])
					.intValue();
		}
		data = Arrays.asList(ArrayUtils.toObject(a));
		return data;
	}

	public List<Integer> getDayChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>();
		Date end = new Date(date.getTime());
		Date begin = new Date(end.getYear(), end.getMonth(), 1, 0, 0, 0);
		String hql = "select daily.time, avg(daily.totalQuantity) from AssetRawAvailabilityBO daily "
				+ "where daily.assetId = ? and daily.availabilityType = ? "
				+ "and (daily.time>= ? and daily.time<?) group by day(daily.time)";

		Query query = getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		// System.out.println(list.size());
		int[] a = new int[31];
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Timestamp date1 = (Timestamp) obj[0];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			a[calendar.get(Calendar.DAY_OF_MONTH)] = ((Double) obj[1])
					.intValue();
		}
		data = Arrays.asList(ArrayUtils.toObject(a));
		return data;
	}

	public List<Integer> getMonthChartDataByNet(Timestamp date,
			AssetRawAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>();
		Date end = new Date(date.getTime());
		Date begin = new Date(end.getYear(), 0, 1, 0, 0, 0);
		String hql = "select daily.time, avg(daily.totalQuantity) from AssetRawAvailabilityBO daily "
				+ "where daily.assetId = ? and daily.availabilityType = ? "
				+ "and (daily.time>= ? and daily.time<?) group by month(daily.time)";

		Query query = getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		// System.out.println(list.size());
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

	public List<Integer> getHourChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>();

		Date end = new Date(date.getTime());
		Date begin = new Date(end.getYear(), end.getMonth(), end.getDate(), 0,
				0, 0);
		String hql = "select daily.time, count(daily) from AssetRawAvailabilityBO daily "
				+ "where daily.assetId = ? and daily.availabilityType != ? "
				+ "and (daily.time>= ? and daily.time<?) group by hour(daily.time)";

		Query query = getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		// System.out.println(list.size());
		int[] a = new int[24];
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Timestamp date1 = (Timestamp) obj[0];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			a[calendar.get(Calendar.HOUR_OF_DAY)] = ((Long) obj[1]).intValue();
		}
		data = Arrays.asList(ArrayUtils.toObject(a));
		return data;
	}

	public List<Integer> getDayChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>();

		Date end = new Date(date.getTime());
		Date begin = new Date(end.getYear(), end.getMonth(), 1, 0, 0, 0);
		String hql = "select daily.time, count(daily) from AssetRawAvailabilityBO daily "
				+ "where daily.assetId = ? and daily.availabilityType != ? "
				+ "and (daily.time>= ? and daily.time<?) group by day(daily.time)";

		Query query = getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		// System.out.println(list.size());
		int[] a = new int[31];
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Timestamp date1 = (Timestamp) obj[0];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			a[calendar.get(Calendar.DAY_OF_MONTH)] = ((Long) obj[1]).intValue();
		}
		data = Arrays.asList(ArrayUtils.toObject(a));
		return data;
	}

	public List<Integer> getMonthChartDataByOnline(Timestamp date,
			AssetRawAvailabilityBO entity) {
		List<Integer> data = new ArrayList<Integer>();

		Date end = new Date(date.getTime());
		Date begin = new Date(end.getYear(), 0, 1, 0, 0, 0);
		String hql = "select daily.time, count(daily) from AssetRawAvailabilityBO daily "
				+ "where daily.assetId = ? and daily.availabilityType != ? "
				+ "and (daily.time>= ? and daily.time<?) group by month(daily.time)";

		Query query = getSession().createQuery(hql);
		query.setInteger(0, entity.getAssetId());
		query.setInteger(1, entity.getAvailabilityType());
		query.setParameter(2, begin);
		query.setParameter(3, end);
		List<Object[]> list = query.list();
		// System.out.println(list.size());
		int[] a = new int[12];
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);
			Timestamp date1 = (Timestamp) obj[0];
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date1);
			a[calendar.get(Calendar.MONTH)] = ((Long) obj[1]).intValue();
		}
		data = Arrays.asList(ArrayUtils.toObject(a));
		return data;
	}
	
	
	public Integer statisticsByLocId(Integer locId, Integer deviceType) {
		String hql = "select avg(asset.usedPercent)from AssetRawAvailabilityBO asset where asset.assetId in(select device.id from AssetDeviceBO device where device.locationId=:locId and device.assetType=:assetType)";
		Query query = getSession().createQuery(hql);
		query.setParameter("locId", locId);
		query.setParameter("assetType", deviceType);
		Double usedPercent =(Double)query.uniqueResult();
		if(usedPercent == null)
			usedPercent = 0D;
		return usedPercent.intValue();
	}

	/**
	 * 生成查询条件
	 */
	private Criteria spliceCriteria(AssetRawAvailabilityBO assetRawAvailability) {
		Criteria criteria = getSession().createCriteria(
				AssetRawAvailabilityBO.class);

		if (null == assetRawAvailability) {
			return criteria;
		}
		if (null != assetRawAvailability.getId()) {
			criteria.add(Restrictions.eq("id", assetRawAvailability.getId()));
		}
		if (null != assetRawAvailability.getAssetId()) {
			criteria.add(Restrictions.eq("assetId", assetRawAvailability
					.getAssetId()));
		}
		if (null != assetRawAvailability.getAvailabilityType()) {
			criteria.add(Restrictions.eq("availabilityType",
					assetRawAvailability.getAvailabilityType()));
		}
		if (null != assetRawAvailability.getOnline()) {
			criteria.add(Restrictions.eq("online", assetRawAvailability
					.getOnline()));
		}
		if (null != assetRawAvailability.getTotalQuantity()) {
			criteria.add(Restrictions.eq("totalQuantity", assetRawAvailability
					.getTotalQuantity()));
		}
		if (null != assetRawAvailability.getUsedQuantity()) {
			criteria.add(Restrictions.eq("usedQuantity", assetRawAvailability
					.getUsedQuantity()));
		}
		if (null != assetRawAvailability.getUsedPercent()) {
			criteria.add(Restrictions.eq("usedPercent", assetRawAvailability
					.getUsedPercent()));
		}
		if (null != assetRawAvailability.getTime()) {
			criteria.add(Restrictions
					.eq("time", assetRawAvailability.getTime()));
		}
		return criteria;
	}

}
