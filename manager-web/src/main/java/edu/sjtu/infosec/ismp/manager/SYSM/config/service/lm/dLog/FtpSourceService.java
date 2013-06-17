package edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public interface FtpSourceService {
	
	/**
	 * 无条件获得所在域下的所有FtpSource
	 * @return
	 * @throws Exception
	 */
	public List<FtpSource> getAllFtpSource(FtpSource ftpSource,OperatorDetails user,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 新增	FtpSource
	 * 
	 * @param ftpSource
	 * @return
	 * @throws Exception
	 */
	public boolean addFtpSource(FtpSource ftpSource)throws Exception;
	
	/**
	 * 删除	FtpSource
	 * 
	 * @param ftpSource
	 * @return
	 * @throws Exception
	 */
	public boolean delFtpSource(FtpSource ftpSource)throws Exception;
	
}
