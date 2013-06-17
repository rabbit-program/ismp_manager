package org.infosec.ismp.manager.agent;

import org.infosec.ismp.manager.model.AgentEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;
/**
 * 负责读取、保存Agent的信息
 * @author lianglin
 *
 */
@Component
public class AgentDao extends HibernateDao<AgentEntity, Integer> {
     public void saveUuid(String agentId,String uuid){
    	 String hql="update AgentEntity agent set agent.uuid=? where agent.agentName=?";
    	 batchExecute(hql, uuid,agentId);
     }
}
