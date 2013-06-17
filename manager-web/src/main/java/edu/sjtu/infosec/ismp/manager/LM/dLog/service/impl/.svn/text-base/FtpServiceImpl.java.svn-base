package edu.sjtu.infosec.ismp.manager.LM.dLog.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.dao.FtpDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.Ftp;
import edu.sjtu.infosec.ismp.manager.LM.dLog.service.FtpService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class FtpServiceImpl implements FtpService {

	private FtpDao ftpDao;
	
	public List<FtpSource> getAllFtpSource(FtpSource ftpSource,
			OperatorDetails user, Integer pageNo, Integer pageRowNum)
			throws Exception {
		List<Domain> domain = user.getDomainList();
		return ftpDao.getAllFtpSource(ftpSource, domain, pageNo, pageRowNum);
	}

	public FtpDao getFtpDao() {
		return ftpDao;
	}

	public void setFtpDao(FtpDao ftpDao) {
		this.ftpDao = ftpDao;
	}

	public List<Ftp> getFtpBySource(String ftpSource, List<Domain> domain,
			Integer pageNo, Integer pageRowNum) throws Exception {
		StringBuffer HQL = new StringBuffer();
		
		HQL.append("from Ftp where 1=1");
		
		String inDomain = "00";
		for(Domain d : domain)
			inDomain += ","+d.getId();
		HQL.append(" and domain in ("+inDomain+")");
		
		HQL.append("and logSourceSequence = '" + ftpSource +"'");
		
		return ftpDao.getFtpBySource(HQL.toString(), pageNo, pageRowNum);
	}
}
