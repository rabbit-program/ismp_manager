package org.infosec.ismp.manager.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.infosec.ismp.manager.db.dao.DatabaseResultService;
import org.infosec.ismp.manager.model.db.DatabaseResultEntity;
import org.infosec.ismp.manager.model.db.DeadLockEntity;
import org.infosec.ismp.manager.model.db.ProcessMemoryEntity;
import org.infosec.ismp.manager.model.db.WorkspaceEntity;
import org.infosec.ismp.manager.rmi.db.model.DatabaseResultStatus;
import org.infosec.ismp.manager.rmi.db.model.DeadLock;
import org.infosec.ismp.manager.rmi.db.model.ProcessMemory;

import org.infosec.ismp.model.db.status.OracleDeadLock;
import org.infosec.ismp.model.db.status.OracleProcessMemory;
import org.infosec.ismp.model.db.status.Status;
import org.infosec.ismp.model.db.status.Workspace;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guoxianwei
 * @date 2010-12-15 下午06:52:43
 * 
 *       Oracle 数据库JMS监听器。用于监听从Agent发来的信息。
 * 
 */
@Component
public class OracleMessageListener implements MessageListener {

	private DatabaseResultService m_databaseResultService;

	private DatabaseLocator m_databaseLocator;

	final ThreadCategory logger = ThreadCategory.getInstance(getClass());

	@Autowired(required = true)
	public void setDatabaseResultService(
			DatabaseResultService databaseResultService) {
		m_databaseResultService = databaseResultService;
	}

	@Autowired(required = true)
	public void setDatabaseLocator(DatabaseLocator databaseLocator) {
		m_databaseLocator = databaseLocator;
	}

	@Override
	public void onMessage(Message message) {
		ObjectMessage msg = (ObjectMessage) message;
        logger.info("oraclelistener wait receive remote jms");
		try {
			Status result = (Status) msg.getObject();
			DatabaseResultEntity dbResult = new DatabaseResultEntity();
			dbResult.setNodeid(result.getNodeid());
			dbResult.setCacheHitRatio(result.getCacheHitRatio());
			dbResult.setCpuBusyRatio(result.getCpuBusyRatio());
			dbResult.setSessionNum(result.getSessionNum());
			dbResult.setTransactionNum(result.getTransactionNum());
			dbResult.setType(result.getType());
			List<DeadLockEntity> deadLockList = deadLockList(result
					.getOracleDeadLocks());
			List<ProcessMemoryEntity> processMemorykList = processMemoryList(result
					.getOracleProcessMemories());
			List<WorkspaceEntity> workspaceList = workspaceList(result
					.getWorkspaces());
			dbResult.setDeadLocks(deadLockList);
			dbResult.setWorkspaces(workspaceList);
			dbResult.setProcessMemories(processMemorykList);
			dbResult.setNodeid(result.getNodeid());
			dbResult.setCreateTime(new Date());
			// 存库操作
			logger.info("save receive oracle message into database");
			m_databaseResultService.saveDatabaseResult(dbResult);
			logger.info("put receive oracle message into domain");
			// 缓存数据供前台调用
			DatabaseResultStatus status = databaseResultStatus(result);
//			try {
////				PropertyUtils.copyProperties(status, dbResult);
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
//				e.printStackTrace();
//			}
			m_databaseLocator.setDatabaseResult(result.getNodeid(), status);
		} catch (JMSException e) {
			logger.debug("OracleMessageListener receive jms occured exception",
					e);
		}
	}
    private DatabaseResultStatus databaseResultStatus(Status result){
    	DatabaseResultStatus dbResult = new DatabaseResultStatus();
		dbResult.setNodeid(result.getNodeid());
		dbResult.setCacheHitRatio(result.getCacheHitRatio());
		dbResult.setCpuBusyRatio(result.getCpuBusyRatio());
		dbResult.setSessionNum(result.getSessionNum());
		dbResult.setTransactionNum(result.getTransactionNum());
		dbResult.setType(result.getType());
		List<DeadLock> deadLockList = deadLockLists(result
				.getOracleDeadLocks());
		List<ProcessMemory> processMemorykList = processMemoryLists(result
				.getOracleProcessMemories());
		List<org.infosec.ismp.manager.rmi.db.model.Workspace> workspaceList = workspaceLists(result
				.getWorkspaces());
		dbResult.setDeadLocks(deadLockList);
		dbResult.setWorkspaces(workspaceList);
		dbResult.setProcessMemories(processMemorykList);
		dbResult.setNodeid(result.getNodeid());
		dbResult.setCreateTime(new Date());
		return dbResult;
    }
	// 根据AGENT发来的数据组装List<DeadLockEntity>
	private List<DeadLockEntity> deadLockList(List<OracleDeadLock> deadlocks) {
		List<DeadLockEntity> deadLockList = new ArrayList<DeadLockEntity>();
		if(deadlocks != null){
			for (OracleDeadLock oDeadLock : deadlocks) {
				DeadLockEntity deadLock = new DeadLockEntity();
				try {
					org.apache.commons.beanutils.PropertyUtils.copyProperties(
							deadLock, oDeadLock);
				} catch (Exception e) {
					logger.debug("Copy deadLock occured exception :", e);
				}
				deadLockList.add(deadLock);
			}
		}

		return deadLockList;
	}

