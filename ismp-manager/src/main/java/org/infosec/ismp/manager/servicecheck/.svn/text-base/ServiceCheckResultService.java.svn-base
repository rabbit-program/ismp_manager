package org.infosec.ismp.manager.servicecheck;

import org.infosec.ismp.manager.model.ServiceCheckResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * serviceCheck结果service类
 * @author jiel
 *
 */
@Component
@Transactional
public class ServiceCheckResultService {

	private ServiceCheckResultDao dao;

	@Autowired(required=true)
	public void setDao(ServiceCheckResultDao dao) {
		this.dao = dao;
	}
	
	/**
	 * 将检测结果保存到DB中
	 * @param entity
	 */
	@Transactional
	public void save(ServiceCheckResultEntity entity){
		dao.save(entity);
	}
	
}
