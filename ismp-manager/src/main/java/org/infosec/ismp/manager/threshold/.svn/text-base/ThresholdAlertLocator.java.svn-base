package org.infosec.ismp.manager.threshold;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.infosec.ismp.manager.rmi.threshold.AlertType;
import org.springframework.stereotype.Component;

/**
 * @author guoxianwei
 * @date 2010-12-30 下午12:21:03 
 * 
 *   把阈值信息放到缓存中进行管理
 * 
 */
@Component
public class ThresholdAlertLocator {

	/**
	 * 缓存阈值信息到缓存中
	 * 
	 * @param String nodeid
	 * @param AlertType type
	 * @param String value
	 * @param int level
	 * @param int threshold
	 */
	public synchronized void cacheThresholdConfig(String nodeid, AlertType type,
			String value, int level, Number threshold) {
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, type);
		Threshold thresholds = new Threshold(level, nodeid, threshold, type,
				value);
		m_thresholdMap.put(key, thresholds);
	}
	/**
	 * 从缓存中删除阈值信息
	 * 
	 * @param <p>String</p> nodeid
	 * @param <p>AlertType</p>  type
	 */
	public void removeThresholdCache(String nodeid, AlertType type) {
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, type);
		m_thresholdMap.remove(key);
	}

	private static class NodeIdAndTypePair {
		String nodeid;
		AlertType type;

		public NodeIdAndTypePair(final String nodeid, final AlertType type) {
			this.nodeid = nodeid;
			this.type = type;
		}

		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this);
		}

		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(obj, this);
		}
	}
    public boolean containsThreshold(String nodeid, AlertType type) {
		return m_thresholdMap.containsKey(new NodeIdAndTypePair(nodeid, type));
	}
	/**
	 * 由SnmpMessageListener <method>init</method>初始化数据
	 */
	private static Map<NodeIdAndTypePair,Threshold> m_thresholdMap = Collections.synchronizedMap(new HashMap<NodeIdAndTypePair,Threshold>());
	
	public Threshold getThreshold(String nodeid, AlertType type){
		return m_thresholdMap.get(new NodeIdAndTypePair(nodeid, type));
	}
//	public Map<NodeIdAndTypePair, Threshold> getThresholdMap() {
//		return m_thresholdMap;
//	}

}
