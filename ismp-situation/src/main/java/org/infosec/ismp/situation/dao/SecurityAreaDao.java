package org.infosec.ismp.situation.dao;

import java.util.Map;

import org.infosec.ismp.situation.common.BaseDao;
import org.infosec.ismp.situation.model.Domain;

public interface SecurityAreaDao extends BaseDao {
	/**
	 * 得到所有安全域信息
	 * @return
	 */
	Map<Integer,Domain> getAllSecurityArea();
}
