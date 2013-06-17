package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.modle.HillStoneFireWall;
import edu.sjtu.infosec.ismp.security.Domain;

public interface HillStoneFireWallService {
	
	/**
	 * 通过条件得到 HillStoneFireWall 的Log记录
	 * @param domain
	 * @param logSourceLogo
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	public List<HillStoneFireWall> getHillStoneFireWallSysLog(List<Domain> domain,String logSourceLogo,Integer pageNo,Integer pageRowNum)throws Exception;
	
	/**
	 * 通过条件得到 HillStoneFireWall 的Log记录的总数
	 * @param domain
	 * @param logSourceLogo
	 * @return
	 * @throws Exception
	 */
	public Integer getHillStoneFireWallSysLogCount(List<Domain> domain,String logSourceLogo)throws Exception;
}
