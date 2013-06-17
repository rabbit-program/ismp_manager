package org.infosec.ismp.manager.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.infosec.ismp.manager.ComponentLocator;
import org.infosec.ismp.manager.db.dao.DatabaseNodeEntityService;
import org.infosec.ismp.manager.db.task.DatabaseNode;
import org.infosec.ismp.manager.domains.DomainComponent;
import org.infosec.ismp.manager.domains.DomainLocator;
import org.infosec.ismp.manager.model.DatabaseNodeEntity;
import org.infosec.ismp.manager.model.db.DatabaseResultEntity;
import org.infosec.ismp.manager.rmi.db.model.DatabaseResultStatus;
import org.infosec.ismp.manager.rmi.db.model.DbCollectionRmiBean;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 是添加Database任务的入口类
 * @author lianglin
 *
 */
@Component
public class DatabaseLocator implements ComponentLocator{

	
	/**
	 * nodeid<->domain
	 */
	private Map<String, DomainComponent> nodeidMaps = new HashMap<String, DomainComponent>();

	private DatabaseNodeEntityService m_databaseNodeEntityService;
	private DomainLocator m_domainLocator;

	
	@Autowired(required = true)
	public void setDatabaseNodeEntityService(DatabaseNodeEntityService databaseNodeEntityService) {
		m_databaseNodeEntityService = databaseNodeEntityService;
	}

	@Autowired(required = true)
	public void setDomainLocator(DomainLocator domainLocator) {
		m_domainLocator = domainLocator;
	}

	public DatabaseLocator() {
	}

	@PostConstruct
	public void init() {
		System.out.println("Database Locator 开始初始化");
		Assert.state(m_databaseNodeEntityService != null, "m_DatabaseDao不能为空，请检查");
		Assert.state(m_domainLocator != null, "m_domainLocator不能为空，请检查");
		distruteAllDatabaseNode();
	}

	public List<DatabaseNodeEntity> getAllDatabaseNode() {
		List<DatabaseNodeEntity> entites = m_databaseNodeEntityService.getAll();
		return entites;
	}

	public void distruteAllDatabaseNode() {
		List<DatabaseNodeEntity> entities = getAllDatabaseNode();
		for (DatabaseNodeEntity entity : entities) {
			addDatabaseNodeToDomain(entity);
		}
	}

	public void addDatabaseNode(DbCollectionRmiBean rmibean) {
		DatabaseNodeEntity entity = new DatabaseNodeEntity();
		copyDatabaseNodeProperties(entity, rmibean);
		addDatabaseNodeToDb(entity);
		addDatabaseNodeToDomain(entity);
	}

	/**
	 * 将Database任务添加到domainComponent
	 * @param DatabaseNodeEntity
	 */
	private void addDatabaseNodeToDomain(DatabaseNodeEntity entity) {
		DomainComponent domainComp = m_domainLocator
				.createDomainIfNessary(entity.getDomain());
		log().info("wait for put dbcollect task into domain.");
		nodeidMaps.put(entity.getNodeid(), domainComp);
		log().info("put dbcollect task into domain success");
		DatabaseNode node = createDatabaseNode(entity);
		log().info("wait for send dbcollect task to remote agent");
		domainComp.addJdbcNode(node);
		log().info("send dbcollect task to remote agent success");
	}
	
	protected DatabaseNode createDatabaseNode(DatabaseNodeEntity entity){
		DatabaseNode node = new DatabaseNode();
		copyDatabaseNodeProperties(node, entity);
		return node;
	}

	private void addDatabaseNodeToDb(DatabaseNodeEntity entity ) {
		m_databaseNodeEntityService.save(entity);
	}

	public void removeDatabaseNode(String nodeid) {
		removeDatabaseNodeFromDb(nodeid);
		removeDatabaseNodeFromDomain(nodeid);
	}

	private void removeDatabaseNodeFromDomain(String nodeid) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
				domainComp.removeDatabaseCollectionNode(nodeid);
		} else {
			if (log().isDebugEnabled()) {
				log().debug("removeDatabaseNode没有找到该nodeId：" + nodeid + "对应的域 ");
			}
		}
	}
	//bean属性值拷贝
	private void copyDatabaseNodeProperties(Object dest, Object orig) {
		try {
			org.apache.commons.beanutils.PropertyUtils.copyProperties(dest,
					orig);
		} catch (Exception e) {
			log().debug("DatabaseLocator : the caller does not have access to the property accessor method",
							e);
		}

	}
	/**
	 * 用nodeid做索引存储database采集结果到内存域中。
	 * @param nodeid
	 * @param entity
	 */
	public void setDatabaseResult(String nodeid, DatabaseResultStatus status) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.putDatabaseResult(nodeid,status);
		}
		
	}
	public DatabaseResultStatus getDatabaseResult(String nodeid) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			return domainComp.getDatabaseResult(nodeid);
		}
		return null;
	}
	private void removeDatabaseNodeFromDb(String nodeid) {
		m_databaseNodeEntityService.removeDatabaseNodeByNodeId(nodeid);
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
