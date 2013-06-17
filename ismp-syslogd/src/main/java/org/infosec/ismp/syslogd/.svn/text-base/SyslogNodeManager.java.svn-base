package org.infosec.ismp.syslogd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.util.ThreadCategory;

/**
 * 管理所有的syslog日志源，是Agent查询、添加日志的工具
 * 
 * @author lianglin
 * 
 */
public class SyslogNodeManager {
	private Map<String, SyslogNode> m_syslogNodes = Collections
			.synchronizedMap(new HashMap<String, SyslogNode>());

	public void addSyslogNode(SyslogNode node) {
		if (node.getNodeid() != null) {
			m_syslogNodes.put(node.getNodeid(), node);
			log().debug("添加一个新的日志源节点: " + node);
		} else {
			log().warn("无法添加日志源，因为Nodeid 是null，请检查 :" + node);
		}
	}
	
	
	public void removeSyslogNode(String nodeid){
		synchronized (m_syslogNodes) {
			if(m_syslogNodes.containsKey(nodeid)){
				m_syslogNodes.remove(nodeid);
				log().debug("删除一个日志源节点,节点nodeid是 :"+nodeid);
			}else{
				log().debug("该日志源不存在，无法删除，请检查nodeid :"+nodeid);
			}
		}
	}
	
	public List<SyslogNode> getAllSyslogNodes(){
		List<SyslogNode> nodeList = new ArrayList<SyslogNode>(m_syslogNodes.size());
		Collection<SyslogNode> nodeCollection = m_syslogNodes.values();
		for(SyslogNode node:nodeCollection){
			nodeList.add(node);
		}
		return nodeList;
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
