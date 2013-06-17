package org.infosec.ismp.situation.dao;

import java.util.Map;

import org.infosec.ismp.situation.common.BaseDao;
import org.infosec.ismp.situation.model.MachineCabinet;

public interface MachineCabinetDao extends BaseDao {
	
	/**
	 * 得到所有机柜信息
	 * @return
	 */
	Map<Integer,MachineCabinet> getAllMachineCabinet();
}
