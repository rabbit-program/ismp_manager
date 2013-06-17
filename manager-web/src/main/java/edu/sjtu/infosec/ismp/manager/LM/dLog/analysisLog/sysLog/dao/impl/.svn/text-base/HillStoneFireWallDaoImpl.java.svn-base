package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.dao.HillStoneFireWallDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.modle.HillStoneFireWall;

public class HillStoneFireWallDaoImpl extends HibernateDaoSupport implements HillStoneFireWallDao {

	@SuppressWarnings("unchecked")
	public List<HillStoneFireWall> getHillStoneFireWallSysLog(String HQL,
			Integer pageNo, Integer pageRowNum) throws Exception {
		Query sysLogQuery = this.getSession().createQuery(HQL);
		sysLogQuery.setFirstResult(pageNo);
		sysLogQuery.setMaxResults(pageRowNum);
		return sysLogQuery.list();
	}

	public Integer getHillStoneFireWallSysLogCount(String HQL) throws Exception {
		Query sysLogQuery = this.getSession().createQuery(HQL);
		if(!sysLogQuery.list().isEmpty()){
			return Integer.parseInt(sysLogQuery.list().get(0).toString());
		}else{
			return 0;
		}
	}

}
