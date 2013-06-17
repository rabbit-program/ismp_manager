package edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.FtpSourceDao;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.FtpSourceService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class FtpSourceServiceImpl implements FtpSourceService {
	
	private FtpSourceDao ftpSourceDao;
	
	public boolean addFtpSource(FtpSource ftpSource) throws Exception {
		Integer flox = ftpSourceDao.addFtpSource(ftpSource);
		if(flox == 1){
			return true;
		}
		return false;
	}

	public List<FtpSource> getAllFtpSource(FtpSource ftpSource,OperatorDetails user,Integer pageNo,Integer pageRowNum) throws Exception {
		List<Domain> domain = user.getDomainList();
		return ftpSourceDao.getAllFtpSource(ftpSource, domain, pageNo, pageRowNum);
	}

	public boolean delFtpSource(FtpSource ftpSource) throws Exception {
		Integer flox = ftpSourceDao.delFtpSource(ftpSource);
		if(flox == 1){
			return true;
		}
		return false;
	}

	public FtpSourceDao getFtpSourceDao() {
		return ftpSourceDao;
	}

	public void setFtpSourceDao(FtpSourceDao ftpSourceDao) {
		this.ftpSourceDao = ftpSourceDao;
	}
	
}
