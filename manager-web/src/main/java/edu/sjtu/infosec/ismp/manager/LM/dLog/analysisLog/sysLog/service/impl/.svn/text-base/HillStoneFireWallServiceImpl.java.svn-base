package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.dao.HillStoneFireWallDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.modle.HillStoneFireWall;
import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.service.HillStoneFireWallService;
import edu.sjtu.infosec.ismp.security.Domain;

public class HillStoneFireWallServiceImpl implements HillStoneFireWallService {
	
	private HillStoneFireWallDao hillStoneFireWallDao;
	
	public List<HillStoneFireWall> getHillStoneFireWallSysLog(
			List<Domain> domain, String logSourceLogo, Integer pageNo,
			Integer pageRowNum) throws Exception {
		StringBuffer HQL = new StringBuffer();
		
		HQL.append("from HillStoneFireWall where 1=1");
		
		String inDomain = "00";
		for(Domain d : domain)
			inDomain += ","+d.getId();
		HQL.append(" and domain in ("+inDomain+")");
		
		HQL.append(" and logSourceseQuence = '" + logSourceLogo +"'");
		
		HQL.append(" order by timestamp desc");
		
		return hillStoneFireWallDao.getHillStoneFireWallSysLog(HQL.toString(), pageNo, pageRowNum);
	}

	public Integer getHillStoneFireWallSysLogCount(List<Domain> domain,
			String logSourceLogo) throws Exception {
		StringBuffer HQL = new StringBuffer();
		
		HQL.append("select count(*) from HillStoneFireWall where 1=1");
		
		String inDomain = "00";
		for(Domain d : domain)
			inDomain += ","+d.getId();
		HQL.append(" and domain in ("+inDomain+")");
		
		HQL.append("and logSourceseQuence = '" + logSourceLogo +"'");
		
		return hillStoneFireWallDao.getHillStoneFireWallSysLogCount(HQL.toString());
	}

	public HillStoneFireWallDao getHillStoneFireWallDao() {
		return hillStoneFireWallDao;
	}

	public void setHillStoneFireWallDao(HillStoneFireWallDao hillStoneFireWallDao) {
		this.hillStoneFireWallDao = hillStoneFireWallDao;
	}
}
