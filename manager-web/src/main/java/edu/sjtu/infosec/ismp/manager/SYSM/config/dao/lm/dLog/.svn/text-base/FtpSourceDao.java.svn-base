package edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.security.Domain;

public interface FtpSourceDao {
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
	 * 新增	FtpSource
	 * 
	 * @param ftpSource
	 * @return
	 * @throws Exception
	 */
	public Integer addFtpSource(FtpSource ftpSource)throws Exception;
	
	/**
	 * 删除	FtpSource
	 * @param ftpSource
	 * @return
	 * @throws Exception
	 */
	public Integer delFtpSource(FtpSource ftpSource)throws Exception;
	
}
