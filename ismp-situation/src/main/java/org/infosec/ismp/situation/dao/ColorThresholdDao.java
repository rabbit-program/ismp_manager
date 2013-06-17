package org.infosec.ismp.situation.dao;

import java.util.Map;

import org.infosec.ismp.situation.common.BaseDao;

public interface ColorThresholdDao extends BaseDao{
	/**
	 * 获取绿，黄，红所对应的阈值
	 * @param id
	 */
	Map<String, Integer> get();
}
