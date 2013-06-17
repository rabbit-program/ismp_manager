package org.infosec.ismp.manager.rmi.db.service;

import org.infosec.ismp.manager.rmi.db.model.DatabaseResultStatus;
import org.infosec.ismp.manager.rmi.db.model.DbCollectionRmiBean;

/**
 * @author guoxianwei
 * @date 2010-12-14 下午03:17:12
 * 数据库性能收集远程调用接口
 */
public interface DbCollectionServiceMonitor {
	/**
	 * 添加需要收集数据库信息
	 * 
	 * @param 参数bean
	 */
	public void addDatabaseColletor(DbCollectionRmiBean rmiBean);

	/**
	 * 移除收集数据库信息
	 * 
	 * @param 数据库设备节点ID
	 */
	public void removeDatabaseColletor(String nodeid);

	/**
	 * 获取数据库状态信息
	 * 
	 * @return DatabaseResultStatus
	 */
	public DatabaseResultStatus getDatabaseResult(String nodeid);
}

