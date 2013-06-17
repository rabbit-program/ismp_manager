package edu.sjtu.infosec.ismp.manager.LM.dLog.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.model.Ftp;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.security.Domain;

public interface FtpDao {
	/**
	 * 获得符合条件的FtpSource
	 * @param ftpSource
	 * @param domain
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	public List<FtpSource> getAllFtpSource(FtpSource ftpSource,List<Domain> domain,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 根据 HQL 获得所在域下的所有Ftp
	 * @param ftpSource
	 * @param user
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	public List<Ftp> getFtpBySource(String HQL,Integer pageNo,Integer pageRowNum)throws Exception;

}
