package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.comm.AssetConstant;
import edu.sjtu.infosec.ismp.manager.AM.dao.AssetDeviceDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.DeviceChartVO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.security.Domain;

public class AssetDeviceDaoImpl extends HibernateDaoSupport implements AssetDeviceDao {

	public void add(AssetDeviceBO assetDevice) throws Exception {
		getHibernateTemplate().saveOrUpdate(assetDevice);
	}

	public void delete(AssetDeviceBO assetDevice) throws Exception {
		getHibernateTemplate().delete(assetDevice);
	}

	public void update(AssetDeviceBO assetDevice) throws Exception {
		getHibernateTemplate().update(assetDevice);
		getHibernateTemplate().flush();
	}
	
	
	public AssetDeviceBO getByNodeId(String nodeid) throws Exception{
		Criteria criteria = this.getSession().createCriteria(AssetDeviceBO.class);
		criteria.add(Restrictions.eq("node_id", nodeid));
		AssetDeviceBO assetDeviceBO = (AssetDeviceBO)criteria.uniqueResult();
		return assetDeviceBO;
	}
	
	

	@SuppressWarnings("unchecked")
	public List<AssetDeviceBO> findAll() throws Exception {
		String hql = "from AssetDeviceBO ad where 1=1 ";
		hql = hql + " order by ad.ip";
		
		List<AssetDeviceBO> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<AssetDeviceBO> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from AssetDeviceBO ad where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ad.updateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ad.updateTime<='"+endRecordTime+"' ";
		}
		
		hql = hql + " order by ad.ip";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<AssetDeviceBO> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<AssetDeviceBO> findAllByDomain(List<Domain> domainList)
			throws Exception {
		String hql = "from AssetDeviceBO ad where 1=1 ";
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ad.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ad.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by ad.ip";
		
		List<AssetDeviceBO> list = getHibernateTemplate().find(hql);
		return list;
	}
	/**
	 * 资产统计数据
	 */
	public DeviceChartVO getDeviceChartData(int year, AssetDeviceBO deviceBO) {
		DeviceChartVO chartVo = new DeviceChartVO();
		Map<Integer, Integer> dataMap = new HashMap<Integer, Integer>();
		// 当前时间
		Date now = new Date();
		now.setSeconds(0);
		if (year > 0) {
			now.setYear(now.getYear() - year);
			now.setMonth(0);
			now.setDate(1);
			now.setHours(0);
			now.setSeconds(0);
			now.setMinutes(0);
		}

		List<AssetDeviceBO> assetList = getListByAssetDevice(deviceBO);

		// 网络设备类别
		int netCount = 0;
		if (assetList != null && !assetList.isEmpty()) {
			for (int i = 0; i < assetList.size(); i++) {
				AssetDeviceBO device = (AssetDeviceBO) assetList.get(i);
				if (device.getAssetType() != null
						&& device.getAssetType().equals(
								AssetConstant.NETWORK_DEVICE_TYPE)) {
					if (device.getStockTime() != null
							&& device.getValidityPeriod() != null) {
						// System.out.println(device.getStockTime()
						// + "   ::::::stocktime");
						// System.out.println(device.getValidityPeriod()
						// + "   ::::Validityperiod");
						if (device.getStockTime().getTime() < now.getTime()) {
							Calendar cal = Calendar.getInstance();
							cal.setTime(device.getStockTime());
							cal.add(Calendar.MONTH, device.getValidityPeriod());
							// System.out.println(cal.getTime().toLocaleString()
							// + "stocktime + Validityperiod ");
							if (cal.getTime().after(now)) {
								netCount++;
							}
						}
						// System.out.println(cal.getTime().toLocaleString());
					}
				}
			}
		}
		dataMap.put(AssetConstant.NETWORK_DEVICE_TYPE, netCount);

		// 安全设备类别
		int secCount = 0;
		if (assetList != null && !assetList.isEmpty()) {
			for (int i = 0; i < assetList.size(); i++) {
				AssetDeviceBO device = (AssetDeviceBO) assetList.get(i);
				if (device.getAssetType() != null
						&& device.getAssetType().equals(
								AssetConstant.SECURITY_DEVICE_TYPE)) {
					if (device.getStockTime() != null
							&& device.getValidityPeriod() != null) {
						// System.out.println(device.getStockTime() +
						// "   ::::::stocktime");
						// System.out.println(device.getValidityPeriod() +
						// "   ::::Validityperiod");
						if (device.getStockTime().getTime() < now.getTime()) {
							Calendar cal = Calendar.getInstance();
							cal.setTime(device.getStockTime());
							cal.add(Calendar.MONTH, device.getValidityPeriod());
							if (cal.getTime().after(now)) {
								secCount++;
							}
							//System.out.println(cal.getTime().toLocaleString())
							// ;
						}
					}
				}
			}
		}
		dataMap.put(AssetConstant.SECURITY_DEVICE_TYPE, secCount);

		// 服务器类别
		int serverCount = 0;
		if (assetList != null && !assetList.isEmpty()) {
			for (int i = 0; i < assetList.size(); i++) {
				AssetDeviceBO device = (AssetDeviceBO) assetList.get(i);
				if (device.getAssetType() != null
						&& device.getAssetType().equals(
								AssetConstant.SERVER_DEVICE_TYPE)) {
					if (device.getStockTime() != null
							&& device.getValidityPeriod() != null) {
						// System.out.println(device.getStockTime() +
						// "   ::::::stocktime");
						// System.out.println(device.getValidityPeriod() +
						// "   ::::Validityperiod");
						if (device.getStockTime().getTime() < now.getTime()) {
							Calendar cal = Calendar.getInstance();
							cal.setTime(device.getStockTime());
							cal.add(Calendar.MONTH, device.getValidityPeriod());
							if (cal.getTime().after(now)) {
								serverCount++;
							}
							//System.out.println(cal.getTime().toLocaleString())
							// ;
						}
					}
				}
			}
		}
		dataMap.put(AssetConstant.SERVER_DEVICE_TYPE, serverCount);

		// 终端pc类别
		int terminCount = 0;
		if (assetList != null && !assetList.isEmpty()) {
			for (int i = 0; i < assetList.size(); i++) {
				AssetDeviceBO device = (AssetDeviceBO) assetList.get(i);
				if (device.getAssetType() != null
						&& device.getAssetType().equals(
								AssetConstant.TERMINAL_DEVICE_TYPE)) {
					if (device.getStockTime() != null
							&& device.getValidityPeriod() != null) {
						// System.out.println(device.getStockTime() +
						// "   ::::::stocktime");
						// System.out.println(device.getValidityPeriod() +
						// "   ::::Validityperiod");
						if (device.getStockTime().getTime() < now.getTime()) {
							Calendar cal = Calendar.getInstance();
							cal.setTime(device.getStockTime());
							cal.add(Calendar.MONTH, device.getValidityPeriod());
							if (cal.getTime().after(now)) {
								terminCount++;
							}
							//System.out.println(cal.getTime().toLocaleString())
							// ;
						}
					}
				}
			}
		}
		dataMap.put(AssetConstant.TERMINAL_DEVICE_TYPE, terminCount);
		chartVo.setDataMap(dataMap);
		chartVo.setYear(new Timestamp(now.getTime()));

		return chartVo;

	}
	
