package org.infosec.ismp.manager.threshold;

import java.util.List;

import org.infosec.ismp.manager.model.threshold.ThresholdEntity;
import org.infosec.ismp.manager.rmi.threshold.AlertType;
import org.infosec.ismp.manager.threshold.dao.ThresholdConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guoxianwei
 * @date 2010-12-30 下午01:44:48
 *  
 */
@Component
@Transactional
public class ThresholdLoader {

	private ThresholdConfigDao m_thresholdConfigDao;

	private ThresholdAlertLocator m_thresholdAlertLocator;

	@Transactional
	protected List<ThresholdEntity> thresholds() {
		String hql = " from ThresholdEntity t ";
		return m_thresholdConfigDao.find(hql);

	}
    //从数据库中加载阈值信息到内存
	public void loadThresholds() {
		for (ThresholdEntity entity : thresholds()) {
			m_thresholdAlertLocator
					.cacheThresholdConfig(entity.getNodeid(), AlertType.valueOf(entity.getAlertType()), entity.getValue(),
							entity.getLevel(), entity.getThreshold());
		}
	}

	@Autowired(required = true)
	public void setThresholdConfigDao(ThresholdConfigDao thresholdConfigDao) {
		m_thresholdConfigDao = thresholdConfigDao;
	}

	@Autowired(required = true)
	public void setThresholdAlertLocator(
			ThresholdAlertLocator thresholdAlertLocator) {
		m_thresholdAlertLocator = thresholdAlertLocator;
	}
}

