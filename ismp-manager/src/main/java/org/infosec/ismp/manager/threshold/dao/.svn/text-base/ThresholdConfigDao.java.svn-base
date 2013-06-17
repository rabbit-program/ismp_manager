package org.infosec.ismp.manager.threshold.dao;

import org.infosec.ismp.manager.model.threshold.ThresholdEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * @author guoxianwei
 * @date 2010-12-29 下午05:14:25
 * 
 */
@Component
public class ThresholdConfigDao  extends HibernateDao<ThresholdEntity, Integer> {
	/**
	 * 根据nodeid删除对应的Threshold
	 * 
	 * @param nodeid
	 */
	public void removeThresholdEntityByNodeId(String nodeid) {
		String hql = "delete from ThresholdEntity t where t.nodeid=?";
		batchExecute(hql, nodeid);
	}
}

