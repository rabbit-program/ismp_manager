package org.infosec.ismp.manager.rmi.event;

import java.sql.Timestamp;
import java.util.List;

/**
 * 用于和APPLET进行通信的接口
 * @author wudengke
 * @version 创建时间：2009-6-16 下午04:29:50
 * 
 */
public interface Ilnvoker {

	
	/**
	 * 获取实时数据
	 * @return
	 */
	public List<Object> getDates();
	
	/**
	 * 获取初始化数据
	 * @return
	 */
	public List<Object> initRealTimeList(String value, Integer bureauId);
	
	/**
	 * 统计所有安全设备在时间段内的事件集合(实现事件页面安全设备事件总量统计)
	 * @param starttime
	 * @param endtime
	 * @return 事件实时显示表信息
	 */
	public List<Object> staticticsSafety(Timestamp starttime,Timestamp endtime, Integer bureauId);
	
	/**
	 * 统计所有事件类型的各分组类型数量(实现安全设备事件类型分类统计)
	 * @param starttime
	 * @param endtime
	 * @return 事件实时显示表信息
	 */
	public List<Object> staticticsEventType(Timestamp starttime,Timestamp endtime, Integer bureauId);
	
	/**
	 * 统计域事件总量
	 * @return
	 */
	public List<Object> StatisticsDomain(Timestamp starttime,Timestamp endtime, Integer bureauId);

}
