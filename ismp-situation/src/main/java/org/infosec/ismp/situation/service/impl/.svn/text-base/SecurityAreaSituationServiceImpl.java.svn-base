package org.infosec.ismp.situation.service.impl;

import java.util.List;

import org.infosec.ismp.situation.dao.SecurityAreaSituationDao;
import org.infosec.ismp.situation.model.SecurityAreaSituation;
import org.infosec.ismp.situation.service.SecurityAreaSituationService;

public class SecurityAreaSituationServiceImpl implements SecurityAreaSituationService {

	private SecurityAreaSituationDao securityAreaSituationDao;

	public void setSecurityAreaSituationDao(SecurityAreaSituationDao securityAreaSituationDao) {
		this.securityAreaSituationDao = securityAreaSituationDao;
	}

	public void save(SecurityAreaSituation securityAreaSituation) {
		if (securityAreaSituation.getSecurityAreaName() != null
				&& securityAreaSituation.getSecurityAreaName().length() > 0
				&& securityAreaSituation.getDomain().getId() != null
				&& securityAreaSituation.getDomain().getId() > 0
				&& securityAreaSituation.getTime() != null
				&& securityAreaSituation.getWholeSituation() > 0) {
			securityAreaSituationDao.save(securityAreaSituation);
		}
	}

	public void save(List<SecurityAreaSituation> securityAreaSituations) {
		if (securityAreaSituations != null && securityAreaSituations.size() >0) {
			securityAreaSituationDao.save(securityAreaSituations);
		}
	}

}
