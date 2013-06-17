package org.infosec.ismp.manager.domains;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.infosec.ismp.util.ThreadCategory;

/**
 * 管理当前状态信息的类
 * 
 * @author lianglin
 * 
 */
public class StatusComponent<T> {

	public static final long TIME_ELAPSE = 1000L * 60 * 2;
	private Map<NodeId, Status> m_statuses = new HashMap<NodeId, Status>();

//	/**
//	 * 设置状态
//	 * 
//	 * @param nodeid
//	 * @param status
//	 */
//	public void setStatus(String nodeid, T status) {
//		Status s = new Status(status, System.currentTimeMillis());
//		m_statuses.put(nodeid, s);
//	}

	/**
	 * 返回状态
	 * @param nodeid
	 * @return
	 */
	public T getStatus(String nodeid,StatusType type) {
		NodeId key = new NodeId(nodeid,type);
		Status s = m_statuses.get(key);
		
		if (s != null) {
			log().info("找到对应的状态："+s);
			long now = System.currentTimeMillis();
			long time = s.m_time;
			if (now - time < TIME_ELAPSE) {
				return s.m_status;
			}else{
				log().info("时间过期");
			}
		}else{
			log().info("没有找到");
		}
		return null;
	}

	/**
	 * 内部类
	 * 
	 * @author lianglin
	 * 
	 */
	private class Status {
		T m_status;
		long m_time;

		Status(T status, long time) {
			m_status = status;
			m_time = time;
		}
	}
	
	
	private class NodeId{
		String nodeid;
		StatusType type;
		
		NodeId(String nodeid,StatusType type){
			this.nodeid = nodeid;
			this.type = type;
		}

		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this);
		}

		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(this, obj);
		}
		
		
	}
	
	/**
	 * 删除状态
	 * @param nodeid
	 */
	public void removeStatus(String nodeid,StatusType type){
		NodeId key = new NodeId(nodeid,type);
		m_statuses.remove(key);
	}
	
	ThreadCategory log(){
		return ThreadCategory.getInstance(getClass());
	}

	public void setStatus(String nodeid, StatusType type, T status) {
		Status s = new Status(status, System.currentTimeMillis());
		NodeId key = new NodeId(nodeid,type);
		m_statuses.put(key, s);
		
	}
}
