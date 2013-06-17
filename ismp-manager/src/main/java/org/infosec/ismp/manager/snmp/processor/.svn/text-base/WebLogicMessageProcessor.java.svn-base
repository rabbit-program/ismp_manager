package org.infosec.ismp.manager.snmp.processor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseEntity;
import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseStatus;
import org.infosec.ismp.manager.model.snmp.WeblogicHistoryEntity;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicJdbcConnectionPoolStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicJvmStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicThreadPoolStatus;
import org.infosec.ismp.manager.snmp.SnmpDeviceConstants;
import org.infosec.ismp.manager.snmp.SnmpDeviceLocator;
import org.infosec.ismp.model.snmp.Result;
import org.infosec.ismp.model.snmp.Results;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-12-23 上午10:27:57
 *  weblogic message process
 */
public final class WebLogicMessageProcessor {
    
	//持久化类，入库
	private SnmpDeviceHistoryBaseEntity m_baseEntity = null;
	//持久化类，入库
	private List<WeblogicHistoryEntity> m_weblogicHistory = new ArrayList<WeblogicHistoryEntity>();

	public SnmpDeviceHistoryBaseStatus process(Results results) {
		SnmpDeviceHistoryBaseStatus baseStatus = null;//保存状态和持久化
		WeblogicDeviceStatus weblogicDeviceStatus = new WeblogicDeviceStatus();//状态信息，供前台调用
		if (results != null && results.getResultList() != null) {
			for (Result result : results.getResultList()) {
				if ("jvmRuntimeTable".equals(result.getTrackerName())) {
					// weblogic java Visual machine status
					weblogicDeviceStatus.setJvmStatus(convertJvmStatus(result));
				}
				if ("jdbcConnectionPoolRuntimeTable".equals(result
						.getTrackerName())) {
					// weblogic JdbcConnectionPool status
					weblogicDeviceStatus
							.setJdbcConnectionPoolStatus(convertJdbcConnectionPoolStatus(result));
				}
				if ("threadPoolRuntimeTable".equals(result.getTrackerName())) {
					// weblogic ThreadPool status

					weblogicDeviceStatus
							.setThreadPoolStatus(convertThreadPoolStatus(result));
				}
			}
		}
		if (!m_weblogicHistory.isEmpty()) {
			baseStatus = new SnmpDeviceHistoryBaseStatus();
			copyProperties(results.getNodeid(), results.getIpAddr(),results.getBrand());
			baseStatus.setSnmpDeviceHistoryBaseEntity(m_baseEntity);
			weblogicDeviceStatus.setActive(true);
			weblogicDeviceStatus.setIpAddr(results.getIpAddr());
			weblogicDeviceStatus.setDomain(SnmpDeviceLocator.getDomainId(results.getNodeid()));
			weblogicDeviceStatus.setNodeid(results.getNodeid());
			baseStatus.setWeblogicDeviceStatus(weblogicDeviceStatus);
		}
		return baseStatus;
	}

	private List<WeblogicJvmStatus> convertJvmStatus(Result result) {
		List<WeblogicJvmStatus> jvmStatusList = new ArrayList<WeblogicJvmStatus>();
		for (Map<String, Object> properties : result.getListResults()) {
			WeblogicJvmStatus bean = new WeblogicJvmStatus();
			populate(bean, properties);
			log().info(bean.toString());
			jvmStatusList.add(bean);
			// 加入到历史信息集合，便于后面存入DB
			m_weblogicHistory.add(converHostHistory(properties,
					SnmpDeviceConstants.JVM_WEBLOGIC));
		}
		return jvmStatusList;
	}

	private List<WeblogicJdbcConnectionPoolStatus> convertJdbcConnectionPoolStatus(
			Result result) {
		List<WeblogicJdbcConnectionPoolStatus> poolList = new ArrayList<WeblogicJdbcConnectionPoolStatus>();
		for (Map<String, Object> properties : result.getListResults()) {
			WeblogicJdbcConnectionPoolStatus bean = new WeblogicJdbcConnectionPoolStatus();
			populate(bean, properties);
			log().info(bean.toString());
			poolList.add(bean);
			// 加入到历史信息集合，便于后面存入DB
			m_weblogicHistory.add(converHostHistory(properties,
					SnmpDeviceConstants.JDBC_CONN_POOL_WEBLOGIC));
		}
		return poolList;

	}

	private List<WeblogicThreadPoolStatus> convertThreadPoolStatus(Result result) {
		List<WeblogicThreadPoolStatus> threadPoolList = new ArrayList<WeblogicThreadPoolStatus>();
		for (Map<String, Object> properties : result.getListResults()) {
			WeblogicThreadPoolStatus bean = new WeblogicThreadPoolStatus();
			populate(bean, properties);
			log().info(bean.toString());
			threadPoolList.add(bean);
			// 加入到历史信息集合，便于后面存入DB
			m_weblogicHistory.add(converHostHistory(properties,
					SnmpDeviceConstants.THREAD_POOL_WEBLOGIC));
		}
		return threadPoolList;

	}
	private WeblogicHistoryEntity converHostHistory(
			Map<String, Object> map, String type) {
		WeblogicHistoryEntity bean = new WeblogicHistoryEntity();
		int keyindex = 1;
		for (Entry<String, Object> entry : map.entrySet()) {
			bean.setKey(String.valueOf(entry.getKey()));
			bean.setValue(String.valueOf(entry.getValue()));
			bean.setKeyindex(keyindex++);
			bean.setDeviceType(type);
		}
		bean.setTime(new Date());
		return bean;
	}
	private void populate(Object bean, Map<String, Object> properties) {
		try {
			BeanUtils.populate(bean, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
    //属性赋值
	private void copyProperties(String nodeid, String ipAddr,String brand) {
		m_baseEntity = new SnmpDeviceHistoryBaseEntity();
		m_baseEntity.setWeblogicHistory(m_weblogicHistory);
		m_baseEntity.setNodeid(nodeid);
		m_baseEntity.setIpAddr(ipAddr);
		m_baseEntity.setType(brand);
		m_baseEntity.setDomain(SnmpDeviceLocator.getDomainId(nodeid));
		m_baseEntity.setTime(new Date());
	}
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}

