package org.infosec.ismp.manager.syslog;

import java.util.List;

import org.infosec.ismp.manager.model.syslog.SyslogNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SyslogNodeService {
    private SyslogNodeDao nodeDao;

    @Autowired(required=true)
	public void setNodeDao(SyslogNodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}

    @Transactional(readOnly=true)
	public List<SyslogNodeEntity> getAll() {
		return nodeDao.getAll();
	}

    @Transactional
	public void save(SyslogNodeEntity entity) {
		nodeDao.save(entity);
		
	}

	public boolean findExistingNode(String nodeId) {
		List<SyslogNodeEntity> list= nodeDao.findBy("nodeid", nodeId);
		if(list!=null&&list.size()>0)return true;
		return false;
	}

	public void removeNodeByNodeId(String nodeid) {
		String hql = "delete from SyslogNodeEntity syslog where syslog.nodeid=?";
		nodeDao.batchExecute(hql, nodeid);
		
	}
    
    
}
