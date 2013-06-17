package org.infosec.ismp.manager.threshold;

import java.util.List;

import org.infosec.ismp.manager.model.threshold.ThresholdEntity;
import org.infosec.ismp.manager.rmi.threshold.AlertType;
import org.infosec.ismp.manager.rmi.threshold.service.ThresholdConfigRmi;
import org.infosec.ismp.manager.threshold.dao.ThresholdConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
* @author guoxianwei
* @date 2010-12-29 下午05:11:30
*  阈值设定实现类
 */
@Component
@Transactional
public class ThresholdConfigImpl implements ThresholdConfigRmi {

	private ThresholdConfigDao m_thresholdConfigDao;
	private ThresholdAlertLocator m_thresholdAlertLocator; 
	
	/**
	 * 删除阈值
	 */
	@Override
	@Transactional
	public void deleteThreshConfig(String nodeid, AlertType type,String value) {
		String hql = " from ThresholdEntity t where t.nodeid =? and alertType = ? and value = ?";
		List<ThresholdEntity> list = m_thresholdConfigDao.find(hql, nodeid,
				type.name(),value);
		for (ThresholdEntity entity : list) {
			m_thresholdConfigDao.delete(entity);
		}
		//从缓存中移除被删除阈值信息
		m_thresholdAlertLocator.removeThresholdCache(nodeid, type);
	}
	
	/**
	 * 新增阈值
	 */
	@Override
	@Transactional
	public void setThreshConfig(String nodeid, AlertType type, String value,
			int level, Number threshold) {
		ThresholdEntity entity = new ThresholdEntity();
		entity.setNodeid(nodeid);
		entity.setLevel(level);
		entity.setValue(value);
		entity.setThreshold(threshold);
		entity.setAlertType(type.toString());
		m_thresholdConfigDao.save(entity);
		//缓存阈值信息到内存
		m_thresholdAlertLocator.cacheThresholdConfig(nodeid, type, value, level, threshold);
	}

	@Autowired(required = true)
	public void setThresholdConfigDao(ThresholdConfigDao thresholdConfigDao) {
		m_thresholdConfigDao = thresholdConfigDao;
	}
	@Autowired(required = true)
	public void setThresholdAlertLocator(ThresholdAlertLocator thresholdAlertLocator) {
		m_thresholdAlertLocator = thresholdAlertLocator;
	}

}

