package edu.sjtu.infosec.ismp.manager.BSAM.service;

import java.util.List;

public interface SecurityAreaSituationService {
	
	/**
	 * 根据传入的域id返回这些域的态势列表
	 * @param userDomainStr
	 * @return
	 */
	List getSecurityAreaSituation(String userDomainStr);
}
