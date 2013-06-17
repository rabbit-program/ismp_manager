package edu.sjtu.infosec.ismp.manager.EM.service;

import java.sql.Timestamp;
import java.util.List;

import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventGetTopoResult;

/**
 * 从拓朴数据库取数据
 * @author wudengke 2009-6-29
 *
 */
public interface IGetTopoInfo {
	
	/**
	 * 获取TOPO设备IP和MAC地址和设备名
	 * @return
	 */
	public List<Object> getTopoInfo();
	
	/**
	 * 分页获取TOPO设备IP和MAC地址和设备名
	 * @return
	 */
	public EventGetTopoResult getTopoInfo(Page page, Integer[] bureauIds);
	
	/**
	 * 获取域事件总量
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<Object> StatisticsDomain(Timestamp starttime, Timestamp endtime, Integer bureauId);
	
	public NodeEntity queryByIpBureauId(String ip,Integer bureauId);
	
}