	public List<AssetDeviceBO> getListByAssetDevice(AssetDeviceBO entity) {
		return (List<AssetDeviceBO>) termMaker(entity).list();
	}

	@SuppressWarnings("unchecked")
	public List<AssetDeviceBO> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult) throws Exception {
		String hql = "from AssetDeviceBO ad where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ad.updateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ad.updateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ad.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ad.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}
		
		hql = hql + " order by ad.ip";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<AssetDeviceBO> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from AssetDeviceBO ad where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ad.updateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ad.updateTime<='"+endRecordTime+"' ";
		}

		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		String hql = "select count(id) from AssetDeviceBO ad where 1=1 ";
		
		if(startRecordTime != null){
			hql = hql + " and ad.updateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ad.updateTime<='"+endRecordTime+"' ";
		}
		
		int i = 0;
		for(Domain domain : domainList){
			if(i == 0){
				hql = hql + " and (ad.domain.id=" + domain.getId();
			}
			if(i > 0){
				hql = hql + " or ad.domain.id=" + domain.getId();
			}
			i++;
		}
		if(i > 0){
			hql = hql + ") ";
		}

		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	public AssetDeviceBO findById(int id) {
		AssetDeviceBO assetDevice = (AssetDeviceBO)getHibernateTemplate().get(AssetDeviceBO.class, id);
		return assetDevice;
	}

	@SuppressWarnings("unchecked")
	public List<AssetDeviceBO> findAllByUnknowDomain() throws Exception {
		String hql = "from AssetDeviceBO ad where ad.domain.id is null ";
		hql = hql + " order by ad.ip";
		
		List<AssetDeviceBO> list = getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<AssetDeviceBO> findAllByUnknowDomain(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		String hql = "from AssetDeviceBO ad where ad.domain.id is null ";
		
		if(startRecordTime != null){
			hql = hql + " and ad.updateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ad.updateTime<='"+endRecordTime+"' ";
		}

		hql = hql + " order by ad.ip";
		
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(startResult);
		query.setMaxResults(maxResult);
		List<AssetDeviceBO> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public long findAllNumByUnknowDomain(Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		String hql = "select count(id) from AssetDeviceBO ad where ad.domain.id is null ";
		
		if(startRecordTime != null){
			hql = hql + " and ad.updateTime>='"+startRecordTime+"' ";
		}
		if(endRecordTime != null){
			hql = hql + " and ad.updateTime<='"+endRecordTime+"' ";
		}
		
		List<Long> list = getHibernateTemplate().find(hql);
		long num = 0;
		if(list!=null && list.size()>0){
			num = list.get(0);
		}
		return num;
	}

	public List<AssetDeviceBO> getPageListByAssetDevice(
			AssetDeviceBO assetDeviceBO, Page page,List<Integer> list) {
		Criteria criteria = this.termMaker(assetDeviceBO);
		if(list!=null && list.size()>0){
			criteria.add(Restrictions.in("locationId", list));
		}
//		int count = ((Integer)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		int count = getCountByAssetDevice(assetDeviceBO);
		page.setTotalCount(count);
		criteria.setFirstResult(page.getBeginIndex());
		criteria.setMaxResults(page.getEveryPage());
		return criteria.list();
	}
	
	Criteria termMaker(AssetDeviceBO assetDeviceBO){
		Criteria criteria = this.getSession().createCriteria(AssetDeviceBO.class);
		if(assetDeviceBO!=null){
			if(assetDeviceBO.getDomain()!=null && assetDeviceBO.getDomain().getId()==0){
				criteria.add(Restrictions.isNull("locationId"));
			}
			if (null != assetDeviceBO.getId()) {
				criteria.add(Restrictions.eq("id", assetDeviceBO.getId()));
			}
			if (null != assetDeviceBO.getPriority()) {
				criteria
						.add(Restrictions.eq("priority", assetDeviceBO.getPriority()));
			}
			if (null != assetDeviceBO.getSn()
					&& assetDeviceBO.getSn().trim().length() > 0) {
				criteria.add(Restrictions.like("sn", "%"
						+ assetDeviceBO.getSn().trim() + "%"));
			}
			if (null != assetDeviceBO.getCheckAvailable()) {
				criteria.add(Restrictions.eq("checkAvailable", assetDeviceBO
						.getCheckAvailable()));
			}
			if (null != assetDeviceBO.getName()
					&& assetDeviceBO.getName().trim().length() > 0) {
				criteria.add(Restrictions.like("name", "%"
						+ assetDeviceBO.getName().trim() + "%"));
			}
			if (null != assetDeviceBO.getAssetType()) {
				criteria.add(Restrictions.eq("assetType", assetDeviceBO
						.getAssetType()));
			}
			if (null != assetDeviceBO.getIp()
					&& assetDeviceBO.getIp().trim().length() > 0) {
				criteria.add(Restrictions.like("ip", "%"
						+ assetDeviceBO.getIp().trim() + "%"));
			}
			if (null != assetDeviceBO.getMac()
					&& assetDeviceBO.getMac().trim().length() > 0) {
				criteria.add(Restrictions.like("mac", "%"
						+ assetDeviceBO.getMac().trim() + "%"));
			}
			if (null != assetDeviceBO.getManufacturer()
					&& assetDeviceBO.getManufacturer().trim().length() > 0) {
				criteria.add(Restrictions.like("manufacturer", "%"
						+ assetDeviceBO.getManufacturer().trim() + "%"));
			}
			if (null != assetDeviceBO.getModel()
					&& assetDeviceBO.getModel().trim().length() > 0) {
				criteria.add(Restrictions.like("model", "%"
						+ assetDeviceBO.getModel().trim() + "%"));
			}
			if (null != assetDeviceBO.getDescription()
					&& assetDeviceBO.getDescription().trim().length() > 0) {
				criteria.add(Restrictions.like("description", "%"
						+ assetDeviceBO.getDescription().trim() + "%"));
			}
			if (null != assetDeviceBO.getUser()
					&& assetDeviceBO.getUser().trim().length() > 0) {
				criteria.add(Restrictions.like("user", "%"
						+ assetDeviceBO.getUser().trim() + "%"));
			}
			if (null != assetDeviceBO.getTelephone()
					&& assetDeviceBO.getTelephone().trim().length() > 0) {
				criteria.add(Restrictions.like("telephone", "%"
						+ assetDeviceBO.getTelephone().trim() + "%"));
			}
			if (null != assetDeviceBO.getUnit()
					&& assetDeviceBO.getUnit().trim().length() > 0) {
				criteria.add(Restrictions.like("unit", "%"
						+ assetDeviceBO.getUnit().trim() + "%"));
			}
			if (null != assetDeviceBO.getDepartment()
					&& assetDeviceBO.getDepartment().trim().length() > 0) {
				criteria.add(Restrictions.like("department", "%"
						+ assetDeviceBO.getDepartment().trim() + "%"));
			}
			if (null != assetDeviceBO.getStatus()) {
				criteria.add(Restrictions.eq("status", assetDeviceBO.getStatus()));
			}
			if (null != assetDeviceBO.getStockTime()) {
				criteria.add(Restrictions.eq("stockTime", assetDeviceBO
						.getStockTime()));
			}
			if (null != assetDeviceBO.getValidityPeriod()) {
				criteria.add(Restrictions.eq("validityPeriod", assetDeviceBO
						.getValidityPeriod()));
			}
			if (null != assetDeviceBO.getRegistrationTime()) {
				criteria.add(Restrictions.eq("registrationTime", assetDeviceBO
						.getRegistrationTime()));
			}
			if (null != assetDeviceBO.getLocationId()) {
				criteria.add(Restrictions.eq("locationId", assetDeviceBO
						.getLocationId()));
			} 
		}
		return criteria;
	}

	public int getCountByAssetDevice(AssetDeviceBO assetDeviceBO) {
		Criteria criteria = this.termMaker(assetDeviceBO);
		return ((Integer)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}

}
