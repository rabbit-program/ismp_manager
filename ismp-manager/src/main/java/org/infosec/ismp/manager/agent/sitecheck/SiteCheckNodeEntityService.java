package org.infosec.ismp.manager.agent.sitecheck;

import java.util.List;

import org.infosec.ismp.manager.model.SiteCheckNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * siteCheckNodeEntity服务类
 * @author jiel
 *
 */
@Component
@Transactional
public class SiteCheckNodeEntityService {
	private SiteCheckNodeEntityDao m_siteCheckDao;

	@Autowired(required=true)
	public void setSiteCheckDao(SiteCheckNodeEntityDao siteCheckDao) {
		m_siteCheckDao = siteCheckDao;
	}
	/**
	 * 从DB中获取所有siteCheckNodeEntity
	 * @return
	 */
	@Transactional
	public List<SiteCheckNodeEntity> getAll()
	{
		return m_siteCheckDao.getAll();
	}
	/**
	 * 保存一个siteCheckNodeEntity到DB中
	 * @param entity
	 */
	@Transactional
	public void save(SiteCheckNodeEntity entity){
		m_siteCheckDao.save(entity);
	}
	/**
	 * 从DB中删除一个siteCheckNodeEntity
	 * @param nodeid
	 */
	@Transactional
	public void removeSiteCheckNodeByNodeId(String nodeid){
		m_siteCheckDao.removeSiteCheckNodeByNodeId(nodeid);
	}
}
