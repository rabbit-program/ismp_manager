package edu.sjtu.infosec.ismp.manager.LM.dLog.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.model.Ftp;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public interface FtpService {
	/**
	 * 根据条件获得所在域下的所有FtpSource
	 * @return
	 * @throws Exception
	 */
	public List<FtpSource> getAllFtpSource(FtpSource ftpSource,OperatorDetails user,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 根据条件获得所在域下的所有Ftp
	 * @param ftpSource
	 * @param user
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	public List<Ftp> getFtpBySource(String ftpSource,List<Domain> domain,Integer pageNo,Integer pageRowNum)throws Exception;
}