	// 根据AGENT发来的数据组装List<WorkspaceEntity>
	private List<WorkspaceEntity> workspaceList(List<Workspace> workspaces) {
		List<WorkspaceEntity> workspaceList = new ArrayList<WorkspaceEntity>();
		if(workspaces !=null){
			for (Workspace oWorkspace : workspaces) {
				WorkspaceEntity workspace = new WorkspaceEntity();
				try {
					org.apache.commons.beanutils.PropertyUtils.copyProperties(
							workspace, oWorkspace);
				} catch (Exception e) {
					logger.debug("Copy deadLock occured exception :", e);
				}
				workspaceList.add(workspace);
			}
		}

		return workspaceList;
	}

	// 根据AGENT发来的数据组装List<ProcessMemoryEntity>
	private List<ProcessMemoryEntity> processMemoryList(
			List<OracleProcessMemory> processMemorys) {
		List<ProcessMemoryEntity> processMemorykList = new ArrayList<ProcessMemoryEntity>();
		if(processMemorys !=null){
			for (OracleProcessMemory oProcessMemory : processMemorys) {
				ProcessMemoryEntity processMemory = new ProcessMemoryEntity();
				try {
					org.apache.commons.beanutils.PropertyUtils.copyProperties(
							processMemory, oProcessMemory);
				} catch (Exception e) {
					logger.debug("Copy processMemory occured exception :", e);
				}
				processMemorykList.add(processMemory);
			}
		}

		return processMemorykList;
	}
	// 根据AGENT发来的数据组装List<DeadLockEntity>
	private List<DeadLock> deadLockLists(List<OracleDeadLock> deadlocks) {
		List<DeadLock> deadLockList = new ArrayList<DeadLock>();
		if(deadlocks!=null){
			for (OracleDeadLock oDeadLock : deadlocks) {
				DeadLock deadLock = new DeadLock();
				try {
					org.apache.commons.beanutils.PropertyUtils.copyProperties(
							deadLock, oDeadLock);
				} catch (Exception e) {
					logger.debug("Copy deadLock occured exception :", e);
				}
				deadLockList.add(deadLock);
			}
		}

		return deadLockList;
	}

	// 根据AGENT发来的数据组装List<WorkspaceEntity>
	private List<org.infosec.ismp.manager.rmi.db.model.Workspace> workspaceLists(List<Workspace> workspaces) {
		List<org.infosec.ismp.manager.rmi.db.model.Workspace> workspaceList = new ArrayList<org.infosec.ismp.manager.rmi.db.model.Workspace>();
		if(workspaces!=null){
			for (Workspace oWorkspace : workspaces) {
				org.infosec.ismp.manager.rmi.db.model.Workspace workspace = new org.infosec.ismp.manager.rmi.db.model.Workspace();
				try {
					org.apache.commons.beanutils.PropertyUtils.copyProperties(
							workspace, oWorkspace);
				} catch (Exception e) {
					logger.debug("Copy deadLock occured exception :", e);
				}
				System.out.println(workspace.toString());
				workspaceList.add(workspace);
			}
		}
		return workspaceList;
	}

	// 根据AGENT发来的数据组装List<ProcessMemoryEntity>
	private List<ProcessMemory> processMemoryLists(
			List<OracleProcessMemory> processMemorys) {
		List<ProcessMemory> processMemorykList = new ArrayList<ProcessMemory>();
		if(processMemorys!=null){
			for (OracleProcessMemory oProcessMemory : processMemorys) {
				ProcessMemory processMemory = new ProcessMemory();
				try {
					org.apache.commons.beanutils.PropertyUtils.copyProperties(
							processMemory, oProcessMemory);
				} catch (Exception e) {
					logger.debug("Copy processMemory occured exception :", e);
				}
				processMemorykList.add(processMemory);
			}
		}
		return processMemorykList;
	}
}
