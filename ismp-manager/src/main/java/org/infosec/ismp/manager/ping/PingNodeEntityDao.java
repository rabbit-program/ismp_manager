package org.infosec.ismp.manager.ping;

import java.util.List;

import org.infosec.ismp.manager.model.PingNodeEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
public class PingNodeEntityDao extends HibernateDao<PingNodeEntity, Integer> {
	/**
	 * 根据AgentId返回所有该Agent的PingNodeEntity对象
	 * 
	 * @param agentId
	 * @return
	 */
	public List<PingNodeEntity> getAllPingNodeByAgentId(String agentId) {
		String hql = "from PingNodeEntity ping where ping.agentId=?";
		return findBy(hql, agentId);
	}

	/**
	 * 根据nodeid删除对应的pingNode
	 * 
	 * @param nodeid
	 */
	public void removePingNodeByNodeId(String nodeid) {
		String hql = "delete from PingNodeEntity ping where ping.nodeid=?";
		batchExecute(hql, nodeid);
	}

	public PingNodeEntity getPingNodeEntityByNodeid(String nodeid) {
//		String hql = "from PingNodeEntity ping where ping.nodeid= ?";
		List<PingNodeEntity> list = findBy("nodeid", nodeid);
		if(list!=null&&list.size()>0)return list.get(0);
		return null;
	}

}
