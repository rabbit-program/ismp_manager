package org.infosec.ismp.manager.rmi.aim.service;

import java.util.List;
import java.util.Map;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
/**
 * 得到页面显示的告警列表
 * @author Administrator
 *
 */
public interface NewAlertService {

	/**
	 * 根据maxId得到告警列表。
	 * @param maxId: 页面告警模块当前告警信息的最大ID，由后台产生，首次传0；
	 * @return key: maxId，返回告警列表中最大的告警Id。
	 * 					value: 返回后台产生的，当前所有的大于入参maxId的告警列表。
	 * 					如无告警信息，则返回空的Map（not null）。
	 */
	Map<String,List<AlertInfoBO>> getNewAlert(Long maxId);
}
