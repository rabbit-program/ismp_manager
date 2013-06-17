package org.infosec.ismp.agent.dao;

import java.util.List;

import org.infosec.ismp.agent.entity.AgentConfig;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * @author guoxianwei
 * @date 2010-9-20 下午04:06:51
 * 
 */
@Component
public class GenericDao extends HibernateDao<AgentConfig,Integer>{
    @Transactional
	public AgentConfig getAgentConfig() {
        List<AgentConfig> list = find("from AgentConfig a");
        if(!list.isEmpty()){
        	AgentConfig agentConfig = list.get(0);
        	return agentConfig;
        }
		return new AgentConfig();
	}

}

