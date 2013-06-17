package org.infosec.ismp.manager.sitecheck;

import org.infosec.ismp.manager.model.SiteCheckResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * sitecheck结果service类
 * @author jiel
 *
 */
@Component
@Transactional
public class SiteCheckResultService {
	private SiteCheckResultDao dao;

	@Autowired(required=true)
	public void setDao(SiteCheckResultDao dao) {
		this.dao = dao;
	}
	
	/**
	 * 保存sitecheck结果
	 * @param entity
	 */
	@Transactional
	public void save(SiteCheckResultEntity entity){
		dao.save(entity);
	}

}
