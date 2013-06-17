package edu.sjtu.infosec.ismp.manager.AIM.dao;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

/**
 * 重队列里面得到最新告警接口
 * @author Administrator
 *
 */
public interface NewAlertDao {
	
	/**
	 * 根据maxId得到告警列表。
	 * @param maxId
	 * @return key 分别为maxId、alertList
	 */
	Map<String,List<AlertInfoBO>> getNewAlert(Long maxId);
	
}
