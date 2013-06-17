package org.infosec.ismp.manager.db;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.infosec.ismp.manager.model.db.DatabaseResultEntity;
import org.infosec.ismp.manager.rmi.db.model.DatabaseResultStatus;
import org.infosec.ismp.manager.rmi.db.model.DbCollectionRmiBean;
import org.infosec.ismp.manager.rmi.db.service.DbCollectionServiceMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guoxianwei
 * @date 2010-12-14 下午03:27:02
 * 
 *  数据库信息采集远程调用接口实现类
 *  
 */
@Component
public class DbCollectionServiceMonitorImpl implements DbCollectionServiceMonitor {
	
	private DatabaseLocator m_databaseLocator;

	@Override
	public void addDatabaseColletor(DbCollectionRmiBean rmibean) {
		m_databaseLocator.addDatabaseNode(rmibean);
	}

	@Override
	public void removeDatabaseColletor(String nodeid) {
		m_databaseLocator.removeDatabaseNode(nodeid);
	}
	
	@Autowired(required=true)
	public void setDatabaseLocator(DatabaseLocator databaseLocator) {
		m_databaseLocator = databaseLocator;
	}

	@Override
	public DatabaseResultStatus getDatabaseResult(String nodeid) {
		DatabaseResultStatus status = m_databaseLocator
				.getDatabaseResult(nodeid);
		System.out.println("-------------------------"
				+ status.getCacheHitRatio());
		System.out.println("-------------------------"
				+ status.getCacheHitRatio());
		System.out.println("-------------------------"
				+ status.getCacheHitRatio());
	
		return status;
	}
}

